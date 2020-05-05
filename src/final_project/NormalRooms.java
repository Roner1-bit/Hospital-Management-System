
package final_project;



import java.sql.ResultSet;
import java.sql.SQLException;

public class NormalRooms extends DB {

    int roomID;
    int patientID;
    String patientName;
    int roomType;








    public String Search(String table, String column, String column2, int ID) throws SQLException {                                      // This function searches any table a return two specific column in any row.
        String quary = "SELECT * FROM `" + secure_inputs(table) + "` WHERE `" + secure_inputs(column) + "`='" + ID + "'";

        ResultSet set = getStatement().executeQuery(quary);                                                                        //This function will be discussed with Mostafa for further enhancement.

        String result1 = "";
        String result2 = "";
        //result 1 and 2 are actually results of column 1 and 2 previously mentioned in the parameters.

        while (set.next()) {
            result1 = set.getString(column);

            if (column2 != "") {                                                                                  //This is to make the function availabile for the usage of 1 column if required.
                result2 = set.getString(column2);
            }

        }
        return result1 + ":" + result2;

    }






    public NormalRooms() {                                                                                          //A constructor for any purpose other than intializing the patient id completely


    }


    public void SetPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void SetPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void SetroomType(int roomType) {

        this.roomType = roomType;
    }







    public NormalRooms(int id, int roomType) throws SQLException, ClassNotFoundException {              //Enter 1 for special room and 0 for ordinary room.

        connect();

        String[] databaseResults = Search("patients", "IDs", "Names", id).split(":");

        try {
            this.patientID = Integer.parseInt(databaseResults[0]);
            this.patientName = databaseResults[1];
        } catch (Exception e) {
            System.out.println("There has been a problem ,please make sure you have entered a correct patient id");

        }
    }







    //For a special room with 2 beds enter integer 1 for roomType and for ordinary one enter integer 0.

    //The function uses patient name,id and room type already assigned to the object.

    //Room limiter is the expression used to determine if the room is ordinary or not (as if it's number is less than or equal 30 then it's ordinary and more trhan that it's special.


    public void AddRoom() throws SQLException, ClassNotFoundException {


        int numberOfReservedRooms = Integer.parseInt(GetColumn("normalrooms","IDs","PatientID","50"));

        if (numberOfReservedRooms < 46) {
            String roomLimiter;
            if (this.roomType == 0) {
                roomLimiter = "<=";
            } else if (this.roomType == 1) {
                roomLimiter = ">";
            } else {
                System.out.println("Enter either 0 or 1 for room type");
                return;
            }

            String quary = "SELECT `IDs` FROM `normalrooms` WHERE `IDs`" + roomLimiter + "30 ORDER BY RoomStatus DESC ,IDs ASC LIMIT 1";

            ResultSet set = getStatement().executeQuery(quary);

            while (set.next()) {
                try {
                    this.roomID = set.getInt(1);
                }catch (Exception e){
                    System.out.println("Rooms of this type are all reserved");                //Basically this exception is for that if this type of rooms is full.
                }
            }

            update("normalrooms", String.valueOf(this.roomID), "PatientName", this.patientName,"IDs");         //This addes patient's name.
            update("normalrooms", String.valueOf(this.roomID), "RoomStatus", "1","IDs");            //This addes status busy.
            update("normalrooms", String.valueOf(this.roomID), "PatientID", String.valueOf(this.patientID),"IDs");   //This addes patient's id                          //Update statements are redundant and will be checked for improvement in improvement phase.
            update("normalrooms", "50", "PatientID", String.valueOf(numberOfReservedRooms+1),"IDs");

        }
        else {

            System.out.println("All rooms both ordinary and special are full");

        }

    }




//function Overloading.




    public void AddRoom(int roomType,int patientID,String patientName ) throws SQLException, ClassNotFoundException {



        int numberOfReservedRooms = Integer.parseInt(GetColumn("normalrooms","IDs","PatientID","50"));

        int roomID=0;

        if (numberOfReservedRooms < 46) {
            String roomLimiter;
            if (roomType == 0) {
                roomLimiter = "<=";
            } else if (roomType == 1) {
                roomLimiter = ">";
            } else {
                System.out.println("Enter either 0 or 1 for room type");
                return;
            }

            String quary = "SELECT `IDs` FROM `normalrooms` WHERE `IDs`" + roomLimiter + "30 ORDER BY RoomStatus DESC ,IDs ASC LIMIT 1";

            ResultSet set = getStatement().executeQuery(quary);

            while (set.next()) {
                try {
                    roomID = set.getInt(1);
                }catch (Exception e){
                    System.out.println("Rooms of this type are all reserved");                //Basically this exception is for that if this type of rooms is full.
                }
            }

            update("normalrooms", String.valueOf(roomID), "PatientName", patientName,"IDs");         //This addes patient's name.
            update("normalrooms", String.valueOf(roomID), "RoomStatus", "1","IDs");            //This addes status busy.
            update("normalrooms", String.valueOf(roomID), "PatientID", String.valueOf(patientID),"IDs");   //This addes patient's id                          //Update statements are redundant and will be checked for improvement in improvement phase.
            update("normalrooms", "50", "PatientID", String.valueOf(numberOfReservedRooms+1),"IDs");

        }
        else {

            System.out.println("All rooms both ordinary and special are full");

        }

    }





    public String Edit_or_Delete(int roomID,int patientID,String patientName,int determiner) throws SQLException, ClassNotFoundException {                             //Enter in determiner place 1 for delete and 0 for edit.
                                                                                                                                                                     //Incase of deleting,don't bother to enter any strings for patient id or patient name just enter the room number.

        int numberOfReservedRooms = Integer.parseInt(GetColumn("normalrooms","IDs","PatientID","50"));   //This is to get the counter of rooms stored in the last row of the database in the patientID's column

        if (determiner==0){
            update("normalrooms", String.valueOf(roomID), "PatientName", patientName,"IDs");         //This addes patient's name.
            update("normalrooms", String.valueOf(roomID), "PatientID", String.valueOf(patientID),"IDs");   //This addes patient's id

        }
        else if (determiner==1){

            if (numberOfReservedRooms>0) {


                int roomStatus=Integer.parseInt(GetColumn("normalrooms","IDs","RoomStatus",String.valueOf(roomID)));

                if(roomStatus==1){

                    update("normalrooms", String.valueOf(roomID), "PatientName", "", "IDs");         //This deletes patient's name.
                    update("normalrooms", String.valueOf(roomID), "PatientID", "0", "IDs");            //This addes patient's id
                    update("normalrooms", String.valueOf(roomID), "RoomStatus", "0", "IDs");      //This addes room status to be free.
                    update("normalrooms", "50", "PatientID", String.valueOf(numberOfReservedRooms-1),"IDs");

                    return "Room was sucessfully deleted";
                }
                else{
                    return "Room is already empty";

                }

            }
            else {
                return "All rooms are empty";
            }
        }

        else {
            return "Enter a correct determiner";
        }
        return "";
    }




    public String RoomChcker(int roomID) throws SQLException, ClassNotFoundException {                 //Takes room id and prints all rooms properties

        if (roomID>49||roomID<5){
            return "Enter a correct room number";
        }


        int roomStatus;

        String roomType;

        if (roomID>30){
            roomType="special";
        }

        else{
            roomType="ordinary";
        }


        roomStatus=Integer.parseInt(GetColumn("normalrooms","IDs","RoomStatus",String.valueOf(roomID)));


        if (roomStatus==1) {                                                                                       //This checks if the room had any patients in the first place.
            String patientName = GetColumn("normalrooms", "IDs", "PatientName", String.valueOf(roomID));
            int patientID = Integer.parseInt(GetColumn("normalrooms", "IDs", "PatientID", String.valueOf(roomID)));

            return "The room has patient "+patientName+" of id "+patientID+"and it's type is "+roomType;
        }
        else {

            return "This room is totally free.";
        }




    }






}


















/*
Draft of my quaries


SELECT `Room_ID` FROM `normalrooms` ORDER BY Room_Status DESC

UPDATE `normalrooms` SET `Room_Status`="free" WHERE Room_ID= any id (for deleting)

SELECT `Room_ID` FROM `normalrooms` ORDER BY Room_Status DESC ,Room_ID ASC  This one is to get the first row of free rooms.

SELECT `Room_ID` FROM `normalrooms` WHERE Room_ID <=20 ORDER BY Room_Status DESC ,Room_ID ASC --> To get the first 20 free rooms less than id of 20 (needless to say:or any number).

SELECT `Room_ID` FROM `normalrooms` WHERE Room_ID <=20 ORDER BY Room_Status DESC ,Room_ID ASC LIMIT 1 -->To get the first free room using SQL'S.


 */





