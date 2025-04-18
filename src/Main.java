import Handlers.*;

public class Main {
    public static void main(String[] args) {
        try {
            User u1 = new User("ali123", "password123");
            User u2 = new User("sara456", "securepass");
            User u3 = new User("john_doe", "mysecretpass");

            // User تکراری
            new User("ali123", "anotherpass");

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u4 = new User("mike", "123"); // رمز کوتاه
        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u1 = User.getAllUsers().get(0);
            User u2 = User.getAllUsers().get(1);
            User u3 = User.getAllUsers().get(2);

            u1.follow(u2);
            u2.follow(u1);
            u3.follow(u1);

            System.out.println("\n--- Follower & Following Lists ---");
            System.out.println("u1 followers:");
            for (User u : u1.getFollowerList())
                System.out.println("- " + u.getUsername());
            System.out.println("u1 following:");
            for (User u : u1.getFollowingList())
                System.out.println("- " + u.getUsername());

            Music m1 = new Music("Track One", u1);
            Music m2 = new Music("Track Two", u1);
            Music m3 = new Music("Summer Jam", u2);

            new Music("Track One", u1); // موزیک تکراری

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u3 = User.getAllUsers().get(2);
            Music m1 = Music.getAllMusics().get(0);
            Music m2 = Music.getAllMusics().get(1);
            Music m3 = Music.getAllMusics().get(2);

            System.out.println("\n--- Regular User Playing Music ---");
            u3.playMusic(m1);
            u3.playMusic(m2);
            u3.playMusic(m1);
            u3.playMusic(m3);
            u3.playMusic(m2);

            u3.playMusic(m1);

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u3 = User.getAllUsers().get(2);

            u3.buyPremium(3);
            System.out.println("\n" + u3.getUsername() + " is now Premium!");

            Music m1 = Music.getAllMusics().get(0);
            Music m3 = Music.getAllMusics().get(2);

            u3.createPlaylist("My Favs");
            Playlist favs = u3.getPlaylists().get(0);

            favs.addMusic(m1, u3.getPassword());
            favs.addMusic(m3, u3.getPassword());

            favs.addMusic(m1, u3.getPassword());

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u3 = User.getAllUsers().get(2);
            Playlist favs = u3.getPlaylists().get(0);
            Music m3 = Music.getAllMusics().get(2);

            favs.removeMusic(m3, u3.getPassword());
            favs.removeMusic(m3, u3.getPassword());

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u3 = User.getAllUsers().get(2);
            Playlist favs = u3.getPlaylists().get(0);
            Music found = favs.searchInPlaylist("Track One", u3);
            if (found != null)
                System.out.println("Found in playlist: " + found.getTitle());

            System.out.println("\n--- Playing Playlist ---");
            favs.playPlaylist();

            System.out.println("\n--- Shuffling Playlist ---");
            favs.shuffle();

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u3 = User.getAllUsers().get(2);
            u3.createPlaylist(""); // عنوان خالی

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u1 = User.getAllUsers().get(0);
            u1.createPlaylist("MyRock"); // کاربر عادی

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User u3 = User.getAllUsers().get(2);
            u3.buyPremium(-2); // ماه اشتراک نامعتبر

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
