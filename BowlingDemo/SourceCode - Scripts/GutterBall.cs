using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GutterBall : MonoBehaviour {

    PinSetter pinSetter;

    private void Start()
    {
        pinSetter = GameObject.FindObjectOfType<PinSetter>();
    }

    private void OnCollisionExit(Collision collision)
    {
        if (collision.gameObject.GetComponent<Ball>())
        {
            pinSetter.GutterBall();
        }
    }
}
