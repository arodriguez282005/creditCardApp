/*
    Program Name: creditCardApp
    Program Date: 5/27/26
    Developer Names: Alejandro Rodriguez, Natalia Jackson
    Program Version: 2.1
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
        private JLabel totalLabel, monthsLabel, yearsLabel;
        private DefaultTableModel tableModel;
        public Window() {

            // Window setup

            setTitle("Credit Card Payoff Schedule");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            // Top section
            
            JPanel  topPanel = new JPanel();
            topPanel.add(new JLabel("Enter  Monthly Payment:"));
            extraPaymentField = new JTextField(10);
            topPanel.add(extraPaymentField);
            
            // Button for calculation and reset just in case you mess up the input

            JButton calculateButton = new JButton("Calculate");
            JButton resetButton = new JButton("Reset");
            topPanel.add(calculateButton);
            topPanel.add(resetButton);
            add(topPanel, BorderLayout.NORTH);

            // Table setup for the monthly payment

            String[] columnNames = {"Month", "Payment", "Interest", "PrincipAmt", "Remaining Balance"};
            tableModel = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(tableModel);
            add(new JScrollPane(table), BorderLayout.CENTER);

            // Bottom section to show us the  total paid, months, and years

            JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
            totalLabel = new JLabel("Total Paid: $0.00");
            monthsLabel = new JLabel("Months: 0");
            yearsLabel = new JLabel("Years: 0");
            bottomPanel.add(totalLabel);
            bottomPanel.add(monthsLabel);
            bottomPanel.add(yearsLabel);
            add(bottomPanel, BorderLayout.SOUTH);

            Object chaseVisa;
            // Buttons
            calculateButton.addActionListener(e -> runSimulation(60000,0.018,0.02));
            resetButton.addActionListener(e -> reset());
             setVisible(true);
    }

    // siumulation

        private void runSimulation(int par, double par1, double par2) {
            model.setRows(0); // Clear existing data
            //chaseVisa.principleAmt();
            //chaseVisa
            // CardDetails card =  new cardDetails(/*6000,0.18,0.02*/);
            double extraPayment = 0.0;
            try {
                extraPayment = Double.parseDouble(extraPaymentField.getText());
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "Please enter a valid number ");
                return;
            }
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        private void reset() {
            model.setRows(0);
    extraPaymentField.setText("0");
    totalLabel.setText("Total Paid: $0.00");
    monthsLabel.setText("Months: 0");
    yearsLabel.setText("Years: 0.00");
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        

    
    }
    public static void main(String[] args) throws Exception {
        cardDetails chaseVisa = new cardDetails();
        Window display = new Window(); //if not commentted out, pop up opens

        //chaseVisa.payMinimum();
        //chaseVisa.printBalance();
        int temp;
        int month = 0;
        Scanner scnr = new Scanner(System.in);
        temp = scnr.nextInt();
        if(temp == 1){
            for (int i = 1; i <= 12; i++)
            {
                chaseVisa.payMinimum();
                System.out.println("Month " + i + " calculated");
                chaseVisa.printBalance();
                chaseVisa.printTotalPaid();
                System.out.println("");
            }
        }
        else {
            while (chaseVisa.cardBalance > 0){
                chaseVisa.payMinimum();
                month += 1;
            }
            chaseVisa.printBalance();
            System.out.println("Months taken: " + month);
        }
    }

    private static class model {

        public model() {
        }

       

        public static void setRows(int i) {
            throw new UnsupportedOperationException("Unimplemented method 'setRows'");
        }
    }
    
}

