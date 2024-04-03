package Api.src.griffith;

public class WeatherData {
    private final String weatherCondition;

    public WeatherData(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }
}
