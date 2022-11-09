package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import ru.omarov.commands.CommandsHandler;

import java.util.Map;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        this.setName("help");
        this.setDescription("выводит список команд");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        StringBuilder help = new StringBuilder();
        for (Command command :
                CommandsHandler.COMMANDS.values()) {
            help.append(command.toString());
        }
        event.reply(help.toString()).queue();
    }
}
