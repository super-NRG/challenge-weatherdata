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
        return Math.abs(val2 - val1);
    }

    /**
     * Searches a csv file for the minimum range between two values in specified rows.
     * @param path Path to csv file
     * @param row1
     * @param row2
     * @return Returns the first String value
     * @throws IOException
     */
    String getMinRangeValue(String path, int row1, int row2) throws IOException {

        String minRangeValue = "";
        int minRange = 99999;
        int numberOfLines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while((line = reader.readLine()) != null){
            if(numberOfLines > 0){
                String[] data = line.split(",");
                int tempRange = getRange(Integer.parseInt(data[row1]), Integer.parseInt(data[row2]));
                if(tempRange < minRange){
                    minRange = tempRange;
                    minRangeValue = data[0];
                }
            }
            numberOfLines++;
        }
        reader.close();

        return minRangeValue;
    }
}
