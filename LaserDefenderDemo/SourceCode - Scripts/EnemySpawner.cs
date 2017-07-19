using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemySpawner : MonoBehaviour {

    public GameObject enemyPrefab;
    public float width;
    public float height;
    private float speed = 5f;
    private float cameraDistance;
    private float minX;
    private float maxX;
    private bool enemiesGoingRight = true;
    private int newSpawns = 5;

    // Use this for initialization
    void Start () {
        Enemy.enemyCounter = 0;
        cameraDistance = transform.position.z - Camera.main.transform.position.z;
        Vector3 leftLimit = Camera.main.ViewportToWorldPoint(new Vector3(0, 0, cameraDistance));
        minX = leftLimit.x + width / 2;
        Vector3 rightLimit = Camera.main.ViewportToWorldPoint(new Vector3(1, 0, cameraDistance));
        maxX = rightLimit.x - width / 2;
        foreach (Transform child in transform)
        {
            GameObject.Instantiate(enemyPrefab, child);
        }
    }
	
	// Update is called once per frame
	void Update () {
        MoveEnemies();
        if (Enemy.enemyCounter <= 1 && newSpawns != 0)
        {
            SpawnEnemy();
            newSpawns--;
        }
        Debug.Log(Enemy.enemyCounter);
    }

    private void OnDrawGizmos()
    {
        Gizmos.DrawWireCube(transform.position, new Vector3(width, height));
    }

    private void MoveEnemies()
    {
        if (enemiesGoingRight)
        {
            Vector3 newPos = new Vector3(Mathf.Clamp(transform.position.x + speed * Time.deltaTime, minX, maxX), transform.position.y);
            transform.position = newPos;
            if (transform.position.x >= maxX)
            {
                enemiesGoingRight = false;
            }
        }
        else if (!enemiesGoingRight)
        {
            Vector3 newPos = new Vector3(Mathf.Clamp(transform.position.x - speed * Time.deltaTime, minX, maxX), transform.position.y);
            transform.position = newPos;
            if (transform.position.x <= minX)
            {
                enemiesGoingRight = true;
            }
        }
    }

    public void SpawnEnemy()
    {
        Debug.Log("Spawnenemy called");

        
        if(NextFreePosition())
        {
            GameObject.Instantiate(enemyPrefab, NextFreePosition());
            Invoke("SpawnEnemy", 0.5f);
        }

        
    }

    private Transform NextFreePosition()
    {
        Debug.Log("Nextfreepos called");
        foreach(Transform position in transform)
        {
            if(position.childCount == 0)
            {
                return position;
            }
        }
        return null;
    }

}
