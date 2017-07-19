using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[RequireComponent (typeof(Ball))]
public class DragLaunch : MonoBehaviour {


    private Ball ball;

    private Vector3 dragStart;
    private float timeMouseDown;

	// Use this for initialization
	void Start () {
        ball = GetComponent<Ball>();
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    public void DragStart()
    {
        dragStart = Input.mousePosition;
        timeMouseDown = Time.time;
    }

    public void DragEnd()
    {
        Vector3 dragLength = Input.mousePosition - dragStart;
        float dragDuration = Time.time - timeMouseDown;
        float ballSpeedZ = dragLength.y / dragDuration;
        float ballSpeedX = dragLength.x / dragDuration;
        ball.Launch(new Vector3(ballSpeedX,0f, ballSpeedZ));
    }

    public void MoveStart(float xNudge)
    {
        ball.moveStartPosition(xNudge);
    }
}
