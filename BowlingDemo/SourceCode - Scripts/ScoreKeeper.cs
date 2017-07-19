using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScoreKeeper : MonoBehaviour {

    private int totalScore;
    private bool firstThrowMade = false;
    private bool strikeMultiplier = false;
    private bool spareMultiplier = false;
    private int scoreFirstThrow = 0;
    private PinSetter pinSetter;
    private int consecutiveStrikes = 0;

    private void Start()
    {
        pinSetter = GameObject.FindObjectOfType<PinSetter>();
    }





}
