package Handlers;
import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist;
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
        this.playlist = new ArrayList<>();
    }

    public void addMusic(Music music, String password) {
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("Incorrect Password.");
        if (playlist.contains(music))
            throw new InvalidOperationException("this song is already added.");
        playlist.add(music);
    }

    public void removeMusic(Music music, String password) {
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("Invalid password");
        if (!playlist.contains(music))
            throw new InvalidOperationException("Music not found in playlist");
        playlist.remove(music);
        System.out.println("\nMusic removed from playlist: " + music.getTitle());
    }

    public void editTitle(String newTitle, String password) {
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("Incorrect Password.");
        this.title = newTitle;
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title)) result.add(music);
        }
        if (result.isEmpty()){
            return null;
        }
        else {
            return result;
        }
    }

    public Music searchInPlaylist(String title, User singer) {
        for (Music m : playlist) {
            if (m.getTitle().equals(title) && m.getSinger().equals(singer)){
                return m;
            }
        }
        return null;
    }

    public void playPlaylist() {
        for (Music music : playlist) {
            music.play();
        }
    }

    public void shuffle() {
        ArrayList<Music> shuffled = new ArrayList<>(playlist);
        Collections.shuffle(shuffled);
        for (Music music : shuffled) {
            music.play();
        }
    }
    public String getTitle() { return title; }
    public ArrayList<Music> getPlaylist() { return playlist; }
    public User getOwner() { return owner; }
}