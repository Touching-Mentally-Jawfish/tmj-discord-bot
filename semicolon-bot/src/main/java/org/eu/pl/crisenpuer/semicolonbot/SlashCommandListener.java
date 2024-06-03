package org.eu.pl.crisenpuer.semicolonbot;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            event.reply("Pong " + event.getMember().getNickname() + "!").queue();
        } else if (event.getName().equals("reloadconfig")) {
            Start.bot.reloadconfig()
        }
    }
}
