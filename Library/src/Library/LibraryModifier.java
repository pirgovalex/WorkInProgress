package Library;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryModifier {
    private PublicLibrary Plibrary;
    private Scanner sc = new Scanner(System.in);

    public LibraryModifier(PublicLibrary Plibrary) {
        this.Plibrary = Plibrary;
    }

    // Display main menu and handle user actions
    public void displayMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Library Information");
            System.out.println("2. Add Book to Library");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book from Library");
            System.out.println("5. Update Book in Library");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {//moderen switch! kazahte che go predpochitate
                case 1 -> addLibraryInfo();
                case 2 -> addBookInput();
                case 3 -> searchBookInput();
                case 4 -> deleteBookInput();
                case 5 -> updateBookInput();
                case 6 -> displayAllBooks();
                case 7 -> {
                    System.out.println("Exiting...");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add library information
    public void addLibraryInfo() {
        System.out.println("Enter library's name: ");
        Library.setLibName(sc.nextLine());

        System.out.println("Enter library's address: ");
        Library.setAddress(sc.nextLine());

        System.out.println("Enter number of employees: ");
        Library.setEmployeeCount(Integer.parseInt(sc.nextLine()));
    }

    //  new book
    public void addBookInput() {
        Book book = new Book();
        try {
            System.out.println("Enter title: ");
            book.setTitle(sc.nextLine());

            System.out.println("Enter genre: ");
            book.setGenre(sc.nextLine());

            System.out.println("Enter author: ");
            book.setAuthor(sc.nextLine());

            System.out.println("Enter publisher: ");
            book.setPublisher(sc.nextLine());

            System.out.println("Enter year of manufacture: ");
            book.setYear(Integer.parseInt(sc.nextLine()));

            System.out.println("Enter ISBN: ");
            book.setIsbn(sc.nextLine());

            System.out.println("Enter number of pages: ");
            book.setPageCount(Integer.parseInt(sc.nextLine()));

            System.out.println("Enter language: ");
            book.setLanguage(sc.nextLine());

            System.out.println("Enter borrowing period (in days): ");
            book.setBorrowingPeriod(Integer.parseInt(sc.nextLine()));

            System.out.println("Enter borrowing date (yyyy-mm-dd) or leave blank if not borrowed: ");
            String borrowingDateInput = sc.nextLine();
            if (!borrowingDateInput.isBlank()) {
                book.setBorrowedDate(LocalDate.parse(borrowingDateInput));
            }
            book.setBorrowBook();

            Plibrary.addBook(book);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Discarding book and returning to main menu.");
        }
    }

    // Search for a book by title
    public void searchBookInput() {
        System.out.println("Enter title of the book to search: ");
        Book foundBook = Plibrary.searchBookByTitle(sc.nextLine());
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook.getTitle());
        }
    }

    // Delete a book by title
    public void deleteBookInput() {
        System.out.println("Enter title of the book to delete: ");
        Plibrary.deleteBookByTitle(sc.nextLine());
    }

    // Update book details
    public void updateBookInput() {
        System.out.println("Enter title of the book to update: ");
        Book bookToUpdate = Plibrary.searchBookByTitle(sc.nextLine());
        if (bookToUpdate != null) {
            System.out.println("Enter new genre: ");
            bookToUpdate.setGenre(sc.nextLine());

            System.out.println("Enter new author: ");
            bookToUpdate.setAuthor(sc.nextLine());

            System.out.println("Enter new publisher: ");
            bookToUpdate.setPublisher(sc.nextLine());

            System.out.println("Book updated successfully.");
        }
    }

    // Display all books in the library
    public void displayAllBooks() {
        System.out.println("\nLibrary Books:");
        Plibrary.listAllBooks();
    }
}
