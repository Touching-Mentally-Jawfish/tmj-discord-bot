const express = require('express');
const session = require('express-session');
const passport = require('passport');
const DiscordStrategy = require('passport-discord').Strategy;
const bodyParser = require('body-parser');
const path = require('path');
const fs = require('fs');

const app = express();

// Configure session management
app.use(session({
    secret: 'your-secret',
    resave: false,
    saveUninitialized: false
}));

// Configure body parser
app.use(bodyParser.json());

// Configure Passport
passport.serializeUser((user, done) => done(null, user));
passport.deserializeUser((obj, done) => done(null, obj));

passport.use(new DiscordStrategy({
    clientID: '1246514396805464074',
    clientSecret: 'L4UiNqhz4h-aHOj9ifLeHqabthEzuvbD',
    callbackURL: 'http://localhost:3000/callback',
    scope: ['identify', 'guilds']
}, (accessToken, refreshToken, profile, done) => {
    return done(null, profile);
}));

app.use(passport.initialize());
app.use(passport.session());

// Serve static files from frontend
app.use(express.static(path.join(__dirname, '../frontend')));

// Routes
app.get('/login', passport.authenticate('discord'));

app.get('/callback', passport.authenticate('discord', { failureRedirect: '/' }), (req, res) => {
    res.redirect('/dashboard');
});

app.get('/dashboard', (req, res) => {
    if (!req.isAuthenticated()) return res.redirect('/login');
    res.sendFile(path.join(__dirname, '../frontend/dashboard.html'));
});

// Endpoint to get user information
app.get('/api/user', (req, res) => {
    if (!req.isAuthenticated()) return res.status(401).send('Unauthorized');
    res.json(req.user);
});

// Endpoint to update bot configuration
app.post('/api/config', (req, res) => {
    if (!req.isAuthenticated()) return res.status(401).send('Unauthorized');
    const config = req.body;
    fs.writeFileSync('config.json', JSON.stringify(config, null, 2));
    res.send('Configuration updated YAY!');
    console.log('Configuration updated YAY!')
});

app.listen(3000, () => console.log('Server running on http://localhost:3000'));
