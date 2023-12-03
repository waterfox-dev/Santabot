package com.waterfox.santabot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface Command
{
    public void execute(SlashCommandInteractionEvent event);
}
