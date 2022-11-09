package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.List;

public class KickCommand extends AbstractCommand{
    public KickCommand() {
        this.setName("kick");
        this.setDescription("Выгоняет участника с сервера.\n" +
                "/kick <кого> <почему>");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

    }
}
