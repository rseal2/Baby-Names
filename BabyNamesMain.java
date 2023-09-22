package edu.unl.raikes.babynames;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Baby names gets a name and sex from the user to output when the name was most popular and some facts.
 *
 */
public class BabyNamesMain {

    /**
     * Sorts through the array to find the year when the name was most popular.
     * 
     * @param babies gives us the array list of baby objects.
     * @return peakRank is the highest rank occurrence of the name.
     */
    public static int peakRank(ArrayList<Name> babies) {
        int peakRank = Integer.MAX_VALUE;
        for (int i = 0; i < babies.size(); i++) {
            if (babies.get(i).getRank() < peakRank) {
                peakRank = babies.get(i).getRank();
            }
        }
        return peakRank;
    }

    /**
     * Sorts through array to get the year where the name was most popular.
     * 
     * @param babies gives us the array list of baby objects.
     * @return peakYear is the year where the name was most popular.
     */
    public static int peakYear(ArrayList<Name> babies) {

        int peakYear = 0;
        for (int i = 0; i < babies.size(); i++) {
            if (babies.get(i).getRank() == peakRank(babies)) {
                peakYear = babies.get(i).getYear();
            }
        }
        return peakYear;
    }

    /**
     * Sorts through arrays to find the numBabies during the peak year.
     * 
     * @param babies gives us the array list of baby objects.
     * @return peakNumBabies is the number of babies during the peak year.
     */
    public static int peakNumBabies(ArrayList<Name> babies) {
        int peakNumBabies = 0;
        for (int i = 0; i < babies.size(); i++) {
            if (babies.get(i).getRank() == peakRank(babies)) {
                peakNumBabies = babies.get(i).getNumBabies();
            }
        }
        return peakNumBabies;
    }

    /**
     * Sorts through array to find the max number of babies in a year.
     * 
     * @param babies gives us the array list of baby objects.
     * @return maxBabies is the greatest number of babies at any year.
     */
    public static int maxBabies(ArrayList<Name> babies) {
        int maxBabies = 0;
        for (int i = 0; i < babies.size(); i++) {
            if (babies.get(i).getNumBabies() > maxBabies) {
                maxBabies = babies.get(i).getNumBabies();
            }
        }
        return maxBabies;
    }

    /**
     * Sorts through array to find the year where there are the most babies.
     * 
     * @param babies gives us the array list of baby objects.
     * @return maxBabiesYear is the year when there is the most babies with a name.
     */
    public static int maxBabiesYear(ArrayList<Name> babies) {
        int maxBabiesYear = 0;
        for (int i = 0; i < babies.size(); i++) {
            if (babies.get(i).getNumBabies() == maxBabies(babies)) {
                maxBabiesYear = babies.get(i).getYear();
            }
        }
        return maxBabiesYear;
    }

    /**
     * Sorts through array and finds the popularity rank of max babies.
     * 
     * @param babies gives us the array list of baby objects.
     * @return the popularity rank when there is the max number of babies with a name.
     */
    public static int maxBabiesRank(ArrayList<Name> babies) {
        int maxBabiesRank = 0;
        for (int i = 0; i < babies.size(); i++) {
            if (babies.get(i).getNumBabies() == maxBabies(babies)) {
                maxBabiesRank = babies.get(i).getRank();
            }
        }
        return maxBabiesRank;
    }

    /**
     * Sorts through the babies array to get the ranking and finds the average by dividing by the size of the babies
     * array.
     * 
     * @param babies gives us the array list of baby objects.
     * @return averagePopularity for the average baby rank.
     */
    public static int averagePopularity(ArrayList<Name> babies) {
        int sumPopularity = 0;
        for (int i = 0; i < babies.size(); i++) {
            sumPopularity += babies.get(i).getRank();
        }
        int averagePopularity = sumPopularity / babies.size();
        return averagePopularity;
    }

    /**
     * Sorts through the babies array to gather the number of total babies and adds it to a sum.
     * 
     * @param babies gives us the array list of baby objects.
     * @return sum of totalBabies.
     */
    public static int totalBabies(ArrayList<Name> babies) {
        int totalBabies = 0;
        for (int i = 0; i < babies.size(); i++) {
            totalBabies += babies.get(i).getNumBabies();
        }
        return totalBabies;
    }

    /**
     * https://stackoverflow.com/questions/6810336/is-there-a-way-in-java-to-convert-an-integer-to-its-ordinal-name
     * Gives the ending for a rank or any other number (i.e. nd, rd, st). Source code cited above.
     * 
     * @param i is an integer.
     * @return the suffix of the integer depending on the last number.
     */
    public static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        final int TEN = 10;
        final int ELEVEN = 11;
        final int TWELVE = 12;
        final int THIRTEEN = 13;
        final int HUNDRED = 100;

        switch (i % HUNDRED) {
            case ELEVEN:
            case TWELVE:
            case THIRTEEN:
                return i + "th";
            default:
                return i + suffixes[i % TEN];
        }
    }

    /**
     * Main method controls outcome of program.
     */
    public static void main(String[] args) {

        System.out.print("Welcome to the Baby Name Genie!\r\n"
                + "I can tell you information about the history of first names across three centuries!\r\n"
                + "What first name would you like to learn more about? ");

        Scanner scnr = new Scanner(System.in);
        String name = scnr.next();

        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        System.out.print("Which sex would you like statistics for? (F for female, M for male): ");
        char sex = scnr.next().toLowerCase().charAt(0);
        while (sex != 'm' && sex != 'f') {
            System.out.print("Please enter a valid input ");
            sex = scnr.next().toLowerCase().charAt(0);
        }

        String gender = "female";
        if (sex == 'm') {
            gender = "male";
        }

        System.out.println("Okay! Let me see what I can find about " + gender + " babies named " + name);

        System.out.println("..");
        System.out.println("....");
        System.out.println("...");
        System.out.println("....");
        System.out.println("...");

        System.out.println("Okay, here's what I found:");

        ArrayList<Name> babies = YearData.readAllFiles(name, sex, gender);
        int totalYears = babies.size();
        System.out.println(
                "* " + name + " first appeared as a popular " + gender + " first name in " + babies.get(0).getYear()
                        + ", at which time it was ranked " + ordinal(babies.get(0).getRank()) + ". There were "
                        + babies.get(0).getNumBabies() + " " + gender + " babies named " + name + " that year.");

        System.out.println("* " + name + " reached peak popularity in " + peakYear(babies)
                + ", at which time it was ranked " + ordinal(peakRank(babies)) + ". There were " + peakNumBabies(babies)
                + " " + gender + " babies named " + name + " that year.");

        System.out.println("* The name " + name + " was given to the most babies in " + maxBabiesYear(babies) + "("
                + maxBabies(babies) + " " + gender + " babies were named " + name + " in " + maxBabiesYear(babies)
                + "). " + name + " was the " + ordinal(maxBabiesRank(babies)) + " most popular " + gender
                + " name that year.");

        System.out.println("* Of the " + totalYears + " years that " + name + " has been a popular " + gender
                + " name, " + totalBabies(babies) + " " + gender + " babies have been named " + name
                + " and its average popularity has been " + ordinal(averagePopularity(babies)) + ".");

        for (int i = 0; i < babies.size(); i++) {
            Name baby = babies.get(i);
            System.out.println(baby.getYear() + " - " + baby.getName() + " was ranked " + ordinal(baby.getRank())
                    + " for " + gender + " babies (" + baby.getNumBabies() + " given that name)");
        }

        scnr.close();
    }

}
