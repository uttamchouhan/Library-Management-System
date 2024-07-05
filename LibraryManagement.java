import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private List<Book> books;
    private List<Member> members;
    private List<Librarian> librarians;
    private List<Loan> loans;
    private Scanner scanner;

    public LibraryManagement() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        librarians = new ArrayList<>();
        loans = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    

    public void menu() {
        while (true) {
            System.out.println("======== ### Library Management System ### ========");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Availability");
            System.out.println("3. Delete Book");
            System.out.println("4. View All Books");
            System.out.println("5. Add Member");
            System.out.println("6. View All Members");
            System.out.println("7. Add Librarian");
            System.out.println("8. View All Librarians");
            System.out.println("9. Create Loan");
            System.out.println("10. View All Loans");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1 -> addBook();
                case 2 -> updateBookAvailability();
                case 3 -> deleteBook();
                case 4 -> viewAllBooks();
                case 5 -> addMember();
                case 6 -> viewAllMembers();
                case 7 -> addLibrarian();
                case 8 -> viewAllLibrarians();
                case 9 -> createLoan();
                case 10 -> viewAllLoans();
                case 11 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Is the book available? (true/false): ");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        books.add(new Book(bookId, title, author, isAvailable));
        System.out.println("Book added successfully!");
    }

    private void updateBookAvailability() {
        System.out.print("Enter book ID to update availability: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = findBookById(bookId);
        if (book != null) {
            System.out.print("Is the book available? (true/false): ");
            boolean isAvailable = scanner.nextBoolean();
            scanner.nextLine(); // consume newline
            book.setIsAvailable(isAvailable);
            System.out.println("Book availability updated successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = findBookById(bookId);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addMember() {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member contact info: ");
        String contactInfo = scanner.nextLine();

        members.add(new Member(memberId, name, contactInfo));
        System.out.println("Member added successfully!");
    }

    private void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found!");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    private void addLibrarian() {
        System.out.print("Enter librarian ID: ");
        int librarianId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter librarian name: ");
        String name = scanner.nextLine();
        System.out.print("Enter librarian contact info: ");
        String contactInfo = scanner.nextLine();

        librarians.add(new Librarian(librarianId, name, contactInfo));
        System.out.println("Librarian added successfully!");
    }

    private void viewAllLibrarians() {
        if (librarians.isEmpty()) {
            System.out.println("No librarians found!");
        } else {
            for (Librarian librarian : librarians) {
                System.out.println(librarian);
            }
        }
    }

    private void createLoan() {
        System.out.print("Enter loan ID: ");
        int loanId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueDateStr = scanner.nextLine();
        Date dueDate = java.sql.Date.valueOf(dueDateStr);

        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book != null && member != null && book.getIsAvailable()) {
            book.setIsAvailable(false); // Set book to unavailable after loaning
            loans.add(new Loan(loanId, book, member, dueDate));
            System.out.println("Loan created successfully!");
        } else {
            System.out.println("Invalid book or member details, or book is not available.");
        }
    }

    private void viewAllLoans() {
        if (loans.isEmpty()) {
            System.out.println("No loans found!");
        } else {
            for (Loan loan : loans) {
                System.out.println(loan);
            }
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    private Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getMemberId() == id) {
                return member;
            }
        }
        return null;
    }
}