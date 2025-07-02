import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private boolean isXTurn;
    private JLabel statusLabel;
    
    public TicTacToeGame() {
        setTitle("Game Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
        
        // Initialize game state
        isXTurn = true; // X goes first
        buttons = new JButton[3][3];
        
        // Create components
        statusLabel = new JLabel("Giliran: X", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Create game board
        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                gamePanel.add(buttons[i][j]);
            }
        }
        
        // Create reset button
        JButton resetButton = new JButton("Reset Game");
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.addActionListener(e -> resetGame());
        
        // Layout
        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        
        // Check if button is already clicked
        if (!clickedButton.getText().equals("")) {
            return;
        }
        
        // Set X or O based on current turn
        if (isXTurn) {
            clickedButton.setText("X");
            clickedButton.setForeground(Color.BLUE);
            statusLabel.setText("Giliran: O");
        } else {
            clickedButton.setText("O");
            clickedButton.setForeground(Color.RED);
            statusLabel.setText("Giliran: X");
        }
        
        // Toggle turn
        isXTurn = !isXTurn;
        
        // Disable the clicked button
        clickedButton.setEnabled(false);
    }
    
    private void resetGame() {
        // Reset all buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        
        // Reset game state
        isXTurn = true;
        statusLabel.setText("Giliran: X");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicTacToeGame().setVisible(true);
        });
    }
}