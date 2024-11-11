import Library.LibraryModifier;
import Library.PublicLibrary;


public class Main {
    public static void main(String[] args) {

        PublicLibrary library = new PublicLibrary();
        LibraryModifier libraryModifier = new LibraryModifier(library);

        libraryModifier.gatheringData();
        libraryModifier.printBooks();

    }
}