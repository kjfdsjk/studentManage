package manageStudent.service;

import manageStudent.student.Student;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WriteNRead {
    public static void writeFIle(List<Student> list) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\demo13\\src\\main\\java\\manageStudent\\service\\studentsData.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder string = new StringBuilder("ID,Name,Age,Gender,Address,AverageScore\n");
        for (Student student : list) {
            string.append(student.getId()).append(",").append(student.getName()).append(",").append(student.getAge()).append(",").append(student.getGender()).append(",").append(student.getAddress()).append(student.getAverageScore()).append("\n");
        }
        bufferedWriter.write(string.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Student> readFile() throws IOException {
        List<Student> studentList = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\Admin\\IdeaProjects\\demo13\\src\\main\\java\\manageStudent\\service\\studentsData.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data = bufferedReader.readLine();
        while ((data = bufferedReader.readLine()) != null) {
            String[] valve = data.split(",");
            int id = Integer.parseInt(valve[0]);
            String name = valve[1];
            int age = Integer.parseInt(valve[2]);
            String gender = valve[3];
            String address = valve[4];
            int averageScore = Integer.parseInt(valve[5]);
            Student student = new Student(id, name, age, gender, address, averageScore);
            studentList.add(student);
        }
        bufferedReader.close();
        fileReader.close();
        return studentList;
    }
}
