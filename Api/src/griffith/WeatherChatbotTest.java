package griffith;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherChatbotTest {

    private WeatherChatbot chatbot; // Declare chatbot as a field of the class

    // Set up common objects or state before each test
    @BeforeEach
    void setUp() {
        // Initialize necessary objects and prepare test environment
        chatbot = new WeatherChatbot();
    }

    // Clean up after each test
    @AfterEach
    void tearDown() {
    	chatbot = null;
        // Clean up test environment and dispose of objects
    }

    // Test case for the fetchWeather method
    @Test
    void testFetchWeather() {
        // Implement test for fetchWeather method
        // Call the fetchWeather method with a location
            String weatherData = WeatherChatbot.fetchWeather("Ireland");

            // Checking if the weather data is not null
            assertNotNull(weatherData);
        // Checking if the weather data contains temperature and humidity
        assertTrue(weatherData.contains("temperature"), "Weather data should contain temperature");
        assertTrue(weatherData.contains("humidity"), "Weather data should contain humidity");
    }

    // Test case for the suggestClothing method
    @Test
    void testSuggestClothing() {
        // Implement test for suggestClothing method
        // Omotayo and Samuel
    }

}

