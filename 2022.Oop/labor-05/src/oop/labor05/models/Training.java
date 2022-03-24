package oop.labor05.models;

import oop.labor02.dateutil.MyDate;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student>enrolledStudents;

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
        this.enrolledStudents = new ArrayList<>();
    }

    public Course getCourse() {
        return course;
    }

    public boolean enroll(Student student){
        if (findStudentById(student.getID())==null)
        {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public Student findStudentById(String ID){
        for(Student student:enrolledStudents){
            if(student.getID()==ID){
                return student;
            }
        }
        return null;
    }
    public int findStudentById2(String ID){
        for(int i=0;i<enrolledStudents.size();i++){
            if(enrolledStudents.get(i).getID()==ID){
                return i;
            }
        }
        return -1;
    }

    public int numEnrolled(){
        return enrolledStudents.size();
    }

    public void printToFile(){
        String fileName=String.format("%s_%s_%s.csv",course.getName(),startDate,endDate);
        try(PrintStream printStream= new PrintStream(fileName)){
            printStream.println(course.getName());
            printStream.println(startDate);
            printStream.println(endDate);
            printStream.println(pricePerStudent);
            for (Student enrolledStudent : enrolledStudents) {
                printStream.println(enrolledStudent);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void unEnroll(String student){
        enrolledStudents.remove(findStudentById2(student));
    }

    @Override
    public String toString() {
        return "Training{" +
                "course=" + course +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pricePerStudent=" + pricePerStudent +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}
