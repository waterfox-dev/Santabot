package com.waterfox.santabot.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.Arrays;
import java.util.List;

public class CommandLoader
{
    public static List<SlashCommandData> commands = Arrays.asList(
            Commands.slash("ping", "Calculate the ping of SantaBot"),
            Commands.slash("getsecret", "Retourne le secret santa en DM."),
            Commands.slash("writesecret", "Permet d'écrire un message à son secret Santa")
                    .addOption(OptionType.STRING, "message", "Le message à distribuer", true)
                    .addOption(OptionType.ATTACHMENT, "fichier", "Fichier associé au message", false),
            Commands.slash("updatesecret", "Permet la lecture ou la modification du message")
                    .addOption(OptionType.STRING, "message", "Le nouveau message", false)
    );

    public static void load(JDA jda)
    {
        jda.updateCommands().addCommands(CommandLoader.commands).queue();
    }
}
