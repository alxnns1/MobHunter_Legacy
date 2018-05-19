package alxnns1.mobhunter.init;

import alxnns1.mobhunter.capability.Storage;
import alxnns1.mobhunter.capability.hunterRank.CapabilityHunterRank;
import alxnns1.mobhunter.capability.hunterRank.IHunterRank;
import alxnns1.mobhunter.capability.monsters.CapabilityMonsters;
import alxnns1.mobhunter.capability.monsters.IMonsters;
import alxnns1.mobhunter.capability.quest.CapabilityQuest;
import alxnns1.mobhunter.capability.quest.IQuest;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import java.util.ArrayList;

/**
 * Created by Mark on 17/01/2017.
 */
public class MHCapabilities
{
    @CapabilityInject(IQuest.class)
    public static Capability<IQuest> QUESTS = null;
    @CapabilityInject(IHunterRank.class)
    public static Capability<IHunterRank> HUNTER_RANK = null;
    @CapabilityInject(IMonsters.class)
    public static Capability<IMonsters> MONSTERS = null;

    private static ArrayList<Capability> CAPABILITIES = new ArrayList<>();

    public static ArrayList<Capability> getCapabilities()
    {
        if(CAPABILITIES.isEmpty())
        {
            CAPABILITIES.add(QUESTS);
            CAPABILITIES.add(HUNTER_RANK);
            CAPABILITIES.add(MONSTERS);
        }
        return CAPABILITIES;
    }

    public static void init()
    {
        CapabilityManager.INSTANCE.register(IHunterRank.class, new Storage<>(), CapabilityHunterRank::new);
        CapabilityManager.INSTANCE.register(IQuest.class, new Storage<>(), CapabilityQuest::new);
        CapabilityManager.INSTANCE.register(IMonsters.class, new Storage<>(), CapabilityMonsters::new);
    }
}
