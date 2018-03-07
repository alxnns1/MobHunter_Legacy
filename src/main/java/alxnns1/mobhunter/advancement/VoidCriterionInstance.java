package alxnns1.mobhunter.advancement;

import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 07/03/2018.
 */
public class VoidCriterionInstance extends MHCriterionInstance<Void>
{
    public VoidCriterionInstance(ResourceLocation id)
    {
        super(id, null);
    }

    @Override
    public boolean test(Void object)
    {
        return true;
    }
}
