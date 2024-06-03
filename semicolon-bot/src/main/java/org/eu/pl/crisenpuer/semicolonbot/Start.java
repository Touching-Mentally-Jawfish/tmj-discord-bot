package org.eu.pl.crisenpuer.semicolonbot;

public class Start {
    Bot bod;
    public static void main(String[] args) {
        String tmjToken = "MTI0NjUxNDM5NjgwNTQ2NDA3NA.GVz1mD.cuDgkcdYriB2bT8zVsUgOY9ilfLqqbmfL2fRBU";
        // String scToken = "MTIwOTg4MTE5NTg1MzM4NTgzOA.GGWluo.2FakhlYDmevOOXpAsCNe8PhYV_0kGpQT8_bQxM";

        Bot bot = new Bot(tmjToken, "tmj?");
        bot.start();
    }

}
