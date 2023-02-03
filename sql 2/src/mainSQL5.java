import java.sql.*;
import java.util.ArrayList;

public class mainSQL5 {
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

            ArrayList<Student> italians = new ArrayList<Student>();
            ArrayList<Student> germans = new ArrayList<Student>();

            ResultSet rsIta = statement.executeQuery( "SELECT first_name, last_name FROM newdb.italian_student");

            ResultSet rsGer = statement.executeQuery( "SELECT first_name, last_name FROM newdb.germany_student");

            while (rsIta.next()){
                italians.add(new Student(rsIta.getString("first_name"), rsIta.getString("last_name")));
            }
            while (rsGer.next()){
                germans.add(new Student(rsGer.getString("first_name"), rsGer.getString("last_name")));
            }

            for (Student it : italians ){
                it.studentDetails();
            }
            for (Student ger : germans){
                ger.studentDetails();
            }

        }catch (Exception e){
        e.printStackTrace();
        }
    }
}
