package LibraryManagementSystem;

public class Book {
    private String title;
    private String author;
    private boolean reserved;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.reserved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        reserved = true;
    }

    public void unreserve() {
        reserved = false;
    }
}
