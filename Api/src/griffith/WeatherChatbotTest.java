package griffith;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherChatbotTest {

    // Set up common objects or state before each test
    @BeforeEach
    void setUp() {
        // Initialize necessary objects and prepare test environment
    }

    // Clean up after each test
    @AfterEach
    void tearDown() {
        // Clean up test environment and dispose of objects
    }

    // Test case for the fetchWeather method
    @Test
    void testFetchWeather() {
        // Implement test for fetchWeather method
        // Call the fetchWeather method with a location
            String weatherData = WeatherChatbot.fetchWeather("Ireland");

            // Check if the weather data is not null
            assertNotNull(weatherData);
    }

    // Test case for the suggestClothing method
    @Test
    void testSuggestClothing() {
        // Implement test for suggestClothing method
        // Omotayo and Samuel
    }

}

