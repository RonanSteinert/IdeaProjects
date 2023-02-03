import java.sql.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "root";
        String pass = "snow";
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS students " +
                    "(student_ID INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "last_name VARCHAR(30), " +
                    "first_name VARCHAR(30))";
            statement.executeUpdate(sql);

            System.out.println("table created.");


            String viewIta = "CREATE VIEW italian_student (first_name,last_name)" +
                    "AS ( SELECT first_name,last_name FROM 'students' WHERE country = 'Italian' )";
            statement.executeUpdate(viewIta);

            String viewGer  = "CREATE VIEW germany_student (first_name,last_name)" +
                    "AS ( SELECT first_name,last_name FROM 'students' WHERE country = 'Germany' )";
            statement.executeUpdate(viewGer);

            ArrayList<Student> italianStudent  = new ArrayList<>();
            ArrayList<Student> germanStudent  = new ArrayList<>();

            ResultSet resultSetGermany = statement.executeQuery(viewGer);
            ResultSet resultSetItaly = statement.executeQuery(viewIta);

            while (resultSetItaly.next()){
                germanStudent.add(new Student())
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
