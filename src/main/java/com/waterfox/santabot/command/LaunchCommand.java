package com.waterfox.santabot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class LaunchCommand
{
    public void execute(MessageReceivedEvent event)
    {
        String msg = """
                # SantaBot\s
                La période de Noël est SantaBot revient lui aussi, tout naturellement.\s
                Cette année le moteur du Bot à un peu changer et il intègre les slashs commands.\s
                Pour ce qui ne connaisse pas le principe, voici une explication.\s
                L'évènement se déroule en trois étapes :\s
                - __L'inscription__ : Tout ce qui veulent participer s'inscrivent à l'évènement permettant, le moment venue de rédiger un message\s
                - __La rédaction de message__ : Chaque participant reçoit en secret santa un autre participant et il peut lui écrire un message\s
                - __L'envoi__ : Tous les messages sont distribués au secret santa qui peuvent le découvrir\s
                Pour l'instant personne ne peut rédiger de message, pour autant, pour vous inscrire, il suffit de cliquer sur le bouton ci-dessous""";

        event.getChannel().sendMessage(msg).addActionRow(Button.primary("login", "Je m'inscris")).queue();
    }
}
