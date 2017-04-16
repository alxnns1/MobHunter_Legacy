package com.alxnns1.mobhunter.command;

import com.alxnns1.mobhunter.capability.monsters.IMonsters;
import com.alxnns1.mobhunter.capability.monsters.MonsterSize;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.init.MHEntities;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.*;

/**
 * Created by Mark on 10/04/2017.
 */
public class CommandMonsters extends CommandBase
{
    @Override
    public String getName()
    {
        return "monsters";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "Usage:" +
                "List all monsters: monsters <pageNum>" +
                "Show for specific monster: monsters [monsterName]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if(sender.getEntityWorld().isRemote || !(sender instanceof EntityPlayerMP))
            return;

        EntityPlayerMP player = (EntityPlayerMP) sender;
        IMonsters cap = player.getCapability(MHCapabilities.MONSTERS, null);
        if(cap == null)
            throw new CommandException("Couldn't get monster data for player " + player.getDisplayNameString() + "!");

        //Just for testing if we need to clear the list in the capability
        /*
        if(args.length == 1 && args[0].equals("clear"))
        {
            cap.getAllMonsterSizes().clear();
            cap.dataChanged(player);
            player.sendMessage(new TextComponentString("Cleared"));
            return;
        }
        */

        int page = Integer.MIN_VALUE;
        if(args.length > 0)
        {
            try
            {
                page = Integer.valueOf(args[0]);
            }
            catch(NumberFormatException e) {}
        }

        if(args.length == 0 || page != Integer.MIN_VALUE)
        {
            //Show the list of all monsters, but only so many per page
            List<MonsterSize> monsters = cap.getAllMonsterSizes();

            if(monsters.size() == 0)
            {
                player.sendMessage(new TextComponentTranslation("message.monsters.noneKilled"));
                return;
            }

            int monstersPerPage = 9;
            int pageMax = monsters.size() / monstersPerPage;
            if(page < 0) page = 0;
            //We reduce the given page number by 1, because we calculate starting from page 0, but is shown to start from page 1.
            if(page > 0) page--;
            if(page * monstersPerPage > monsters.size()) page = pageMax;

            //Work out the range to display on the page
            int min = page * monstersPerPage;
            int max = min + monstersPerPage;
            if(monsters.size() < max) max = monsters.size();

            //Create the String to send to the player
            ITextComponent text = new TextComponentString(TextFormatting.YELLOW + "============= ");
            TextComponentTranslation titleText = new TextComponentTranslation("message.monsters.title", (page + 1), (pageMax + 1));
            titleText.getStyle().setColor(TextFormatting.GOLD);
            text.appendSibling(titleText);
            text.appendText(TextFormatting.YELLOW +  " =============");
            for(int i = min; i < max; i++)
            {
                MonsterSize ms = monsters.get(i);
                text.appendSibling(new TextComponentString("\n  "))
                        .appendSibling(new TextComponentTranslation(ms.getEntityUnlocName()))
                        .appendText(" -> ")
                        .appendSibling(new TextComponentTranslation("message.monsters.small"))
                        .appendText(": " + CommonUtil.floatAsPercentage(ms.smallest) + "% - ")
                        .appendSibling(new TextComponentTranslation("message.monsters.large"))
                        .appendText(": " + CommonUtil.floatAsPercentage(ms.largest) + "%");
            }
            player.sendMessage(text);
        }
        else if(args.length == 1)
        {
            //Show the sizes for a specific monster
            String monster = args[0];
            MonsterSize sizes = cap.getMonsterSizes(monster);
            if(sizes == null)
            {
                player.sendMessage(new TextComponentTranslation("message.monsters.cantFind", monster));
                return;
            }
            player.sendMessage(new TextComponentTranslation(sizes.getEntityUnlocName())
                    .appendText(":\n")
                    .appendSibling(new TextComponentTranslation("message.monsters.small"))
                    .appendText(": " + CommonUtil.floatAsPercentage(sizes.smallest) + "% - ")
                    .appendSibling(new TextComponentTranslation("message.monsters.large"))
                    .appendText(": " + CommonUtil.floatAsPercentage(sizes.largest) + "%"));
        }
        else
            throw new WrongUsageException(getUsage(sender));
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        if(args.length == 1)
            return getListOfStringsMatchingLastWord(args, MHEntities.ENTITY_NAMES);
        return Collections.emptyList();
    }
}
