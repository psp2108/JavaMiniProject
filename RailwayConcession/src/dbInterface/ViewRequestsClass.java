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
public class ViewRequestsClass {

    public static boolean changeStatus(String rcid, int status) {
        String s = "";
        try {
            PreparedStatement st = CommonDataSet.conn.prepareStatement("call status_change(" + rcid + ", " + status + ")");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                s=rs.getString(1);
            }
            if(!s.equals("true")){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewRequestsClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
}
