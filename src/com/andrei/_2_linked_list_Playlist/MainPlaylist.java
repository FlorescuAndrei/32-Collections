package com.andrei._2_linked_list_Playlist;

import java.util.*;

public class MainPlaylist {
    private static List<Album>albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("album 1", "artist 1");
        album.addSongToAlbum("song 1", 2.5);
        album.addSongToAlbum("song 2", 2);
        album.addSongToAlbum("song 3", 3);
        album.addSongToAlbum("song 4", 3.5);
        album.addSongToAlbum("song 5", 4);
        album.addSongToAlbum("song 6", 4.22);
        album.addSongToAlbum("song 7", 3.37);
        album.addSongToAlbum("song 8", 2.54);
        album.addSongToAlbum("song 9", 2.45);

        albums.add(album);

        album = new Album("album 2", "artist 2");
        album.addSongToAlbum("song 21", 3.5);
        album.addSongToAlbum("song 22", 2.55);
        album.addSongToAlbum("song 23", 4.32);
        album.addSongToAlbum("song 24", 6.2);
        album.addSongToAlbum("song 25", 3.4);
        album.addSongToAlbum("song 26", 2.5);
        album.addSongToAlbum("song 27", 3.6);
        album.addSongToAlbum("song 28", 4.21);
        album.addSongToAlbum("song 29", 3.44);

        albums.add(album);

        LinkedList<Song>playList = new LinkedList<>();

        albums.get(0).addSongToPlaylist("song 1", playList);
        albums.get(0).addSongToPlaylist("song 2", playList);
        albums.get(0).addSongToPlaylist("song 100", playList);
        albums.get(0).addSongToPlaylist("song 3", playList);

        albums.get(0).addSongToPlaylist(4, playList);
        albums.get(0).addSongToPlaylist(5, playList);
        albums.get(0).addSongToPlaylist(6, playList);
        albums.get(0).addSongToPlaylist(7, playList);

        albums.get(1).addSongToPlaylist(1, playList);
        albums.get(1).addSongToPlaylist(2, playList);
        albums.get(1).addSongToPlaylist(3, playList);
        albums.get(1).addSongToPlaylist(4, playList);
        albums.get(1).addSongToPlaylist(54, playList);

        printMenu();
        play(playList);


    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);

        //help for the menu
        boolean quit = false;

        //helps to know where is the position fo the cursor for the listIterator, before or after the song.
        boolean forward = true;


        ListIterator listIterator = playlist.listIterator();

        if(playlist.size() == 0){
            System.out.println("No songs in playlist");
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                // case 1: play next song.
                case 1:

                    // set direction to be forward
                    //when going forward, and we use listIterator.next(), the next song will be play and the cursor(listIterator position) will move after that song
                    //when going backward, and we use listIterator.previous(), the previous song will be played and the cursor will move before the that song
                    //when changing directions, we firs place the cursor to the correct position otherwise the song will repeat.
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }

                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                //repeat
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    listIterator.remove();
                    //move to the next or previous position
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next());
                    }else if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous());
                    }
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("Available actions: \npress");
        System.out.println("0 - quit\n" +
                "1 - play next song\n" +
                "2 - play previous song\n" +
                "3 - replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        // iterator is the superior interface for listIterator. Can not go back in the list
        // perfect for looping once
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==============");
        while (iterator.hasNext()){
            //.toString() is optional, it is set by default
            System.out.println(iterator.next().toString());
        }
        System.out.println("===============");
    }


}

