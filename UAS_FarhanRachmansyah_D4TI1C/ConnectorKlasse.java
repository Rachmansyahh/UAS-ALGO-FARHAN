import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;

/**
 * Write a description of class ConnectorKlasse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConnectorKlasse extends Actor
{
    
    public static void main()
    {
        Connection conn = null;
        String datenbank = "localhost:3306/mysql/dbconnection";
        String user = "root";
        String password = "";
        
    try {
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        System.out.println("bis hierhin klappts");
        conn = DriverManager.getConnection ("jdbc:mysql://"+datenbank+"?useUnicode=yes&characterEncoding=UTF-8=true", user, password);
        System.out.println ("Database connection established");
    }
    catch(Exception ex)
    {
        System.out.println("SQLException: " + ex.getMessage());
    }
    finally
    {
        if (conn != null)
        {
            try
            {
                conn.close ();
                System.out.println ("Database connection terminated");
            }
            catch (Exception e) { /* ignore close errors */ }
        }
    }
    }

}
