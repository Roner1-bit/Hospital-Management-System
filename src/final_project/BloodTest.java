package final_project;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alset
 */
public class BloodTest extends Patients {

    void AddBloodTest(String Id, String DRid, String TestResult) throws ClassNotFoundException, SQLException {
        // ResultSet res=Select1("patients",,"IDs", Id);
        connect();
        String PatientID = null, Name = null, Age = null, Sex = null, Address = null, Email = null, Status = null;
        ResultSet result = Select("patients", "IDs", Id);
        while (result.next()) {
            PatientID = result.getString("IDs");
            System.out.println(PatientID);
            Name = result.getString("Names");
            Age = result.getString("Age");
            Sex = result.getString("Sex");
            Address = result.getString("Address");
            Email = result.getString("Email");
            Status = result.getString("Status");
        }
        if (PatientID != null) {
            String qry = "INSERT INTO `bloodtests` (`PatientID`,`Name`,`Age`,`Sex`,`Address`,`Email`,`Status`,`DRID`,`result`) VALUES "
                    + "('" + PatientID + "','" + Name + "','" + Age + "','" + Sex + "','" + Address + "','" + Email + "','" + Status + "','" + DRid + "','" + TestResult + "')";
            getStatement().executeUpdate(qry);
        } else {
            System.out.println("Not Found");
        }
        String HealthRecord = HealthRecords(Id);
        HealthRecord += GetLastID("bloodtests", "ID") + " : " + TestResult;
        update("patients", Id, "Health_Record", HealthRecord, "IDs");
    }

    String GetResult(String Data, String SearchBy) throws SQLException, ClassNotFoundException {
        
        String TestResult = GetColumn("bloodtests", SearchBy,"Result", Data);
        System.out.println(TestResult);
        return TestResult;
    }

}
