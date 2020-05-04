/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Patients extends DB {

    public void Add(String tabel, String Names, String Age, String Sex,
            String Address, String Email, String healthr, String Status) throws ClassNotFoundException, SQLException {

        tabel = secure_inputs(tabel);
        Names = secure_inputs(Names);
        Age = secure_inputs(Age);
        Sex = secure_inputs(Sex);
        Address = secure_inputs(Address);
        Email = secure_inputs(Email);
        healthr = secure_inputs(healthr);
        Status = secure_inputs(Status);

        connect();
        String qry = "INSERT INTO `" + tabel + "` (`Names`,`Age`,`Sex`,`Address`,`Email`,`Health_Record`,`Status`) VALUES ('" + Names + "','" + Age + "','" + Sex + "','" + Address + "','" + Email + "','" + healthr + "','" + Status + "')";
        getStatement().executeUpdate(qry);
    }

    public void print(String tabel, String id) throws ClassNotFoundException, SQLException {
        ResultSet res = Select("patients", "IDs", id);
        while (res.next()) {
            System.out.println("id: " + res.getInt("IDs") + "  Name: " + res.getString("Names")
                    + " Age: " + res.getInt("Age") + " Sex: " + res.getString("Sex") + " Address: " + res.getString("Address")
                    + "  Health Record: " + res.getString("Health_Record") + "   Status: " + res.getString("Status"));
        }
      
    }

    String HealthRecords(String id) throws ClassNotFoundException, SQLException {
        String HealthRecords = "";
        HealthRecords = GetColumn("patients", "IDs", "Health_Record", id);
        return HealthRecords;
    }
}
