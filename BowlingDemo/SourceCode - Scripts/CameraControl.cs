using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraControl : MonoBehaviour {

    public Ball ball;

    private Vector3 offset;

	// Use this for initialization
	void Start () {
        CalculateOffset();

	}
	
    void CalculateOffset()
    {
        Vector3 ballPos = ball.transform.position;
        Vector3 cameraPos = transform.position;
        offset = ballPos - cameraPos;
    }

	// Update is called once per frame
	void Update () {
        if (transform.position.z <= 1700)
        {
            transform.position = ball.transform.position - offset;
        }
        
	}

    public void Reset()
    {
        transform.position = ball.transform.position - offset;
    }
}
