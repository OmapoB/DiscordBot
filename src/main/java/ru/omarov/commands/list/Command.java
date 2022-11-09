package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface Command {
    void execute(SlashCommandInteractionEvent event);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
