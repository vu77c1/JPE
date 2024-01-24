import java.util.Scanner;

public class Song extends Multimedia  {
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    private String singer;

    public Song() {
    }

    public Song(String name, double duration, String singer) {
        super(name, duration);
        this.singer = singer;
    }

    public void createSong() {
        super.createMultimedia();
        setSinger(InputValidator.validateStringInput("Enter Singer: "));

    }

    @Override
    public String toString() {
        return String.format("Song: %-20s  %-10.2f  %-20s %n", super.getName(), super.getDuration(), singer);

    }
}
