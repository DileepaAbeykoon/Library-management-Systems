import java.util.Scanner;

class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Library library = new Library();
        LibraryMember member = new LibraryMember();
        String option;

        while (true) {
			System.out.println("Library Management System");
            System.out.println("\nSelect an option:");
            System.out.println("1. Books Management");
            System.out.println("2. Members Management");
            System.out.println("3. Exit Program");
            System.out.print("Enter your choice: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    manageBooks(scanner, library);
                    break;
                case 2:
                    manageMembers(scanner, member);
                    break;
                case 3:
                    System.out.println("Program end.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void manageBooks(Scanner scanner, Library library) {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Search Book");
            System.out.println("5. Return to Main Menu");

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
                    library.addBook(new Book(title, author, isbn, publishedYear));
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
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void manageMembers(Scanner scanner, LibraryMember member) {
        while (true) {
            System.out.println("\nLibrary Member Management System");
            System.out.println("1. Register Member");
            System.out.println("2. Remove Member");
            System.out.println("3. Display Members");
            System.out.println("4. Return to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String id = scanner.nextLine();
                    member.addMember(new Member(name, id));
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    id = scanner.nextLine();
                    member.removeMember(id);
                    break;
                case 3:
                    member.displayMembers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Published Year: " + publishedYear);
    }
}

class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        books = new Book[1000];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full.");
        }
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null;
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books available.");
        } else {
            for (int i = 0; i < bookCount; i++) {
                books[i].displayBook();
            }
        }
    }

    public void searchBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i].displayBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

class LibraryMember {
    private Member[] members;
    private int memberCount;

    public LibraryMember() {
        members = new Member[1000];
        memberCount = 0;
    }

    public void addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
            System.out.println("Member added successfully.");
        } else {
            System.out.println("Member limit reached.");
        }
    }

    public void removeMember(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(memberId)) {
                for (int j = i; j < memberCount - 1; j++) {
                    members[j] = members[j + 1];
                }
                members[--memberCount] = null;
                System.out.println("Member removed successfully.");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    public void displayMembers() {
        if (memberCount == 0) {
            System.out.println("No members registered.");
        } else {
            for (int i = 0; i < memberCount; i++) {
                members[i].displayMember();
            }
        }
    }
}

class Member {
    private String name;
    private String id;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void displayMember() {
        System.out.println("Name: " + name + ", Member ID: " + id);
    }
}
