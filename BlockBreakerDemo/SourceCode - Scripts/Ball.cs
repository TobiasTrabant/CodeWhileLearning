using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour {

    private bool gameStarted = false;

    private Paddle paddle;

    private Vector3 paddleToBallVector;

    

    // Use this for initialization
    void Start () {
        paddle = GameObject.FindObjectOfType<Paddle>();
        paddleToBallVector = this.transform.position - paddle.transform.position;
    }
	
	// Update is called once per frame
	void Update () {

        if (!gameStarted)
        {
            this.transform.position = paddle.transform.position + paddleToBallVector;
            if (Input.GetMouseButtonDown(0))
            {
                print("Mouse button clicked");
                this.GetComponent<Rigidbody2D>().velocity = new Vector2(2f, 10f);
                gameStarted = true;
            }
        }

	}

    private void OnCollisionEnter2D(Collision2D collision)
    {
        Vector2 tweak = new Vector2(Random.Range(0f, 0.2f),Random.Range(0f,0.2f));
        if (gameStarted)
        {
            AudioSource audio = GetComponent<AudioSource>();
            audio.Play();
            Debug.Log(GetComponent<Rigidbody2D>().velocity);
            GetComponent<Rigidbody2D>().velocity += tweak;
            Debug.Log("tweaked" + GetComponent<Rigidbody2D>().velocity);
        }
    }
}
