package griffith;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherChatbot {
	//PLEASE MAKE A BRANCH TO TEST YOUR CODE AND ONLY PUSH TO YOUR BRNCH NOT THE MAIN BRANCH!!!!!
	
    // Constants for API key and base URL
    private static final String API_KEY = "HBBklX5K1UUwqJXCW7V3BKdomOtOGEVI"; 
    private static final String BASE_URL = "https://api.tomorrow.io/v4/weather/realtime?location=Ireland&apikey=HBBklX5K1UUwqJXCW7V3BKdomOtOGEVI"; 

    /**
     * Fetches weather data from the API.
     * 
     * @param location The location for which to fetch the weather.
     * @return A string containing the weather data.
     */ 
 // Samuel will implement this method
    public static String fetchWeather(String location) {
        try {
            // Build the API URL with the location and API key
            String apiUrl = String.format(BASE_URL, location, API_KEY);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return location;
    }

    /**
     * Suggests clothing based on the weather data.
     * 
     * @param weatherData The weather data.
     * @return A string containing clothing suggestions.
     */
 // Omotayo will implement this method
    public static String suggestClothing(String weatherData) {
        // This method should interpret the weather data and return a string with clothing suggestions.
        return null; 
    }

    /**
     * Main method for chatbot interaction.
     * 
     * @param args Command line arguments (not used).
     */
    // Saviour will implement this section
    public static void main(String[] args) {
        // This section should handle user interaction, including asking for user input (location),
        // calling the fetchWeather method, getting clothing suggestions from the suggestClothing method,
        // and displaying the results to the user.
    }
}

