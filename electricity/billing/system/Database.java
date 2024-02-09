package electricity.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Database 
{
    Connection connection = null; // set of connection to setup driver manager and comes from sql package
    Statement statement; //
    Database()
    {
        // There may be some exception while accesing databse
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill_system","root","Pranav@123");
            //connectiontype:type_of_Database://localhost:3306/Name_of_Database,user:Name_of_user,password:Password_of_user
            statement = connection.createStatement();
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       
    }
}
