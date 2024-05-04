import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--");
            System.out.println("Chọn chức năng theo số:");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Danh sách sinh viên:");
                    studentManager.displayStudentList();
                    break;
                case 2:
                    System.out.println("Nhập thông tin sinh viên mới:");
                    String studentId;
                    boolean isDuplicate;
                    do {
                        System.out.print("Mã sinh viên: ");
                        studentId = scanner.nextLine();
                        isDuplicate = false;
                        for (Student existingStudent : studentManager.getStudentList()) {
                            if (existingStudent.getStudentId().equals(studentId)) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (isDuplicate) {
                            System.out.println("Mã sinh viên bị trùng lặp. Vui lòng nhập lại.");
                        }
                    } while (isDuplicate);

                    System.out.print("Họ tên: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Địa chỉ: ");
                    String address = scanner.nextLine();
                    System.out.print("Điểm trung bình: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    Student newStudent = new Student(studentId, fullName, age, gender, address, gpa);
                    studentManager.addStudent(newStudent);
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần cập nhật: ");
                    String updateStudentId = scanner.nextLine();
                    boolean isExisting = false;
                    for (Student existingStudent : studentManager.getStudentList()) {
                        if (existingStudent.getStudentId().equals(updateStudentId)) {
                            isExisting = true;
                            break;
                        }
                    }
                    if (!isExisting) {
                        System.out.println("Không tìm được sinh viên với mã sinh viên trên. Vui lòng nhập lại.");
                        break;
                    }
                    System.out.println("Nhập thông tin sinh viên mới:");
                    System.out.print("Họ tên: ");
                    fullName = scanner.nextLine();
                    System.out.print("Tuổi: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Giới tính: ");
                    gender = scanner.nextLine();
                    System.out.print("Địa chỉ: ");
                    address = scanner.nextLine();
                    System.out.print("Điểm trung bình: ");
                    gpa = scanner.nextDouble();
                    scanner.nextLine();
                    Student updatedStudent = new Student(updateStudentId, fullName, age, gender, address, gpa);
                    studentManager.updateStudent(updatedStudent);
                    break;

                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String deleteStudentId = scanner.nextLine();

                    isExisting = false;
                    for (Student existingStudent : studentManager.getStudentList()) {
                        if (existingStudent.getStudentId().equals(deleteStudentId)) {
                            isExisting = true;
                            break;
                        }
                    }
                    if (!isExisting) {
                        System.out.println("Mã sinh viên không tồn tại. Không thể xóa sinh viên.");
                    } else {
                        studentManager.deleteStudent(deleteStudentId);
                        System.out.println("Xóa sinh viên thành công!");
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
