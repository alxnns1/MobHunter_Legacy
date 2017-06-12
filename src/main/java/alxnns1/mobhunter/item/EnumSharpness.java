package alxnns1.mobhunter.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;

/**
 * Created by Mark on 19/05/2016.
 */
public enum EnumSharpness
{
    RED(0, TextFormatting.RED, "sharpness.red.name", 0.5f, 0.25f),
    ORANGE(1, TextFormatting.GOLD, "sharpness.orange.name", 0.75f, 0.5f),
    YELLOW(2, TextFormatting.YELLOW, "sharpness.yellow.name", 1f, 0.75f),
    GREEN(3, TextFormatting.GREEN, "sharpness.green.name", 1.05f, 1f),
    BLUE(4, TextFormatting.BLUE, "sharpness.blue.name", 1.2f, 1.0625f),
    WHITE(5, TextFormatting.WHITE, "sharpness.white.name", 1.32f, 1.125f),
    PURPLE(6, TextFormatting.LIGHT_PURPLE, "sharpness.purple.name", 1.45f, 1.2f);

    private static final EnumSharpness[] allValues = new EnumSharpness[values().length];
    private final int id;
    private final TextFormatting colour;
    private final String name;
    private final float damage;
    private final float element;

    //Creates the array containing all the sharpness levels in order
    static
    {
        for(EnumSharpness es : values())
        {
            allValues[es.id] = es;
        }
    }

    EnumSharpness(int id, TextFormatting chatColour, String unlocalisedName, float damageMult, float elementMult)
    {
        this.id = id;
        this.colour = chatColour;
        this.name = unlocalisedName;
        this.damage = damageMult;
        this.element = elementMult;
    }

    public static boolean isSame(EnumSharpness sharpness1, EnumSharpness sharpness2)
    {
        return sharpness1.id == sharpness2.id;
    }

    public static EnumSharpness getById(int id)
    {
        if(id > allValues.length - 1 || id < 0)
            return null;
        return allValues[id];
    }

    public int getId()
    {
        return id;
    }

    public EnumSharpness getNextSharpness()
    {
        return getNextSharpness(1);
    }

    /**
     * Gets a sharpness which is 'i' higher than the current one.
     * @param i Amount higher than current sharpness level.
     * @return The higher sharpness level.
     */
    public EnumSharpness getNextSharpness(int i)
    {
        if(i < 1)
            return this;
        if(id + i > allValues.length - 1)
            return allValues[allValues.length - 1];
        return allValues[id + i];
    }

    public EnumSharpness getPrevSharpness()
    {
        return getPrevSharpness(1);
    }

    /**
     * Gets a sharpness which is 'i' lower than the current one.
     * @param i Amount lower than current sharpness level.
     * @return The lower sharpness level.
     */
    public EnumSharpness getPrevSharpness(int i)
    {
        if(i < 1)
            return this;
        if(id - i < 0)
            return allValues[0];
        return allValues[id - i];
    }

    public TextFormatting getChatColour()
    {
        return colour;
    }

    public String getUnlocalizedName()
    {
        return name;
    }

    public String getLocalizedName()
    {
        return I18n.format(name);
    }

    public float getDamageMult()
    {
        return damage;
    }

    public float getElementalMult()
    {
        return element;
    }
}
