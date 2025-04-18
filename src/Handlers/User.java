package Handlers;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        if (usernameIsValid(username)) {
            throw new InvalidOperationException("Username taken");
        }
        if (password.length() < 8) {
            throw new InvalidOperationException("Eror : Password must be at least 8 characters!!!");
        }
        this.username = username;
        this.password = password;
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        this.behavior = new RegularBehavior();
        this.playlists = new ArrayList<>();

        allUsers.add(this);
    }

    public void createPlaylist(String title) {
        this.behavior.createPlaylist(title, this);
    }

    public void follow(User user) {
        if (user == null || user == this) {
            throw new InvalidOperationException("Invalid user to follow");
        }
        if (!followingList.contains(user)) {
            followingList.add(user);
            user.followerList.add(this);
        }
    }

    private boolean usernameIsValid(String username) {
        for (User u : allUsers) {
            if (u.username.equals(username)) return true;
        }
        return false;
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }
    public void buyPremium(int month) {
        this.behavior.buyPremium(this,month);
    }
    public UserBehavior getBehavior() {
        return behavior;
    }
    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
    public static ArrayList<User> getAllUsers() { return allUsers; }
    public ArrayList<User> getFollowerList() { return followerList; }
    public ArrayList<Playlist> getPlaylists() { return playlists; }
    public ArrayList<User> getFollowingList() { return followingList; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }


}