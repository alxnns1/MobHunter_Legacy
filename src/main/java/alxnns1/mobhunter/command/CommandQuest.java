package alxnns1.mobhunter.command;

import alxnns1.mobhunter.capability.quest.MHQuest;
import alxnns1.mobhunter.capability.quest.MHQuestCooldown;
import alxnns1.mobhunter.capability.quest.EnumQuestDataChange;
import alxnns1.mobhunter.capability.quest.IQuest;
import alxnns1.mobhunter.init.MHCapabilities;
import alxnns1.mobhunter.init.MHQuests;
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
 * Created by Mark on 13/03/2017.
 */
public class CommandQuest extends CommandBase
{
    @Override
    public String getName()
    {
        return "quest";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "Usage:" +
                "\nClear all quest progress: quest clearAll [playerName]" +
                "\nClear current quest: quest clearCurrent [playerName]" +
                "\nComplete a quest: quest complete <questID> [playerName]" +
                "\nUncomplete a quest: quest uncomplete <questID> [playerName]" +
                "\nAccept a quest: quest accept <questID> [playerName]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if(sender.getEntityWorld().isRemote)
            return;
        if(args.length == 0)
            throw new WrongUsageException(getUsage(sender));

        if(((args[0].equals("clearAll") || args[0].equals("clearCurrent")) && args.length < 1) ||
                (((!args[0].equals("clearAll") && !args[0].equals("clearCurrent")) && args.length < 2)))
            throw new WrongUsageException(getUsage(sender));

        //Get quest capability for the targeted player
        EntityPlayerMP target = null;
        IQuest questCap;
        if(args[0].equals("clearAll") && args.length >= 2)
            target = server.getPlayerList().getPlayerByUsername(args[1]);
        else if(args.length >= 3)
            target = server.getPlayerList().getPlayerByUsername(args[2]);
        else if(sender instanceof EntityPlayerMP)
            target = (EntityPlayerMP) sender;

        if(target == null)
            throw new CommandException("Couldn't get target player!");
        else
            questCap = target.getCapability(MHCapabilities.QUESTS, null);
        if(questCap == null)
            throw new CommandException("Couldn't get quest data for player " + target.getDisplayNameString() + "!");

        //Get the quest if applicable
        MHQuest quest = null;
        if(!args[0].equals("clearAll") && !args[0].equals("clearCurrent"))
        {
            quest = MHQuests.getQuest(args[1]);
            if(quest == null)
            {
                sender.sendMessage(new TextComponentTranslation("message.quest.noQuest", args[1]));
                return;
            }
        }

        if(args[0].equals("clearAll"))
        {
            questCap.clearQuest();
            questCap.getCompletedQuests().clear();
            questCap.getCooldownQuests().clear();
            questCap.dataChanged(target, EnumQuestDataChange.ALL);
            sender.sendMessage(new TextComponentTranslation("message.quest.clearAll", target.getDisplayNameString()));
        }
        else if(args[0].equals("clearCurrent"))
        {
            questCap.clearQuest();
            questCap.dataChanged(target, EnumQuestDataChange.CURRENT);
            sender.sendMessage(new TextComponentTranslation("message.quest.clearCurrent", target.getDisplayNameString()));
        }
        else if(args[0].equals("complete"))
        {
            questCap.getCompletedQuests().add(quest.getQuestId());
            MHQuestCooldown cooldownQuest = questCap.getQuestCooldown(quest);
            if(cooldownQuest != null)
            {
                questCap.getCooldownQuests().remove(cooldownQuest);
                questCap.dataChanged(target, EnumQuestDataChange.COOLDOWN);
            }
            questCap.dataChanged(target, EnumQuestDataChange.COMPLETED);
            sender.sendMessage(new TextComponentTranslation("message.quest.forceComplete", quest.getQuestId(), target.getDisplayNameString()));
        }
        else if(args[0].equals("uncomplete"))
        {
            questCap.getCompletedQuests().remove(quest.getQuestId());
            MHQuestCooldown cooldownQuest = questCap.getQuestCooldown(quest);
            if(cooldownQuest != null)
            {
                questCap.getCooldownQuests().remove(cooldownQuest);
                questCap.dataChanged(target, EnumQuestDataChange.COOLDOWN);
            }
            questCap.dataChanged(target, EnumQuestDataChange.COMPLETED);
            sender.sendMessage(new TextComponentTranslation("message.quest.forceUncomplete", quest.getQuestId(), target.getDisplayNameString()));
        }
        else if(args[0].equals("accept"))
        {
            questCap.clearQuest();
            questCap.addQuest(quest, server.getEntityWorld().getTotalWorldTime());
            MHQuestCooldown cooldownQuest = questCap.getQuestCooldown(quest);
            if(cooldownQuest != null)
            {
                questCap.getCooldownQuests().remove(cooldownQuest);
                questCap.dataChanged(target, EnumQuestDataChange.COOLDOWN);
            }
            questCap.dataChanged(target, EnumQuestDataChange.CURRENT);
            sender.sendMessage(new TextComponentTranslation("message.quest.setQuest", quest.getQuestId(), target.getDisplayNameString()));
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        switch(args.length)
        {
            case 1:
                return getListOfStringsMatchingLastWord(args, "clearAll", "clearCurrent", "complete", "uncomplete", "accept");
            case 2:
                if(args[1].equals("clearAll") || args[1].equals("clearCurrent"))
                    return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
                else
                    return getListOfStringsMatchingLastWord(args, MHQuests.getQuestIds());
            case 3:
                if(!args[1].equals("clearAll") && !args[1].equals("clearCurrent"))
                    return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
            default:
                return Collections.<String>emptyList();
        }
    }
}
