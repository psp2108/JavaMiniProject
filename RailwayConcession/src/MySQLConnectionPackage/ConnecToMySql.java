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
            String url = "jdbc:mysql://localhost:3306/railwayconcession";
            String username = "root";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}
