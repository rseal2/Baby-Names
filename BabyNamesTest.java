package edu.unl.raikes.babynames;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class BabyNamesTest {

    @Test
    void testIfPeakRankYieldsPeakRank() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 2, 100, 1989, 'M'));
        test.add(new Name("Adam", 3, 100, 1989, 'M'));
        test.add(new Name("Adam", 4, 100, 1989, 'M'));

        int expected = 2;

        // execute
        int actual = BabyNamesMain.peakRank(test);

        // test
        assertEquals("Peak baby rank is not correct", expected, actual);
    }
    
    @Test
    void testIfPeakYearYieldsPeakYear() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 1, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 1999;

        // execute
        int actual = BabyNamesMain.peakYear(test);

        // test
        assertEquals("Peak baby year is not correct", expected, actual);
    }
    
    @Test
    void testIfPeakNumBabiesYieldsPeakNumBabies() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 1, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 1000;

        // execute
        int actual = BabyNamesMain.peakNumBabies(test);

        // test
        assertEquals("Peak number of babies is not outputting correctly", expected, actual);
    }
    
    @Test
    void testIfMaxBabiesYieldsMaxBabies() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 1, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 1000;

        // execute
        int actual = BabyNamesMain.maxBabies(test);

        // test
        assertEquals("Max number of babies is not outputting correctly", expected, actual);
    }
    
    @Test
    void testIfMaxBabiesYearYieldsMaxBabiesYear() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 1, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 1999;

        // execute
        int actual = BabyNamesMain.maxBabiesYear(test);

        // test
        assertEquals("Max babies year is not outputting correctly", expected, actual);
    }
    
    @Test
    void testIfMaxBabiesRankYieldsMaxBabiesRank() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 1, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 1;

        // execute
        int actual = BabyNamesMain.maxBabiesRank(test);

        // test
        assertEquals("Max babies rank is not outputting correctly", expected, actual);
    }
    
    @Test
    void testIfAveragePopularityYieldsAveragePopularity() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 2, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 3;

        // execute
        int actual = BabyNamesMain.averagePopularity(test);

        // test
        assertEquals("Average popularity is not outputting correctly", expected, actual);
    }
    
    @Test
    void testIfTotalBabiesYieldsTotalBabies() {
        // setup
        ArrayList<Name> test = new ArrayList<Name>();
        test.add(new Name("Adam", 2, 1000, 1999, 'M'));
        test.add(new Name("Adam", 5, 100, 1930, 'M'));
        test.add(new Name("Adam", 2, 10, 1900, 'M'));

        int expected = 1110;

        // execute
        int actual = BabyNamesMain.totalBabies(test);

        // test
        assertEquals("Total babies is not outputting correctly", expected, actual);
    }
    
    @Test
    void testReadOneFile() throws FileNotFoundException {
        // setup
        Scanner scnr = new Scanner(new File("./src/Test.txt"));
        Name expected = new Name("Sarah", 2, 10, 2022, 'f');
    
        // execute
        Name actual = YearData.readOneFile(scnr, "Sarah", 'f', 2022);

        // test
        assertEquals("The file reader is not working correctly", expected, actual);
    }
   

}
