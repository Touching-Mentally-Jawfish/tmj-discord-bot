package org.eu.pl.crisenpuer.semicolonbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class verifycreate {
    static public void execute(MessageReceivedEvent embedevent) {
        EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("Staff Roles");
                embed.setDescription("While these roles are highly selective, it is still useful to know what they do");
                embed.addField("@Beluga 🐋", "The role of the one and only Beluga!", false);
                embed.addField("@Community Manager 📥", "Manager(s) of the server with the most permissions", false);
                embed.addField("@Admin 🛠️", "Manage the staff team and implement major changes to the server", false);
                embed.addField("@Senior Moderator 🛡️", "Experienced position of the staff team", false);
                embed.addField("@Honourable Staff 🏅", "Given to put a spotlight on staff!", false);
                embed.addField("@Moderator ⚔️", "Keep the server safe and productive", false);
                embed.addField("@Trial Moderator 🖋️", "Entry position of the staff team", false);
                embed.addField("@Advisor 🎓", "Advise the admins when needed", false);
                embed.addField("@Event Manager 🎉", "Manage Events Team and finalizing event's ideas", false);
                embed.addField("@Event Team 🎊", "Plan and discuss to host events in `#events`", false);
                
                embedevent.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}
