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

            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Checking if the response code is successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Return the weather data as string
                return response.toString();
            } else {
                // If the response code is not successful, return null
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Suggests clothing based on the weather data.
     * 
     * @param weatherData The weather data.
     * @return A string containing clothing suggestions.
     */
 //Omotayo will implement this method
   
    	public static String suggestClothing(String weatherCondition) {
    	    // Check the weather condition and suggest clothing accordingly
    	    if (weatherCondition == null || weatherCondition.isEmpty()) {
    	        return "Weather condition is not provided.";
    	    }

    	    String suggestion;
    	    switch (weatherCondition.toLowerCase()) {
    	        case "cold":
    	            suggestion = "Recommended clothing for cold weather: Thermal layers, heavy coat, gloves, and a beanie.";
    	            break;
    	        case "mild":
    	            suggestion = "Recommended clothing for mild weather: Sweater, long-sleeved shirt, and light jacket.";
    	            break;
    	        case "hot":
    	            suggestion = "Recommended clothing for hot weather: Shorts and a t-shirt, or light dresses.";
    	            break;
    	        default:
    	            suggestion = "No specific clothing suggestion available for the weather condition: " + weatherCondition;
    	            break;
    	    }

    	    return suggestion;
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

