public class Student {
    String name;
    String surname;

    public Student(String name, String surname){
        this.name  = name;
        this.surname = surname;
    }
    public void studentDetails(){
        System.out.println("Name: " + name + "" + "Surname: " + surname);
    }
}
