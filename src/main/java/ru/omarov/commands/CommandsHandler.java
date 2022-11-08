package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.list.HelpCommand;
import ru.omarov.commands.list.PlayCommand;

public class CommandsHandler extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals(HelpCommand.allCommands.get("help").getText())) {
            event.reply(HelpCommand.getHelp()).queue();
        } else if (event.getName().equals(HelpCommand.allCommands.get("play").getText())) {
            event.reply(PlayCommand.play()).queue();
        }
    }
}
