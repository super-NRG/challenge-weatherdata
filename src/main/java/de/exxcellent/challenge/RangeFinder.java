package de.exxcellent.challenge;

import java.io.*;

class RangeFinder {
    /**
     * Calculates range between two int values.
     * @param val1 First integer value.
     * @param val2 Second integer value.
     * @return Range between the two given integer values.
     */
    private int getRange(int val1, int val2){
        //Calculate range between given values, regardless of which value is greater.
        return Math.abs(val2 - val1);
    }

    /**
     * Searches a csv file for the minimum range between two values in specified rows.
     * @param path Path to csv file
     * @param row1 First of two rows in csv file to be compared.
     * @param row2 Second of two rows in csv file to be compared.
     * @return Returns first String value of line with minimum range between compared values.
     * @throws IOException if given file can't be found or read.
     */
    String getMinRangeValue(String path, int row1, int row2) throws IOException {
        //String to be returned.
        String minRangeValue = "";
        //Integer value that keeps track of minimum range calculated.
        int minRange = 99999;
        //Integer value that counts lines in file.
        int numberOfLines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        //String for current line being read.
        String line;
        while((line = reader.readLine()) != null){
            //First line with names for rows gets ignored for range calculation.
            if(numberOfLines > 0){
                //Create temporary array of Strings seperated by "," in current line.
                String[] data = line.split(",");
                //Calculate range between Integer values to be compared.
                int tempRange = getRange(Integer.parseInt(data[row1]), Integer.parseInt(data[row2]));
                //If current range is smaller than previous, save value as new minimum.
                if(tempRange < minRange){
                    minRange = tempRange;
                    minRangeValue = data[0];
                }
            }
            numberOfLines++;
        }
        reader.close();
        //Return String value corresponding to calculated minimum range.
        return minRangeValue;
    }
}
