
package final_project;


import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Clinics extends DB {


    
    String[] clinics = {"Eye Clinic", "Clinic 2", "Clinic 3", "Clinic 4", "Clinic 5", "Clinic 6", "Clinic 7", "Clinic 8"};


    String[] columnNames = {"ClinicName", "DoctorID", "NurseName", "PatientName", "PatientID", "HealthRecord", "TypeOfVisit", "DateAndTime", "DoctorName"};


//INSERT INTO table(column1, column2,...)
//VALUES (value1, value2,...);


    //I expected the ids to be valid.

    public String AddClinic(int clinicName, int doctorID, String nurseName, int patientID, String typeOfVisit) throws SQLException, ClassNotFoundException {                                                           //each clinic has a unique number.

        if (clinicName > 8) {

            return "Enter a coorect clinic number.";

        }

        String patientName = GetColumn("patients", "IDs", "Names", String.valueOf(patientID));
        String healthRecord = GetColumn("patients", "IDs", "Health_Record", String.valueOf(patientID));
        String doctorName = GetColumn("staff", "IDs", "Names", String.valueOf(doctorID));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String dateAndTime = dtf.format(now);

        String quary = "INSERT INTO clinics(ClinicName,DoctorID,NurseName,PatientName,PatientID,HealthRecord,TypeOfVisit,DateAndTime,DoctorName) VALUES ('" + clinics[clinicName] + "','" + String.valueOf(doctorID) + "','" + nurseName + "','" + patientName + "','" + String.valueOf(patientID) + "','" + healthRecord + "','" + typeOfVisit + "','" + dateAndTime + "','" + doctorName + "');";

        getStatement().executeUpdate(quary);

        return "Executed successfully";
    }


    //deletes certain record by patient id.

    public String DeleteRecord(int patientID) throws SQLException, ClassNotFoundException {

        delete("clinics", "PatientID", String.valueOf(patientID));

        return "deleted successfully";

    }


    //This function returns all visit info.
    public String GetVisitInfo(int patientID) throws SQLException, ClassNotFoundException {
        String roomInfo = "";
        for (int i = 0; i < columnNames.length; i++) {

            roomInfo = roomInfo + GetColumn("clinics", "PatientID", columnNames[i], String.valueOf(patientID));

            if (i < columnNames.length - 1) {
                roomInfo = roomInfo + ":";
            }


        }
        return roomInfo;

    }
}



   
   


