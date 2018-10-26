/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pratik Panchal
 */
public class RequestApplicationClass {

    public static String Name;
    public static String StationTo;
    public static String StationFrom;
    public static String Email;
    public static String Department;
    public static int Class;
    public static String ApplicationMessage;

    public static boolean fetchValues() {
        String str = "select * from student_profile where sap_id = '" + CommonDataSet.SapId + "'";
        try {
            PreparedStatement st = CommonDataSet.conn.prepareStatement(str);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Name = rs.getString(2);
                Email = rs.getString(4);
                StationFrom = rs.getString(5);
                Department = rs.getString(6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RequestApplicationClass.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Name = "Pratik Panchal";
        StationTo = "Ville Parle";
//        StationFrom = "Badlapur";
//        Email = "pratik.sp.1112@gmail.com";
//        Department = "Computer";
        Class = 1;
        return true;
    }

    public static boolean requestApplication() {
        try {
            String str="call request_application('" + CommonDataSet.SapId + "'," + Class + " )";
            PreparedStatement st = CommonDataSet.conn.prepareStatement(str);
            ResultSet rs=st.executeQuery();
            if(rs.next())
                ApplicationMessage = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApplicationClass.class.getName()).log(Level.SEVERE, null, ex);
        }
//        ApplicationMessage = "Your Application is waiting for approval";
//        ApplicationRejectionMessage = "Application request has been enqueued";
//        ApplicationRejectionMessage = "You have alread applied for 3 month Railway Concession";
        return true;
    }
}
