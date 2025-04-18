package Handlers;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new InvalidOperationException("You discovered a premium feature. upgrade to make playlists");
    }

    @Override
    public void playMusic(Music music) {
        if (playingLimit <= 0) {
            throw new InvalidOperationException("You discovered a premium feature. upgrade to play more songs");
        }
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int len) {
        owner.setBehavior(new PremiumBehavior(len));
    }

}
