import java.util.Scanner;

class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        String option;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter published year: ");
                    int publishedYear = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(title, author, isbn, publishedYear);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    library.removeBook(isbn);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    library.searchBook(isbn);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.print("Do you need another option? (Y/N): ");
            option = scanner.nextLine();

        } while (option.equalsIgnoreCase("Y"));

        System.out.println("Program ended.");
    }
}



class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishedYear;

    public Book(String title, String author, String isbn, int publishedYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + publishedYear);
    }
}

class Library {
    private Book[] books;
    private int bookCount;

    public Library() {  
        this.books = new Book[1000]; 
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full!");
        }
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[bookCount - 1]; 
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library!");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBook();
        }
    }

    public void searchBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                System.out.println("Book found:");
                books[i].displayBook();
                return;
            }
        }
        System.out.println("Book not found!");
    }
}
