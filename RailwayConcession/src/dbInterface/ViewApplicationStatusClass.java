/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbInterface;

public class ViewApplicationStatusClass {

    public static String Name;
    public static String StationTo;
    public static String StationFrom;
    public static String Email;
    public static String Department;
    public static int Class;
    public static int Status;
    
    public static boolean fetchStatus(){
        Name = "Pratik Panchal";
        StationTo = "Ville Parle";
        StationFrom = "Badlapur";
        Email = "pratik.sp.1112@gmail.com";
        Department = "Computer";
        Status = 1;
        Class = 1;        
        return true;
    }
    
}
