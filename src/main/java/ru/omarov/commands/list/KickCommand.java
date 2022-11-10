package ru.omarov.commands.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.AbstractCommand;

import java.util.List;

public class KickCommand extends AbstractCommand {
    private final String member = "кого";
    private final String reason = "почему";

    public KickCommand() {
        this.setName("kick");
        this.setDescription("Выгоняет участника с сервера.\n" +
                "/kick <кого> <почему>");
        this.setOptions(List.of(
                new OptionData(
                        OptionType.STRING,
                        member,
                        "@кого",
                        true
                ),
                new OptionData(
                        OptionType.STRING,
                        reason,
                        "та за шо",
                        false
                )
        ));
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        System.out.println(event.getOption(member).getMentions().getMembers());
        if (event.getOption(member).getMentions().getMembers().size() == 0) {
            event.reply("Кого кикать то").queue();
        } else if (event.getOption(member).getMentions().getMembers().size() > 1) {
            event.reply("По одной давай.").queue();
//        } else if (event.getOption(member).getMentions().getMembers())
//        if (event.getOption(member).getAsMember() != null) {
//            Member memberToKick = event.getOption(member).getAsMember();
//            String reasonWhy = event.getOption(reason).toString();
//            event.getGuild()
//                    .kick(memberToKick)
//                    .reason(reasonWhy).queue(
//                            (__) -> event
//                                    .getChannel()
//                                    .sendMessageFormat("%s кикнут по причине %s", memberToKick, reasonWhy)
//                                    .queue(),
//                            (error) -> event
//                                    .getChannel()
//                                    .sendMessageFormat("Не получилось:(.\n%s", error.getMessage())
//                                    .queue()
//                    );
//        }
    }
}
