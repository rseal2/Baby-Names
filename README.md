# Baby Name Analyzer

Every year, The US Social Security Administration releases data regarding the most popular baby names of that year. Included in the dataset are the names given to newborn babies, the sex of the babies who were given that name, and the number of babies who were given that name. The data is sorted by the number of babies given a specific name, such that the most frequently given names appear first in the list. The list reports all female names first, followed by the male names.

This program has the following functionality: 

-   ask users which baby name they'd like to know more about and the sex of the babies with that name
-   find all of the years where that name was listed as popular and record that information
    -   record the year
    -   record the count of babies given that name in that year
    -   record the "popularity ranking". The most popular name for a given sex in a given year should be `1`, the second-most popular name should be `2`, etc.
-   report to the user statistics about the first year that name was popular
-   find and report to the user statistics about the year where the name was the most popular (the year with the lowest popularity ranking). In the case that several years tie for the lowest popularity ranking, choose the year with the highest count of babies. If both the popularity and the count are the same, choose the year that occurred first
-   find and report to the user statistics about the year where the name was given to the most babies (the year with the highest baby count). In the case that several years tie for the highest baby count, choose the year with the lowest popularity ranking. If both the popularity and the count are the same, choose the year that occurred first
-   find and report to the user the number of years that name has been popular
-   find and report to the user the total number of babies in the US that have been given that name
-   write unit tests for all functions that perform calculations (including the function that reads one file).
