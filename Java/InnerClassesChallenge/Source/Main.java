package com.company;




import com.sun.xml.internal.bind.v2.runtime.reflect.*;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.*;

public class Main {

    static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24

        play(playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean forward = true;
        boolean quit = false;


        if( playList.size() == 0 ){
            System.out.println("No songs in playlist");
        }else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printActions();
        }

        while(!quit){
            System.out.println("Enter action: ");
            int action = scanner.nextInt();

            switch(action){
                case 0:
                    System.out.println("Stopping playback");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing : " + listIterator.next() );
                    }else {
                        System.out.println("Reached the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing : " + listIterator.previous());
                    }else {
                        System.out.println("Reached the start of the list");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous());
                        }
                        forward = false;
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next());
                        }
                        forward = true;
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printActions();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next());
                    }else if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    }
                    break;
            }
        }
    }

    private static void printActions(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }

    private static void printList(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        System.out.println("===================");
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("===================");
    }
}