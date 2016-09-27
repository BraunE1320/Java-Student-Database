/*
 * A menu-driven program for testing the StudentDatabase class.
 * Supplied for Assignment 6.
 * CISC 124, Winter 2015
 * M. Lamb
 */
import java.util.*;

public class DatabaseTest {

    public static Scanner keyboard = new Scanner(System.in);
    
    // Reads an integer from the user.  Skips the rest of the input line.
    public static int readInt() {
        if (keyboard.hasNextInt()) {
            int result = keyboard.nextInt();
            keyboard.nextLine(); // skip rest of line
            return result;
        }
        else {
            keyboard.nextLine(); 
            // skip the whole line and make the user try again
            System.out.print("please enter an integer: ");
            return readInt();
        } // end if
    } // end readInt

    public static void main(String args[]) {
        StudentDatabase database = new StudentDatabase(); // initially empty
   
        // a student id number
        int idnum;
        
        // a course name
        String courseName;
        
        // a choice from the menu
        int choice;

        // Constants for menu choices.  The "init" choice calls "add"
        // multiple times to create an initial database for experimenting with.
        final int INIT_CHOICE = 1;
        final int ADD_CHOICE = 2;
        final int REMOVE_CHOICE = 3;
        final int COURSES_CHOICE = 4;
        final int ALL_STUDENTS_CHOICE = 5;
        final int WITHDRAW = 6;
        final int CHECK = 7;
        final int QUIT_CHOICE = 8;
        
        // show initial database
        database.report();

        while (true) { // exit with a break
            System.out.print("enter choice (" 
                + INIT_CHOICE + " = initialize, "
                + ADD_CHOICE + " = add, "
                + REMOVE_CHOICE + " = remove, "
                + COURSES_CHOICE + " = courses, "
                + ALL_STUDENTS_CHOICE + " = show all students, " 
                + "\n              " +
                + WITHDRAW + " = withdraw a student, "
                + CHECK + " = check database, "            
                + QUIT_CHOICE + " = quit): ");
            choice = readInt();
            
            if (choice == INIT_CHOICE) {
                // Set up an initial database, with several courses with
                // different numbers of students, and some students in
                // multiple courses
                database.add("CISC 121", 1234);
                database.add("CISC 121", 2345);
                database.add("CISC 121", 3456);
                database.add("CISC 124", 4567);
                database.add("CISC 124", 5678);
                database.add("CISC 124", 6789);
                database.add("CISC 203", 4567);
                database.add("CISC 203", 6789);
                database.add("CISC 203", 7890);
                database.add("CISC 220", 5678);
                database.add("CISC 220", 6789);                
            } 
        
            else if (choice == ADD_CHOICE) {
                System.out.print("course name: ");
                courseName = keyboard.nextLine();
                System.out.print("student id number: ");
                idnum = readInt();
                database.add(courseName, idnum);
            }
            
            else if (choice == REMOVE_CHOICE) {
                System.out.print("course name: ");
                courseName = keyboard.nextLine();
                System.out.print("student id number: ");
                idnum = readInt();
                database.remove(courseName, idnum);
            }
            
            else if (choice == COURSES_CHOICE) {
                System.out.print("student id number: ");
                idnum = readInt();
                Set<String> courseSet = database.courses(idnum);
                if (courseSet.isEmpty())
                    System.out.println("This student is not taking any courses.");
                else
                    System.out.println("This student is taking " + courseSet);
            }
            
            else if (choice == ALL_STUDENTS_CHOICE) {
                System.out.println("Students in the school: " + database.allStudents());
            } // end if
            
            else if (choice == WITHDRAW) {
                System.out.print("student id number: ");
                idnum = readInt();
                database.withdraw(idnum);
            } // end if
            
            else if (choice == CHECK) {
                System.out.println("removing all negative student ids");
                database.check();
            }
            
            else if (choice == QUIT_CHOICE) {
                break;
            }    
               
            else {
                System.out.println("unknown choice; please try again");
            } // end if
            
            // After each operation, display the contents of the database
            System.out.println();
            database.report();
            System.out.println();            
        } // end while
        
        System.out.println("End of database test program.");
        
    } // end main
    
} // end class DatabaseTest    
            

