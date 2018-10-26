/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbInterface;

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
        Name = "Pratik Panchal";
        StationTo = "Ville Parle";
        StationFrom = "Badlapur";
        Email = "pratik.sp.1112@gmail.com";
        Department = "Computer";
        Class = 1;
        return true;
    }

    public static boolean requestApplication() {
        ApplicationMessage = "Your Application is waiting for approval";
//        ApplicationRejectionMessage = "Application request has been enqueued";
//        ApplicationRejectionMessage = "You have alread applied for 3 month Railway Concession";
        return true;
    }
}
