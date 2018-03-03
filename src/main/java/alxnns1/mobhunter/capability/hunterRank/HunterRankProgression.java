package alxnns1.mobhunter.capability.hunterRank;

import alxnns1.mobhunter.MobHunter;

/**
 * Created by Mark on 20/01/2017.
 */
public class HunterRankProgression
{
    public static final int HR_MAX = 100;
    private static int[] progressPoints = new int[HR_MAX];
    private static int[] cumulativePoints = new int[HR_MAX];

    /**
     * Mark's progression
     */
    private static void setProgress1(int i)
    {
        int HR = i + 1;
        float step = (i % 10f) / 9f;
        progressPoints[i] = Math.round(step * (HR / 2)) + progressPoints[i - 1] + Math.round(HR / 2);
    }

    /**
     * Alex's progression
     */
    private static void setProgress2(int i)
    {
        int HR = i + 1;
        double curve = HR * Math.exp(Math.sqrt(HR * 0.1));
        double step = (HR * 2) / ((HR % 10) + 1);
        progressPoints[i] = (int) Math.round((curve + step + progressPoints[i - 1]) / 2) + 1;
    }

    public static void init()
    {
        MobHunter.LOGGER.info("Starting HR progression creation");
        long timeStart = System.nanoTime();

        progressPoints[0] = 5;
        cumulativePoints[0] = 0;

        for(int i = 1; i < HR_MAX; i++)
        {
            //Mark's progression
            setProgress1(i);
            //Alex's progression
            //setProgress2(i);

            cumulativePoints[i] = cumulativePoints[i - 1] + progressPoints[i];
        }

        long time = System.nanoTime() - timeStart;
        MobHunter.LOGGER.info("HR progression created in " + time + "ns");
    }

    public static int getProgressForRank(int hunterRank)
    {
        return progressPoints[Math.min(hunterRank, HR_MAX)];
    }

    public static int getTotalProgressForRank(int hunterRank)
    {
        return cumulativePoints[Math.min(hunterRank, HR_MAX)];
    }
}
