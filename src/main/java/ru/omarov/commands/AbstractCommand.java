package ru.omarov.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AbstractCommand implements Command {
    private String name;
    private String description;
    private List<OptionData> options;

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        event.reply("this command doing nothing.").queue();
    }

    @Override
    public List<OptionData> getOptions() {
        return options;
    }

    @Override
    public void setOptions(List<OptionData> options) {
        this.options = options;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + ": " + description + "\n";

    }
}
