package ru.omarov.commands;

public enum CommandsEnum {
    HELP("help", "выводит список команд"),
    PLAY("play", "воспроизводит трек по ссылке");

    private final String name;
    private final String description;

    CommandsEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
