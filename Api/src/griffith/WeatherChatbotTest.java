package Api.src.griffith;

import Api.src.griffith.WeatherChatbot;
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


    /**
     * Task for Sam - Enhance the testFetchWeather method:
     * - Expand testing to cover various scenarios including different locations and their expected weather data.
     * - Ensure that the test cases cover a range of temperatures, checking both lower and upper bounds.
     * - Incorporate tests for error handling, such as response to invalid locations or when the API is unreachable.
     * - Validate that the fetched weather data includes not only temperature but also humidity, and possibly other weather conditions like wind speed.
     * - The goal is to ensure that the fetchWeather method is robust, handles errors gracefully, and provides accurate and comprehensive weather data.
     */

    // Test case for the fetchWeather method
    @Test
    void testFetchWeather() {
        // Implement test for fetchWeather method
        // Call the fetchWeather method with a location
            String weatherData = String.valueOf(WeatherChatbot.fetchWeather("Ireland"));

            // Checking if the weather data is not null
            assertNotNull(weatherData);
        // Checking if the weather data contains temperature and humidity
        assertTrue(weatherData.contains("temperature"), "Weather data should contain temperature");
        assertTrue(weatherData.contains("humidity"), "Weather data should contain humidity");
    }


    /**
     * Task for Tayo - Enhance the testSuggestClothing method:
     * - Develop tests that cover a wider range of temperature scenarios, including borderline temperatures where clothing suggestions might change.
     * - Include tests for different weather conditions like rain, snow, or high winds, and how they impact clothing suggestions.
     * - Ensure the suggestions are sensible and detailed for varying weather conditions, reflecting the nuances in temperature and weather variations.
     * - Test the method's response to null or incomplete data to ensure the system's robustness.
     * - Aim to confirm that the clothing suggestions are not only appropriate for the given conditions but also detailed and practical for the end-user.
     */

      @Test
      void testSuggestClothing() {

      }

}

