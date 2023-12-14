package com.waterfox.santabot.command;

import com.waterfox.santabot.JsonUtil;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.Objects;

public class WriteSecretCommand implements Command {

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (event.getOption("fichier") != null) {
            Message.Attachment a = event.getOption("fichier").getAsAttachment();
            JsonUtil.writeFile(event.getUser().getIdLong(), a.getUrl());
        }
        else
        {
            JsonUtil.writeFile(event.getUser().getIdLong(),"");
        }

        JsonUtil.writeMessage(event.getUser().getIdLong(), Objects.requireNonNull(event.getOption("message")).getAsString());
        event.reply("Message enregistré :)").queue();
    }

}