package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class PlayCommand extends AbstractCommand {
    private final OptionData link = new OptionData(OptionType.STRING,
            "link", "ссылка на аудио");
    public PlayCommand() {
        this.setName("play");
        this.setDescription("воспроизводит аудио по ссылке в голосовой канал");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        setOptions(link);
        System.out.println(event.getOptions());
    }
}
