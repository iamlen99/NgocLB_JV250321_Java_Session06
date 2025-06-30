import java.util.Scanner;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(){
        this.length =  1;
        this.width = 1;
    }

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return this.length * this.width;
    }

    public double getPerimeter(){
        return (this.length + this.width) * 2;
    }

    public void display() {
        System.out.println("Chieu dai: " + length);
        System.out.println("Chieu rong: " + width);
        System.out.println("Dien tich: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Hinh chu nhat 1:");
        rectangle1.display();

        System.out.println();

        System.out.printf("Nhap chieu dai: ");
        double length = Double.parseDouble(sc.nextLine());

        System.out.printf("Nhap chieu rong: ");
        double width = Double.parseDouble(sc.nextLine());

        System.out.println("Hinh chu nhat 2:");
        Rectangle rectangle2 = new Rectangle(length, width);
        rectangle2.display();
    }
}
