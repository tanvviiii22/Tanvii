import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGameUI {
    private int randomNumber;
    private int attemptsLeft;
    private final int maxAttempts = 3;

    public NumberGameUI() {
        // Initialize a new random number
        resetGame();
    }

    public void resetGame() {
        randomNumber = (int) (100 * Math.random()) + 1; // Generate random number between 1 and 100
        attemptsLeft = maxAttempts;
    }

    public void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel for user input and feedback
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        // Add components
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        JTextField inputField = new JTextField();
        JButton guessButton = new JButton("Guess");
        JLabel feedbackLabel = new JLabel("Attempts left: " + attemptsLeft, SwingConstants.CENTER);

        // Add components to the panel
        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(guessButton);

        // Add panel and feedback label to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(feedbackLabel, BorderLayout.SOUTH);

        // Handle guess button click
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(inputField.getText().trim());
                    if (userGuess < 1 || userGuess > 100) {
                        feedbackLabel.setText("Please enter a number between 1 and 100.");
                        return;
                    }

                    attemptsLeft--;

                    if (userGuess == randomNumber) {
                        feedbackLabel.setText("Congratulations! You guessed the correct number!");
                        JOptionPane.showMessageDialog(frame, "You won! Starting a new game.");
                        resetGame();
                        feedbackLabel.setText("Attempts left: " + maxAttempts);
                        inputField.setText("");
                    } else if (attemptsLeft > 0) {
                        feedbackLabel.setText(userGuess > randomNumber
                                ? "Too high! Attempts left: " + attemptsLeft
                                : "Too low! Attempts left: " + attemptsLeft);
                    } else {
                        feedbackLabel.setText("No attempts left. The number was " + randomNumber + ".");
                        JOptionPane.showMessageDialog(frame, "Game Over! Starting a new game.");
                        resetGame();
                        feedbackLabel.setText("Attempts left: " + maxAttempts);
                        inputField.setText("");
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGameUI game = new NumberGameUI();
            game.createAndShowGUI();
        });
    }
}

