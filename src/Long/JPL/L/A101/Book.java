package JPL.L.A101;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {
    private static boolean loadHeader = false;
    private String isbn;
    private Set<String> authors;
    private String publicationPlace;

    public Book() {
    }

    // Constructor
    public Book(int publicationYear, String publisher, Date publicationDate, String isbn, Set<String> authors, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.authors = authors;
        this.publicationPlace = publicationPlace;
    }

    // Getter và setter cho các thuộc tính mới
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }
    public void addAuthor(String newAuthor) {
        if (authors == null) {
            authors = new HashSet<>();
        }

        boolean added=  authors.add(newAuthor);
        if (added) {
            System.out.println("Element has been added to the Set.");
        } else {
            System.out.println("Element already exists in the Set.");
        }
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }


    @Override
    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf(" %-30s %-15s %-15s %-20s %-20s\n",
                authorsToString(), isbn, getPublicationYear(), getPublisher(), dateFormat.format(getPublicationDate()));

    }

    private String authorsToString() {
        // Convert set of authors to a string
        StringBuilder authorsString = new StringBuilder();
        for (String author : authors) {
            authorsString.append(author).append(", ");
        }
        // Remove the trailing comma and space
        if (authorsString.length() > 2) {
            authorsString.setLength(authorsString.length() - 2);
        }
        return authorsString.toString();
    }
}
