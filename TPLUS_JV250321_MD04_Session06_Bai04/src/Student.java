import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private String Class;
    private double avgScore;

    public Student(String name, int age, String Class,  double avgScore) {
        this.name = name;
        this.age = age;
        this.Class = Class;
        this.avgScore = avgScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAClass() {
        return Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student [] students  = new Student [50];
        students[0] = new Student("Bob", 21, "A1", 7.0);
        students[1] = new Student("Alice", 21, "A1", 5.0);
        students[2] = new Student("John", 21, "A1", 4.8);
        students[3] = new Student("Eve", 20, "A1", 8.0);
        students[4] = new Student("Len", 21, "A1", 9.0);
        int currentIndex = 5;

        System.out.print("Nhap diem min: ");
        double minScore = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap diem max: ");
        double maxScore = Double.parseDouble(sc.nextLine());

        System.out.printf("Danh sach sinh vien co diem trung binh tu %.1f den %.1f:\n", minScore, maxScore);
        for (int i = 0; i < currentIndex; i++) {
            if(students[i].getAvgScore() >= minScore &&  students[i].getAvgScore() <= maxScore){
                System.out.printf("Ten: %s, Tuoi: %d, Lop: %s, Diem trung binh: %.1f\n", students[i].getName(),
                        students[i].getAge(), students[i].getAClass(), students[i].getAvgScore());
            }
        }

    }
}
