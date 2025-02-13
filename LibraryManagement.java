import java.util.Scanner;

class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        LibraryMember member = new LibraryMember();
        String option;

        while (true) {
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
            System.out.println("\nLibrary Management System");
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
