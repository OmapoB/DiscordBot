package ru.omarov.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import ru.omarov.commands.CommandsHandler;
import ru.omarov.commands.Command;
import ru.omarov.commands.list.HelpCommand;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Bot {
    private final ResourcesLoader loader = new ResourcesLoader(
            new FileInputStream("src/main/resources/config.properties"),
            new Properties()
    );
    private JDA bot;
    private final String TOKEN = loader.getProperties().getProperty("token");
    private final String GUILD_ID = loader.getProperties().getProperty("guildId");

    private List<GatewayIntent> intents;

    private List<EventListener> eventListeners;

    public Bot() throws IOException {
    }

    public void startBot() throws InterruptedException {
        bot = JDABuilder.createDefault(TOKEN)
                .enableIntents(intents)
                .addEventListeners(eventListeners.toArray())
                .build()
                .awaitReady();
    }

    public void commandsRegister() {
        Guild guild = bot.getGuildById(GUILD_ID);
        if (guild != null) {
            for (Command command :
                    CommandsHandler.COMMANDS.values()) {
                if (command.getOptions() != null) {
                    guild.upsertCommand(command.getName(), command.getDescription())
                            .addOptions(command.getOptions())
                            .queue();
                } else {
                    guild.upsertCommand(command.getName(), command.getDescription())
                            .queue();
                }
            }
        }
    }

    public List<EventListener> getEventListeners() {
        return eventListeners;
    }

    public void setEventListeners(List<EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }

    public JDA getBot() {
        return bot;
    }

    public void setBot(JDA bot) {
        this.bot = bot;
    }

    public List<GatewayIntent> getIntents() {
        return intents;
    }

    public void setIntents(List<GatewayIntent> intents) {
        this.intents = intents;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public String getGUILD_ID() {
        return GUILD_ID;
    }
}
