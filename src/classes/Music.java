package classes;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream;
    public static ArrayList<Music> allMusics = new ArrayList<>();


    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        this.numberOfStream = 0;
        allMusics.add(this);
    }

    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }

    public void play() {
        numberOfStream++;
        System.out.println("Playing \"" + title + "\" by " + singer.getUsername() + ". Total streams: " + numberOfStream);
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                result.add(music);
            }
        }
        return result;
    }

    public static Music search(String title, String singerUsername) {
        for (Music music : allMusics) {
            if (music.getTitle().equalsIgnoreCase(title) &&
                    music.getSinger().getUsername().equalsIgnoreCase(singerUsername)) {
                return music;
            }
        }
        return null;
    }
}
