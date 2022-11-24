package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.list.HelpCommand;
import ru.omarov.commands.list.KickCommand;
import ru.omarov.commands.list.PlayCommand;

import java.util.Map;

public class CommandsHandler extends ListenerAdapter {
    public static final Map<String, Command> COMMANDS = Map.ofEntries(
            Map.entry("help", new HelpCommand()),
            Map.entry("play", new PlayCommand()),
            Map.entry("kick", new KickCommand())
    );

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getUser().isBot()) {
            event.reply("Бот, пошел на йух!");
            return;
        }
        COMMANDS.get(event.getName()).execute(event);
    }
}
