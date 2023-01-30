import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","snow");
            Statement statement = connection.createStatement();
            statement.executeUpdate()

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
