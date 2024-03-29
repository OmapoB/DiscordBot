package ru.omarov.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventsHandler extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        if (event.getUser().isBot()) {
            event.getGuild()
                    .getChannelById(TextChannel.class, 1032334538292068352L)
                    .sendMessageFormat("%s, пошел на уйх", event.getUser())
                    .queue();
            return;
        }
        event.getGuild()
                .getChannelById(TextChannel.class, 1032334538292068352L)
                .sendMessage("Салам алейкум уцыыы.\n" +
                        "Введи команду /names, чтобы выбрать ник" +
                        " и получить роль жиес.")
                .queue();
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        Guild guild = event.getGuild();
        assert guild != null;
        Member member = event.getMember();
        assert member != null;
        String chosenNickname = event.getInteraction().getValues().get(0);
        guild.modifyNickname(member, chosenNickname).queue();
        guild.addRoleToMember(member, guild.getRoleById("935230486811398254")).queue();
        event.getMessage().delete().queue();
        guild.getChannelById(TextChannel.class, 1015901267240951818L)
                .sendMessageFormat("У нас новый участник.\n%s а.к.а %s", member.getUser().getName(), chosenNickname)
                .queue();
    }
}
