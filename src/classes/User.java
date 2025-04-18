package classes;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;

    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                throw new InvalidOperationException("Username is already taken.");
            }
        }

        if (password.length() < 8) {
            throw new InvalidOperationException("Password must be at least 8 characters long.");
        }

        this.username = username;
        this.password = password;
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        this.behavior = new RegularBehavior();
        this.playlists = new ArrayList<>();

        allUsers.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void follow(User user) {
        this.followingList.add(user);
        user.getFollowerList().add(this);
    }

   public void createPlaylist(String title) {
        this.behavior.createPlaylist(title, this);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(int months) {
        this.behavior.buyPremium(this, months);
    }

    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
}
