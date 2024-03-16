package LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding some books to the library
        library.addBook(new Book("Java Programming", "John Smith"));
        library.addBook(new Book("Python Basics", "Alice Johnson"));
        library.addBook(new Book("Data Structures in C", "Michael Brown"));

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Display Books");
            System.out.println("2. Reserve a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to reserve: ");
                    scanner.nextLine(); // Consume newline character
                    String titleToReserve = scanner.nextLine();
                    Book bookToReserve = library.findBookByTitle(titleToReserve);
                    if (bookToReserve != null) {
                        if (!bookToReserve.isReserved()) {
                            bookToReserve.reserve();
                            System.out.println("Book \"" + titleToReserve + "\" reserved successfully.");
                        } else {
                            System.out.println("Book \"" + titleToReserve + "\" is already reserved.");
                        }
                    } else {
                        System.out.println("Book \"" + titleToReserve + "\" not found in the library.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine(); // Consume newline character
                    String titleToReturn = scanner.nextLine();
                    Book bookToReturn = library.findBookByTitle(titleToReturn);
                    if (bookToReturn != null) {
                        if (bookToReturn.isReserved()) {
                            bookToReturn.unreserve();
                            System.out.println("Book \"" + titleToReturn + "\" returned successfully.");
                        } else {
                            System.out.println("Book \"" + titleToReturn + "\" is not currently reserved.");
                        }
                    } else {
                        System.out.println("Book \"" + titleToReturn + "\" not found in the library.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }
}
