using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PinSetter : MonoBehaviour {

    private bool ballEnteredBox;
    private bool gutterBall;
    private int lastStandingCount = -1;
    private float lastChangeTime;
    private Ball ball;
    private CameraControl cameraControl;
    private ActionMaster actionMaster;
    private int pinsStandingBeforeThisThrow = 10;
    private Animator animator;

    public GameObject pinSet;
    public Text pinCount;
    public float distanceToRaise = 40f;


    private void Start()
    {
        animator = GetComponent<Animator>();
        actionMaster = new ActionMaster();

        ball = GameObject.FindObjectOfType<Ball>();
        cameraControl = GameObject.FindObjectOfType<CameraControl>();
    }

    private void Update()
    {
        pinCount.text = CountStanding().ToString();
        if (ballEnteredBox || gutterBall)
        {
            CheckStanding();
        }
 
    }

    private void CheckStanding()
    {
        if (lastStandingCount != CountStanding())
        {
            lastStandingCount = CountStanding();
            lastChangeTime = Time.time;
        }else if(lastStandingCount == CountStanding() && Time.time - lastChangeTime >= 3f)
        {
            lastStandingCount = -1;
            PinsHaveSettled();
        }
    }

    private void PinsHaveSettled()
    {

        ballEnteredBox = false;
        gutterBall = false;
        pinCount.color = Color.green;
        int pinfall = pinsStandingBeforeThisThrow - CountStanding();
        pinsStandingBeforeThisThrow = CountStanding();
        ActionMaster.Action doThis = actionMaster.Bowl(pinfall);
        if (doThis == ActionMaster.Action.Tidy)
        {
            animator.SetTrigger("tidyTrigger");
        }else if(doThis == ActionMaster.Action.EndTurn)
        {
            animator.SetTrigger("resetTrigger");
            pinsStandingBeforeThisThrow = 10;
        }else if(doThis == ActionMaster.Action.Reset)
        {
            animator.SetTrigger("resetTrigger");
            pinsStandingBeforeThisThrow = 10;
        }
        
        ball.Reset();
        cameraControl.Reset();
    }

    public int CountStanding()
    {
        int standingPins = 0;
        foreach(Pin pin in GameObject.FindObjectsOfType<Pin>())
        {
            if (pin.IsStanding())
            {
                standingPins++;
            }
        }
        return standingPins;
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.GetComponent<Ball>())
        {
            ballEnteredBox = true;
            pinCount.color = Color.red;
        }

    }

    private void OnTriggerExit(Collider other)
    {
        if (other.GetComponentInParent<Pin>())
        {
            Destroy(other.transform.parent.gameObject);
        }
    }

    public void ResetPins()
    {
        GetComponent<Animator>().SetTrigger("resetTrigger");
    }

    public void TidyPins()
    {
        GetComponent<Animator>().SetTrigger("tidyTrigger");
    }

    public void RaisePins()
    {
        //raise standing by distance
        Debug.Log("raising pins");
        foreach (Pin pin in GameObject.FindObjectsOfType<Pin>())
        {
            pin.RaisePin();
        }
    }

    public void LowerPins()
    {
        Debug.Log("lowering pins");
        foreach (Pin pin in GameObject.FindObjectsOfType<Pin>())
        {

            pin.LowerPin();
        }
    }

    public void RenewPins()
    {
        Debug.Log("renewing pins");
        Instantiate(pinSet, new Vector3(0f, 20f, 0f),Quaternion.identity);
    }

    public void GutterBall()
    {
        gutterBall = true;
    }
}
