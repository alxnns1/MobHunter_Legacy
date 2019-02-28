package alxnns1.mobhunter.advancement.trigger;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.advancement.MHCriterionInstance;
import alxnns1.mobhunter.advancement.MHTrigger;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 07/03/2018.
 */
public class SmallCrownTrigger extends MHTrigger<SmallCrownTrigger.Instance, Float>
{
	public SmallCrownTrigger()
	{
		super("small_crown", "scale");
	}

	@Override
	public Instance deserializeInstance(JsonObject json, JsonDeserializationContext context)
	{
		String string = getObjectStringFromJson(json);
		if(string != null)
		{
			float value;
			try
			{
				value = Float.valueOf(string);
				return new Instance(ID, value);
			}
			catch(NumberFormatException e)
			{
				MobHunter.LOGGER.error("Value " + string + " is not a float!", e);
			}
		}
		return new Instance(ID, Float.MAX_VALUE);
	}

	public static class Instance extends MHCriterionInstance<Float>
	{
		private final Float object;

		public Instance(ResourceLocation id, Float object)
		{
			super(id, object);
			this.object = object;
		}

		@Override
		public boolean test(Float object)
		{
			//TODO: Need to take into account that the min/max scale is configurable!
			return object != null && object < this.object;
		}
	}
}
