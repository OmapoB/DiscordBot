package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandsHandler extends ListenerAdapter {
    private String reply = "";
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals(CommandsEnum.HELP.getName())) {
            for (CommandsEnum command: CommandsEnum.values()) {
                reply = reply.concat(command.getName() + ": " + command.getDescription() + "\n");
            }
            event.reply(reply).queue();
        } else if (event.getName().equals(CommandsEnum.PLAY.getName())) {
            reply = reply.concat("сейчас играет: " + "ничего");
            event.reply(reply).queue();
        }
    }
}
