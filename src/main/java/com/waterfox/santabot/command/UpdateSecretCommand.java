package com.waterfox.santabot.command;

import com.waterfox.santabot.JsonUtil;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Objects;

public class UpdateSecretCommand implements Command
{
    @Override
    public void execute(SlashCommandInteractionEvent event)
    {
        String secret = JsonUtil.getMessage(event.getUser().getIdLong());
        event.getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(secret).addActionRow(Button.primary("update", "Mettre à jour"))).queue();
        if(JsonUtil.getFile(event.getUser().getIdLong()) != null)
        {
            event.getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(Objects.requireNonNull(JsonUtil.getFile(event.getUser().getIdLong()))).addActionRow(Button.primary("update", "Mettre à jour"))).queue();
        }
        event.deferReply().queue();
    }
}
