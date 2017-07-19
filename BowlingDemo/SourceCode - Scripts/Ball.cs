using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour {

    public float speed = 500f;
    private Rigidbody rigidBody;
    private AudioSource audioSource;
    private bool launched = false;

	// Use this for initialization
	void Start () {      
        rigidBody = GetComponent<Rigidbody>();
        audioSource = GetComponent<AudioSource>();
        rigidBody.useGravity = false;
	}

    public void Launch(Vector3 velocity)
    {
        rigidBody.useGravity = true;
        rigidBody.velocity = velocity;
        audioSource.Play();
        launched = true;
    }

	public void moveStartPosition(float xNudge)
    {
        if(launched == false)
        {
            float newPosX = Mathf.Clamp(transform.position.x + xNudge, -50, 50);
            Vector3 newPos = new Vector3(newPosX,transform.position.y,transform.position.z);
            transform.position = newPos;
            Debug.Log("nudged");
        }
       
    }

    public void Reset()
    {
        Vector3 startPos = new Vector3(0f, 20f, 30f);
        transform.position = startPos;
        rigidBody.useGravity = false;
        rigidBody.velocity = new Vector3(0f, 0f, 0f);
        rigidBody.angularVelocity = new Vector3(0f, 0f, 0f);
        launched = false;
    }
}
