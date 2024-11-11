package Library;
import java.util.Scanner;
import java.util.List;

public class PublicLibrary extends Library {


    public PublicLibrary() {
        super();
    }


    public PublicLibrary(String libName, String address, int employeeCount, List<Book> books,List<Library> libraries) {
        super(libName, address, employeeCount, books,libraries);
    }

    public PublicLibrary(String name, String address, int employeeCount) {
    }


    public void addLibraryWithScanner() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the library name:");
        String name = sc.nextLine();
        setLibName(name);

        System.out.println("Enter the library address:");
        String address = sc.nextLine();
        setAddress(address);

        System.out.println("Enter the number of employees:");
        int employeeCount = sc.nextInt();
        setEmployeeCount(employeeCount);
        sc.nextLine();


        PublicLibrary newLibrary = new PublicLibrary(name, address, employeeCount);


        libraries.add(newLibrary);
        printLibrary();
        System.out.println("Library added successfully.");
    }

    @Override
    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        } else {
            System.out.println("Invalid book entry. Cannot add a null book.");
        }
    }

   /* public void deleteBookByTitle(String title) {
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                this.books.remove(book); осъзнах, че няма да стане, докато итерирам по листа : )
            }

        }
    }*/

    public void deleteBookByTitle(String title ){
        Book desiredBook=searchBookByTitle(title);
        removeBook(desiredBook);
    }
    public boolean removeBook(Book book) {
        return this.books.remove(book);
    }

    //search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }

        }
        System.out.println("Book not found!");
        return null; //  not found
    }

    // list all books
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", ISBN: " + book.getIsbn());
            }
        }
    }
    @Override
    public void printLibrary() {
        // Print the library's basic details
        System.out.println("Library Name: " + getLibName());
        System.out.println("Address: " + getAddress());
        System.out.println("Employee Count: " + getEmployeeCount());

        // Print the list of books in the library
        System.out.println("Books in this library:");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getYear());
            }
        }
    }
}
