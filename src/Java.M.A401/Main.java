import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Multimedia> listOfMultimedia = new ArrayList<>();
        MultimediaManagement m=new MultimediaManagement(listOfMultimedia);
        int choice;

        do {
            System.out.println("Multimedia Management Menu:");
            System.out.println("1. Add Video");
            System.out.println("2. Add Song");
            System.out.println("3. Show All Multimedia");
            System.out.println("4. Exit");

            choice = InputValidate.validateIntInput("Enter your choice (1-4):");

            switch (choice) {
                case 1:
                    Video video=new Video();
                    video.createVideo();
                    m.addMultimedia(video);
                    System.out.println("Video added successfully!");

                    break;
                case 2:
                    Song song=new Song();
                    song.createSong();
                    m.addMultimedia(song);
                    System.out.println("Song added successfully!");

                    break;
                case 3:
                    m.displayMultimedia();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4);
    }
}
