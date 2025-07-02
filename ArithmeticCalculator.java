import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmeticCalculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton;
    
    public ArithmeticCalculator() {
        setTitle("Kalkulator Aritmatika Sederhana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Top panel for text fields and result
        JPanel topPanel = new JPanel(new FlowLayout());
        
        // Create text fields with proper size
        num1Field = new JTextField(8);
        num2Field = new JTextField(8);
        resultField = new JTextField(8);
        resultField.setEditable(false);
        resultField.setBackground(Color.WHITE);
        
        // Add text fields and equals label
        topPanel.add(num1Field);
        topPanel.add(num2Field);
        topPanel.add(new JLabel("="));
        topPanel.add(resultField);
        
        // Labels above text fields
        JPanel labelPanel = new JPanel(new FlowLayout());
       
        
        
        
      
        
        // Button panel with red border
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        buttonPanel.setBackground(Color.WHITE);
        
        // Create buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("Modulus");
        
        // Style buttons
        JButton[] buttons = {addButton, subtractButton, multiplyButton, divideButton, modulusButton};
        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(200, 40));
            button.setBackground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            button.addActionListener(this);
        }
        
        // Add buttons to panel
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(modulusButton);
        
        // Add label for button panel
        JLabel buttonLabel = new JLabel("Operasi Aritmatika");
        buttonLabel.setForeground(Color.RED);
        buttonLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Add components to main panel
        mainPanel.add(labelPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(topPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        
        JPanel buttonContainer = new JPanel(new BorderLayout());
        buttonContainer.add(buttonLabel, BorderLayout.NORTH);
        buttonContainer.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(buttonContainer);
        
        add(mainPanel, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            
            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Tidak bisa dibagi dengan nol!");
                    return;
                }
            } else if (e.getSource() == modulusButton) {
                if (num2 != 0) {
                    result = num1 % num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Tidak bisa modulus dengan nol!");
                    return;
                }
            }
            
            // Format result to remove unnecessary decimal places
            if (result == (long) result) {
                resultField.setText(String.valueOf((long) result));
            } else {
                resultField.setText(String.format("%.2f", result));
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArithmeticCalculator().setVisible(true);
        });
    }
}