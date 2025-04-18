
import classes.InvalidOperationException;
import classes.Music;
import classes.Playlist;
import classes.User;


public class Main {
    public static void main(String[] args) {
        try {

            User user1 = new User("ali", "12345678");
            User user2 = new User("sara", "password123");

            user1.follow(user2);

            Music music1 = new Music("Shab", user1);
            Music music2 = new Music("Rooz", user1);

            user1.playMusic(music1);
            user1.playMusic(music2);
            user1.playMusic(music1);
            user1.playMusic(music2);
            user1.playMusic(music1);


            user1.buyPremium(6);

            user1.createPlaylist("My Playlist");

            Playlist p = user1.getPlaylists().getFirst();
            p.addMusic(music1, "12345678");
            p.addMusic(music2, "12345678");

            p.playPlaylist();
        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
