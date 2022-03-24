package oop.labor05;

import oop.labor02.dateutil.MyDate;
import oop.labor05.models.Course;
import oop.labor05.models.Student;
import oop.labor05.models.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Course> courses=readCourses("courses.csv");
        for (Course course: courses){
            System.out.println(course);
        }
        ArrayList<Student> students=readStudents("students.csv");
        for (Student student: students){
            System.out.println(student);
        }
        ArrayList<Training> trainings = new ArrayList<>();;
        MyDate startDate= new MyDate(2022,03,21);
        MyDate endDate= new MyDate(2022,03,25);
        for (Course course : courses){
            trainings.add( new Training(course,startDate,endDate,rand.nextInt(1000,2000)));
            for (int i=0;i<10;i++){
                trainings.get(trainings.size()-1).enroll(students.get(rand.nextInt(0,students.size())));
           }
        }
        for (Training training:trainings){
            training.printToFile();
        }
        for(Student student:students){
            System.out.println("\n"+student+": ");
            for (Training training:trainings){
                if(training.findStudentById(student.getID())!=null){
                    System.out.println("  "+training);
                }
            }
        }
    }

    public static ArrayList<Course> readCourses(String fileName) {
        ArrayList<Course> courses = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                courses.add(new Course(items[0].trim(),items[1].trim(),Integer.parseInt(items[2].trim())));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public static ArrayList<Student> readStudents(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                students.add(new Student(items[0].trim(),items[1].trim(),items[2].trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
