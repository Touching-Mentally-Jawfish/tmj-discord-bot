package org.eu.pl.crisenpuer.semicolonbot;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

import org.json.JSONObject;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {

    private final String token;
    private String cmd_prefix;

    public Bot(String token, String prefix) {
        this.token = token;
        this.cmd_prefix = prefix;
        loadConfig();
    }

    public void loadConfig() {
        String cmd_prefix_bak = cmd_prefix;
        try {
            String content = new String(Files.readAllBytes(Paths.get("config.json")));
            JSONObject json = new JSONObject(content);
            this.cmd_prefix = json.getString("prefix");
        } catch (Exception e) {
            e.printStackTrace();
            this.cmd_prefix = cmd_prefix_bak;
        }
    }

    public void start() {
        JDA jda = JDABuilder.createLight(token, EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
            .addEventListeners(new MessageEventListener(cmd_prefix), new SlashCommandListener())
            .build();

        SlashCommandManager.registerCommands(jda);
    }
}