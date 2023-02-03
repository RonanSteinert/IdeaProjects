import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "root";
        String pass = "snow";
        try {Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();
            //statement.executeUpdate("ALTER TABLE students ADD country VARCHAR(60) NOT NULL");
            //statement.execute("UPDATE `newdb`.`students` SET `country` = 'Italian' WHERE (`student_id` = '1');");
            //statement.execute("UPDATE `newdb`.`students` SET `country` = 'Italian' WHERE (`student_id` = '2');");
            //statement.execute("UPDATE `newdb`.`students` SET `country` = 'Germany' WHERE (`student_id` = '3');");
            statement.execute("UPDATE `newdb`.`students` SET `country` = 'Germany' WHERE (`student_id` = '4');");
            connection.close();
            statement.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}