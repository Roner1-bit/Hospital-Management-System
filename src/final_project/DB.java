package final_project;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * Calss DataBase
 *
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
    public DB() {
        username = "root";
        password = "";
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        System.out.println("Connecting!");
        conn = DriverManager.getConnection(DB_PATH, username, password);
        stmt = conn.createStatement();
    }

    //select From any table with any identifier
    ResultSet Select(String Table, String Location, String Data) throws ClassNotFoundException, SQLException {
        connect();
        String qry = "SELECT * FROM `" + secure_inputs(Table) + "` WHERE `" + Location + "`='" + secure_inputs(Data) + "'";
        ResultSet result = getStatement().executeQuery(qry);
        return result;
    }
    String GetColumn(String table,String Location,String Column,String data) throws ClassNotFoundException, SQLException{
        ResultSet re=Select(table, Location, data);
        String Data="";
        while (re.next()){
            Data=re.getString(Column);
        }
    return Data;
    }

    // delete by ID
    public void delete(String tabel,String Location, String id) throws ClassNotFoundException, SQLException {
        connect();
        String qry = "DELETE FROM `" + secure_inputs(tabel) + "` WHERE `" + Location + "`='" + secure_inputs(id) + "'";
        getStatement().executeUpdate(qry);
    }

    String GetLastID(String table,String From) throws ClassNotFoundException, SQLException {
        connect();
        String query = "Select * from `" + secure_inputs(table) + "`";
        ResultSet rs = stmt.executeQuery(query);
        String ID = "";
        rs.last();
        ID = rs.getString(From);
        return ID;
    }

    public void update(String tabel, String Data, String target, String NewData, String where) throws ClassNotFoundException, SQLException {

        tabel = secure_inputs(tabel);
        target = secure_inputs(target);
        NewData = secure_inputs(NewData);

        connect();
        String qry = "UPDATE `" + tabel + "` SET `" + target + "`='" + NewData + "' WHERE `" + where + "`='" + Data + "'";
        getStatement().executeUpdate(qry);
    }

    public void close() throws SQLException {
        conn.close();
        stmt.close();
    }

    public Statement getStatement() {
        return stmt;
    }

    public Connection getConnection() {
        return conn;
    }

    //to Validation The Inputs
    public String secure_inputs(String input) {
        input = input.trim();
        input = input.replaceAll("\\\\", "\\\\\\\\");
        input = input.replaceAll("\\n", "\\\\n");
        input = input.replaceAll("\\r", "\\\\r");
        input = input.replaceAll("\\00", "\\\\0");
        input = input.replaceAll("'", "\\\\'");
        return input;
    }

    //to encrypt the password
    public String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //all Inputs Validations
    protected boolean NumberChecker(String number) {
        try {
            int Number = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (number.matches("\\d{11}")) {
            return true;
        } else {
            return false;
        }

    }

    protected boolean AgeChecker(String Age) {
        int age;
        try {
            age = Integer.parseInt(Age);

        } catch (NumberFormatException nfe) {
            return false;
        }
        return Age.length() <= 3 && age <= 150 && age > 0;
    }

    protected boolean GenderChecker(String Gender) {
        if (Gender.equals("Male") || Gender.equals("Female")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean EmailChecker(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return Email.matches(regex);
    }
}
