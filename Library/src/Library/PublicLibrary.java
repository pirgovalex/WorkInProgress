package Library;
import java.util.List;

public class PublicLibrary extends Library {


    public PublicLibrary() {
    }

    public PublicLibrary(String libName, String address, int employeeCount, List<Book> books) {
        super(libName, address, employeeCount, books);
    }
}