package de.exxcellent.challenge;

import java.io.*;
import java.nio.file.*;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    private final static String CMDLINE_PARAM_FOOTBALL = "--football";
    private final static String CMDLINE_PARAM_WEATHER = "--weather";
    private final static String BASE_FILEPATH = "src/main/resources/de/exxcellent/challenge/";

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed.
     * @throws IOException if given file can't be found or read.
     */
    public static void main(String... args) throws IOException {

        /*
        Checks for correct parameters, prints error message to console if incorrect.
        Depending on given parameters, prints day with minimum temperature spread
        or football team with minimum goal difference.
         */

        if(args[0].equals(CMDLINE_PARAM_FOOTBALL)){
            File football = new File(BASE_FILEPATH + args[1]);
            RangeFinder finder = new RangeFinder();
            String teamWithSmallestGoalSpread = finder.getMinRangeValue(football.getPath(), 6, 5);
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        }else if(args[0].equals(CMDLINE_PARAM_WEATHER)){
            File weather = new File(BASE_FILEPATH + args[1]);
            RangeFinder finder = new RangeFinder();
            String dayWithSmallestTempSpread = finder.getMinRangeValue(weather.getPath(), 2, 1);
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } else{
            System.out.println("Invalid Parameter \"" + args[0] + "\". Use either \"--football\" or \"--weather\".");
            System.exit(1);
        }
    }
}
