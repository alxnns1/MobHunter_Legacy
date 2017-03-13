package com.alxnns1.mobhunter.capability.quest;

public enum EnumQuestStatus
{
    ACCEPTED(0xE52B2B), //Red
    COMPLETED(0x18AF27), //Green
    COOLDOWN(0x3591CE), //Blue
    UNCOMPLETED(0xEAC81C); //Orange

    private final int colour;

    EnumQuestStatus(int colour)
    {
        this.colour = colour;
    }

    public int getColour()
    {
        return colour;
    }
}
