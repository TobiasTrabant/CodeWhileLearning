using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour {

    float health = 200f;
    int lifeCounter = 4;
    float speed = 14f;
    float projectileSpeed = 10f;
    float fireRate = 0.15f;
    float xmin;
    float xmax;
    public GameObject laserProjectile;
    public LevelManager levelManager;
    public AudioClip missileSound;
    

	// Use this for initialization
	void Start () {
        float distance = transform.position.z - Camera.main.transform.position.z;
        Vector3 leftMin = Camera.main.ViewportToWorldPoint(new Vector3(0,0,distance));
        Vector3 rightMax = Camera.main.ViewportToWorldPoint(new Vector3(1, 0, distance));
        xmin = leftMin.x + 0.5f;
        xmax = rightMax.x - 0.5f;
    }
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKey(KeyCode.RightArrow))
        {
            Debug.Log("RightArrowPressed");

            Vector3 newPos = new Vector3(Mathf.Clamp(transform.position.x + speed * Time.deltaTime, xmin, xmax), transform.position.y, transform.position.z);
            transform.position = newPos;
        }

        if (Input.GetKey(KeyCode.LeftArrow))
        {
            Debug.Log("LeftArrowPressed");
           
            
            Vector3 newPos = new Vector3(Mathf.Clamp(transform.position.x - speed * Time.deltaTime, xmin, xmax), transform.position.y, transform.position.z);
            transform.position = newPos;
            
        }

        if (Input.GetKeyDown(KeyCode.Space))
        {
            InvokeRepeating("Fire", 0.0000001f, fireRate);
        }

        if (Input.GetKeyUp(KeyCode.Space))
        {
            CancelInvoke("Fire");
        }
    }

    void Fire()
    {
      //  Vector3 shotPos = new Vector3(transform.position.x, transform.position.y + 1f);
        GameObject laserProjectile = GameObject.Instantiate(this.laserProjectile, this.transform.position, Quaternion.identity);
        laserProjectile.GetComponent<Rigidbody2D>().velocity = new Vector2(0f, projectileSpeed);
        AudioSource.PlayClipAtPoint(missileSound, Camera.main.transform.position,0.7f);
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        health -= collision.gameObject.GetComponent<LaserProjectile>().GetDamage();
        string deleteLife = "Life" + lifeCounter.ToString();
        Destroy(GameObject.Find(deleteLife));
        lifeCounter--;
        Destroy(collision.gameObject);
        if(health <= 0)
        {
            levelManager.LoadLevel("Lose Screen");
            Destroy(gameObject);
        }
    }
}
