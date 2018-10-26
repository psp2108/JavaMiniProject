/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pratik Panchal
 */
package MySQLConnectionPackage;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class JTableFill {

    private Connection conn;
    private String UserName;
    private String Password;

    //public JTableFill(Connection connectionObject, String SQLusername, String SQLpassword){
    public JTableFill(Connection connectionObject) {
        conn = connectionObject;
        /* UserName = SQLusername;
        Password = SQLpassword;*/
    }

    public TableModel fillMyJTable(String Query) throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Query);
        ResultSetMetaData rsmt = rs.getMetaData();
        int c = rsmt.getColumnCount();

        Vector column = new Vector(c);

        for (int i = 1; i <= c; i++) {
            column.add(rsmt.getColumnName(i));
        }

        Vector data = new Vector();
        Vector row = new Vector();

        while (rs.next()) { 
            row = new Vector(c);
            for (int i = 1; i <= c; i++) {
                row.add(rs.getString(i));
            }

            data.add(row);
        }

        return (new DefaultTableModel(data, column));
    }
}
