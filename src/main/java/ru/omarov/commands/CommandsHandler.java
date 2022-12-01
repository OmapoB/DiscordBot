package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.list.*;

import java.util.Map;

public class CommandsHandler extends ListenerAdapter {
    public static final Map<String, Command> COMMANDS = Map.ofEntries(
            Map.entry("help", new HelpCommand()),
            Map.entry("play", new PlayCommand()),
            Map.entry("kick", new KickCommand()),
            Map.entry("names", new NamesCommand())
    );

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getUser().isBot()) {
            event.reply("Бот, пошел на йух!").queue();
            return;
        }
        COMMANDS.get(event.getName()).execute(event);
    }
}
