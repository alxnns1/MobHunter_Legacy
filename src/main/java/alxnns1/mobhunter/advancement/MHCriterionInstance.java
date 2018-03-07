package alxnns1.mobhunter.advancement;

import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 07/03/2018.
 */
public abstract class MHCriterionInstance<T> extends AbstractCriterionInstance
{
    protected final T object;

    public MHCriterionInstance(ResourceLocation id, T object)
    {
        super(id);
        this.object = object;
    }

    public abstract boolean test(T object);
}
