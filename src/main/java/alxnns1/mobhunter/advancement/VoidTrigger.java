package alxnns1.mobhunter.advancement;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

/**
 * Created by Mark on 07/03/2018.
 */
public class VoidTrigger extends MHTrigger<VoidCriterionInstance, Void>
{
	public VoidTrigger(String name)
	{
		super(name, null);
	}

	@Override
	public VoidCriterionInstance deserializeInstance(JsonObject json, JsonDeserializationContext context)
	{
		return new VoidCriterionInstance(ID);
	}
}
