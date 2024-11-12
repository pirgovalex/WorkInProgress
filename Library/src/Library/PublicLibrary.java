package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PublicLibrary extends Library {

    public PublicLibrary() {
        super();//blqblqblqblq
        this.books = new ArrayList<>();
    }

    // Add book to library
    @Override
    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        } else {
            System.out.println("Invalid book entry. Cannot add a null book.");
        }
    }

    // Delete book by title
    public void deleteBookByTitle(String title) {
        Book desiredBook = searchBookByTitle(title);
        if (desiredBook != null && this.books.remove(desiredBook)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found or could not be deleted.");
        }
    }

    // Search book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found!");
        return null;
    }


    //OBICHAM STREAMING I KOLEKTORIIII!!!!!!!!!
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        // a header
        String header = String.format("%-20s %-15s %-20s %-15s %-5s %-10s %-8s %-10s %-15s %-15s %-10s %-15s",
                "Title", "Genre", "Author", "Publisher", "Year", "ISBN", "Pages", "Language", "Available", "Borrowed Date", "Return Date", "Times Borrowed");
        System.out.println(header);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        // Details as a string & collect into a single output
        String table = books.stream()
                .map(book -> String.format("%-20s %-15s %-20s %-15s %-5d %-10s %-8d %-10s %-15s %-15s %-10s %-15s",
                        book.getTitle(),
                        book.getGenre(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getYear(),
                        book.getIsbn(),
                        book.getPageCount(),
                        book.getLanguage(),
                        (book.isAvailable() ? "Yes" : "No"),
                        (book.getBorrowedDate() != null ? book.getBorrowedDate().toString() : "N/A"),
                        (book.getReturnDate() != null ? book.getReturnDate().toString() : "N/A"),  // Show returnDate
                        book.getTimesBorrowed()
                ))
                .collect(Collectors.joining("\n"));
//fix times borroweeeed
        System.out.println(table);
    }


    @Override
    public void printLibrary() {
        System.out.println("Library Name: " + getLibName());
        System.out.println("Address: " + getAddress());
        System.out.println("Employee Count: " + getEmployeeCount());
        listAllBooks();
    }
}
