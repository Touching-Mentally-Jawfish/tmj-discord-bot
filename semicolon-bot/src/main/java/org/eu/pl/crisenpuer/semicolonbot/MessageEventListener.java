package org.eu.pl.crisenpuer.semicolonbot;

import org.eu.pl.crisenpuer.semicolonbot.commands.embed;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
// import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;


class MessageEventListener extends ListenerAdapter {
    String command_prefix;

    MessageEventListener(String command_prefix) {
        this.command_prefix = command_prefix;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String content = message.getContentRaw();
        // MessageChannelUnion channel = message.getChannel();
        
        System.err.printf("Message detected: %s\n", content);


        if (content.strip().equalsIgnoreCase(command_prefix + "ping")) {
            System.out.printf("Command %s sent\n", content);
            embed.execute(event);
        } else if (content.strip().equalsIgnoreCase(command_prefix + "verifycreate")) {
            MessageEmbed embed = new net.dv8tion.jda.api.EmbedBuilder()
                    .setTitle("Join Servers for You!")
                    .setDescription("Click the button below to authenticate and allow the bot to join servers on your behalf.")
                    .build();
            Button joinButton = Button.primary("join_for_me", "Authenticate");
            event.getChannel().sendMessageEmbeds(embed)
                    .setActionRow(joinButton)
                    .queue();
        } else {
            System.out.printf("Unregistered command: \n", content);
        }
    }
}
