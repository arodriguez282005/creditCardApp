/*
    Program Name: creditCardApp
    Program Date: 5/27/26
    Developer Names: Alejandro Rodriguez, Natalia Jackson
    Program Version: 3.1
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class App {
    
    public static class Window extends JFrame {

        private JTextField extraPaymentField;
        private JLabel totalLabel;
        private JLabel monthsLabel;
        private JLabel yearsLabel;
        private JLabel floorLabel;
        private JLabel disclaimer;
        private JLabel disclaimer2;
        private DefaultTableModel tableModel;
        // label here

        public Window() {

            // Window setup

            setTitle("Credit Card Payoff Schedule");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            // Top section
            
            JPanel  topPanel = new JPanel();

            topPanel.add(new JLabel("Payment above minimum payment:"));

            extraPaymentField = new JTextField(10);
            topPanel.add(extraPaymentField);
            
            // Button for calculation and reset just in case you mess up the input

            JButton calculateButton = new JButton("Calculate");
            JButton resetButton = new JButton("Reset");

            topPanel.add(calculateButton);
            topPanel.add(resetButton);

            add(topPanel, BorderLayout.NORTH);

            // Table setup for the monthly payment

            String[] columnNames = {"Month", "Minimum Payment","Total Paid", "Interest Payment", "Principle Payment", "Remaining Balance"
    };
           // lable here
            tableModel = new DefaultTableModel(columnNames, 0);
              JTable table = new JTable(tableModel);
            add(new JScrollPane(table), BorderLayout.CENTER);

            // Bottom section to show us the  total paid, months, and years

            JPanel bottomPanel = new JPanel(new GridLayout(3, 1));

            totalLabel = new JLabel("Total Paid: $0.00");
            monthsLabel = new JLabel("Months: 0");
            yearsLabel = new JLabel("Years: 0");
            floorLabel = new JLabel("Payment Floor is $25");
            disclaimer = new JLabel("The payment is based on a percentage of the current balance, this bank is evil");
            disclaimer2 = new JLabel("Some banks do interest only loans, we are one of those banks");

            bottomPanel.add(totalLabel);
            bottomPanel.add(monthsLabel);
            bottomPanel.add(yearsLabel);
            bottomPanel.add(floorLabel);
            bottomPanel.add(disclaimer);
            bottomPanel.add(disclaimer2);
            // label here

            add(bottomPanel, BorderLayout.SOUTH);

            // Buttons
            calculateButton.addActionListener(e -> runSimulation());
            resetButton.addActionListener(e -> reset());
             
             setVisible(true);
    }

    // siumulation

        private void runSimulation() {

            tableModel.setRowCount(0); // Clear existing data
                double extraPayment = 0;
                
            try 
            {
                extraPayment = Double.parseDouble(extraPaymentField.getText());
            } 
            catch (Exception e)
             {
               JOptionPane.showMessageDialog(this, "Please enter a valid number ");
                return;
            }
            cardDetails card = new cardDetails();

            int month = 0;
            double totalPaid = 0;
            

             while ( card.cardBalance >= 0.01)
            {
                  card.payPayment(extraPayment);

                double interest = card.interestPaid;
                double principal = card.principalPaid;
                double payment = interest + principal;

                totalPaid += payment;
                month++;

                tableModel.addRow(new Object[] {
                    month,
                    String.format("$%.2f", payment),
                    String.format("$%.2f", totalPaid),
                    String.format("$%.2f", interest),
                    String.format("$%.2f", principal),
                    String.format("$%.2f", card.cardBalance)
                    // lable here 
                });
            }

           totalLabel.setText(
                    String.format("Total Paid: $%.2f", totalPaid));
                floorLabel.setText("Payment Floor is $25");
                monthsLabel.setText("Months: " + month);
                yearsLabel.setText(
                    String.format("Years: %.2f", month / 12.0));

        }

 private void reset() {

            tableModel.setRowCount(0);

            extraPaymentField.setText("");

            totalLabel.setText("Total Paid: $0.00");
            monthsLabel.setText("Months: 0");
            yearsLabel.setText("Years: 0.00");
        }
    }
    public static void main(String[] args) throws Exception {
        cardDetails chaseVisa = new cardDetails();
        Window display = new Window(); //if not commentted out, pop up opens

        //chaseVisa.payMinimum();
        //chaseVisa.printBalance();
        int temp;
        int temp2;
        int month = 0;
        Scanner scnr = new Scanner(System.in);
        temp = scnr.nextInt();
        if(temp == 1)
        {
            for (int i = 1; i <= 12; i++)
            {
                chaseVisa.payMinimum();
                System.out.println("Month " + i + " calculated");
                chaseVisa.printBalance();
                chaseVisa.printTotalPaid();
                System.out.println("");
            }
        }
        else if (temp == 2){
            while (chaseVisa.cardBalance > 0){
                chaseVisa.payMinimum();
                month += 1;
            }
            chaseVisa.printBalance();
            chaseVisa.printTotalPaid();
            System.out.println("Months taken: " + month);
        }
        else {
            temp2 = scnr.nextInt();
            while (chaseVisa.cardBalance > 0){
                chaseVisa.setPayment(temp2);
                month += 1;
            }
            chaseVisa.printBalance();
            chaseVisa.printTotalPaid();
            System.out.println("Months taken: " + month);
        }
    }
}

    
    


