package classes;

public class PremiumBehavior implements UserBehavior {

    private int month;

    public PremiumBehavior() {
        this.month = 0 ;
    }

    public PremiumBehavior(int month) {
        this.month = month;
    }

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist newPlaylist = new Playlist(title, owner);
        owner.getPlaylists().add(newPlaylist);
        System.out.println("Playlist created for " + owner.getUsername());
    }

    @Override
    public void playMusic(Music music) {
        music.play();
        System.out.println("Playing music for premium user: " + music.getTitle());
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
        System.out.println(owner.getUsername() + " has extended premium by " + month + " months. Total premium months: " + this.month);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
