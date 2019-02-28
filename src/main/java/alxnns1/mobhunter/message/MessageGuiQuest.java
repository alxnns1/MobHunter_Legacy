package alxnns1.mobhunter.message;

import alxnns1.mobhunter.capability.quest.EnumQuestDataChange;
import alxnns1.mobhunter.capability.quest.IQuest;
import alxnns1.mobhunter.capability.quest.MHQuest;
import alxnns1.mobhunter.init.MHCapabilities;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.UUID;

/**
 * Created by Mark on 14/01/2017.
 */
public class MessageGuiQuest implements IMessage
{
	public int buttonId;
	public UUID playerUuid;

	public MessageGuiQuest(){}

	public MessageGuiQuest(int buttonId, UUID playerUuid)
	{
		this.buttonId = buttonId;
		this.playerUuid = playerUuid;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		buttonId = buf.readInt();
		long mostSig = buf.readLong();
		long leastSig = buf.readLong();
		playerUuid = new UUID(mostSig, leastSig);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(buttonId);
		buf.writeLong(playerUuid.getMostSignificantBits());
		buf.writeLong(playerUuid.getLeastSignificantBits());
	}

	public static class Handler implements IMessageHandler<MessageGuiQuest, IMessage>
	{
		@Override
		public IMessage onMessage(final MessageGuiQuest message, final MessageContext ctx)
		{
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.world;
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					WorldServer world = (WorldServer) ctx.getServerHandler().player.world;
					EntityPlayerMP player = (EntityPlayerMP) world.getPlayerEntityByUUID(message.playerUuid);
					if(message.buttonId > 1 && player == null)
						return;
					IQuest questCapability = player.getCapability(MHCapabilities.QUESTS, null);
					if(questCapability == null)
						return;
					switch(message.buttonId)
					{
						case 1:
							//Share
							//For info on what's going on here, have a look at:
							// StatBase#getStatName

							if(questCapability.getCurrentQuest() == null)
								return;

							MinecraftServer server = world.getMinecraftServer();
							if(server != null)
							{
								ITextComponent msg1;
								if(player != null)
									msg1 = new TextComponentTranslation("message.quest.share", player.getDisplayNameString())
											.appendText(" [");
								else
									msg1 = new TextComponentString("[");
								MHQuest quest = questCapability.getCurrentQuest().getQuest();
								TextComponentTranslation questName = new TextComponentTranslation(quest.getUnlocName());
								questName.getStyle().setColor(TextFormatting.GREEN);
								questName.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
										new TextComponentTranslation("message.quest.share.description")
												.appendText(":\n")
												.appendSibling(new TextComponentTranslation(quest.getUnlocDesc())
														.appendText("\n")
														.appendSibling(new TextComponentTranslation("message.quest.share.objectives"))
														.appendText(":\n")
														.appendSibling(quest.getObjectiveTextComponent())
														.appendText("\n")
														.appendSibling(new TextComponentTranslation("message.quest.share.penalty"))
														.appendText(":\n" + quest.getPointsPenaltyText() + "\n")
														.appendSibling(new TextComponentTranslation("message.quest.share.rewards"))
														.appendText(":\n" + quest.getPointsRewardText() + ", ")
														.appendSibling(quest.getRewardTextComponent()))));
								server.getPlayerList().sendMessage(msg1.appendSibling(questName).appendText("]"));
							}
							break;
						case 2:
							//Submit
							//Try to submit every item in the player's inventory
							for(int i = 0; i < player.inventory.getSizeInventory(); i++)
							{
								ItemStack stack = player.inventory.getStackInSlot(i);
								if(stack == null)
									continue;
								questCapability.progressQuest(player, stack);
								if(questCapability.getCurrentQuest() == null)
								{
									//Quest completed
									player.closeScreen();
									break;
								}
							}
							break;
						case 3:
							//Cancel
							questCapability.cancelQuest(player);
							questCapability.dataChanged(player, EnumQuestDataChange.CURRENT);
							player.closeScreen();
							break;
					}
				}
			});
			return null;
		}
	}
}
