using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class ActionMaster {
       
    public enum Action {Tidy, Reset, EndTurn, EndGame};

    public int[] bowls = new int[21];
    private int bowl = 1;

    

    public Action Bowl (int pins)
    {
        Debug.Log("Bowl");
        Debug.Log(bowl);
        if (pins < 0 || pins > 10) {
            throw new UnityException("Invalid number of pins given as parameter");
        }
        BonusHandler(pins);
        if(bowl == 20 && bowls[18] + pins != 10 && pins != 10)
        {
            bowls[bowl-1] += pins;
            return Action.EndGame;
        }
        if (bowl == 20 && bowls[18] == 10 && pins != 10)
        {
            bowls[bowl - 1] += pins;
            return Action.Tidy;
        }
        else if (bowl == 19 && pins == 10)
        {
            bowls[bowl - 1] += pins;
            bowl++;
            return Action.Reset;
        }
        else if (bowl == 21 && pins == 10)
        {
            bowls[bowl - 1] += pins;
            return Action.EndGame;
        }
        else if (bowl == 20 && pins == 10)
        {
            bowls[bowl - 1] += pins;
            bowl++;
            return Action.Reset;
        }
        else if (bowl == 21 && pins != 10)
        {
            bowls[bowl - 1] += pins;
            return Action.EndGame;
        }
        if (pins == 10 && bowl % 2 != 0)
        {
            Debug.Log("Strike!");
            bowls[bowl - 1] += pins;
            bowl += 2;
            return Action.EndTurn;
        }else if (pins == 10 && bowl % 2 == 0)
        {
            Debug.Log("Spare");
            bowls[bowl - 1] += pins;
            bowl ++;
            return Action.EndTurn;
        }

        if (bowl % 2 != 0)
        {
            bowls[bowl - 1] += pins;
            bowl++;
            return Action.Tidy;
        }

        if(bowl % 2 == 0)
        {
            bowls[bowl - 1] += pins;
            bowl++;
            return Action.EndTurn;
        }

        

        throw new UnityException("Not sure what action to return");
    }

    //public int GetTotalScore()
    //{

    //    int totalScore = 0;

    //    for(int i = 0; i < bowls.Length-1; i++)
    //    {
    //        if(bowls[i] == 10)
    //        {
    //            totalScore += 10;
    //            int bonusCount = 2;
    //            while(bonusCount > 0)
    //            {
    //                totalScore += bowls[i + 2];
    //                bonusCount--;
    //                if (bowls[i+2] == 10)
    //                {
    //                    totalScore += bowls[i + 4];
    //                    bonusCount--;
    //                }
    //                else
    //                {
    //                    totalScore += bowls[i + 3];
    //                    bonusCount--;
    //                }
    //            }
    //        }
    //    }
    //    Debug.Log("totalscore is " + totalScore);
    //    return totalScore;
    //}

    public int Test()
    {
        int totalScore = 0;
        for (int i = 0; i <= 20; i++)
        {
            totalScore += bowls[i];
        }
        return totalScore;
    }

    public void BonusHandler(int pins)
    {
        if(bowl == 20 && bowls[16] == 20)
        {

            bowls[16] += pins;
            
        }
        if(bowl == 21)
        {
            return;
        }
        if(bowl >= 3 && bowl % 2 != 0)
        {
            if(bowls[bowl-3] == 10)
            {
                bowls[bowl - 3] += pins;
                if(bowl >= 5 && bowls[bowl -5] == 20 )
                {
                    bowls[bowl - 5] += pins;
                }
            }
        }
        if(bowl >= 4 && bowl % 2 == 0 && bowls[bowl-4] == 10  )
        {
            bowls[bowl-4] += pins;
        }
    }
}