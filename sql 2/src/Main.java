import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","snow");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM 'students'");

            //statement.executeUpdate("create table if not exists students(student_id int(10) auto_increment primary key not null)");
            //statement.executeUpdate("alter table students add last_name varchar(30) not null after student_id");
            //statement.executeUpdate("alter table students add first_name varchar(30) not null after last_name");
            //statement.executeUpdate("insert into students (last_name, first_name) values ('Rossi', 'Mario')");
            //statement.executeUpdate("insert into students (last_name, first_name) values ('Verdi', 'Marco')");
            //statement.executeUpdate("insert into students (last_name, first_name) values ('Gialli', 'Francesco')");
            //statement.executeUpdate("insert into students (last_name, first_name) values ('Bianchi', 'Dario')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}