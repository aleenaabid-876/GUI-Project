import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingSystemGUI extends JFrame implements ActionListener {

    private JLabel titleLabel, balanceLabel;
    private JTextField amountField;
    private JButton depositBtn, withdrawBtn, checkBalanceBtn, exitBtn;

    private double balance = 1000.0; // Initial Balance

    public BankingSystemGUI() {

        // Frame Settings
        setTitle("🏦 Smart Banking System");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Custom Background Panel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0, 102, 204),
                        0, getHeight(), new Color(102, 255, 204));

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(null);

        // Title
        titleLabel = new JLabel("SMART BANKING SYSTEM");
        titleLabel.setBounds(120, 20, 400, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        // Balance Label
        balanceLabel = new JLabel("Current Balance: Rs. " + balance);
        balanceLabel.setBounds(170, 80, 300, 30);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(Color.YELLOW);
        panel.add(balanceLabel);

        // Amount Field
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(130, 140, 150, 30);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        amountLabel.setForeground(Color.WHITE);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(270, 140, 180, 35);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(amountField);

        // Buttons
        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(80, 230, 120, 40);
        depositBtn.setBackground(new Color(0, 204, 102));
        depositBtn.setForeground(Color.WHITE);
        depositBtn.addActionListener(this);
        panel.add(depositBtn);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(230, 230, 120, 40);
        withdrawBtn.setBackground(new Color(255, 102, 102));
        withdrawBtn.setForeground(Color.WHITE);
        withdrawBtn.addActionListener(this);
        panel.add(withdrawBtn);

        checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.setBounds(380, 230, 140, 40);
        checkBalanceBtn.setBackground(new Color(255, 153, 0));
        checkBalanceBtn.setForeground(Color.WHITE);
        checkBalanceBtn.addActionListener(this);
        panel.add(checkBalanceBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(230, 320, 120, 40);
        exitBtn.setBackground(Color.BLACK);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == depositBtn) {
                double amount = Double.parseDouble(amountField.getText());
                balance += amount;
                JOptionPane.showMessageDialog(this,
                        "Rs. " + amount + " Deposited Successfully!");
            }

            else if (e.getSource() == withdrawBtn) {
                double amount = Double.parseDouble(amountField.getText());

                if (amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this,
                            "Rs. " + amount + " Withdrawn Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient Balance!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            else if (e.getSource() == checkBalanceBtn) {
                JOptionPane.showMessageDialog(this,
                        "Current Balance: Rs. " + balance);
            }

            else if (e.getSource() == exitBtn) {
                System.exit(0);
            }

            balanceLabel.setText("Current Balance: Rs. " + balance);
            amountField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid amount!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BankingSystemGUI();
    }
}
