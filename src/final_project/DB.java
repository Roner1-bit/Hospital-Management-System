package final_project;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * Calss DataBase
 * @author SadC0d3r
 */

public class DB {
    
    // DataBase Configuration
    
    final String DRIVER = "com.mysql.jdbc.Driver";
  
    final String DB_PATH = "jdbc:mysql://127.0.0.1/hospital";
    String username = null;
    String password = null;
    Connection conn = null;
    Statement stmt = null;
    
    // End Configuration
    
    public DB(){
        username = "root";
        password = "";
    }    
    
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        System.out.println("Connecting!");
        conn = DriverManager.getConnection(DB_PATH, username, password);
        stmt = conn.createStatement();
    }
    
 
    

    // delete by ID
    
    public void delete(String tabel, String id) throws ClassNotFoundException, SQLException{
        connect();
        String qry = "DELETE FROM `"+secure_inputs(tabel)+"` WHERE `IDs`='"+secure_inputs(id)+"'";
        getStatement().executeUpdate(qry);
    }
    
   
    
    public void close() throws SQLException {
        conn.close();
        stmt.close();
    }
    
    public Statement getStatement(){
        return stmt;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    //to Validation The Inputs
    
    public String secure_inputs(String input){
        input = input.trim(); 
        input = input.replaceAll("\\\\", "\\\\\\\\");
        input = input.replaceAll("\\n", "\\\\n");
        input = input.replaceAll("\\r", "\\\\r");
        input = input.replaceAll("\\00", "\\\\0");
        input = input.replaceAll("'", "\\\\'");
        return input;
    }
    
    //to encrypt the password
    
    public String md5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
} 
