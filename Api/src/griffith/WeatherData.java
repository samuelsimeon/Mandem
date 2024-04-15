package Api.src.griffith;

/**
 * Task for Saviour;
 * Enhancements to WeatherData class:
 * - This class will now includes additional attributes to store comprehensive weather data, such as temperature, humidity, wind speed, and a descriptive weather condition (e.g., sunny, cloudy, rainy).
 * - A method to determine the general weather condition ('cold', 'mild', 'hot') based on the temperature is included within the class. This method categorizes the temperature at the time of object creation.
 * - The constructor has been updated to initialize all new fields and calculate the weather condition based on the provided temperature.
 * - Getters are provided for each field, allowing other parts of the application to access the weather details. No setters are included, making instances of this class immutable once created.
 * - The purpose of these enhancements is to enable more detailed and accurate clothing recommendations based on a richer set of weather parameters.
 *
 * Responsibilities:
 * - Implement the new fields (temperature, humidity, wind speed, weatherDescription) with appropriate data types.
 * - Update the constructor to initialize these new fields and to set weatherCondition based on the calculated value from temperature.
 * - Implement the private method `determineWeatherCondition(double temperature)` to categorize temperature into 'cold', 'mild', or 'hot'.
 * - Ensure that all data fields are properly encapsulated with public getter methods.
 */

//Saviour will implement this method
public class WeatherData {
    private final String weatherCondition;

    public WeatherData(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }
}
