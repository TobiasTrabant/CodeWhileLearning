using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ScoreKeeper : MonoBehaviour {

    public static int score = 0;

    public void AddScore(int points)
    {
        score += points;
        transform.GetComponent<Text>().text = score.ToString();
    }

    public static void Reset()
    {
        score = 0;
        
    }

    private void Start()
    {
        DontDestroyOnLoad(gameObject);
        Reset();
        transform.GetComponent<Text>().text = score.ToString();
    }
}
