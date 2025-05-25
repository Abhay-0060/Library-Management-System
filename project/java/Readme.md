# 📚 Library Management System (Java Console Application)

## Overview

The **Library Management System** is a Java-based console application that automates book issuing, returning, and member management. Designed with object-oriented principles, this system categorizes books by genre (Fiction, Non-Fiction, Others) and facilitates smooth operations for both librarians and members. While it uses **in-memory storage**, it offers a solid foundation for academic use or future expansion into GUI or database-driven systems.

---

## ✨ Features

- Add and categorize books (Fiction, Non-Fiction, Others)
- Register new members on the fly
- Issue books to members with automatic availability tracking
- Process book returns and generate return receipts
- Display available books for selection
- Console-based interaction with a clear and simple menu

---

## 🛠️ Technologies Used

- **Language**: Java  
- **Paradigm**: Object-Oriented Programming (OOP)  
- **Interface**: Console-based UI  
- **Storage**: In-memory lists (no database required)

---

## 📂 Project Structure

LibraryManagementSystem/
│
├── Main.java # Entry point of the application
├── Book.java # Abstract class for all books
├── Fiction.java # Fiction genre book class
├── NonFiction.java # Non-Fiction genre book class
├── Other.java # Other genre book class
├── Member.java # Member representation
├── Issuing.java # Handles issuing operations
├── Return.java # Handles return operations
├── LibraryManagementSystem.java # Core library system with book/member logic

> **Note:** All classes are defined within a single Java file in this version for simplicity. For production, separating each class into its own `.java` file is recommended.

---

## 🚀 How to Run

### Prerequisites

- JDK 8 or above installed
- Java-compatible IDE (Eclipse, IntelliJ, NetBeans) or command-line tools

### Steps

1. Save the full source code in a file named `Main.java`.

2. Compile the program:
   ```bash
   javac Main.java

   
    👨‍💻 Author
Your Name
GitHub: @yourusername