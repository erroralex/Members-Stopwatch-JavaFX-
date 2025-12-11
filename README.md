# Members Registry & Stopwatch Suite

![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-Code--First-4285F4?style=for-the-badge&logo=java&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-Styling-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Jackson](https://img.shields.io/badge/Persistence-Jackson_JSON-2f2f2f?style=for-the-badge&logo=json&logoColor=white)

A dual-function desktop application built with **JavaFX** that demonstrates robust data persistence and real-time UI handling.

This project was built to demonstrate **Object-Oriented Design patterns**, **MVC architecture**, and **programmatic UI development** (Pure JavaFX without FXML).

---

## ✨ Key Features

* **Member Management:** A persistent CRUD system for managing member profiles (Name, Phone, Email, ID).
* **Data Persistence:** Automatic serialization/deserialization of Java objects to JSON using Jackson Databind.
* **Precision Stopwatch:** A dedicated stopwatch tool utilizing `AnimationTimer` for accurate, high-frequency time tracking (60 FPS).
* **Concurrency:** Separated UI logic from timing threads to ensure a responsive interface.
* **Dynamic Styling:** Centralized CSS styling for consistent application theming.

---

## 🛠️ Technical Architecture

The application follows a **Model-View-Controller (MVC)** architecture to ensure separation of concerns.

### Design Patterns Implemented
* **MVC Pattern:** Strictly separates the data (`Member`), the interface (`MembersView`), and the logic (`MembersController`).
* **Repository Pattern:** The `MemberRepository` handles all data retrieval and storage, decoupling the file I/O details from the business logic.
* **Observer Pattern:** Used implicitly by JavaFX components to update the UI when underlying data models change.

### Technology Stack
* **Core:** Java 8+, JavaFX (Programmatic DOM, No FXML)
* **Persistence:** Jackson (JSON Data Binding)
* **Build Tool:** Maven
* **UI Assets:** Custom CSS Theming

---

## 🚀 Getting Started

To run the application locally:

1.  **Clone the repository**
2.  **Build with Maven:**
    ```bash
    mvn clean install
    ```
3.  **Run:**
    ```bash
    mvn javafx:run
    ```

---

## 📂 Project Structure

```
src/com/nilsson
├── application/    # Application Entry Point
├── controller/     # Event Handling & Logic bridging
├── model/          # Data Entities (POJOs)
├── repository/     # JSON File I/O & Persistence
├── view/           # Pure JavaFX Layouts (No FXML)
└── styling/        # CSS Resources & Assets
```

---

## 📜 License

This project was developed for educational purposes as part of a System Development course. Distributed under the **MIT License**.

---
