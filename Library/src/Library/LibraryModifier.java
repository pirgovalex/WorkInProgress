package Library;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class LibraryModifier {
    private PublicLibrary Plibrary;
    private Scanner sc = new Scanner(System.in);

    public LibraryModifier(PublicLibrary Plibrary) {
        this.Plibrary = Plibrary;

    }

    public LibraryModifier() {
        this.Plibrary = new PublicLibrary();
    }

    public void addBookInput() {
        Book book = new Book();

        // Library information
        System.out.println("Enter library's name: ");
        while (true) {
            String libNameInput = sc.nextLine();
            if (libNameInput.isBlank()) {
                System.out.println("Library name cannot be empty. Please enter a valid library name.");
            } else {
                Library.setLibName(libNameInput);
                break;
            }
        }

        System.out.println("Set address: ");
        while (true) {
            String addressInput = sc.nextLine();
            if (addressInput.isBlank() || addressInput.length() > 500) {
                System.out.println("Address cannot be empty and must be less than 500 characters. Please try again.");
            } else {
                Library.setAddress(addressInput);
                break;
            }
        }

        System.out.println("How many employees? ");
        while (true) {
            try {
                int employeeCountInput = sc.nextInt();
                sc.nextLine();  // Consume the newline character
                if (employeeCountInput > 0 && employeeCountInput <= 50) {
                    Library.setEmployeeCount(employeeCountInput);
                    break;
                } else {
                    System.out.println("The number of employees must be between 1 and 50. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for the number of employees.");
            }
        }

        // Book information
        System.out.println("Enter title: ");
        while (true) {
            String titleInput = sc.nextLine();
            if (titleInput.isBlank() || titleInput.length() > 100) {
                System.out.println("Invalid title! The title cannot be empty and must be less than 100 characters. Please try again.");
            } else {
                book.setTitle(titleInput);
                break;
            }
        }

        System.out.println("Enter genre: ");
        book.setGenre(sc.nextLine());

        System.out.println("Enter author: ");
        while (true) {
            String authorInput = sc.nextLine();
            if (authorInput.isBlank() || authorInput.length() > 100) {
                System.out.println("Invalid author name! The name cannot be empty and must be less than 100 characters. Please try again.");
            } else {
                book.setAuthor(authorInput);
                break;
            }
        }

        System.out.println("Enter publisher: ");
        while (true) {
            String publisherInput = sc.nextLine();
            if (publisherInput.isBlank() || publisherInput.length() > 50) {
                System.out.println("Invalid publisher! Publisher name cannot be empty and must be less than 50 characters. Please try again.");
            } else {
                book.setPublisher(publisherInput);
                break;
            }
        }

        System.out.println("Enter year of manufacture: ");
        while (true) {
            try {
                int yearInput = Integer.parseInt(sc.nextLine());
                book.setYear(yearInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid year (numeric).");
            }
        }

        System.out.println("Enter ISBN: ");
        while (true) {
            String isbnInput = sc.nextLine();
            if (isbnInput.isBlank() || isbnInput.length() > 10) {
                System.out.println("Invalid ISBN! The ISBN cannot be empty and must be less than 10 characters. Please try again.");
            } else {
                book.setIsbn(isbnInput);
                break;
            }
        }

        System.out.println("Enter number of pages: ");
        while (true) {
            try {
                int pageCountInput = Integer.parseInt(sc.nextLine());
                if (pageCountInput > 0) {
                    book.setPageCount(pageCountInput);
                    break;
                } else {
                    System.out.println("Number of pages must be positive. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for the number of pages.");
            }
        }

        System.out.println("Enter language: ");
        book.setLanguage(sc.nextLine());

        book.setAvailable(false);
        System.out.println("Enter borrowing period: ");
        while (true) {
            try {
                int borrowingPeriodInput = Integer.parseInt(sc.nextLine());
                book.setBorrowingPeriod(borrowingPeriodInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid borrowing period (numeric).");
            }
        }

        System.out.println("Enter borrowing date (yyyy-mm-dd) or leave blank if not borrowed: ");
        String borrowingDateInput = sc.nextLine();
        if (!borrowingDateInput.isBlank()) {
            book.setBorrowedDate(LocalDate.parse(borrowingDateInput));
        }

        Plibrary.addBook(book);
    }

       /* System.out.println("Enter return date (yyyy-mm-dd):");
        String returnDateInput = sc.nextLine();
        if (!returnDateInput.isBlank()) {
            book.setReturnDate(LocalDate.parse(returnDateInput));
        }*/



  public boolean activeLibrary(){
        int  timesIterated = 0;
      System.out.println("What would you like to do bro??\n STOP|NO|S to stop program, CONTINUE|YES|C to continue");

      String decision = sc.nextLine();
      boolean isOperationRunning;

      switch (decision.toUpperCase()){
          case "STOP","S","NO" ->
                  isOperationRunning=false;
          
          case "YES","C", "CONTINUE"->{
              
              isOperationRunning=true;
              
          }
          default ->{
              isOperationRunning=false;
              throw new IllegalArgumentException("INVALID OPERATION!");

          }
      }
      return isOperationRunning;
  }
    public  void gatheringData(){
        boolean isOperationRunning = activeLibrary();
        while (isOperationRunning){
            Plibrary.addLibraryWithScanner();
            addBookInput();

           isOperationRunning= activeLibrary();
        }


    }
    public void addNewBook(Book book) {

        Plibrary.addBook(book);
    }
    public void printBooks(){
        for(Book book: Plibrary.books){
                    System.out.println("Title: " + book.getTitle()+ "\nGenre: " +book.getGenre()+ "\nAuthor:  "
                    +book.getAuthor()+ "\nPublisher:  " +book.getPublisher()
                    + "\n Year:  " +book.getYear()+ "\nISBN:  " +book.getIsbn()+ "\nPage count:  "
                    +book.getPageCount()+ "\nLanguage " +book.getLanguage()+ "\nAvailable " +(book.isAvailable()? "It is":"It is not")
                    + "\nWhen was it take? " +book.getBorrowedDate()+ "\n Return date: " +book.getReturnDate()+
                    "\n Borrowing period:  " +book.getBorrowingPeriod()+ "\n Times borrowed:  " +book.getTimesBorrowed());
        }

    }
}
