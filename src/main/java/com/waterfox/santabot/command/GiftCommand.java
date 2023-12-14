package com.waterfox.santabot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class GiftCommand
{

    public void execute(MessageReceivedEvent event)
    {
        event.getChannel().sendMessage("Les messages viennent d'être distribués :)").addActionRow(Button.primary("getgift", "Mon cadeau !")).queue();
    }
}
