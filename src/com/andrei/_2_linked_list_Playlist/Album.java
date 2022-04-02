package com.andrei._2_linked_list_Playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song>songs;

    public Album(String name, String artist ) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public boolean addSongToAlbum(String title, double duration){
       if(findSong(title) == null){
           this.songs.add(new Song(title, duration));
           return true;
       }
       return false;
    }

    private Song findSong(String title){
        for (Song song : songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    //songs list is an ArrayList, so we use index to obtain a song from the list
    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("The album does not have a track: " + trackNumber);
        return false;
    }

    //Overload
    public boolean addSongToPlaylist(String title, LinkedList<Song> playList){
        Song song = findSong(title);
        if (song != null){
            playList.add(song);
            return true;
        }
        System.out.println("The song " + title + " is not in the album");
        return false;
    }


}
