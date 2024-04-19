import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;
    private final String FILE_PATH = "/Users/baongoc/Workspace/Java2023/AT_EXAM__c0324m2-at101_VuongBaoNgoc/students.csv";

    public StudentManager() {
        studentList = new ArrayList<>();
        loadStudentsFromFile();
    }

    private void loadStudentsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], Double.parseDouble(data[5]));
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveStudentsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : studentList) {
                bw.write(student.getStudentId() + "," + student.getFullName() + "," + student.getAge() + "," +
                        student.getGender() + "," + student.getAddress() + "," + student.getGpa());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        studentList.add(student);
        saveStudentsToFile();
        System.out.println("Thêm sinh viên thành công!");
    }
    public void updateStudent(Student updatedStudent) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(updatedStudent.getStudentId())) {
                student.setFullName(updatedStudent.getFullName());
                student.setAge(updatedStudent.getAge());
                student.setGender(updatedStudent.getGender());
                student.setAddress(updatedStudent.getAddress());
                student.setGpa(updatedStudent.getGpa());
                break;
            }
        }
        saveStudentsToFile();
        System.out.println("Cập nhật thông tin sinh viên thành công!");
    }


    public void deleteStudent(String studentId) {
        studentList.removeIf(student -> student.getStudentId().equals(studentId));
        saveStudentsToFile();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void displayStudentList() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
