package model;

public class Publication {
    private int id;
    private String title;
    private String type;
    private int totalCopies;
    private int availableCopies;

    public Publication(int id, String title, String type, int totalCopies) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public int getAvailableCopies() { return availableCopies; }
    public int getTotalCopies() { return totalCopies; }

    public boolean borrow() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    public void returnCopy() {
        if (availableCopies < totalCopies) availableCopies++;
    }
}