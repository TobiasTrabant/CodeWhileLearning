package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Tobias on 01.06.2017.
 */
public class Album {

    private String name;
    private String artist;
    SongList songList = new SongList();

    public Album(String albumName, String artist){
        this.name = albumName;
        this.artist = artist;
    }
     public void addSong(String title, double duration){
        songList.addSong(title,duration);

      }

    public void addToPlayList(String title, LinkedList<Song> playList){
        Song songToAdd = songList.findSong(title);
        if(songToAdd != null){
            playList.add(songToAdd);
        }
    }

    public void addToPlayList(int trackNumber, LinkedList<Song> playList){
       if(trackNumber <= songList.songs.size()){
           playList.add(songList.songs.get(trackNumber - 1));
       }

    }

//    public Song findSong(String title){
//        for(Song check : songs){
//            if(check.getTitle().equals(title)){
//                return check;
//            }
//        }
//        return null;
//    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList(){
            songs = new ArrayList<>();
        }

        public void addSong(String title,double dutation){
            this.songs.add(new Song(title,dutation));
        }

        public Song findSong(String title){
            for(Song check : songs){
                if(check.getTitle().equals(title)){
                    return check;
                }
            }
            return null;
        }


    }
}
