package com.waterfox.santabot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PingCommand implements Command
{
    @Override
    public void execute(SlashCommandInteractionEvent event)
    {
        long time = System.currentTimeMillis();
        event.reply("Pong!").setEphemeral(true).flatMap(v ->
                event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time)
        ).queue();
    }
}
