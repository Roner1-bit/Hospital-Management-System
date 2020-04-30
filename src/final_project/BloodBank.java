/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alset
 */
public class BloodBank {

    DB db = new DB();

    void DrawBloodBags(String BloodType, double Bags) throws SQLException, ClassNotFoundException {
       //it's just a negative update LoL :-)
        UpdateBags(BloodType, -Bags);
    }

    void AddBloodDonation(String Name, String Age, String Gender, String Email, String Number, double Litres, String BloodType, String Address) throws ClassNotFoundException, SQLException {
        //Validate all The Inputs From SQL Errors
        String name = db.secure_inputs(Name);
        String age = db.secure_inputs(Age);
        String gender = db.secure_inputs(Gender);
        String email = db.secure_inputs(Email);
        String number = db.secure_inputs(Number);
        double Bags = Litres / 2;
        String bloodType = db.secure_inputs(BloodType);
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
            db.connect();
            String qry = "INSERT INTO `bloodbank` (`Name`,`Age`,`Gender`,`Email`,`Date`,`Time`,`Litres`,`Bag`,`BloodType`,`Number`,`Address`) VALUES ('"
                    + name + "','" + age + "','" + gender + "','" + email + "','" + Date + "','" + Time + "','" + Litres + "','" + Bags
                    + "','" + bloodType + "','" + number + "','" + Address + "')";
            db.getStatement().executeUpdate(qry);
           //checking if the bloodtype exists Or not
            ResultSet res = Select("bloodbags", "bloodType", BloodType);
            //if exsits we add the bags into it 
            if (res.first()) {
                UpdateBags(bloodType, Bags);
            } else {
                //if not insert the new blood type
                String quary = "INSERT INTO `bloodbags` ( `BloodType`,`Count`) VALUES ('" + bloodType + "','" + Bags
                        + "')";
                db.getStatement().executeUpdate(quary);
            }
        }
    }

    private boolean BloodTypeChecker(String BloodType) {

        String[] bloodTypes = {"A+", "A-", "O+", "O-", "B+", "B-", "AB+", "AB-"};
        for (int i = 0; i < bloodTypes.length; i++) {
            if (bloodTypes[i].equals(BloodType)) {
                return true;
            }
        }
        return false;
    }

    private boolean NumberChecker(String number) {
        try {
            int Number = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (number.matches("\\d{11}")) {
            return true;
        } else {
            return false;
        }

    }

    boolean AgeChecker(String Age) {
        int age;
        try {
            age = Integer.parseInt(Age);

        } catch (NumberFormatException nfe) {
            return false;
        }
        return Age.length() <= 3 && age <= 150 && age > 0;
    }

    private boolean GenderChecker(String Gender) {
        if (Gender.equals("Male") || Gender.equals("Female")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean EmailChecker(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return Email.matches(regex);
    }

    void UpdateBags(String bloodType, double Bags) throws ClassNotFoundException, SQLException {
        //check if the blood type is Right
        if (BloodTypeChecker(bloodType)) {
            //getting the old value
            ResultSet result = Select("bloodbags", "bloodType", bloodType);
            double bagsCount = 0;
            while (result.next()) {
                bagsCount = result.getFloat("Count");
            }
            db.connect();
            //adding the old value into the new one
            bagsCount += Bags;
            String qry = "UPDATE `bloodbags` SET `Count`= '" + bagsCount + "' WHERE `bloodType`='" + bloodType + "'";
            db.getStatement().executeUpdate(qry);
        } else {
            System.out.println("Blood Type Error");
        }
    }
    // المثود يا صلاح يا علق لو نقلتها اعمل انهرتانس من داتا بيز وشيل الاوبجيكتس 
    ResultSet Select(String Table, String Location, String Data) throws ClassNotFoundException, SQLException {
        db.connect();
        String qry = "SELECT * FROM `" + db.secure_inputs(Table) + "` WHERE `" + Location + "`='" + db.secure_inputs(Data) + "'";
        ResultSet result = db.getStatement().executeQuery(qry);
        return result;
    }

}
