package edu.unl.raikes.babynames;

/**
 * 
 * Class name creates a name object with attributes.
 *
 */
public class Name {
    String name;
    int rank;
    int numBabies;
    int year;
    char gender;

    /**
     * Constructor for the Name (baby).
     * 
     * @param name is the name of the baby.
     * @param rank is the rank of the baby's popularity.
     * @param numBabies is the number of babies with that name in a given year.
     * @param year is the year.
     * @param gender is the sex of the baby.
     */
    public Name(String name, int rank, int numBabies, int year, char gender) {
        this.name = name;
        this.rank = rank;
        this.numBabies = numBabies;
        this.year = year;
        this.gender = gender;
    }

    /**
     * Gets the baby's name.
     * 
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the baby's name.
     * 
     * @param name is the baby's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the baby's rank.
     * 
     * @return rank.
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Sets the baby's rank.
     * 
     * @param rank is the baby's rank.
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Gets the number of babies.
     * 
     * @return number of babies.
     */
    public int getNumBabies() {
        return this.numBabies;
    }

    /**
     * Sets the number of babies.
     * 
     * @param numBabies number of babies.
     */
    public void setNumBabies(int numBabies) {
        this.numBabies = numBabies;
    }

    /**
     * Gets the year.
     * 
     * @return year.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year.
     * 
     * @param year of the baby's name popularity.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the gender.
     * 
     * @return gender.
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * Sets the gender.
     * 
     * @param gender is the baby's gender.
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Compares two babies to see if they are equal.
     */
    public boolean equals(Object o) {
        Name r = (Name) o;
        if (this.name == r.name && this.rank == r.rank && this.numBabies == r.numBabies && this.year == r.year
                && this.gender == r.gender) {
            return true;
        }
        return false;
    }

}
