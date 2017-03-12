package com.alxnns1.mobhunter.capability.quest;

public enum EnumQuestStatus
{
    ACCEPTED(0xE52B2B),
    COMPLETED(0x18AF27),
    COOLDOWN(0x1B7FC6),
    UNCOMPLETED(0xEAC81C);

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
