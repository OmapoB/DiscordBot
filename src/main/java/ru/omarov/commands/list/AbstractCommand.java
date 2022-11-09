package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class AbstractCommand implements Command {
    private String name;
    private String description;

    private List<OptionData> options;

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("this command doing nothing.").queue();
    }

    public boolean hasOptions() {
        return !options.isEmpty();
    }

    public List<OptionData> getOptions() {
        return options;
    }

    public void setOptions(OptionData... options) {
        this.options = List.of(options);
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
