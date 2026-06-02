import java.util.ArrayList;
import java.util.Scanner;

// Course Class
class Course {
    private String courseName;
    private int totalSemesters;

    public Course(String courseName, int totalSemesters) {
        this.courseName = courseName;
        this.totalSemesters = totalSemesters;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTotalSemesters() {
        return totalSemesters;
    }
}

// Student Class
class Student {
    private String name;
    private String rollNo;
    private Course course;
    private ArrayList<Double> sgpaList;

    public Student(String name, String rollNo, Course course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.sgpaList = new ArrayList<>();
    }

    public void addSGPA(double sgpa) {
        sgpaList.add(sgpa);
    }

    public ArrayList<Double> getSgpaList() {
        return sgpaList;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public Course getCourse() {
        return course;
    }
}

// Calculator Class
class CGPACalculator {

    public static double calculateCGPA(ArrayList<Double> sgpaList) {

        double total = 0;
        int validSemesters = 0;

        for (double sgpa : sgpaList) {
            if (sgpa > 0) {
                total += sgpa;
                validSemesters++;
            }
        }

        if (validSemesters == 0) {
            return 0;
        }

        return total / validSemesters;
    }

    public static int countValidSemesters(ArrayList<Double> sgpaList) {

        int count = 0;

        for (double sgpa : sgpaList) {
            if (sgpa > 0) {
                count++;
            }
        }

        return count;
    }

    public static String getPerformance(double cgpa, int validSemesters) {

        if (validSemesters == 0)
            return "No Result Available";

        if (cgpa >= 9.0)
            return "Outstanding";
        else if (cgpa >= 8.0)
            return "Distinction";
        else if (cgpa >= 7.0)
            return "First Class";
        else if (cgpa >= 6.0)
            return "Second Class";
        else
            return "Pass";
    }
}

public class Calc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Course[] courses = {
                new Course("BCA", 6),
                new Course("B.Tech", 8),
                new Course("MCA", 4),
                new Course("MBA", 4),
                new Course("BBA", 6),
                new Course("B.Com", 6),
                new Course("B.Sc", 6),
                new Course("BA", 6),
                new Course("M.Tech", 4),
                new Course("M.Sc", 4),
                new Course("M.Com", 4),
                new Course("B.Pharm", 8),
                new Course("D.Pharm", 4),
                new Course("B.Ed", 4),
                new Course("Polytechnic Diploma", 6)
        };

        System.out.println("================================================");
        System.out.println("         COURSE BASED CGPA CALCULATOR");
        System.out.println("================================================");

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number  : ");
        String rollNo = sc.nextLine();

        System.out.println("\nAvailable Courses:");

        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + ". "
                    + courses[i].getCourseName()
                    + " (" + courses[i].getTotalSemesters()
                    + " Semesters)");
        }

        int choice;

        while (true) {

            System.out.print("\nSelect Course (1-15): ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 15)
                break;

            System.out.println("Invalid Choice! Try Again.");
        }

        Course selectedCourse = courses[choice - 1];

        Student student =
                new Student(name, rollNo, selectedCourse);

        System.out.println("\nSelected Course : "
                + selectedCourse.getCourseName());

        System.out.println("Total Semesters : "
                + selectedCourse.getTotalSemesters());

        System.out.println("\nEnter SGPA");
        System.out.println("(0 or -1 = Result Pending)\n");

        for (int i = 1;
             i <= selectedCourse.getTotalSemesters();
             i++) {

            double sgpa;

            while (true) {

                System.out.print("Semester "
                        + i + " SGPA : ");

                sgpa = sc.nextDouble();

                if ((sgpa >= 0 && sgpa <= 10)
                        || sgpa == -1) {
                    break;
                }

                System.out.println(
                        "Enter value between 0-10 or -1");
            }

            student.addSGPA(sgpa);
        }

        double cgpa = CGPACalculator.calculateCGPA(
                student.getSgpaList());

        int validSemesters =
                CGPACalculator.countValidSemesters(
                        student.getSgpaList());

        // REPORT CARD

        System.out.println(
                "\n+------------------------------------------------------+");
        System.out.println(
                "|                 STUDENT REPORT CARD                  |");
        System.out.println(
                "+------------------------------------------------------+");

        System.out.printf(
                "| %-15s : %-34s |%n",
                "Name",
                student.getName());

        System.out.printf(
                "| %-15s : %-34s |%n",
                "Roll Number",
                student.getRollNo());

        System.out.printf(
                "| %-15s : %-34s |%n",
                "Course",
                student.getCourse().getCourseName());

        System.out.println(
                "+------------------------------------------------------+");
        System.out.println(
                "|                 SEMESTER DETAILS                     |");
        System.out.println(
                "+------------------------------------------------------+");

        ArrayList<Double> list =
                student.getSgpaList();

        for (int i = 0; i < list.size(); i++) {

            String value;

            if (list.get(i) <= 0) {
                value = "Result Pending";
            } else {
                value =
                        String.format("%.2f",
                                list.get(i));
            }

            System.out.printf(
                    "| Semester %-6d : %-34s |%n",
                    (i + 1),
                    value);
        }

        System.out.println(
                "+------------------------------------------------------+");

        if (validSemesters == 0) {

            System.out.printf(
                    "| %-15s : %-34s |%n",
                    "Current CGPA",
                    "Not Available");

        } else {

            System.out.printf(
                    "| %-15s : %-34.2f |%n",
                    "Current CGPA",
                    cgpa);
        }

        System.out.printf(
                "| %-15s : %-34s |%n",
                "Performance",
                CGPACalculator.getPerformance(
                        cgpa,
                        validSemesters));

        System.out.println(
                "+------------------------------------------------------+");

        sc.close();
    }
}