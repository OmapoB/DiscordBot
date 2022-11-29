package ru.omarov.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import ru.omarov.config.Bot;

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
                .sendMessage("Салам алейкум.\n" +
                        "Введи команду /names, чтобы выбрать ник" +
                        " и получить роль")
                .queue();
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        return;
    }
}
