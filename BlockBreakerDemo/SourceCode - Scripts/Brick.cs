using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Brick : MonoBehaviour {

    public AudioClip crack;
    private LevelManager levelManager;
    public GameObject smoke;

    public static int breakableCount = 0;
    private int timesHit;
    private bool isBreakable;

    public Sprite[] hitSprites;


	// Use this for initialization
	void Start () {
        isBreakable = (this.tag == "Breakable");

        if (isBreakable)
        {
            breakableCount++;
        }
        timesHit = 0;
        levelManager = GameObject.FindObjectOfType<LevelManager>();
        Debug.Log(breakableCount + " breakable blocks created");
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    private void OnCollisionEnter2D(Collision2D collision)
    {

        if (isBreakable)
        {
            HandleHits();
        }
    }

    void HandleHits()
    {
        timesHit++;

        if (timesHit > hitSprites.Length)
        {
            AudioSource.PlayClipAtPoint(crack, Camera.main.transform.position, 0.25f);
            GameObject puff = Instantiate(smoke,transform.position,transform.rotation);
            puff.GetComponent<ParticleSystem>().startColor = gameObject.GetComponent<SpriteRenderer>().color;
            Destroy(gameObject);
            breakableCount--;
            Debug.Log("Block destroyed. " + breakableCount + " blocks left");
            levelManager.BrickDestroyed();

        }
        else
        {
            LoadSprites();
        }
    }

    void LoadSprites()
    {
        int spriteIndex = timesHit - 1;
        if (hitSprites[spriteIndex])
        {
            this.GetComponent<SpriteRenderer>().sprite = hitSprites[spriteIndex];
        }
    }

    // TODO remove this method once we can actually win!
    void SimulateWin ()
    {
        levelManager.LoadNextLevel();
    }
}
