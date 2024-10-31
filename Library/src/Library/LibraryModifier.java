package Library;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class LibraryModifier {
    private PublicLibrary Plibrary;
    private Library library;
    public LibraryModifier(PublicLibrary Plibrary){
        this.Plibrary=Plibrary;

    }

    public LibraryModifier(){

    }
    public void addBookInput(){
        Book book = new Book();
       Scanner scanner = new Scanner(System.in);


        System.out.println("Enter title ");
        book.setTitle(scanner.nextLine());

        System.out.println("Enter genre");
        book.setGenre(scanner.nextLine());

        System.out.println("Enter author");
        book.setAuthor(scanner.nextLine());

        System.out.println("Enter publisher");
        book.setPublisher(scanner.nextLine());

        System.out.println("Enter year of manufacture");
        book.setYear(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter isbn");
        book.setIsbn(scanner.next());

        System.out.println("Enter number of pages");
        book.setPageCount(scanner.nextInt());

        System.out.println("Enter language");
        book.setLanguage(scanner.next());

        book.setAvailable(false);
        System.out.println("Borrowing period");
        book.setBorrowingPeriod(scanner.nextInt());

        addNewBook(book);
        scanner.close();
    }

    public void addNewBook(Book book) {

        Plibrary.addBook(book);
    }
}
