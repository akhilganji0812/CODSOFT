import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Course class contains arrays of course codes, titles, descriptions, and schedules.
class Course {
    String[] course = {"PY879", "JAVA231", "SQL082"};
    String[] title = {"Python", "Java", "Mysql"};
    String[] description = {
        "Python is a high-level, dynamically typed language with versatile features like control flow, functions, and object-oriented programming. It supports modules and packages for code organization, along with exception handling for error management.",
        "Java is a high-level, statically typed, object-oriented programming language known for its platform independence via the JVM. It features strong OOP principles like inheritance, polymorphism, and encapsulation, with a rich standard library for tasks ranging from networking to data structures.",
        "MySQL is a widely-used, open-source relational database management system (RDBMS) known for its reliability and performance. It supports SQL (Structured Query Language) for managing and querying databases, allowing efficient handling of large datasets."
    };
    String[] schedule = {"10th Oct, 2024", "25th Oct, 2024", "2nd Nov, 2024"};
}

// Main class handles course registration logic.
class Main {
    // Initial capacity for Python, Java, and MySQL courses.
    public static int py_cap = 20;
    public static int java_cap = 30;
    public static int sql_cap = 25;

    public static void main(String[] args) {
        // Lists to store the names and IDs of students registered in each course.
        List<String> py_list = new ArrayList<>();
        List<Integer> py_id = new ArrayList<>();
        List<String> java_list = new ArrayList<>();
        List<Integer> java_id = new ArrayList<>();
        List<String> mysql_list = new ArrayList<>();
        List<Integer> mysql_id = new ArrayList<>();

        // Variables to count the number of people registered in each course.
        int py_count = 0;
        int java_count = 0;
        int mysql_count = 0;

        // Create an instance of the Course class to access course information.
        Course obj = new Course();

        // Infinite loop to keep the course registration system running.
        while (true) {
            // Display course information and registration options.
            System.out.println(" *** Course Registration *** ");
            System.out.println("1. Python :- " + obj.description[0]);
            System.out.println("Subject Code :- " + obj.course[0]);
            System.out.println("Start Date :- " + obj.schedule[0]);
            System.out.println("Capacity :-  " + py_cap);
            System.out.println("People Registered :-  " + py_count);
            System.out.println("\n2. Java :- " + obj.description[1]);
            System.out.println("Subject Code :- " + obj.course[1]);
            System.out.println("Start Date :- " + obj.schedule[1]);
            System.out.println("Capacity :-  " + java_cap);
            System.out.println("People Registered :-  " + java_count);
            System.out.println("\n3. MySql :- " + obj.description[2]);
            System.out.println("Subject Code :- " + obj.course[2]);
            System.out.println("Start Date :- " + obj.schedule[2]);
            System.out.println("Capacity :-  " + sql_cap);
            System.out.println("People Registered :-  " + mysql_count);
            System.out.println("\n4. Course Removal");
            System.out.println("\n5. Exit");

            // Read user input for course registration or removal options.
            Scanner value = new Scanner(System.in);
            int choice = value.nextInt();

            // Process course registration based on user choice.
            if (choice == 1) {
                System.out.println("*** Python Registration form ***");
                System.out.println("Enter your name : ");
                Scanner val = new Scanner(System.in);
                String name = val.nextLine();
                py_list.add(name);
                System.out.println("Enter your student id : ");
                Scanner num = new Scanner(System.in);
                int id = num.nextInt();
                py_id.add(id);
                py_cap -= 1;
                py_count++;
                System.out.println("Registered Successfully to Python Course");
            }
            else if (choice == 2) {
                System.out.println("*** Java Registration form ***");
                System.out.println("Enter your name : ");
                Scanner val = new Scanner(System.in);
                String name = val.nextLine();
                java_list.add(name);
                System.out.println("Enter your student id : ");
                Scanner num = new Scanner(System.in);
                int id = num.nextInt();
                java_id.add(id);
                java_cap -= 1;
                java_count++;
                System.out.println("Registered Successfully to Java Course");
            }
            else if (choice == 3) {
                System.out.println("*** MySQL Registration form ***");
                System.out.println("Enter your name : ");
                Scanner val = new Scanner(System.in);
                String name = val.nextLine();
                mysql_list.add(name);
                System.out.println("Enter your student id : ");
                Scanner num = new Scanner(System.in);
                int id = num.nextInt();
                mysql_id.add(id);
                sql_cap -= 1;
                mysql_count++;
                System.out.println("Registered Successfully to MySQL Course");
            }
            // Course removal process.
            else if (choice == 4) {
                System.out.println("Enter your registered course : \n1. Python\n2. Java\n3. MySQL");
                Scanner num1 = new Scanner(System.in);
                int cou = num1.nextInt();
                if (cou == 1) {
                    System.out.println("Enter your name : ");
                    Scanner val = new Scanner(System.in);
                    String name = val.nextLine();
                    py_list.remove(name);
                    System.out.println("Enter your id : ");
                    Scanner num = new Scanner(System.in);
                    int id = num.nextInt();
                    py_id.remove(Integer.valueOf(id));
                    py_cap += 1;
                    py_count--;
                } else if (cou == 2) {
                    System.out.println("Enter your name : ");
                    Scanner val = new Scanner(System.in);
                    String name = val.nextLine();
                    java_list.remove(name);
                    System.out.println("Enter your id : ");
                    Scanner num = new Scanner(System.in);
                    int id = num.nextInt();
                    java_id.remove(Integer.valueOf(id));
                    java_cap += 1;
                    java_count--;
                } else if (cou == 3) {
                    System.out.println("Enter your name : ");
                    Scanner val = new Scanner(System.in);
                    String name = val.nextLine();
                    mysql_list.remove(name);
                    System.out.println("Enter your id : ");
                    Scanner num = new Scanner(System.in);
                    int id = num.nextInt();
                    mysql_id.remove(Integer.valueOf(id));
                    sql_cap += 1;
                    mysql_count--;
                }
            }
            // Exit the program.
            else if (choice == 5) {
                System.exit(0);
            }
            // Handle invalid input.
            else {
                System.out.println("Wrong Input");
            }
        }
    }
}
