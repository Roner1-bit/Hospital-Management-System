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
public class Pharmcy extends DB {

    public void Add(String tabel, String Names, String Category, String Company, int Amount,
            String Validity) throws ClassNotFoundException, SQLException {

        tabel = secure_inputs(tabel);
        Names = secure_inputs(Names);
        Category = secure_inputs(Category);
        Company = secure_inputs(Company);
        String Amounts = secure_inputs(Integer.toString(Amount));
        Validity = secure_inputs(Validity);

        connect();
        String qry = "INSERT INTO `" + tabel + "` (`Drug_Name`,`Category`,`Company`,`Amounts`,`Validity`) "
                + "VALUES ('" + Names + "','" + Category + "','" + Company + "','" + Amounts + "','" + Validity + "')";
        getStatement().executeUpdate(qry);
    }

    public void printDrug(String table, String SearchBy, String Code) throws ClassNotFoundException, SQLException {
        ResultSet res = Select(table, SearchBy, Code);
        while (res.next()) {
            System.out.println("Barcode: " + res.getString("Barcode") + "  Drug_Name: " + res.getString("Drug_Name")
                    + "  Category: " + res.getString("Category")
                    + " Company: " + res.getString("Company") + " Amounts: " + res.getString("Amounts") + " Validity: " + res.getString("Validity"));
        }
    }

    public void UpdateAmounts(String name) throws ClassNotFoundException, SQLException {
        int c = 0;
        String amount = GetColumn("dispensing_medicines", "Drug_Name", "Amount", name);
        c = Integer.parseInt(amount);
        int x = 0;

        String amountPH = GetColumn("pharmcy", "Drug_Name", "Amounts", name);
        x = Integer.parseInt(amountPH);
        String newData = String.valueOf(x - c);
        update("pharmcy", name, "Amounts", newData, "Drug_Name");

        System.out.println("Done!");
    }

    public void Add_invoice(String tabel, String Drug_Name, String Category, String Company, int Amount,
            String Patients_Names, int ID, int Code, String Date) throws ClassNotFoundException, SQLException {

        tabel = secure_inputs(tabel);
        Drug_Name = secure_inputs(Drug_Name);
        Category = secure_inputs(Category);
        Company = secure_inputs(Company);
        String Amounts = secure_inputs(Integer.toString(Amount));
        Patients_Names = secure_inputs(Patients_Names);
        String Patients_ID = secure_inputs(Integer.toString(ID));
        String Drug_Code = secure_inputs(Integer.toString(Code));
        Date = secure_inputs(Date);

        connect();
        String qry = "INSERT INTO `" + tabel + "` (`Drug_Name`,`Category`,`Company`,`Amount`,`Patients_Names`,"
                + "`Patients_ID`,`Drug_Code`,`Date`) "
                + "VALUES ('" + Drug_Name + "','" + Category + "','" + Company + "','" + Amounts + "','" + Patients_Names + "','" + Patients_ID + "','"
                + Drug_Code + "','" + Date + "')";
        getStatement().executeUpdate(qry);

        UpdateAmounts(Drug_Name);

    }

    public void printInvoice(String tabel, String invoice_number) throws ClassNotFoundException, SQLException {
        ResultSet res = Select("dispensing_medicines", "invoice_number", invoice_number);
        while (res.next()) {
            System.out.println("invoice number: " + res.getString("invoice_number") + "  Drug Name: " + res.getString("Drug_Name")
                    + "  Category: " + res.getString("Category")
                    + " Company: " + res.getString("Company") + " Amounts: " + res.getString("Amount") + " Patients Names: " + res.getString("Patients_Names")
                    + " Patients ID: " + res.getString("Patients_ID") + " Drug Code : " + res.getString("Drug_Code")
                    + " Date: " + res.getString("Date"));
        }
    }

    public void EditInvoic(String invoice_number, String target, String new_bal) throws ClassNotFoundException, SQLException {
        target = secure_inputs(target);
        new_bal = secure_inputs(new_bal);
        update("dispensing_medicines", invoice_number, target, new_bal, "invoice_number");

    }

}
