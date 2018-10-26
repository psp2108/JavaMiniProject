package MySQLConnectionPackage;
//import VectorClass.;

//import CordinationForm;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnecToMySql {

    public static Connection getConnection() {

        try {
            String driver = "com.mysql.jdbc.Driver";
            //String url = "jdbc:mysql://ipaddress:port:databaseName";  
            String url = "jdbc:mysql://<ipaddress>:3306/<database_name>";
            String username = "db_username";
            String password = "db_password";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;

        } catch (Exception ex) {

        }
        return null;
    }

}
