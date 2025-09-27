package Constructors;

import java.util.Scanner;

/*  Title : Implement Cloneable interface to allow cloning ( with same BookAccess.java )

An Object of a class is not by default cloneable. 
To create a clone of the object, you will need to create an object and explicitly use "setters" and "getters". 
This technique is not ideal ( setter and getter ), espcially when the class has too many attributes. 
So, Java provides the "Cloneable interface" for this purpose. */


 class Book implements Cloneable {
    private String title;
    private String author;
    private float price;

    public Book() {
        this.title = null;
        this.author = null;
    }

    // overloaded constructor
    public Book(String title, String author, float price) { 
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Overriding the clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public float getPrice() {
        return this.price;
    }

    public String toString() {
        return "Title - " + this.title + "\nAuthor - "
            + this.author + "\nPrice - "+ String.format("%.2f", this.price);
    }
}

public class Cloneable_interface {

    private static Book getExpensiveBook(Book book1, Book book2) {
        if (book1.getPrice()<book2.getPrice()) {
            return book2;
        } else {
            return book1;
        }
    }
    
    public static void main(String s[]) throws CloneNotSupportedException {

      ( with user interaction )
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println(	"Press 1 to view books, 2 to add books, "+
                                "3 to compare prices of books, any other key to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                for(int i=0;i<books.length;i++) {
                    if(books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if(bkIdx == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }
                System.out.println("Which constructor do you want to use? Press 1 for default,"+
                                    "any other key for overloaded constructor");
                String constructor = scanner.nextLine();
                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();
                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());
                if (constructor.equals("1")) {
                    Book bkTmp = new Book();
                    bkTmp.setTitle(tmpTitle);
                    bkTmp.setAuthor(tmpAuthor);
                    bkTmp.setPrice(tmpPrice);
                    books[bkIdx++] = bkTmp;
                } else {
                    books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);
                }
            } else if (userAction.equals("3")) {
                System.out.println("Enter index of first book to compare");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter index of second book to compare");
                int book2Idx = Integer.parseInt(scanner.nextLine());
                if (books[book1Idx] != null && books[book2Idx] != null ) {
                    System.out.println("The details of expensive book is \n"+getExpensiveBook(books[book1Idx],books[book2Idx]));
                } else {
                    System.out.println("One of the books is null");
                }
            } else {
                break;
            }
        }
    }
        
        /*  // Normal Code ( without user interaction )
        Book book1 = new Book("Atomic Habits", "James Clear", 30.00f);
        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);
        System.out.println("The first book object is ");
        System.out.println(book1);
        System.out.println("The second book object is ");
        System.out.println(book2);

        // object cloning ( cloning object )
        Book book3 = (Book)(book1.clone());
        System.out.println("The third book cloned object is ");
        System.out.println(book3);
        */
    
}
