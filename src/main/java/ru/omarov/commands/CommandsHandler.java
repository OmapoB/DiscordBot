package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.list.Command;
import ru.omarov.commands.list.HelpCommand;
import ru.omarov.commands.list.PlayCommand;

import java.util.Map;

public class CommandsHandler extends ListenerAdapter {
    public static final Map<String, Command> COMMANDS = Map.ofEntries(
            Map.entry("help", new HelpCommand()),
            Map.entry("play", new PlayCommand())
    );

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals(COMMANDS.get("help").getName())) {
            COMMANDS.get("help").execute(event);
        } else if (event.getName().equals(COMMANDS.get("play").getName())) {
            COMMANDS.get("play").execute(event);
        }
    }
}
