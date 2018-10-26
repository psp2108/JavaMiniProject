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

public class ViewApplicationStatusClass {

    public static String Name;
    public static String StationTo;
    public static String StationFrom;
    public static String Email;
    public static String Department;
    public static int Class;
    public static int Status;

    public static boolean fetchStatus() {

        try {
            PreparedStatement st = CommonDataSet.conn.prepareStatement("call show_app_status('" + CommonDataSet.SapId + "')");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                try {
                    Name = rs.getString(1);
                    StationFrom = rs.getString(4);
                    Email = rs.getString(5);
                    Department = rs.getString(6);
                    Status = rs.getInt(8);
                    Class = rs.getInt(7);
                } catch (Exception ex) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewApplicationStatusClass.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Name = "Pratik Panchal";
        StationTo = "Ville Parle";
//        StationFrom = "Badlapur";
//        Email = "pratik.sp.1112@gmail.com";
//        Department = "Computer";
//        Status = 1;
//        Class = 1;        
        return true;
    }

}
