/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;

/**
 *
 * @author alset
 */
public class BloodBank extends DB {

    void DrawBloodBags(String BloodType, double Bags) throws SQLException, ClassNotFoundException {
        //it's just a negative update LoL :-)
        UpdateBags(BloodType, -Bags);
    }

    void AddBloodDonation(String Name, String Age, String Gender, String Email, String Number, double Litres, String BloodType, String Address) throws ClassNotFoundException, SQLException {
        //Validate all The Inputs From SQL Errors
        String name = secure_inputs(Name);
        String age = secure_inputs(Age);
        String gender = secure_inputs(Gender);
        String email = secure_inputs(Email);
        String number = secure_inputs(Number);
        double Bags = Litres / 2;
        String bloodType = secure_inputs(BloodType);
        bloodType = bloodType.toUpperCase();
        //Checking all The inputs And print The Errors
        if (!AgeChecker(age)) {
            System.out.println("Age Error");
        } else if (!GenderChecker(gender)) {
            System.out.println("Gender Error");
        } else if (!EmailChecker(email)) {
            System.out.println("Email Error");
        } else if (!NumberChecker(number)) {
            System.out.println("Number Error");
        } else if (!BloodTypeChecker(bloodType)) {
            System.out.println("Blood Type Error");
        } else if (Litres <= 0) {
            System.out.println("Litres Error");
        } else {
            //inserting a new record into the database
            LocalDate Date = LocalDate.now();
            LocalTime Time = LocalTime.now();
            connect();
            String qry = "INSERT INTO `bloodbank` (`Name`,`Age`,`Gender`,`Email`,`Date`,`Time`,`Litres`,`Bag`,`BloodType`,`Number`,`Address`) VALUES ('"
                    + name + "','" + age + "','" + gender + "','" + email + "','" + Date + "','" + Time + "','" + Litres + "','" + Bags
                    + "','" + bloodType + "','" + number + "','" + Address + "')";
            getStatement().executeUpdate(qry);
            //checking if the bloodtype exists Or not
            ResultSet res = Select("bloodbags", "bloodType", BloodType);
            //if exsits we add the bags into it 
            if (res.first()) {
                UpdateBags(bloodType, Bags);
            } else {
                //if not insert the new blood type
                String quary = "INSERT INTO `bloodbags` ( `BloodType`,`Count`) VALUES ('" + bloodType + "','" + Bags
                        + "')";
                getStatement().executeUpdate(quary);
            }
        }
    }

    protected boolean BloodTypeChecker(String BloodType) {

        String[] bloodTypes = {"A+", "A-", "O+", "O-", "B+", "B-", "AB+", "AB-"};
        for (int i = 0; i < bloodTypes.length; i++) {
            if (bloodTypes[i].equals(BloodType)) {
                return true;
            }
        }
        return false;
    }

    void UpdateBags(String bloodType, double Bags) throws ClassNotFoundException, SQLException {
        //check if the blood type is Right
        if (BloodTypeChecker(bloodType)) {
            //getting the old value
            String amount = GetColumn("bloodbags", "bloodType", "Count", bloodType);
            double bagsCount = 0;
            bagsCount = Double.parseDouble(amount);

            //adding the old value into the new one
            bagsCount += Bags;
            update("bloodbags", bloodType, "Count", String.valueOf(bagsCount), "bloodType");

        } else {
            System.out.println("Blood Type Error");
        }
    }

}
