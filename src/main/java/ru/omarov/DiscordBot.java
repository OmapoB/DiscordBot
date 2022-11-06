package ru.omarov;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import ru.omarov.commands.CommandsEnum;
import ru.omarov.commands.CommandsHandler;
import ru.omarov.events.EducEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DiscordBot {
    public static void main(String[] args) throws IOException, InterruptedException {
        ResourcesLoader loader = new ResourcesLoader();
        loader.setFis(new FileInputStream("src/main/resources/config.properties"));
        loader.setProperties(new Properties());
        loader.getProperties().load(loader.getFis());

        JDA Bot = JDABuilder.createDefault(loader.getProperties().getProperty("token"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build()
                .awaitReady();
        Bot.addEventListener(new EducEvent(), new CommandsHandler());

        Guild guild = Bot.getGuildById(loader.getProperties().getProperty("guildId"));
        if (guild != null) {
            guild.upsertCommand(CommandsEnum.HELP.getName(), CommandsEnum.HELP.getDescription()).queue();
            guild.upsertCommand(CommandsEnum.PLAY.getName(), CommandsEnum.PLAY.getDescription()).queue();
        }
    }
}
