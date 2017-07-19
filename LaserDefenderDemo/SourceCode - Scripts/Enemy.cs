using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Enemy : MonoBehaviour {

    private float health = 200;
    public static int enemyCounter;
    public LevelManager levelManager;
    public GameObject laserProjectile;
    public EnemySpawner spawner;
    private float missileSpeed = -10f;
    private float shotsPerSecond = 0.5f;
    private int scorePointsPerKill = 250;
    public AudioClip missileSound;
    public AudioClip deathSound;


	// Use this for initialization
	void Start () {
        enemyCounter++;
	}
	
	// Update is called once per frame
	void Update () {
        float probability = Time.deltaTime * shotsPerSecond;
        if (Random.value < probability)
        {
            Fire();
        }
	}

    private void OnCollisionEnter2D(Collision2D collision)
    {   
        if(collision.gameObject.GetComponent<LaserProjectile>() != null)
        {
            health -= collision.gameObject.GetComponent<LaserProjectile>().GetDamage();
        }
        Destroy(collision.gameObject);
        if(health <= 0)
        {
            AudioSource.PlayClipAtPoint(deathSound, Camera.main.transform.position,0.7f);
            GameObject.Find("Score").GetComponent<ScoreKeeper>().AddScore(scorePointsPerKill);
            enemyCounter--;
            if(enemyCounter <= 0)
            {
                levelManager.LoadLevel("Win Screen");
            }
           
            Destroy(gameObject);

            
        }
    }

    void Fire()
    {
     //   Vector2 missilePos = new Vector3(transform.position.x, transform.position.y - 0.8f);
        GameObject missile = GameObject.Instantiate(laserProjectile, transform.position, Quaternion.identity);
        missile.GetComponent<Rigidbody2D>().velocity = new Vector2(0f, missileSpeed);
        AudioSource.PlayClipAtPoint(missileSound, Camera.main.transform.position,0.7f);
    }


}
