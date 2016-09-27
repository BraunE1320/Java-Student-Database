/* ERIC BRAUN 10121660
 * 13eb20@queensu.ca
 * CISC 124 Assignment 6, April 14th 2015
 * 
 * 
 * 
 */
import java.util.*;
public class StudentDatabase {
    
    // Create tree sets for student numbers and course names
    private TreeSet studentTree = new TreeSet();
    private TreeSet courseTree = new TreeSet();
    
    // INSTANCE VARIABLES
    
    // The database is a map from course names (strings) to sets of students (StudentSets).
    //private Map<String,StudentSet> courseMap = new TreeMap<String,StudentSet>();
    
    // An object of this inner class contains nothing but a set of student ID numbers.
    // The main reason for defining this class is to avoid really ugly notation like
    // "Map<String,TreeSet<Integer>>".  
    private class StudentSet extends TreeSet<Integer> {
        // It's perfectly legal in Java to define a subclass like this that doesn't
        // add anything to its parent class or override anything from its parent
        // class.  You don't even need a constructor because this class will inherit
        // the zero-parameter constructor of its parent.
        
        // You may leave this class empty if you want, but in my solution I found that
        // it was convenient to add some methods to this class -- helper methods that
        // operated on sets of integers only, not on whole maps.  
        
    } // end inner class
    
    
    // Prints a report on the standard output, listing all the courses and all the
    // students in each.  The format should be similar to the output format shown on 
    // the web page.   If the map is completely empty (no courses), prints a message
    // saying that instead of printing nothing.
    void report() {
        
        // Create iterators to run through both tree sets
       Iterator<String> studentIterator = studentTree.iterator();
       Iterator<String> courseIterator = courseTree.iterator();
       while (studentIterator.hasNext()) {
           System.out.println(studentIterator.next());
           while (courseIterator.hasNext()) {
               
               System.out.println(courseIterator.next());
            }
        }
        // If the tree sets are empty
       if (studentTree.isEmpty()){
           System.out.println("No students enrolled");
        }
        else if (courseTree.isEmpty()) {
            System.out.println("No classes input");
        }
    } // end report
    
    // Adds a student to a course.  If the student is already in the course, no change (not an error).
   // If the course doesn't already exist, adds it to the database before adding the student.
    public void add(String courseName, Integer student) {
        courseTree.add(courseName);
        String studentNum = String.valueOf(student);
        studentTree.add(studentNum);
    } // end add
    
    // Removes a student from a course.  If the student is not in the course, or the course
    // does not exist, no change (not an error).
    // If this removes the last student from the course, the course goes away.
    public void remove(String courseName, Integer student) {
        courseTree.remove(courseName);
        String studentNum = String.valueOf(student);
        studentTree.remove(studentNum);
    } // end remove
    
    // Returns a set of all the courses a student is taking.  If the student is not taking any courses,
    // returns an empty set (not an error).
    public Set<String> courses(Integer student) {
        return new TreeSet<String>(); // stub
    } // end courses
    
    // Returns a set of all the students in the school (i.e. every student taking at least one course).
    public Set<Integer> allStudents() {
        return new TreeSet<Integer>(); // stub
    } // end allStudents
    
    // Removes a student from all their courses.  If this empties out a course, the course goes away.
    public void withdraw(Integer student) {
        // stub
    } // end withdraw
    
    // Negative student ids are illegal, but the other methods don't check for them.
    // This method should remove all negative student ids from the database.  If this
    // empties out a course, the course goes away.
    public void check() {
        // stub
    } // end check
    
} // end class