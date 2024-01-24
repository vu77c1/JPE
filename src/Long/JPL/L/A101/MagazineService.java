package JPL.L.A101;

import java.util.*;

public class MagazineService {
    // Placeholder for data storage (could be replaced with a database or other data source)
    private List<Magazine> magazineList;

    public MagazineService(List<Magazine> magazineList) {
        this.magazineList = magazineList;
    }

    // Business logic related to Magazine entity
    public void addMagazine() {
        Magazine magazine=new Magazine();
        magazine.InputPublication();
        magazine.setMagazineAuthor(InputValidator.validateStringInput("Enter Magazine Author: "));
        magazine.setEdition(InputValidator.validateIntInput("Enter Edition: "));
        magazine.setVolume(InputValidator.validateIntInput("Enter Volume: "));
        magazineList.add(0,magazine);
        System.out.println("Magazine Add success!");
    }

    public void removeMagazine(Magazine magazine) {
        // Remove magazine from the data storage
        magazineList.remove(magazine);
    }

    public void displayAllMagazines() {
        for (Magazine magazine : magazineList) {
            magazine.displayInfo();
        }
    }

    //5.	Display top 10 of magazines by volume
    public void displayTop10MagazinesByVolume()
    {
        if (magazineList != null && magazineList.size() >= 3) {
            // Sort the list of magazines by volume in descending order
            Collections.sort(magazineList, Comparator.comparingInt(Magazine::getVolume).reversed());

            // Display the top 10 magazines by volume
            System.out.println("Top 10 Magazines by Volume:");
            for (int i = 0; i < 3; i++) {
                Magazine magazine = magazineList.get(i);
                magazine.displayInfo();
            }
        } else {
            System.out.println("Insufficient magazines to display the top 10.");
        }
    }

    // Additional methods as needed
}
