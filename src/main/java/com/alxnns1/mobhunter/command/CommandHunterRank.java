package com.alxnns1.mobhunter.command;

import com.alxnns1.mobhunter.capability.hunterRank.IHunterRank;
import com.alxnns1.mobhunter.init.MHCapabilities;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mark on 14/03/2017.
 */
public class CommandHunterRank extends CommandBase
{
    @Override
    public String getName()
    {
        return "hr";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "Usage:" +
                "Add/Remove HR points: hr addPoints <amount> [playerName]" +
                "Set HR points: hr setPoints <amount> [playerName]" +
                "Add/Remove HR: hr addRank <amount> [playerName]" +
                "Set HR: hr setRank <amount> [playerName]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if(sender.getEntityWorld().isRemote)
            return;
        if(args.length < 2)
            throw new WrongUsageException(getUsage(sender));

        EntityPlayerMP target = null;
        IHunterRank hrCap;
        if(args.length > 2)
            target = server.getPlayerList().getPlayerByUsername(args[2]);
        else if(sender instanceof EntityPlayerMP)
            target = (EntityPlayerMP) sender;

        if(target == null)
            throw new CommandException("Couldn't get target player!");
        else
            hrCap = target.getCapability(MHCapabilities.HUNTER_RANK, null);
        if(hrCap == null)
            throw new CommandException("Couldn't get hunter rank data for player " + target.getDisplayNameString() + "!");

        int amount;
        try
        {
            amount = Integer.valueOf(args[1]);
        }
        catch(NumberFormatException e)
        {
            throw new CommandException(args[1] + " is not a number!");
        }

        if(args[0].equals("addPoints"))
        {
            hrCap.changeProgressPointsBy(target, amount);
            sender.sendMessage(new TextComponentTranslation(amount >= 0 ? "message.hr.added" : "message.hr.removed")
                    .appendText(" ")
                    .appendSibling(new TextComponentTranslation("message.hr.addPoints", amount, target.getDisplayNameString(), hrCap.getProgressPoints())));
        }
        else if(args[0].equals("setPoints"))
        {
            hrCap.setProgressPoints(target, amount);
            sender.sendMessage(new TextComponentTranslation("message.hr.setPoints", amount, target.getDisplayNameString()));
        }
        else if(args[0].equals("addRank"))
        {
            hrCap.changeRankBy(target, amount);
            sender.sendMessage(new TextComponentTranslation(amount >= 0 ? "message.hr.added" : "message.hr.removed")
                    .appendText(" ")
                    .appendSibling(new TextComponentTranslation("message.hr.addRank", amount, target.getDisplayNameString(), hrCap.getRank())));
        }
        else if(args[0].equals("setRank"))
        {
            hrCap.setRank(target, amount);
            sender.sendMessage(new TextComponentTranslation("message.hr.setRank", amount, target.getDisplayNameString()));
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        switch(args.length)
        {
            case 1:
                return getListOfStringsMatchingLastWord(args, "addPoints", "setPoints", "addRank", "setRank");
            case 3:
                return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
            default:
                return Collections.<String>emptyList();
        }
    }
}
