public class Student {
    private String studentId;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    private double gpa;

    public Student(String studentId, String fullName, int age, String gender, String address, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Mã sinh viên: " + studentId + ", Họ tên: " + fullName + ", Tuổi: " + age + ", Giới tính: " + gender + ", Địa chỉ: " + address + ", Điểm trung bình: " + gpa;

    }
}
