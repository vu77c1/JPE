package JPL.L.A101;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Magazine extends Publication{
    private String magazineAuthor;
    private int volume;
    private int edition;

    // Constructor
    public Magazine(int publicationYear, String publisher, Date publicationDate, String magazineAuthor, int volume, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.magazineAuthor = magazineAuthor;
        this.volume = volume;
        this.edition = edition;
    }

    public Magazine() {
    }

    // Getter and setter for the new attributes
    public String getMagazineAuthor() {
        return magazineAuthor;
    }

    public void setMagazineAuthor(String magazineAuthor) {
        this.magazineAuthor = magazineAuthor;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     *
     */
    @Override
    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("%-15s %-20s %-20s %-30s %-10s %-10s\n",
                 getPublicationYear(), getPublisher(),
                dateFormat.format(getPublicationDate()), magazineAuthor, volume, edition);
    }

}
