using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Pin : MonoBehaviour {

    public float standingThreshold;
    public float distanceToRaise = 50f;

    private void Start()
    {

    }

    public bool IsStanding()
    {

        float eulerX = transform.eulerAngles.x < 180f ? transform.eulerAngles.x : 360 - transform.eulerAngles.x;
        float eulerZ = transform.eulerAngles.z < 180f ? transform.eulerAngles.z : 360 - transform.eulerAngles.z;
        if(eulerX < standingThreshold && eulerZ < standingThreshold)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public void RaisePin()
    {
        //raise standing by distance

 

                GetComponent<Rigidbody>().angularVelocity = new Vector3(0f, 0f, 0f);
                GetComponent<Rigidbody>().velocity = Vector3.zero;
                GetComponent<Rigidbody>().useGravity = false;
                transform.Translate(0f, distanceToRaise, 0f);
    }

    public void LowerPin()
    {



            transform.Translate(0f, -distanceToRaise, 0f);
            GetComponent<Rigidbody>().useGravity = true;

    }

    public void RenewPins()
    {
        Debug.Log("renewing pins");

    }
}
