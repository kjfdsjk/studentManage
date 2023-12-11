package manageStudent.service;

import manageStudent.student.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ManageStudent {
    List<Student> listStudent = new ArrayList<>();

    public ManageStudent() {
        listStudent.add(new Student(1, "A", 21, "male", "HaNoi", 45));
        listStudent.add(new Student(2, "B", 12, "female", "HoChiMinh", 90));
        listStudent.add(new Student(3, "C", 13, "male", "DaNang", 50));
        listStudent.add(new Student(4, "D", 16, "female", "HaNoi", 13));
        listStudent.add(new Student(5, "E", 18, "male", "SaPa", 65));
        listStudent.add(new Student(6, "R", 22, "male", "NamDinh", 62));
        listStudent.add(new Student(7, "ATY", 42, "female", "HaNoi", 82));
    }

    public List<Student> getListStudentList() {
        return listStudent;
    }

    public void addStudent(Student student) throws IOException {
        listStudent.add(student);
        WriteNRead.writeFIle("StudentFile.csv",listStudent);
    }

    public Student findByName(String name) {
        for (Student student : this.listStudent) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
        return null;
    }

    public Student findById(int id) {
        for (Student student : listStudent) {
            if (student.getId() == id) return student;
        }
        return null;
    }

    public void remove(int id) {
        int index = findProductIndexById(id);
        if (index != -1) {
            listStudent.remove(index);
            System.out.println("Product with ID " + id + " delete successfully.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void edit(int id, Student student) {
        int index = findProductIndexById(id);
        if (index != -1) {
            listStudent.set(index, student);
            System.out.println("Product with ID " + id + " updated successfully.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void sortUp() {
        listStudent.sort(Comparator.comparing(Student::getAverageScore));
    }

    public void sortDown() {
        listStudent.sort((a,b) -> Integer.compare(b.getAverageScore(),a.getAverageScore()));
    }

    public List<Student> showAll() {
        for (Student student : this.listStudent) {
            System.out.println(student);
        }
        return listStudent;
    }

    private int findProductIndexById(int id) {
        int index = -1;
        for (int i = 0; i < listStudent.size(); i++) {
            if (id == listStudent.get(i).getId()) {
                return i;
            }
        }
        return index;
    }
}
