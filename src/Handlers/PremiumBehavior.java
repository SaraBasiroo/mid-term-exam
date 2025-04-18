package Handlers;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        this.setMonth(month);
    }

    @Override
    public void createPlaylist(String title, User owner) {
        if (owner == null) {
            throw new InvalidOperationException("set the owner");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidOperationException("Enter a valid title");
        }
        Playlist playlist = new Playlist(title, owner);
        owner.getPlaylists().add(playlist);
    }

    @Override
    public void playMusic(Music music) {
        if (music == null) {
            throw new InvalidOperationException("Select the music");
        }
        music.play();
    }

    public void setMonth(int month) {
        if (month <= 0)
            throw new InvalidOperationException("invalid time format");

        this.month = month;
    }
    @Override
    public void buyPremium(User owner, int month) {
        if (month <= 0) {
            throw new InvalidOperationException("invalid time format(negative value).");
        }
        this.month += month;
    }
    public int getMonth() {
        return month;
    }
}
