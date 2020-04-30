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
public class Pharmcy extends DB{

  
      public void Add(String tabel, String Names, String Category, String Company , int Amount, 
         String Validity) throws ClassNotFoundException, SQLException{
        
        tabel = secure_inputs(tabel);
        Names = secure_inputs(Names);
        Category = secure_inputs(Category);
        Company = secure_inputs(Company);
        String Amounts = secure_inputs(Integer.toString(Amount));
        Validity = secure_inputs(Validity);
      


        connect();
        String qry = "INSERT INTO `"+tabel+"` (`Drug_Name`,`Category`,`Company`,`Amounts`,`Validity`) "
           + "VALUES ('"+Names+"','"+Category+"','"+Company+"','"+Amounts+"','"+Validity+"')";
        getStatement().executeUpdate(qry);
    }
    
    
       public void Update(String tabel, int Barcode,  String target, String new_bal) throws ClassNotFoundException, SQLException{

        tabel = secure_inputs(tabel);
        target =  secure_inputs(target);
        new_bal = secure_inputs(new_bal);

        connect();
        String qry = "UPDATE `"+tabel+"` SET `"+target+"`='"+new_bal+"' WHERE `Barcode`='"+Barcode+"'";
        getStatement().executeUpdate(qry);
    }
      
      
    public void SearchByName(String tabel, String Names) throws ClassNotFoundException, SQLException {
        connect();
        String qry = "SELECT * FROM `"+secure_inputs(tabel)+"` WHERE `Drug_Name`='"+secure_inputs(Names)+"'";
        ResultSet res = getStatement().executeQuery(qry);
        while(res.next()){
   System.out.println("Barcode: "+res.getString("Barcode") +"  Drug_Name: "+res.getString("Drug_Name")
           +"  Category: "+res.getString("Category")
           +" Company: "+res.getString("Company")+ " Amounts: "+res.getString("Amounts")+  " Validity: "+res.getString("Validity"));
        }
    }
    
    
     public void SearchByCode(String tabel, String Code) throws ClassNotFoundException, SQLException {
        connect();
        String qry = "SELECT * FROM `"+secure_inputs(tabel)+"` WHERE `Barcode`='"+secure_inputs(Code)+"'";
        ResultSet res = getStatement().executeQuery(qry);
        while(res.next()){
           System.out.println("Barcode: "+res.getString("Barcode") +"  Drug_Name: "+res.getString("Drug_Name")
           +"  Category: "+res.getString("Category")
           +" Company: "+res.getString("Company")+ " Amounts: "+res.getString("Amounts")+  " Validity: "+res.getString("Validity"));
        }
    }
    
      public void delete(String tabel, String Code) throws ClassNotFoundException, SQLException{
        connect();
        String qry = "DELETE FROM `"+secure_inputs(tabel)+"` WHERE `Barcode`='"+secure_inputs(Code)+"'";
        getStatement().executeUpdate(qry);
    }
      
      
      
     
      
      public void UpdateAmounts(String name) throws ClassNotFoundException, SQLException {
        int c = 0;
        String qry1 = "SELECT Amount FROM dispensing_medicines WHERE Drug_Name = '"+name+"'";
        connect();
        ResultSet res = getStatement().executeQuery(qry1);
        if(res.next()){
            c = res.getInt("Amount");
        }
        
        int x = 0;
        connect();
        String qry2 = "SELECT Amounts FROM pharmcy WHERE Drug_Name = '"+name+"'";
        ResultSet res2 = getStatement().executeQuery(qry2);
        if(res2.next()){
            x = res2.getInt("Amounts");
        }

        String qry3 = "UPDATE pharmcy SET Amounts='"+(x-c)+"' WHERE Drug_Name = '"+name+"'";
        getStatement().executeUpdate(qry3);
        System.out.println("Done!");
    }
      
      
      
      
         public void Add_invoice(String tabel, String Drug_Name, String Category, String Company , int Amount, 
         String Patients_Names, int ID,int Code,String Date ) throws ClassNotFoundException, SQLException{
        
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
        String qry = "INSERT INTO `"+tabel+"` (`Drug_Name`,`Category`,`Company`,`Amount`,`Patients_Names`,"
                + "`Patients_ID`,`Drug_Code`,`Date`) "
           + "VALUES ('"+Drug_Name+"','"+Category+"','"+Company+"','"+Amounts+"','"+Patients_Names+"','"+Patients_ID+"','"
                +Drug_Code+"','"+Date+"')";
        getStatement().executeUpdate(qry);
        
        UpdateAmounts(Drug_Name);
        
    }
         
         
         public void InvoiceSearch(String tabel, String invoice_number) throws ClassNotFoundException, SQLException {
        connect();
        String qry = "SELECT * FROM `"+secure_inputs(tabel)+"` WHERE `invoice_number`='"+secure_inputs(invoice_number)+"'";
        ResultSet res = getStatement().executeQuery(qry);
        while(res.next()){
           System.out.println("invoice number: "+res.getString("invoice_number") +"  Drug Name: "+res.getString("Drug_Name")
        +"  Category: "+res.getString("Category")
        +" Company: "+res.getString("Company")+ " Amounts: "+res.getString("Amount")+" Patients Names: "+res.getString("Patients_Names")
        +  " Patients ID: "+res.getString("Patients_ID") +  " Drug Code : "+res.getString("Drug_Code") 
        +  " Date: "+res.getString("Date") );
        }     }
         
           public void DeleteInvoic(String tabel, String invoice_number) throws ClassNotFoundException, SQLException{
        connect();
        String qry = "DELETE FROM `"+secure_inputs(tabel)+"` WHERE `invoice_number`='"+secure_inputs(invoice_number)+"'";
        getStatement().executeUpdate(qry);
    }
         
           
            public void EditInvoic(String tabel, int invoice_number,  String target, String new_bal) throws ClassNotFoundException, SQLException{

        tabel = secure_inputs(tabel);
        target =  secure_inputs(target);
        new_bal = secure_inputs(new_bal);

        connect();
        String qry = "UPDATE `"+tabel+"` SET `"+target+"`='"+new_bal+"' WHERE `invoice_number`='"+invoice_number+"'";
        getStatement().executeUpdate(qry);
    }
           
           
           
         }

