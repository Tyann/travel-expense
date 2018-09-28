/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelexpenses;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class TravelExpenses extends JFrame{

    //info for labels
    private JLabel daysOnTrip;
    private JLabel carRental;
    private JLabel airfair;
    private JLabel parkingFees;
    private JLabel taxiFees;
    private JLabel milesDriven;
    private JLabel conReg;
    private JLabel lodgingNightCharges;

    //reference panel obs
    private JPanel travelInfo;
    private JPanel buttonP;

    //info from fields of texts
    private JTextField daysOnTripText;
    private JTextField carRentalText;
    private JTextField airfairText;
    private JTextField parkingFeesText;
    private JTextField taxiFeesText;
    private JTextField milesDrivenText;
    private JTextField conRegText;
    private JTextField lodgingNightChargesText;

    //buttons that will be used to function 
    private JButton calculate; //will be used to calculate informaiton that the user enters when clicked
    private JButton reset; // will be used to reset the fields as needed when clicked

    //constants as specified 
    private double mealsCost = 37.00; //per day for meals
    private double parkingFeesAmount = 10.00; // up to 10 per day
    private double taxiFeesAmount = 20.00; // up to 20 per day
    private double lodgingChargesAmount = 95.00; // up to 95 a day
    private double mileAmount = 0.27; //per mile driven

    /**
     * Constructor 
     * @param args
     */

    public TravelExpenses(){
        //JFrame title called
        super("Travel Expenses");

        //center of desktop placement
        setLocationRelativeTo(null);

        //Close button will do this..
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //border layout mgr cp
        setLayout(new BorderLayout());

        //TravelInfo&Buttons
        buildTravelInfoPanel();
        buildButton();

        // get panels to frame content
        add(travelInfo, BorderLayout.CENTER);
        add(buttonP, BorderLayout.SOUTH);

        //window content display
        pack();
        setVisible(true);
    }
    private void buildTravelInfoPanel(){
        //field labels made
        daysOnTrip = new JLabel("Number of days for trip.");
        airfair = new JLabel("Airfair Amount: ");
        carRental = new JLabel ("Car Rental Cost Amount: ");
        milesDriven = new JLabel ("Mile Driven: ");
        parkingFees = new JLabel ("Parking Fees: ");
        taxiFees = new JLabel ("Taxi Fees: ");
        conReg = new JLabel ("Conference Registration Cost: ");
        lodgingNightCharges =  new JLabel ("Lodging Charges per Night: ");

        //text boxes for input from user
        daysOnTripText = new JTextField(3);
        carRentalText = new JTextField(8);
        airfairText = new JTextField(8);
        parkingFeesText = new JTextField(6);
        taxiFeesText = new JTextField(6);
        milesDrivenText = new JTextField(4);
        conRegText = new JTextField(8);
        lodgingNightChargesText = new JTextField(6);

        //panel for labels/text
        travelInfo = new JPanel();


        //Grid for 10 r and 2 c
        travelInfo.setLayout(new GridLayout(10,2));



        //labels and text for panel made
        travelInfo.add(daysOnTrip);
        travelInfo.add(daysOnTripText);
        travelInfo.add(airfair);
        travelInfo.add(airfairText);
        travelInfo.add(carRental);
        travelInfo.add(carRentalText);
        travelInfo.add(milesDriven);
        travelInfo.add(milesDrivenText);
        travelInfo.add(parkingFees);
        travelInfo.add(parkingFeesText);
        travelInfo.add(taxiFees);
        travelInfo.add(taxiFeesText);
        travelInfo.add(conReg);
        travelInfo.add(conRegText);
        travelInfo.add(lodgingNightCharges);
        travelInfo.add(lodgingNightChargesText);


    }

    /**
     * buildButton is method that adds reset and calc buttons to main panel
     * @param args
     */

    private void buildButton(){
        //caclulation button

        calculate = new JButton("Calculate Reimbursment");

        //event listiner for calculation
        calculate.addActionListener(new CalculateListener());

        //reset button
         reset = new JButton("Reset");

        //event listiner for reset
        reset.addActionListener(new ResetListener());

        //button panels
        buttonP = new JPanel();

        //buttons 
        buttonP.add(reset, BorderLayout.WEST);
        buttonP.add(calculate, BorderLayout.CENTER);





    }

    /**
     * CalculateListener will  do event for calculate button
     * @param args
     */

    private class CalculateListener implements ActionListener{
        //variables
        String input;
        int days;
        double air;
        double miles;
        double carRental;
        double conReg;
        double lodging;
        double parking;
        double meals;
        double taxi;

        public void actionPerformed(ActionEvent e){
            //variables
            double actualExpenses;
            double milesExpenses;
            double allowed;
            double exAirfair;
            double exCarRen;
            double exParking;
            double exTaxi;
            double exLodge;
            double overTotal;
            double savings;
            double reimb;

            //dec format implement
            DecimalFormat money = new DecimalFormat("$#,###.00");
        }
        //get info from text fields
        private void getInfo(){
            days = Integer.parseInt(daysOnTripText.getText());
            air = Double.parseDouble(airfairText.getText());
            carRental = Double.parseDouble(carRentalText.getText());
            miles = Double.parseDouble(milesDrivenText.getText());
            parking = Double.parseDouble(parkingFeesText.getText());
            taxi = Double.parseDouble(parkingFeesText.getText());
            conReg = Double.parseDouble(conRegText.getText());
            lodging = Double.parseDouble(lodgingNightChargesText.getText());

        }
        //figure out expenses
        private void calcActualExpenses(double actualExpenses, double milesExpenses){
            actualExpenses = air + carRental + parking + taxi + conReg + lodging;
            milesExpenses = miles * mileAmount;
            actualExpenses = actualExpenses + milesExpenses;


            //display total
            JOptionPane.showMessageDialog(null, "Total expenses: " + "\n"+
                    "Allowables expenses: " + "\n" +
                    "\n" + "Amount to be paid back: ");


        }


    }

    //this handles reset button
    private class ResetListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            daysOnTripText.setText("");
            airfairText.setText("");
            carRentalText.setText("");
            milesDrivenText.setText("");
            parkingFeesText.setText("");
            taxiFeesText.setText("");
            conRegText.setText("");
            lodgingNightChargesText.setText("");
        }
    }


    public static void main(String[] args) {
        new TravelExpenses();
    }

}