📚 Library Management System
📜 Introduction
The Library Management System is a Java-based application designed to provide efficient book issuing and return services. Members can issue books for a specified duration, process returns, and generate receipts for their transactions.

This system follows object-oriented programming principles such as inheritance, abstraction, encapsulation, and polymorphism, making it scalable, maintainable, and modular. Using a menu-driven interface, users can interact with library services seamlessly while maintaining accurate book availability records.

✨ Features
✅ Book Issuing and Return Management – Members can issue available books and return them after use.
📜 Automatic Receipt Generation – Issuing and return receipts provide clear transaction details.
🚦 Real-time Availability Tracking – Books are dynamically marked as issued or available.
👤 Member Information Management – Each member is uniquely identified and linked to their issuing records.
🛠️ Error Handling & Validation – Prevents invalid transactions, ensuring smooth system operation.
🧩 Modular & Scalable Architecture – Designed for easy extension, supporting new book genres and enhancements.

🛠️ Project Structure
📚 Book (Abstract Class)
Defines common attributes and functionalities shared by all books.

🏷️ Attributes:

bookId: Unique identifier distinguishing each book.
title: Title of the book.
author: Author of the book.
isAvailable: Boolean flag tracking availability status.
⚙️ Methods:

issue(): Marks book as unavailable upon issuing.
returnBook(): Restores availability when returned.
getGenre(): Abstract method for subclasses to define book genre.
Getter methods: Retrieve book ID, title, author, and availability status.
📘 Fiction, 📖 NonFiction, 📂 Other (Subclasses of Book)
Each subclass inherits from Book and implements getGenre() to return its specific type.

📘 Fiction Class
Represents imaginative or invented books.

getGenre() returns "Fiction".
📖 NonFiction Class
Represents factual or informative books.

getGenre() returns "Non-Fiction".
📂 Other Class
Represents books that do not fit into the Fiction or Non-Fiction categories.

getGenre() returns "Others".
👤 Member Class
Stores member details and maintains accurate issuing records.
🏷️ Attributes:

memberId: Unique identifier assigned to each member.
name: Member's name linked to issuing records.
⚙️ Methods:

getMemberId() – Retrieves member ID.
getName() – Retrieves member name.
📜 Issuing Class
Handles book issuing transactions, linking members to their issued books.
🏷️ Attributes:

book: Book object referring to the issued book.
member: Member object associated with the issuing.
⚙️ Methods:

generateReceipt() – Generates a detailed issuing receipt with transaction details.
Getter methods – Retrieve book and member.
🔄 Return Class
Manages the book return process, updating availability and generating confirmation receipts.
🏷️ Attributes:

issuing: Issuing object referring to the returning transaction.
⚙️ Methods:

processReturn() – Marks book as available after verification.
generateReturnReceipt() – Generates return confirmation.
⚙️ LibraryManagementSystem Class
Acts as the central manager for book transactions and system operations.
🏷️ Attributes:

books: List of available books in inventory.
members: List of registered members stored in the system.
issuings: List of active issuing records maintaining transaction details.
⚙️ Methods:

addBook(Book book) – Registers new books in the system.
addMember(Member member) – Adds members during issuing transactions.
issueBook(Book book, Member member) –
Verifies availability before issuing.
Marks book as issued and generates a receipt.
returnBook(String bookId) –
Searches issuing records for book identifier.
Processes the return, restoring availability.
Generates a return receipt confirming transaction.
menu() – Offers an interactive menu-driven system for user transactions.
🚀 Main Class
The entry point of the system.

⚙️ Methods:

main() – Initializes the LibraryManagementSystem and registers predefined books.
Launches menu-driven system, allowing user interaction.
🔎 Core Implementation Details
🛠️ Error Handling & Robustness
Validates input to prevent incorrect selections.
Ensures unavailable books cannot be issued.
Displays clear error messages for invalid transactions.
Implements exception handling for stability.
Closes resources properly to avoid memory leaks.
🔗 Integration of Components
Maintains smooth interaction between Book, Member, Issuing, Return, and System Modules.
Updates availability instantly after issuings and returns.
Modular system architecture allows easy enhancements.
🔄 Event Handling & Processing
Menu-driven interface ensures smooth user interactions.
Real-time updates prevent issuing conflicts.
✅ Data Validation
Verifies valid input before processing transactions.
Checks book availability before issuing approval.
Confirms input format for book IDs.
🎯 Code Quality & Innovation
Object-oriented principles ensure scalability.
Automatic unique member ID generation.
Detailed documentation for maintenance and debugging.
📌 Setup & Usage Guide
🔧 Prerequisites

Java JDK (Version 8 or later).
VS Code (Recommended IDEs), GitHub.
🚀 Installation & Execution
1️⃣ Clone or download the project files.
2️⃣ Open the project in an IDE.
3️⃣ Compile and run the Main application file.
4️⃣ Follow the menu-driven system to issue or return books.

🔮 Future Enhancements
Database integration for storing library history and member records.
Graphical User Interface (GUI) for an improved user experience.
Online reservation system for reserving books in advance.
Due date and fine management for late returns.
🔄 Workflow Documentation
1️⃣ Book Addition Process
✔ Purpose: Register books into the system for library availability.

Workflow:

Administrator adds a new book using addBook().
Each book is assigned a unique ID, title, author, and genre.
The book is marked as available by default.
The book list updates in the system inventory, making it accessible for issuing.
2️⃣ Member Registration & Book Issuing Process
✔ Purpose: Allow members to issue available books.

Workflow:

Member provides their name for registration (or uses an existing member ID if implemented).
The system generates a unique Member ID.
The system displays available books for selection.
Member selects a book using its unique ID.
The system checks availability and processes issuing via issueBook().
The book status updates to unavailable.
The issuing record is stored in the system for tracking.
An issuing receipt is generated, detailing the transaction.
3️⃣ Returning a Book Process
✔ Purpose: Enable members to return issued books.

Workflow:

Member provides the Book ID of the issued book.
The system verifies if the book is currently issued.
Book status updates to available via returnBook().
The issuing record is removed from the system, ensuring accurate inventory tracking.
A return receipt is generated, confirming the return process.
4️⃣ Menu Navigation Workflow
✔ Purpose: Allow users to interact with the system.

Workflow:

The system displays a main menu with the following options:
Issue a Book
Return a Book
Exit
The user chooses an action based on their requirement.
The system executes the selected process (Issuing or Return).
If the user selects Exit, the program terminates.
5️⃣ Error Handling Process
✔ Purpose: Handle invalid inputs and prevent system errors.

Workflow:

If the user enters an invalid Book ID, the system displays an error message.
If the book is already issued, the system prevents duplicate issuings.
If the user tries to return a non-issued book, an error message appears.
Proper exception handling prevents crashes and ensures smooth operations.
📌 Conclusion
The Library Management System successfully streamlines the process of issuing and returning books while maintaining real-time availability tracking, automatic receipt generation, and error handling. The system is built using object-oriented programming principles, ensuring modularity, scalability, and maintainability.

Through its menu-driven interface, members can easily interact with the system, issuing books and processing returns efficiently. The integration of workflow documentation ensures a clear transaction flow, providing a structured approach for managing library operations.

This project lays a strong foundation for future enhancements, such as database integration for persistent storage, a graphical user interface for improved user experience, and an online reservation system for books. With a robust design and well-documented workflow, the Library Management System is a reliable and extensible solution for book management.

🚀 The system provides a practical, efficient, and scalable approach to library operations, ensuring a seamless experience for members.
