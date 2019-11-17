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
public class AppTest {

    private String successLabel = "not successful";

    private final String BASE_FILEPATH = "src/main/resources/de/exxcellent/challenge/";
    private final String FILENAME_FOOTBALL = "football.csv";
    private final String FILENAME_WEATHER = "weather.csv";


    @BeforeEach
    public void setUp() {
        successLabel = "successful";
    }

    @Test
    public void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    public void runFootball() throws IOException {
        App.main("--football", "football.csv");
    }

    @Test
    public void runWeather() throws IOException {
        App.main("--weather", "weather.csv");
    }

    @Test
    public void testFootball() throws IOException {
        File football = new File(BASE_FILEPATH + FILENAME_FOOTBALL);
        RangeFinder finder = new RangeFinder();
        String teamWithSmallestGoalSpread = finder.getMinRangeValue(football.getPath(), 6, 5);
        assertEquals("Aston_Villa", teamWithSmallestGoalSpread);
    }

    @Test
    public void testWeather() throws IOException {
        File weather = new File(BASE_FILEPATH + FILENAME_WEATHER);
        RangeFinder finder = new RangeFinder();
        String dayWithSmallestTemperatureSpread = finder.getMinRangeValue(weather.getPath(), 2, 1);
        assertEquals("14", dayWithSmallestTemperatureSpread);
    }

}