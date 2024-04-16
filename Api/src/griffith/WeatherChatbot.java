/**
 * LESS GO GUYS......WEVE GOT THIS!!!!!!!!!
 * boolean TRUE = (SAM & TAYO & SAVIOUR === MANDEM)? true : false;
 * */
package Api.src.griffith;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Api.src.griffith.WeatherData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Project Overview - WeatherChatbot Enhancement:
 *
 * Objective:
 * - The goal of this project is to enhance the existing WeatherChatbot application to handle more complex weather data and provide more granular and detailed clothing recommendations based on the weather conditions of multiple locations. The enhanced system will not only consider temperature but also other weather factors such as humidity and wind speed, which can influence clothing suggestions.
 *
 * Key Enhancements:
 * - Extend the WeatherData class to include additional weather parameters such as actual temperature, humidity, and wind speed. This will allow for more precise and practical clothing recommendations.
 * - Modify the fetchWeather method to capture and process an extended range of data from the weather API, ensuring that the application can utilize this additional data effectively.
 * - Expand the suggestClothing method to incorporate a detailed temperature scale and additional weather conditions, providing clothing suggestions that are more tailored to the specific weather scenario.
 * - Update the main method to handle inputs for three distinct locations, enhancing the application's utility for users needing weather updates and clothing suggestions for multiple areas simultaneously.
 * - Implement robust unit testing to cover new functionalities and ensure that both new and existing features perform reliably under various scenarios.
 *
 * Development Strategy:
 * - Team members are assigned specific components of the project to ensure clarity of roles and efficient progress. Each component's development is isolated in separate branches to allow for independent testing and integration, minimizing conflicts and regression issues.
 * - Regular code reviews and team meetings will be conducted to discuss progress, tackle any arising issues, and ensure consistency and adherence to project standards.
 *
 * Expected Outcomes:
 * - A more versatile and user-friendly WeatherChatbot that provides accurate weather forecasts and practical clothing recommendations for multiple locations, enhancing the user experience and the application's marketability.
 *
 * By improving the WeatherChatbot's functionality and user interaction, this project aims to create a more engaging and useful tool for day-to-day weather and outfit planning.
 */


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


	/**
	 * Task for Saviour - Enhance the fetchWeather method:
	 * - Modify this method to not only fetch and parse the weather condition based on temperature but also to return the actual temperature alongside the categorized condition.
	 * - Extract and include additional weather parameters such as humidity or wind speed if deemed relevant for the application.
	 * - Ensure the method can handle any API errors gracefully and report back with useful error messages.
	 * - Optimize the method for efficiency, perhaps by adding caching mechanisms to avoid unnecessary API calls for frequently requested locations.
	 */

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
				//.......................................................
				System.out.println(response);
				//Implemented gson
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

				JsonObject dataObject = jsonObject.getAsJsonObject("data");
				JsonObject valuesObject = dataObject.getAsJsonObject("values");
				double temperature = valuesObject.get("temperature").getAsDouble(); // Assuming temperature is in Celsius
				double humidity = valuesObject.get("humidity").getAsDouble();
				double windSpeed = valuesObject.get("windSpeed").getAsDouble();
				double rainLevel = valuesObject.get("rainIntensity").getAsDouble();





				//.............................
				System.out.println(temperature);
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


	/**
	 * Task for Omotayo - Implement and enhance the suggestClothing method:
	 * - Expand the method to offer clothing suggestions based on a detailed temperature scale instead of broad categories.
	 * - Consider including weather conditions like wind or precipitation in the clothing suggestions.
	 * - Ensure the suggestions are practical and adjusted to a variety of weather scenarios which could include extreme temperatures or sudden weather changes.
	 * - Make the output user-friendly and informative, providing clear and actionable clothing recommendations.
	 */

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


	/**
	 * Task for Samuel - Implement the main method enhancements:
	 * - Update the main method to handle input for three locations from the user. Ensure that the method prompts the user appropriately and handles user input efficiently.
	 * - For each of the three locations, fetch the weather using the fetchWeather method and obtain clothing suggestions using the suggestClothing method.
	 * - Format the output to clearly indicate the temperature, location, and suggested clothing in an informative and easy-to-read manner.
	 * - Ensure robust error handling in the main method to manage exceptions that might arise during input handling, weather data fetching, or any other process.
	 */

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

