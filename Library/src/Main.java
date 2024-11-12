import Library.LibraryModifier;
import Library.PublicLibrary;

//mnogo iskam da izpolzvam stream interface-a ama honestly i ediniqt sluchai, v koito go polzvah v  tozi kod beshe bezmislen.
//ne vijdam kude moga

public class Main {
    public static void main(String[] args) {
        PublicLibrary library = new PublicLibrary();
        LibraryModifier libraryModifier = new LibraryModifier(library);
        libraryModifier.displayMenu();
    }
}
//napravih tazi zadacha 3 puti ot scratch :D ne me kefeshe kak obrabotvah dannite