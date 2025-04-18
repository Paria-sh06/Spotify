package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private String title;
    private User owner;
    private ArrayList<Music> playlist;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
        this.playlist = new ArrayList<>();
        owner.getPlaylists().add(this);
    }

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Music> getPlaylist() {
        return playlist;
    }


    public void editTitle(String newTitle, String password) {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Incorrect password.");
        }
        this.title = newTitle;
    }

    public void addMusic(Music music, String password) {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Incorrect password.");
        }
        if (playlist.contains(music)) {
            throw new InvalidOperationException("Music is already in the playlist.");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music, String password) {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Incorrect password.");
        }
        if (!playlist.contains(music)) {
            throw new InvalidOperationException("Music not found in playlist.");
        }
        playlist.remove(music);
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> results = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                results.add(music);
            }
        }
        return results;
    }

    public Music searchInPlaylist(String title, String singerUsername) {
        for (Music music : playlist) {
            if (music.getTitle().equalsIgnoreCase(title) &&
                    music.getSinger().getUsername().equalsIgnoreCase(singerUsername)) {
                return music;
            }
        }
        return null;
    }

    public void playPlaylist() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < playlist.size()) {
            playlist.get(i).play();

            System.out.println("Press 'Enter' to continue playing the current song, or type 'next' to play the next song:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("next")) {
                i++;
            }
            else if (input.isEmpty()) {
                System.out.println("Continuing with the current song...");
            }
            else {
                System.out.println("Playback stopped.");
                break;
            }
        }
    }


    public void shufflePlay() {
        ArrayList<Music> shuffled = new ArrayList<>(playlist);
        java.util.Collections.shuffle(shuffled);
        for (Music music : shuffled) {
            music.play();
        }
    }
}
