
package final_project;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


//No patient id should ever be zero!!   NOTE for salah

public class SurgeryRooms extends NormalRooms {
    //Patient ID are default set to value of 0 to make it easier to handle busy or non-busy rooms

    //No parameters were used as it might be useless in such class.


    private String[] columnNames = {"IDs", "SurgeryName", "PatientName", "PatientID", "NumberOfMedicalStaff", "DateAndTime", "DoctorsName"};


    public String AddRoom(String surgeryName, String patientName, int patientID, int numOfStaff, String doctorName) throws SQLException, ClassNotFoundException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String dateAndTime=dtf.format(now);

        String[] dataAdded = {surgeryName, patientName, String.valueOf(patientID),String.valueOf(numOfStaff), dateAndTime, doctorName};

        int roomID = 0;

        int numberOfReservedRooms = Integer.parseInt(GetColumn("surgeryrooms", "IDs", "PatientID", "72"));


        if (numberOfReservedRooms < 21) {

            String quary = "SELECT `IDs` FROM `surgeryrooms` ORDER BY `PatientID` ASC ,IDs ASC LIMIT 1";    //"SELECT `IDs` FROM `surgeryrooms` WHERE `PatientID`=0 ORDER BY PatientID ASC LIMIT 1"

            ResultSet set = getStatement().executeQuery(quary);

            while (set.next()) {
                try {
                    roomID = set.getInt(1);
                } catch (Exception e) {
                    return "There is an error please check the table surgeryrooms";                //This exception is just for the worest cases and can be removed but it's left for further error handling.

                }
            }

            //loop was made to add all given parameters to the database.

            for (int i = 1; i < dataAdded.length; i++) {
                update("surgeryrooms", String.valueOf(roomID), columnNames[i], dataAdded[i - 1], "IDs");

            }
            update("surgeryrooms", "72", "PatientID", String.valueOf(numberOfReservedRooms+1),"IDs");

        } else {
            return "All rooms are full";
        }

       return "Executed Succefully";
    }
    
    
    
    
    
    
    
    
    

    public String Edit_Or_Delete(int roomID,String surgeryName, String patientName, int patientID, int numOfStaff,String dateAndTime ,String doctorName,int determiner) throws SQLException, ClassNotFoundException {       //Enter 1 for determiner to delete and 0 to edit.
                                                                                                                                                          //if you want to delete just enter 1 and don't bother with the rest of the parameters as it will be ignored.

        if (determiner==0){

            String[] dataAdded = {surgeryName, patientName, String.valueOf(patientID),String.valueOf(numOfStaff), dateAndTime, doctorName};


            for (int i = 1; i < dataAdded.length; i++) {
                update("surgeryrooms", String.valueOf(roomID), columnNames[i], dataAdded[i - 1], "IDs");

            }
            
            return "Executed succesfully";
        }
        else if(determiner==1){

            int numberOfReservedRooms = Integer.parseInt(GetColumn("surgeryrooms", "IDs", "PatientID", "72"));
            
            

            if (numberOfReservedRooms>0){
                int roomstatus= Integer.parseInt(GetColumn("surgeryrooms", "IDs", "PatientID", String.valueOf(roomID)));
                if (roomstatus==0){
                    return "Room is already empty";
                }
                else {

                    for (int i = 1; i < columnNames.length-1; i++) {
                        update("surgeryrooms", String.valueOf(roomID), columnNames[i], "0", "IDs");

                    }
                    
                    update("surgeryrooms", "72", "PatientID", String.valueOf(numberOfReservedRooms-1),"IDs");
                    
                    return "Executed successfully";
                    
                }
                
            }
            else {
                return "All surgery rooms are empty";
            }

        }


return "";
    }
    
    
    
    
    public String RoomChecker(int roomID) throws SQLException, ClassNotFoundException {

        if (roomID>71||roomID<51){
            return "Please enter a correct surgery room number";
        }
        int roomstatus= Integer.parseInt(GetColumn("surgeryrooms", "IDs", "PatientID", String.valueOf(roomID)));

        if (roomstatus==0){
            return "Room is totally empty";
        }
        else {
            String roomInfo="";
            for (int i = 1;i<columnNames.length;i++){

                roomInfo=roomInfo+GetColumn("surgeryrooms", "IDs", columnNames[i],String.valueOf(roomID));
                
                if(i<columnNames.length-1){
                roomInfo=roomInfo+":";
                }

            }
            return roomInfo;

        }



    }





    //alter table yourTableName auto_increment=startingNumber;


//INSERT INTO `surgeryrooms` (`IDs`, `SurgeryName`, `PatientName`, `PatientID`, `NumberOfMedicalStaff`, `DateAndTime`, `DoctorsName`) VALUES (NULL, ' ', NULL, '0', NULL, NULL, NULL);


}