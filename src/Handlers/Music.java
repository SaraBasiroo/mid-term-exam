package Handlers;
import java.util.*;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        for (Music music: allMusics)
            if (music.title.equals(title) && music.singer.equals(singer))
                throw new InvalidOperationException("Music already exists!");
        this.title = title;
        this.singer = singer;
        this.numberOfStream = 0;
        allMusics.add(this);
    }

    public String getTitle() {
        return title;
    }

    public void play(){
        System.out.println("Playing :  '" + title + "' by :  " + singer.getUsername() + " is playing");
        numberOfStream++;
    }

    public ArrayList<Music> search(String title) {
        ArrayList<Music> foundMusics = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title.equalsIgnoreCase(title)) {
                foundMusics.add(music);
            }
        }
        if (foundMusics.isEmpty()){
            return null;
        }
        else {
            return foundMusics;
        }
    }

    public Music search(String title, String singerName) {
        for (Music music : allMusics) {
            if (music.title.equalsIgnoreCase(title) && music.singer.getUsername().equalsIgnoreCase(singerName)) {
                return music;
            }
        }
        return null;
    }
    public User getSinger() { return singer; }
    public int getNumberOfStream() { return numberOfStream; }
    public static ArrayList<Music> getAllMusics() { return allMusics;}
}