package JPL.L.A101;

import java.util.Date;

public abstract class Publication {
    private int publicationYear;
    private String publisher;
    private Date publicationDate;

    // Constructor
    public Publication(int publicationYear, String publisher, Date publicationDate) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public Publication() {
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();

    // Getters and setters
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void InputPublication() {
        boolean checkpublicationYear = false;
        do {
            this.publicationYear = InputValidator.validateIntInput("Enter publicationYear: ");
            if (publicationYear > 0) {
                checkpublicationYear = true;
            } else {
                System.out.println("Input is valid! ");
            }


        } while (!checkpublicationYear);
        this.publisher = InputValidator.validateStringInput("Enter publisher: ");
        this.publicationDate = InputValidator.validateDateInput("Enter publicationDate: ");

    }

}
