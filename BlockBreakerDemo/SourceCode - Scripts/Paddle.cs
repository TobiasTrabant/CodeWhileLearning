using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Paddle : MonoBehaviour {

    public bool autoPlay = false;

    private Ball ball;

    private void Start()
    {
        ball = FindObjectOfType<Ball>();
    }

    // Update is called once per frame
    void Update () {
        if (!autoPlay)
        {
            MoveWithMouse();
        } else
        {
            AutoPlay();
        }
    }

    void MoveWithMouse()
    {
        float mousePosInBlocks = Input.mousePosition.x / Screen.width * 16;
        Vector3 paddlePos = new Vector3(this.transform.position.x, this.transform.position.y, 0f);
        paddlePos.x = Mathf.Clamp(mousePosInBlocks, 1.12f, 14.8f);
        this.transform.position = paddlePos;
    }

    void AutoPlay()
    {
        float ballPosX = Mathf.Clamp(ball.transform.position.x, 0.5f, 15.5f);
        this.transform.position = new Vector3(ballPosX, this.transform.position.y,0f);
    }
}
