package com.waterfox.santabot;

import com.waterfox.santabot.command.CommandLoader;
import com.waterfox.santabot.command.LaunchCommand;
import com.waterfox.santabot.command.PingCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot extends ListenerAdapter
{
    public static JDA jda;
    public static JDABuilder jdaBuilder;
    public static long owner = 669530329299550218L;

    public void createBot(String[] args)
    {
         Bot.jdaBuilder = JDABuilder.createDefault(
                "MTA1MTQ5MzQxODkwMTE5Mjc0Ng.GhQllG._rLUDpkwv5h497K6Xl80JO77KaR6HD5T1T-_R4",
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.GUILD_MESSAGE_TYPING,
                GatewayIntent.GUILD_MEMBERS);


        Bot.jdaBuilder.setActivity(Activity.playing("Gribouille.java"));

        try
        {
            Bot.jda = jdaBuilder.build().awaitReady();

            Bot.jdaBuilder.addEventListeners(new Bot());

            Bot.jda = Bot.jdaBuilder.build();
            CommandLoader.load(Bot.jda);

        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event)
    {
        switch (event.getName())
        {
            case "ping" -> new PingCommand().execute(event);
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (Bot.owner == event.getAuthor().getIdLong())
        {
            System.out.println(event.getMessage().getContentRaw());
            if (event.getMessage().getContentRaw().equals("//launch"))
            {
                new LaunchCommand().execute(event);
            }
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event)
    {
        if (event.getComponentId().equals("login"))
        {
            event.deferEdit().queue();
            event.getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("Inscription bien enregistrée :white_check_mark: ")).queue();
            JsonUtil.addUser(event.getUser().getIdLong());
        }
    }
}
