import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("Mau so khong hop le");
            return;
        }
        this.denominator = denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.getNumerator() * other.getDenominator() +
                this.getDenominator() * other.getNumerator();
        int newDenominator = (this.getDenominator() * other.getDenominator());
        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.getNumerator() * other.getDenominator() -
                this.getDenominator() * other.getNumerator();
        int newDenominator = this.getDenominator() * other.getDenominator();
        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.getNumerator() * other.getNumerator();
        int newDenominator = this.getDenominator() * other.getDenominator();
        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public Fraction divide(Fraction other) {
        int newNumerator = this.getNumerator() * other.getDenominator();
        int newDenominator = this.getDenominator() * other.getNumerator();
        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public Fraction simplify(Fraction f) {
        int greatestCommonDivisor = 0;
        int loop = 0;

        if (f.getNumerator() >= f.getDenominator()) {
            loop = getDenominator();
        } else loop = f.getDenominator();
        for (int i = loop; i > 0; i--) {
            if (f.getNumerator() % i == 0 && f.getDenominator() % i == 0) {
                greatestCommonDivisor = i;
                break;
            }
        }
        return new Fraction(f.getNumerator() / greatestCommonDivisor,
                f.getDenominator() / greatestCommonDivisor);
    }

    @Override
    public String toString() {
        if (denominator == 0) {
            return "Phân số không hợp lệ (mẫu = 0)";
        }

        if (denominator == 1) {
            return String.valueOf(numerator); // in nguyên số nếu mẫu là 1
        }

        if (numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return numerator + "/" + denominator;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap tu so cua phan so thu nhat: ");
        int numerator = Integer.parseInt(input.nextLine());
        System.out.print("Nhap mau so cua phan so thu nhat: ");
        int denominator = Integer.parseInt(input.nextLine());
        Fraction fraction = new Fraction(numerator, denominator);

        System.out.print("Nhap tu so cua phan so thu hai: ");
        int numerator2 = Integer.parseInt(input.nextLine());
        System.out.print("Nhap mau so cua phan so thu hai: ");
        int denominator2 = Integer.parseInt(input.nextLine());
        Fraction fraction2 = new Fraction(numerator2, denominator2);

        System.out.println("Tong cua 2 phan so la: " + fraction.simplify(fraction.add(fraction2)).toString());
        System.out.println("Hieu cua 2 phan so la: " + fraction.simplify(fraction.subtract(fraction2)).toString());
        System.out.println("Tich cua 2 phan so la: " + fraction.simplify(fraction.multiply(fraction2)).toString());
        System.out.println("Thuong cua 2 phan so la: " + fraction.simplify(fraction.divide(fraction2)).toString());
    }
}

