package service;

import repository.UserRepository;
import repository.PublicationRepository;
import model.Publication;

public class LibraryService {
    private UserRepository userRepo;
    private PublicationRepository pubRepo;

    public LibraryService(UserRepository userRepo, PublicationRepository pubRepo) {
        this.userRepo = userRepo;
        this.pubRepo = pubRepo;
    }

    public void addUser(String name, String type) {
        userRepo.add(name, type);
    }

    public void addPublication(String title, String type, int totalCopies) {
        pubRepo.add(title, type, totalCopies);
    }

    public void borrow(int pubId) {
        Publication p = pubRepo.findById(pubId);
        if (p == null) {
            System.out.println("Publication not found!");
            return;
        }
        if (p.borrow()) {
            System.out.println("Borrowed: " + p.getTitle());
        } else {
            System.out.println("Not available!");
        }
    }

    public void returnCopy(int pubId) {
        Publication p = pubRepo.findById(pubId);
        if (p == null) {
            System.out.println("Publication not found!");
            return;
        }
        p.returnCopy();
        System.out.println("Returned: " + p.getTitle());
    }

    public void listPublications() {
        for (Publication p : pubRepo.getAll()) {
            System.out.println(p.getTitle());
        }
    }

    public void search(String title) {
        for (Publication p : pubRepo.searchByTitle(title)) {
            System.out.println("Found: " + p.getTitle());
        }
    }
}