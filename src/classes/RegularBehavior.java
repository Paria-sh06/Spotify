package classes;

public class RegularBehavior implements UserBehavior {

    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new InvalidOperationException("A regular user can't create playlists.");
    }

    @Override
    public void playMusic(Music music) {
        if (playingLimit > 0) {
            music.play();
            playingLimit--;
            System.out.println("Remaining play limit: " + playingLimit);
        } else {
           throw new InvalidOperationException("You have reached your play limit.");
        }
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior());
        System.out.println(owner.getUsername() + " has been upgraded to Premium.");
    }

}
