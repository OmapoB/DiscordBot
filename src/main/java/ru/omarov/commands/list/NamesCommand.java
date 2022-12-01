package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.AbstractCommand;

import java.util.ArrayList;
import java.util.List;

public class NamesCommand extends AbstractCommand {
    private List<SelectOption> namesList = new ArrayList<>();

    public NamesCommand() {
        this.setName("names");
        this.setDescription("Выводит список доступных никнеймов");
        this.addNames(List.of(
                "Конев",
                "Жуков",
                "Малиновский",
                "Берия",
                "Космодемьянская",
                "Савицкая"
        ));
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        StringSelectMenu list = StringSelectMenu.create("select:names")
                .setPlaceholder("Раскрой")
                .setRequiredRange(1, 1)
                .addOptions(namesList)
                .build();

        event.reply("Выберите себе никнейм")
                .setEphemeral(true)
                .addActionRow(list)
                .queue();
    }

    public List<SelectOption> getNamesList() {
        return namesList;
    }

    public void addName(String name) {
        namesList.add(SelectOption.of(name, "ник"));
    }

    public void addNames(List<String> names) {
        for (String name :
                names) {
            namesList.add(SelectOption.of(name, name));
        }
    }
}
