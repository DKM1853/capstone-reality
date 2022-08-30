package dao;

import java.sql.*;

public class Dao {
    String driverName = "com.mysql.cj.jdbc.Driver", dburl = "jdbc:mysql://localhost:3306/userdetail", dbusername="root", dbpassword= "root";
    public int addContactDetails(String contactname, String contactmail, String contactno, String contactmessage) {
        int status = 0;
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dburl, dbusername, dbpassword);
            CallableStatement stmt = con.prepareCall("{call addContactDetails(?,?,?,?)}");
            stmt.setString(1,contactname);
            stmt.setString(2,contactno);
            stmt.setString(3,contactmail);
            stmt.setString(4,contactmessage);
            status = stmt.executeUpdate();
            stmt.close();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }

    public int addSalesDetails(String salesInquiryName, String salesInquiryMail, String salesInquiryNumber, String salesInquiryOccupation,String salesInquiryMessage) {
        int status = 0;
        try{
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dburl, dbusername, dbpassword);
            CallableStatement stmt = con.prepareCall("{call addSalesInquiryDetails(?,?,?,?,?)}");
            stmt.setString(1,salesInquiryName);
            stmt.setString(2,salesInquiryNumber);
            stmt.setString(3,salesInquiryMail);
            stmt.setString(4,salesInquiryOccupation);
            stmt.setString(5,salesInquiryMessage);
            status = stmt.executeUpdate();
            stmt.close();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }
}
