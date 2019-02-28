package alxnns1.mobhunter.item;

import alxnns1.mobhunter.reference.MetaRef;

/**
 * Created by Mark on 17/10/2016.
 */
public interface ISubTypes<O extends Object>
{
	/**
	 * Returns the sub names for this item.
	 */
	String[] getSubNames();

	/**
	 * Override this method and use it for adding the item's sub names to the MetaRef class.
	 */
	O addToMetaRef(MetaRef.EnumItemType itemType);
}
