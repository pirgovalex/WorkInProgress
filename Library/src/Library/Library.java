package Library;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

abstract class Library {
    private static String libName;
    private static String address;
    private static int employeeCount;
    protected List<Book> books;
    protected List<Library> libraries;

    public Library(String libName, String address, int employeeCount, List<Book> books) {
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public Library(String libName, String address, int employeeCount, List<Book> books, List<Library> libraries) {
        try {
            setLibName(libName);
            setAddress(address);
            setEmployeeCount(employeeCount);
            this.books = books != null ? books : new ArrayList<>();
            this.libraries = libraries != null ? libraries : new ArrayList<>();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Library() {
        this.books = new ArrayList<>();
        this.libraries = new ArrayList<>();
    }

    public static String getLibName() {
        return libName;
    }

    public static void setLibName(String libName) {Library.libName = libName;}
     /*   try {
            if (libName == null || libName.length() > 100) {
                throw new IllegalArgumentException("The library name is too long or empty!");
            } else {
                Library.libName = libName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) { Library.address = address;
        /*try {
            if (address == null || address.length() > 500) {
                throw new IllegalArgumentException("The address cannot be empty and must be less than 500 characters!");
            } else {
                Library.address = address;
            }ostavqm tezi komentari za da pokaja general ideata mi predi tozi kod koito pushvam rn

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }*/
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Library.employeeCount = employeeCount;
       /* try {
            if (employeeCount > 50 || employeeCount <1) {
                throw new IllegalArgumentException("The number of employees must be between 0 and 50!");
            } else {
                Library.employeeCount = employeeCount;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }*/
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {

    }

    public void printLibrary() {

    }
}
