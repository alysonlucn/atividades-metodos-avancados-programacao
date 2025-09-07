package view;

import repository.UserRepository;
import repository.PublicationRepository;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
        PublicationRepository pubRepo = new PublicationRepository();
        LibraryService library = new LibraryService(userRepo, pubRepo);

        library.addUser("Ana", "Student");
        library.addUser("Carlos", "Teacher");

        library.addPublication("Java Basics", "Book", 2);
        library.addPublication("Science Today Magazine", "Magazine", 1);

        library.listPublications();

        library.borrow(1);
        library.borrow(2);
        library.borrow(2);

        library.returnCopy(1);

        library.search("java");
    }
}