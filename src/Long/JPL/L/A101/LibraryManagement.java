package JPL.L.A101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        List<Book> bookList=new ArrayList<>();
        List<Magazine> magazineList=new ArrayList<>();
        BookService bookService = new BookService(bookList);
        MagazineService magazineService = new MagazineService(magazineList);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.println("0. Exit");
            int choice = InputValidator.validateIntInput("Please choose a function (0-6): ");

            switch (choice) {
                case 1:
                    bookService.addBook();
                    break;

                case 2:
                   magazineService.addMagazine();
                    break;

                case 3:
                    System.out.println("Books:");
                    System.out.printf(" %-30s %-15s %-15s %-20s %-20s\n",
                            "Authors", "ISBN", "Publication Year", "Publisher", "Publication Date");
                    for (Book book : bookList) {
                        book.displayInfo();
                    }

                    System.out.println("Magazines:");
                    System.out.printf("%-15s %-20s %-20s %-30s %-10s %-10s\n",
                            "Publication Year", "Publisher", "Publication Date",
                            "Magazine Author", "Volume", "Edition");
                    for (Magazine magazine : magazineList) {
                        magazine.displayInfo();
                    }
                    break;

                case 4:
                   bookService.addAuthorToBook();
                    break;

                case 5:
                    // Display top 10 magazines by volume
                    System.out.println("Magazines:");
                    System.out.printf("%-15s %-20s %-20s %-30s %-10s %-10s\n",
                            "Publication Year", "Publisher", "Publication Date",
                            "Magazine Author", "Volume", "Edition");
                    magazineService.displayTop10MagazinesByVolume();
                    break;

                case 6:
                   bookService.searchBooks();
                    break;

                case 0:
                    // Exit
                    System.out.println("Exiting Library Management System. Goodbye!");
            }
        }
    }
}