package edu.unl.raikes.babynames;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Gets the data for the year and the specific baby in that year.
 */
public class YearData {
    /**
     * Searches through a file to find a matching baby for the user-entered name.
     * 
     * @param name is the name of the baby.
     * @param sex is the gender of the baby.
     * @return names of type name corresponding to a matched baby.
     */
    public static ArrayList<Name> readAllFiles(String name, char sex, String gender) {
        final int START = 1880; // start year for baby data
        final int END = 2022; // end year for baby data

        // Array list of names of type name (which is actually a baby)
        ArrayList<Name> names = new ArrayList<>();

        for (int i = START; i < END; i++) {
            // all file names follow this format
            String fileName = "./names/yob" + i + ".txt";
            Scanner scnr = getFileReader(fileName);
            Name baby = readOneFile(scnr, name, sex, i);

            if (baby != null) {
                names.add(baby);
            }
        }

        if (names.size() == 0) {
            // case for if the name is not found in any of the files
            System.out.print("I'm sorry for the inconvenience, but I couldn't find any information about " + gender
                    + " babies named " + name + ".");
            System.exit(1);
        }        
        return names;
    }

    /**
     * Reads one file from the collection of files.
     * 
     * @param scnr looks through a file.
     * @param name is the name of the baby.
     * @param sex is the sex of the baby.
     * @param year is the year of the baby that we are looking at.
     * @return baby.
     */
    public static Name readOneFile(Scanner scnr, String name, char sex, int year) {
        Name baby = null;
        String tempLine = "";
        // rank is the line number
        int rank = 0;
        // while there is a next line in the file
        while (scnr.hasNext()) {
           
            String line = scnr.nextLine();

            // splits the line to get each part of a baby
            String[] parts = line.split(",");
            if (parts[1].toLowerCase().equals("" + sex)) {
                rank += 1;
                if (tempLine.equals(parts[2])) {
                    rank -= 1;
                }
            }
            // casts the sex to a string
            if (parts[0].toLowerCase().equals(name.toLowerCase()) && parts[1].toLowerCase().equals("" + sex)) {
                baby = new Name(name, rank, Integer.parseInt(parts[2]), year, sex);
                return baby;
            }
            // stores the rank of popularity
            tempLine = parts[2];
        }
        return baby;

    }

    /**
     * Sees if the file exists. If it does exist, returns a scnr. If not, exits the program.
     * 
     * @param fileName is the name of the file.
     * @return scnr that reads through the files.
     */
    public static Scanner getFileReader(String fileName) {
        Scanner scnr = null;
        try {
            scnr = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.print("File is not found");
            System.exit(1);
        }
        return scnr;
    }

}
