package mks.sks.com.musicapp;

/**
 * Created by user on 5/21/2016.
 */
public class Songs {

    private long id;
    private String title;
    private String artist;
    private long duration;
    private long albumCover;


    public Songs(long id, String title, String artist, long albumCover, long duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.albumCover = albumCover;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(long albumCover) {
        this.albumCover = albumCover;
    }
}
