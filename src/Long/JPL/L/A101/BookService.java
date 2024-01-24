package JPL.L.A101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookService {
    // Placeholder for data storage (could be replaced with a database or other data source)
    private List<Book> bookList;
    private Set<String> isbnSet = new HashSet<>();
    enum SearchCriteria {
        ISBN,
        AUTHOR,
        PUBLISHER
    }
    private List<Book> searchBooksByISBN(String isbn) {
        return bookList.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .collect(Collectors.toList());
    }

    private List<Book> searchBooksByAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthors().contains(author))
                .collect(Collectors.toList());
    }

    private List<Book> searchBooksByPublisher(String publisher) {
        return bookList.stream()
                .filter(book -> book.getPublisher().equals(publisher))
                .collect(Collectors.toList());
    }
    public List<Book> searchBooks(String keyword, SearchCriteria criteria) {
        List<Book> result = null;

        switch (criteria) {
            case ISBN:
                result = searchBooksByISBN(keyword);
                break;
            case AUTHOR:
                result = searchBooksByAuthor(keyword);
                break;
            case PUBLISHER:
                result = searchBooksByPublisher(keyword);
                break;
        }

        return result;
    }
    public void searchBooks() {
        System.out.println("1. Search by ISBN");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Publisher");
        int searchChoice = InputValidator.validateIntInput("Enter search criteria (1-3): ");

        String keyword = InputValidator.validateStringInput("Enter search keyword: ");

        switch (searchChoice) {
            case 1:
                displaySearchResults(searchBooks(keyword, BookService.SearchCriteria.ISBN));
                break;
            case 2:
                displaySearchResults(searchBooks(keyword, BookService.SearchCriteria.AUTHOR));
                break;
            case 3:
                displaySearchResults(searchBooks(keyword, BookService.SearchCriteria.PUBLISHER));
                break;
            default:
                System.out.println("Invalid search criteria.");
        }
    }

    private void displaySearchResults(List<Book> result) {
        System.out.println("Search Results:");
        System.out.printf(" %-30s %-15s %-15s %-20s %-20s\n",
                "Authors", "ISBN", "Publication Year", "Publisher", "Publication Date");
        for (Book book : result) {
            book.displayInfo();
        }
    }

    public BookService(List<Book> bookList) {
        this.bookList = bookList;
    }

    // Business logic related to Book entity
    public void addBook() {

        Book book = new Book();
        book.InputPublication();
        String isbn;
        boolean isDuplicate;
        do {
            isbn = InputValidator.validateIsbn("Enter ISBN: ");
            isDuplicate = !isbnSet.add(isbn);
            if (isDuplicate) {
                System.out.println("ISBN already exists. Please enter a unique ISBN.");
            }
        } while (isDuplicate);
        book.setIsbn(isbn);
        Set<String> authors = new HashSet<>();
        int authorCount = InputValidator.validateIntInput("Enter the number of authors: ");
        for (int i = 0; i < authorCount; i++) {
            String author = InputValidator.validateStringInput("Enter author name: ");
            authors.add(author);
        }
        book.setAuthors(authors);
        book.setPublicationPlace(InputValidator.validateStringInput("Enter publication place: "));
        bookList.add(0, book);
        System.out.println("Book add success!");
    }

    public void addAuthorToBook() {
        // Assuming you have a Book instance named 'book'
        String id = InputValidator.validateStringInput("Enter ISBN: ");
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(id)) {
                String newAuthor = InputValidator.validateStringInput("Enter the new author's name: ");
                bookList.get(i).addAuthor(newAuthor);
                break;

            }

        }

    }

    public void displayAllBooks() {
        // Display information for all books in the data storage
        for (Book book : bookList) {
            book.displayInfo();
        }
    }

    // Additional methods as needed
}
