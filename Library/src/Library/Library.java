package Library;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


abstract class Library {



    private static String libName;
    private static String address;
    private static int employeeCount;
    protected  static List<Book> books;


    public Library(String libName,String address,int employeeCount,List<Book> books) {
        setLibName(libName);

        setAddress(address);

        setEmployeeCount(employeeCount);

        this.books=new ArrayList<>();

    }
    public Library(){

    }

    public static String getLibName() {

        return libName;
    }

    public static void setLibName(String libName) {
        if(libName==null||libName.length()>100){
            throw new IllegalArgumentException("Името на библиотеката е твъърде дълго или празно!");
        }
        else Library.libName = libName;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        if(address==null||address.length()>500) throw new IllegalArgumentException("Адресът тр" +
                "ябва да не е празен и да не е над 500 char!");
        else Library.address = address;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        if(employeeCount>50||employeeCount<0){
            throw new IllegalArgumentException("Броят на работниците трябва да е между 50 и 0!");
        }
        else Library.employeeCount = employeeCount;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void setBooks(List<Book> books) {
        Library.books = books;
    }

    public void addBook(Book book){
        books.add(book);
    }

}

