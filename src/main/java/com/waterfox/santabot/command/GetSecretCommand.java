package com.waterfox.santabot.command;

import com.waterfox.santabot.JsonUtil;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GetSecretCommand implements Command
{

    @Override
    public void execute(SlashCommandInteractionEvent event)
    {
        event.reply("Salut " + event.getUser().getName() + "\n" +
                "Ton Secret Santa est : <@" + String.valueOf(JsonUtil.getSecret(event.getUser().getIdLong())) + ">\n" +
                "Soit gentil avec et écrit lui un doux message avec la commande `/writesecret`").queue();
    }
}
