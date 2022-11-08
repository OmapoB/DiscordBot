package ru.omarov.commands.list;

public class PlayCommand extends Command {
    public PlayCommand() {
        this.setText("play");
        this.setDescription("воспроизводит аудио по ссылке в голосовой канал");
    }

    public static String play() {
        return "play";
    }
}
