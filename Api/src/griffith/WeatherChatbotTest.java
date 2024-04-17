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
        WeatherData weatherData = WeatherChatbot.fetchWeather("Ireland");

        // Check if the weather data is not null
        assertNotNull(weatherData, "The fetched weather data should not be null.");
        // Check if the weather data contains valid temperature
        assertTrue(weatherData.getTemperature() >= -30, "Temperature should be -30 or greater.");

        // Check if the weather data contains valid humidity
        assertTrue(weatherData.getHumidity() != -20, "Humidity should be fetched and not be zero.");

        // Optionally check for wind speed and rain level if they are critical
        assertTrue(weatherData.getWindSpeed() >= 0, "Wind speed should be fetched and not be zero.");
        assertTrue(weatherData.getRainLevel() >= 0, "Rain level should be fetched be zero or greater than zero.");

        // Checking the weather condition string is not empty or null
        assertNotNull(weatherData.getWeatherCondition(), "Weather condition should be determined and not null.");
        assertFalse(weatherData.getWeatherCondition().isEmpty(), "Weather condition should not be an empty string.");





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
          // Test for very cold weather
          WeatherData veryCold = new WeatherData(-5, 50, 10, 0);  // Sample parameters for constructor
          assertEquals("Recommended clothing for cold weather: Thermal layers, heavy coat, gloves, thick long pants and a beanie.",
                  WeatherChatbot.suggestClothing(veryCold),
                  "Clothing suggestion for very cold weather does not match expected.");




          }

      }
