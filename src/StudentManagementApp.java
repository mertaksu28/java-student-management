import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentGrades = new ArrayList<>();
        while (true){
            System.out.println("======Student Management System======");
            System.out.println("1-Add Student");
            System.out.println("2-List Students");
            System.out.println("3-Remove Student");
            System.out.println("4-Calculate Average");
            System.out.println("0-Exit");
            System.out.print("Please make a choose : ");

            int choose = scanner.nextInt();
            scanner.nextLine();
            if (choose==1){
                addStudent(studentNames,studentGrades,scanner);
            } else if (choose == 2) {
                listStudents(studentNames,studentGrades);
            } else if (choose == 3) {
                removeStudent(studentNames,studentGrades,scanner);
            } else if (choose == 4) {
                calculatePointsAverage(studentGrades);
            } else if (choose == 0) {
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Please choose selected numbers(0-4)");
            }
        }
    }

    public static void addStudent(ArrayList<String> studentNames, ArrayList<Integer> studentGrades,Scanner scanner){
        System.out.print("Please enter a name: ");
        studentNames.add(scanner.nextLine());
        System.out.print("Please enter a point : ");
        studentGrades.add(scanner.nextInt());
        System.out.println("Student added successfully :)");
    }

    public static void listStudents(ArrayList<String> students,ArrayList<Integer> grades){
        System.out.println("======Students And Points======");
        for (int i=0;i<students.size();i++){
            System.out.printf("%-20s | %3d%n", students.get(i), grades.get(i));
        }
    }

    public static void removeStudent(ArrayList<String> names, ArrayList<Integer> grades,Scanner scanner){
        System.out.println("Enter the name of the student to remove : ");
        String nameToRemove = scanner.nextLine();

        for (int i =0; i<names.size();i++){
            if (names.get(i).equalsIgnoreCase(nameToRemove)){
                names.remove(i);
                grades.remove(i);
                System.out.println("Student "+ nameToRemove + " removed successfully :)");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void calculatePointsAverage(ArrayList<Integer> grades){
        if (grades.isEmpty()) {
            System.out.println("No student added yet ! ");
            return;
        }

        int total = 0;
        for (Integer grade : grades){
            total = total + grade;
        }

        double average = (double) total/grades.size();
        System.out.println("Total point average is : "+average);

    }

}