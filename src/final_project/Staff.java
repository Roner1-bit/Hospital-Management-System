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
public class Staff extends DB{

    
    
     public void Add(String tabel, String Names, int Age,String jop, String Department , String Sex, 
         String Address, String Email, Double Sal) throws ClassNotFoundException, SQLException{
        
        tabel = secure_inputs(tabel);
        Names = secure_inputs(Names);
        String ageV = secure_inputs(Integer.toString(Age));
         jop = secure_inputs(jop);
        Department = secure_inputs(Department);
        Sex = secure_inputs(Sex);
        Address = secure_inputs(Address);
        Email = secure_inputs(Email);
       String Salary = secure_inputs(String.valueOf(Sal));


        connect();
        String qry = "INSERT INTO `"+tabel+"` (`Names`,`Age`,`jop`,`Department`,`Sex`,`Address`,`Email`,`Salary`) VALUES ('"+Names+"','"+ageV+"','"+jop+"','"+Department+"','"+Sex+"','"+Address+"','"+Email+"','"+Salary+"')";
        getStatement().executeUpdate(qry);
    }
    
    
     
     
     
    public void printStaff(String tabel, String id) throws ClassNotFoundException, SQLException {
       
        ResultSet res =Select("staff", "IDs", id);
        while(res.next()){
            System.out.println("id: "+res.getInt("IDs")+"  Name: "+res.getString("Names")
                    +" Age: "+res.getInt("Age")+ " Jop: "+res.getString("Jop")+  " Department: "+res.getString("Department")+  " Sex: "+res.getString("Sex")+" Address: "+res.getString("Address")+
                    "  Salary: " +res.getString("Salary"));
        }
    }
    
      
    
}
