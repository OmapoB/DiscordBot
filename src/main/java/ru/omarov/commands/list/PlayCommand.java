package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.AbstractCommand;

import java.util.List;

public class PlayCommand extends AbstractCommand {
    public PlayCommand() {
        this.setName("play");
        this.setDescription("воспроизводит аудио по ссылке в голосовой канал");
        this.setOptions(List.of(
                new OptionData(OptionType.STRING,
                        "ссылка",
                        "ссылка на трэк",
                        true),
                new OptionData(OptionType.STRING,
                        "2ss",
                        "2sss")
        ));
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        System.out.println(event.getOptions());
    }
}
