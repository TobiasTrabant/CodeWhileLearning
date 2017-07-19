using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MusicPlayer : MonoBehaviour {

    static MusicPlayer instance;

    void Awake()
    {
        Debug.Log("Music Player awake" + GetInstanceID());

        if (instance != null)
        {
            Destroy(gameObject);
            print("Duplicate MusicPlayer deleted");
        }
        else
        {
            GameObject.DontDestroyOnLoad(gameObject);
            instance = this;
        }
    }

    // Use this for initialization
    void Start() {

        Debug.Log("Music Player start" + GetInstanceID());



    }
    
	// Update is called once per frame
	void Update () {
		
	}
}
