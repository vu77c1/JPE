import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Video extends Multimedia {

    public Video() {
    }

    public Video(String name, double duration) {
        super(name, duration);
    }

    public void createVideo() {
        super.createMultimedia();

    }
    @Override
    public String toString() {


        return String.format("Video:  %-20s  %-10.2f %n", super.getName(), super.getDuration());

    }
}
