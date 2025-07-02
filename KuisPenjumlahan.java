import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class KuisPenjumlahan extends JFrame implements ActionListener {

    JTextField angka1Field, angka2Field, jawabanField;
    JButton checkButton;
    JLabel resultLabel;
    int angka1, angka2;
    Random rand;

    public KuisPenjumlahan() {
        setTitle("Game Kuis Penjumlahan");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Inisialisasi random
        rand = new Random();
        generateSoal();

        angka1Field = new JTextField(String.valueOf(angka1), 5);
        angka1Field.setEditable(false);
        angka2Field = new JTextField(String.valueOf(angka2), 5);
        angka2Field.setEditable(false);
        jawabanField = new JTextField(5);

        add(angka1Field);
        add(new JLabel("+"));
        add(angka2Field);
        add(new JLabel("="));
        add(jawabanField);

        checkButton = new JButton("CHECK");
        checkButton.addActionListener(this);
        add(checkButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem randomUlangItem = new JMenuItem("Random Ulang");
        JMenuItem exitItem = new JMenuItem("Exit");

        randomUlangItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateSoal();
                angka1Field.setText(String.valueOf(angka1));
                angka2Field.setText(String.valueOf(angka2));
                jawabanField.setText("");
                resultLabel.setText("");
                getContentPane().setBackground(null);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(randomUlangItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    // Method untuk generate soal baru
    private void generateSoal() {
        angka1 = rand.nextInt(10) + 1;
        angka2 = rand.nextInt(10) + 1;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int jawaban = Integer.parseInt(jawabanField.getText());
            if (jawaban == angka1 + angka2) {
                resultLabel.setText("Selamat Jawaban Anda Benar !!! " + jawaban);
                getContentPane().setBackground(Color.GREEN);
            } else {
                resultLabel.setText("Maaf, Jawaban Anda Salah");
                getContentPane().setBackground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Masukkan angka yang valid.");
            getContentPane().setBackground(Color.YELLOW);
        }
    }

    public static void main(String[] args) {
        new KuisPenjumlahan();
    }
}
