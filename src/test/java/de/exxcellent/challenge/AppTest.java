package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    private final String BASE_FILEPATH = "src/main/resources/de/exxcellent/challenge/";
    private final String FILENAME_FOOTBALL = "football.csv";
    private final String FILENAME_WEATHER = "weather.csv";


    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() throws IOException {
        App.main("--football", "football.csv");
    }

    @Test
    void runWeather() throws IOException {
        App.main("--weather", "weather.csv");
    }

    @Test
    void testFootball() throws IOException {
        //Check if returned String is correct.
        File football = new File(BASE_FILEPATH + FILENAME_FOOTBALL);
        RangeFinder finder = new RangeFinder();
        String teamWithSmallestGoalSpread = finder.getMinRangeValue(football.getPath(), 6, 5);
        assertEquals("Aston_Villa", teamWithSmallestGoalSpread);
    }

    @Test
    void testWeather() throws IOException {
        //Check if returned String is correct.
        File weather = new File(BASE_FILEPATH + FILENAME_WEATHER);
        RangeFinder finder = new RangeFinder();
        String dayWithSmallestTemperatureSpread = finder.getMinRangeValue(weather.getPath(), 2, 1);
        assertEquals("14", dayWithSmallestTemperatureSpread);
    }

}