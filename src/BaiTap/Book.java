package BaiTap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private float price;

    public Book() {
    }

    public Book(String isbn, String bookName, String author, String publisher, float price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Book Name: " + bookName + ", Author: " + author + ", Publisher: " + publisher + ", Price: " + price;
    }
}

class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void inputBooks(int n) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            System.out.print("ISBN: ");
            String isbn = reader.readLine();
            System.out.print("Book Name: ");
            String bookName = reader.readLine();
            System.out.print("Author: ");
            String author = reader.readLine();
            System.out.print("Publisher: ");
            String publisher = reader.readLine();
            System.out.print("Price: ");
            float price = Float.parseFloat(reader.readLine());
            books.add(new Book(isbn, bookName, author, publisher, price));
        }
    }

    public void displayBooks() {
        System.out.println("\n--- Book Information ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayBooksSortedByPriceDescending() {
        // Sort using a custom comparator
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Float.compare(b2.getPrice(), b1.getPrice()); // Descending order
            }
        });
        System.out.println("\n--- Book Information Sorted by Price (Descending) ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of books: ");
        int n = Integer.parseInt(reader.readLine());

        BookManager manager = new BookManager();
        manager.inputBooks(n);
        manager.displayBooks();
        manager.displayBooksSortedByPriceDescending();
    }
}