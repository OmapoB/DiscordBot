package ru.omarov.commands.list;

import java.util.Map;

public class HelpCommand extends Command {
    public static final Map<String, Command> allCommands = Map.ofEntries(
            Map.entry("help", new HelpCommand()),
            Map.entry("play", new PlayCommand())
    );

    public HelpCommand() {
        this.setText("help");
        this.setDescription("выводит список команд");
    }

    public static String getHelp() {
        StringBuilder help = new StringBuilder();
        for (Command command :
                allCommands.values()) {
            help.append(command.toString());
        }
        return help.toString();
    }
}
