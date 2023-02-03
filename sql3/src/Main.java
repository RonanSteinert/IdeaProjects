import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user  = "root";
            String pass = "snow";
            String s = ("CREATE TABLE IF NOT EXISTS studentSQL3 " +
                    "(student_ID INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "last_name VARCHAR(30), " +
                    "first_name VARCHAR(30))");
            ArrayList<String> array = new ArrayList<>();

            Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();

            statement.executeUpdate(s);

            ResultSet rs = statement.executeQuery("SELECT first_name, last_name  FROM newdb.studentSQL3");

            while (rs.next()){
                System.out.println(rs.getString("first_name"));
                array.add(rs.getString("last_name"));
            }
            System.out.println(array);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
