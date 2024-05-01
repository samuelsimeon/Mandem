package Api.src.griffith;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JTextArea chatArea;
    private JButton startButton;
    private WeatherChatbot chatbot;
    private final int totalLocations = 5;


    // Constructor to initialize and setup the GUI components.
    public GUI() {
        chatbot = new WeatherChatbot();
        frame = new JFrame("Weather Chatbot");
        chatArea = new JTextArea(16, 50);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        startButton = new JButton("Plan My Trip");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planTrip();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(startButton, BorderLayout.CENTER);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Method to handle the trip planning workflow.
    private void planTrip() {
        chatArea.setText(""); // Clear the chat area at the start of planning.
        for (int i = 0; i < totalLocations; i++) {
            String location = JOptionPane.showInputDialog(frame, "Enter location " + (i + 1) + " (e.g., city name, country):");
            if (location != null && !location.trim().isEmpty()) {
                String day = JOptionPane.showInputDialog(frame, "What day will you visit " + location + "? (day1, day2, or day3):");
                if (day != null && !day.trim().isEmpty()) {
                    fetchWeatherData(location.trim(), day.trim());
                }
            }
        }
    }

    // Method to fetch and display weather data.
    private void fetchWeatherData(String location, String day) {
        chatArea.append("Fetching weather data for: " + location + " on " + day + "...\n");
        WeatherData weatherData = chatbot.fetchWeather(location, day);
        if (weatherData != null) {
            String suggestion = chatbot.suggestClothing(weatherData);
            chatArea.append("For " + location + " on " + day + " (" + weatherData.getTemperature() + "°C): " + suggestion + "\n\n");
        } else {
            chatArea.append("Failed to fetch data for " + location + " on " + day + "\n\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
