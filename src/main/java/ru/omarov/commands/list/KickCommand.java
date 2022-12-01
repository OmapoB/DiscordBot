package ru.omarov.commands.list;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import ru.omarov.commands.AbstractCommand;

import java.util.ArrayList;
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
                        true
                )
        ));
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        List<String> whiteList = new ArrayList<>(); //пока нет бдшки
        List<Member> toKick = event.getOption(member).getMentions().getMembers();
        if (toKick
                .size() == 0) {
            event.reply("Кого кикать-то").queue();
        } else if (toKick
                .size() > 1) {
            event.reply("По одной давай.").queue();
        } else if (whiteList.contains(toKick.get(0))) {
            event.replyFormat("%s его нельзя кикать. %s", whiteList.get(0));
        } else {
            Member memberToKick = toKick.get(0);
            event.getGuild()
                    .kick(memberToKick)
                    .reason(event.getOption(reason).toString()).queue(
                            (__) -> event.getChannel()
                                    .sendMessageFormat("%s кикнут по причине: \"%s\"",
                                            memberToKick,
                                            event.getOption(reason).getAsString())
                                    .queue(),
                            (error) -> event
                                    .getChannel()
                                    .sendMessageFormat("Ошибка: %s", error.getMessage())
                                    .queue()
                    );
        }
    }
}
