package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.AbstractCommand;
import ru.omarov.commands.Command;
import ru.omarov.commands.CommandsHandler;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        this.setName("help");
        this.setDescription("выводит список команд");
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        StringBuilder help = new StringBuilder();
        for (Command command :
                CommandsHandler.COMMANDS.values()) {
            help.append(command.toString());
        }
        event.reply(help.toString()).queue();
    }
}
