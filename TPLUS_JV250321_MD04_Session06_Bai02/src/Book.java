public class Book {
    private String title;
    private String author;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }  else {
            System.out.println("Gia khong duoc am");
        }
    }

    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.setTitle("Java Programming");
        myBook.setAuthor("John Doe");
        myBook.setPrice(29.99);

        System.out.println("Tieu de: " + myBook.getTitle());
        System.out.println("Tac gia: " + myBook.getAuthor());
        System.out.println("Gia: " + myBook.getPrice());

        myBook.setPrice(35.50);
        System.out.println("Gia moi: " + myBook.getPrice());

        myBook.setPrice(-5.00);
    }
}
