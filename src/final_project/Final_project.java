package final_project;

import java.sql.*;

/**
 *
 * @author SadC0d3r
 */
public class Final_project {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    
        //      BloodTest 
            BloodTest t = new BloodTest();
            System.out.println(t.GetResult("19", "PatientID"));
//    Test BloodBank
        //    BloodBank b= new BloodBank();
        //    b.DrawBloodBags("A+",3);
        //    b.UpdateBags("A+", 0);
        //    b.AddBloodDonation("Moas", "1", "Male", "alse@gmail.com", "01100531517", 1, "A-", "daas");
        //    Test for patients
        //    Patients pt = new Patients();
        //    pt.Add("patients", "Mosalah",22,"Male", "Cairo","Mosalah.fuck@gmail.com","Tonsillectomy" ,"in");
        //    pt.Search("patients", "1");
        //    pt.update("patients",1,"Age","21");
        //    pt.delete("patients", "19");
        //  Test for  staff
//        Staff st = new Staff();
//            st.Add("Staff","Mosalah",21,"Doctor","Surgery","male","cairo","Mosalah@gmail.com",50000.0);
//            st.Search("Staff","555");
//            st.update("Staff",555, "Age", "21");
//            st.Search("Staff","555");
//            st.delete("Staff", "557");
        //Test For Pharmcy 
        //      Pharmcy Ph = new Pharmcy();
//            Ph.Add("Pharmcy","Augmentin", "Antibiotic", "Birzeit", 100, "20/5/2025");
//            Ph.Add("Pharmcy","Lantus", "Diabetes", " Sanofi-Aventis", 50, "30/8/2023");
//              Ph.SearchByName("Pharmcy", "5162318","Barcode");
//            Ph.SearchByCode("Pharmcy", "5162319");
//            Ph.Update("Pharmcy", 5162318, "Amounts", "100");
//            Ph.delete("Pharmcy", "5162320");
        //Test for dispensing_medicines
//      Ph.Add_invoice("dispensing_medicines","Augmentin", "Antibiotic", "Birzeit", 1, "Mosalah", 1, 5162318, "30/4/2020");
        //      Ph.InvoiceSearch("dispensing_medicines", "1");
//            Ph.EditInvoic("dispensing_medicines", 1, "Date", "30/4/2020");
//                Ph.DeleteInvoic("Pharmcy", "2");
    }
}
