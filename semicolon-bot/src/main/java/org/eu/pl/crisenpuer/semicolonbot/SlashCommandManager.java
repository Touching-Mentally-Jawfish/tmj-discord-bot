package org.eu.pl.crisenpuer.semicolonbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class SlashCommandManager {

    public static void registerCommands(JDA jda) {
        final CommandData pingCommand = Commands.slash("ping", "Test if bot is alive");
        final CommandData reloadconfigCommand = Commands.slash("reloadconfig", "Use it after changing settings in Dashboard");

        jda.updateCommands()
            .addCommands(pingCommand)
            .addCommands(reloadconfigCommand)
            .queue();
            
    }
}
