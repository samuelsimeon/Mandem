package Api.src.griffith;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Api.src.griffith.WeatherData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WeatherChatbot {
	//PLEASE MAKE A BRANCH TO TEST YOUR CODE AND ONLY PUSH TO YOUR BRNCH NOT THE MAIN BRANCH!!!!!

    // Constants for API key and base URL
    private static final String API_KEY = "HBBklX5K1UUwqJXCW7V3BKdomOtOGEVI";
    private static final String BASE_URL = "https://api.tomorrow.io/v4/weather/realtime?location=%s&apikey=%s";

    /**
	 * Fetches weather data from the API.
	 *
	 * @param location The location for which to fetch the weather.
	 * @return A string containing the weather data.
	 */
 // Saviour will implement this method
	public static WeatherData fetchWeather(String location) {
		try {
			String apiUrl = String.format(BASE_URL, location, API_KEY);
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = in.readLine()) != null) {
					response.append(line);
				}
				in.close();

				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

				JsonObject dataObject = jsonObject.getAsJsonObject("data");
				JsonObject valuesObject = dataObject.getAsJsonObject("values");
				double temperature = valuesObject.get("temperature").getAsDouble(); // Assuming temperature is in Celsius

				// Categorize weather condition based on temperature
				String weatherCondition;
				if (temperature <= 15) {
					weatherCondition = "cold";
				} else if (temperature <= 25) {
					weatherCondition = "mild";
				} else {
					weatherCondition = "hot";
				}

				return new WeatherData(weatherCondition);
			} else {
				System.out.println("HTTP error code: " + responseCode);
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

	public static String suggestClothing(WeatherData weatherData) {
		if (weatherData == null || weatherData.getWeatherCondition() == null || weatherData.getWeatherCondition().isEmpty()) {
			return "Weather condition is not provided.";
		}

		String suggestion;
		switch (weatherData.getWeatherCondition().toLowerCase()) {
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
				suggestion = "No specific clothing suggestion available for the weather condition: " + weatherData.getWeatherCondition();
				break;
		}

		return suggestion;
	}


    /**
     * Main method for chatbot interaction.
     *
     * @param args Command line arguments (not used).
     */
    // Samuel will implement this section
	public static void main(String[] args) {
		// Create a BufferedReader to read input from the console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			// Ask the user for their location
			System.out.println("Please enter your location (e.g., city name, country):");
			String location = reader.readLine().trim();

			// Fetch the weather data for the given location
			WeatherData weatherData = fetchWeather(location);

			// Get clothing suggestions based on the weather condition
			String clothingSuggestion = suggestClothing(weatherData);

			// Display the clothing suggestions
			System.out.println(clothingSuggestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






}

