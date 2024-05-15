package in.maxwell.m2024b.student_using_database;

import java.io.Serializable;

public class Student implements Serializable {

    String studentId;
    String studentFirstName;
    String studentLastName;
    int gender;
    String city;

    boolean isUpdated;

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }

    public Student() {
    }

    public Student(String studentId, String studentFirstName, String studentLastName, int gender, String city) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.gender = gender;
        this.city = city;
        isUpdated = false;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("studentId='").append(studentId).append('\'');
        sb.append(", studentFirstName='").append(studentFirstName).append('\'');
        sb.append(", studentLastName='").append(studentLastName).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
