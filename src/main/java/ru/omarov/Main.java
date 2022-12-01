package ru.omarov;

import net.dv8tion.jda.api.requests.GatewayIntent;
import ru.omarov.commands.CommandsHandler;
import ru.omarov.config.Bot;
import ru.omarov.events.EventsHandler;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Bot bot = new Bot();
        bot.setEventListeners(List.of(new CommandsHandler(),
                new EventsHandler()));
        bot.setIntents(List.of(GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_MEMBERS));
        bot.startBot();
        bot.commandsRegister();
    }
}
