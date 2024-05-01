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


}
