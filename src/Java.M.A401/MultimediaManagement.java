import java.util.List;

public class MultimediaManagement {
    private List<Multimedia> listOfMultimedia=null;

    // Constructor with 1 parameter to initialize a new listOfMultimedia
    public MultimediaManagement(List<Multimedia> listOfMultimedia) {
        this.listOfMultimedia = listOfMultimedia;
    }

    // Method to add a new multimedia to the list
    public void addMultimedia(Multimedia multimedia) {
        listOfMultimedia.add(multimedia);
    }

    // Method to display the list of multimedia
    public void displayMultimedia() {
        System.out.println("List of Multimedia:");
        for (Multimedia multimedia : listOfMultimedia) {
            System.out.println(multimedia);
        }
    }
}
