/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbInterface;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pratik Panchal
 */
public class LoginClass {

    public static boolean checkCredentials(String sap, String pwd) {
        CommonDataSet.SapId = sap;
        try {
            PreparedStatement st = CommonDataSet.conn.prepareStatement("call credential_check('" + CommonDataSet.SapId + "','" + pwd + "')");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
