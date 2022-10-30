package ru.omarov;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DiscordBot {
    public static void main(String[] args) throws IOException {
        TokenLoader loader = new TokenLoader();
        loader.setFis(new FileInputStream("src/main/resources/config.properties"));
        loader.setProperties(new Properties());
        loader.getProperties().load(loader.getFis());

        System.out.println(loader.getToken());

//        JDA BOT = JDABuilder.createDefault(loader.getToken())
//                .setActivity(Activity.playing("with ur dog"))
//                .build();
    }
}
