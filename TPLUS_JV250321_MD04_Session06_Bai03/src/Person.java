import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nguoi thu nhat: ");
        String personName1 = sc.nextLine();
        System.out.print("Nhap tuoi nguoi thu nhat: ");
        int personAge1 = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ten nguoi thu hai: ");
        String personName2 = sc.nextLine();
        System.out.print("Nhap tuoi nguoi thu hai: ");
        int personAge2 = Integer.parseInt(sc.nextLine());


        Person person1 = new Person(personName1, personAge1);
        Person person2 = new Person(personName2, personAge2);
        if (person1.getAge() > person2.getAge()) {
            System.out.println(person1.getName() + " lon tuoi hon " + person2.getName());
        } else if (person1.getAge() < person2.getAge()) {
            System.out.println(person2.getName() + " lon tuoi hon " + person1.getName());
        } else {
            System.out.println("Tuoi cua 2 nguoi bang nhau");
        }
    }
}
