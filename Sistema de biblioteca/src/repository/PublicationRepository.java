package repository;

import model.Publication;
import java.util.ArrayList;
import java.util.List;

public class PublicationRepository {
    private List<Publication> publications = new ArrayList<>();
    private int seq = 1;

    public Publication add(String title, String type, int totalCopies) {
        Publication p = new Publication(seq++, title, type, totalCopies);
        publications.add(p);
        return p;
    }

    public List<Publication> getAll() {
        return publications;
    }

    public Publication findById(int id) {
        for (Publication p : publications) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Publication> searchByTitle(String title) {
        List<Publication> result = new ArrayList<>();
        for (Publication p : publications) {
            if (p.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}