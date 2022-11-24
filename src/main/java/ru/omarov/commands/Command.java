package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Command {

    void execute(@NotNull SlashCommandInteractionEvent event);

    List<OptionData> getOptions();

    void setOptions(List<OptionData> options);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
