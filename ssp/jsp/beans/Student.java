package p1;

public class Student {
    private String name;
    private int prn;
    private String email;
    private int age;

    public Student() {
    }

    public Student(String name, int prn, String email, int age) {
        this.name = name;
        this.prn = prn;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", prn=" + prn +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
