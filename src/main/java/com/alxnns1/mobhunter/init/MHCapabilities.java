package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.capability.hunterRank.CapabilityHunterRank;
import com.alxnns1.mobhunter.capability.hunterRank.IHunterRank;
import com.alxnns1.mobhunter.capability.quest.CapabilityQuest;
import com.alxnns1.mobhunter.capability.quest.IQuest;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by Mark on 17/01/2017.
 */
public class MHCapabilities
{
    @CapabilityInject(IQuest.class)
    public static Capability<IQuest> QUESTS = null;
    @CapabilityInject(IHunterRank.class)
    public static Capability<IHunterRank> HUNTER_RANK = null;

    private static ArrayList<Capability> CAPABILITIES = new ArrayList<Capability>();

    public static ArrayList<Capability> getCapabilities()
    {
        if(CAPABILITIES.isEmpty())
        {
            CAPABILITIES.add(QUESTS);
            CAPABILITIES.add(HUNTER_RANK);
        }
        return CAPABILITIES;
    }

    public static void init()
    {
        CapabilityManager.INSTANCE.register(IHunterRank.class, CapabilityHunterRank.Storage.INSTANCE, new Callable<IHunterRank>()
        {
            @Override
            public IHunterRank call() throws Exception
            {
                return new CapabilityHunterRank();
            }
        });

        CapabilityManager.INSTANCE.register(IQuest.class, CapabilityQuest.Storage.INSTANCE, new Callable<IQuest>()
        {
            @Override
            public IQuest call() throws Exception
            {
                return new CapabilityQuest();
            }
        });
    }
}
