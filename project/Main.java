import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Parent class: Book
abstract class Book {      
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    // Constructor to initialize book details
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;   // Books are available by default
    }
    
    // Getters for book details
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Methods to issue or return a book
    public void issue() {
        isAvailable = false;
    }
    
    public void returnBook() {
        isAvailable = true;
    }

    public abstract String getGenre(); // Each book has a genre (Fiction, Non-Fiction, Others)
}

// Child classes inheriting Book
class Fiction extends Book {
    public Fiction(String bookId, String title, String author) {
        super(bookId, title, author);
    }

    @Override
    public String getGenre() {
        return "Fiction";
    }
}

class NonFiction extends Book {
    public NonFiction(String bookId, String title, String author) {
        super(bookId, title, author);
    }

    @Override
    public String getGenre() {
        return "Non-Fiction";
    }
}

class Other extends Book {
    public Other(String bookId, String title, String author) {
        super(bookId, title, author);
    }

    @Override
    public String getGenre() {
        return "Others";
    }
}

// Member class to store member information
class Member {
    private String memberId;
    private String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}

// Issuing class for managing book issues
class Issuing {
    private Book book;
    private Member member;

    public Issuing(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public void generateReceipt() {
        System.out.println("\n===== Issuing Receipt =====");
        System.out.println("Member Name: " + member.getName());
        System.out.println("Member ID: " + member.getMemberId());
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("=========================\n");
    }
}

// Return class to process book returns
class Return {
    private Issuing issuing;

    public Return(Issuing issuing) {
        this.issuing = issuing;
    }

    public void processReturn() {  
        if (issuing != null && issuing.getBook() != null) {
            issuing.getBook().returnBook();
            System.out.println("\nBook returned successfully by " + issuing.getMember().getName());
            generateReturnReceipt(); 
        } else {
            System.out.println("\nInvalid book ID or book was not issued.");
        }
    }

    public void generateReturnReceipt() {
        System.out.println("\n===== Return Receipt =====");
        System.out.println("Member Name: " + issuing.getMember().getName());
        System.out.println("Member ID: " + issuing.getMember().getMemberId());
        System.out.println("Book Title: " + issuing.getBook().getTitle());
        System.out.println("Author: " + issuing.getBook().getAuthor());
        System.out.println("Genre: " + issuing.getBook().getGenre());
        System.out.println("=========================\n");
    }
}

// Library Management System class managing book operations
class LibraryManagementSystem {
    private List<Book> books;
    private List<Member> members;
    private List<Issuing> issuings;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        issuings = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void issueBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.issue();
            Issuing newIssuing = new Issuing(book, member);
            issuings.add(newIssuing);
            System.out.println("\nBook issued successfully.");
            newIssuing.generateReceipt();
        } else {
            System.out.println("\nBook is not available.");
        }
    }

    public void returnBook(String bookId) {
        Issuing issuingToRemove = null;
        for (Issuing issuing : issuings) {
            if (issuing.getBook().getBookId().equals(bookId)) {
                issuingToRemove = issuing;
                break;
            }
        }

        if (issuingToRemove != null) {
            new Return(issuingToRemove).processReturn();
            issuings.remove(issuingToRemove);
        } else {
            System.out.println("\nInvalid book ID or book was not issued.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Issue a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Issuing Book
                    System.out.print("\nEnter your name: ");
                    String memberName = scanner.nextLine();
                    Member newMember = new Member("MEM" + System.currentTimeMillis(), memberName);
                    addMember(newMember);

                    System.out.println("\nAvailable Books:");
                    for (Book book : books) {
                        if (book.isAvailable()) {
                            System.out.println(book.getBookId() + " - " + book.getTitle() + " by " + book.getAuthor());
                        }
                    }

                    System.out.print("\nEnter the book ID you want to issue: ");
                    String bookId = scanner.nextLine();

                    for (Book book : books) {
                        if (book.getBookId().equals(bookId) && book.isAvailable()) {
                            issueBook(book, newMember);
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("\nEnter the book ID you want to return: ");
                    bookId = scanner.nextLine();
                    returnBook(bookId);
                    break;

                case 3:
                    System.out.println("\nThank you for using the Library Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();
        librarySystem.addBook(new Fiction("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        librarySystem.addBook(new NonFiction("B002", "Sapiens", "Yuval Noah Harari"));
        librarySystem.addBook(new Other("B003", "Cooking Basics", "Jamie Oliver"));
        librarySystem.menu();
    }
}