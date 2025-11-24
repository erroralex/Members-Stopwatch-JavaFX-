# Members & Stopwatch (JavaFX)

A small JavaFX application that manages a list of members and includes a basic stopwatch tool.

## Features

  - Add, save, and remove members (first name, last name, phone, address).
  - Members are stored locally in `members.json` for persistence between runs.
  - Styled member table with automatic updates on load, save, and removal.
  - Stopwatch with start, stop, and reset functionality.
  - Simple navigation between views.

## Project Structure


```
src/
 └── com.nilsson
     ├── application/      # Main JavaFX entry point
     ├── controller/       # UI controllers
     ├── model/            # Data model classes (Member)
     ├── repository/       # JSON file handling (MemberRepository)
     └── view/             # JavaFX views (Menu, Members, Stopwatch)
resources/
 └── com/nilsson/styling/  # CSS styles
```

## How It Works

  - **Persistence:** Member data is loaded from and written to `members.json` using the **Jackson Databind library**. This provides robust, reliable conversion between JSON and the `Member` Java objects.
  - **Member View:** `MembersView` displays the input form and the table; `MembersController` handles validation, saving members via the `MemberRepository`, and updating the list.
  - **Stopwatch:** `StopwatchView` is updated in real-time using an `AnimationTimer` controlled by `StopwatchController`.
  - **Styling:** All screens share a common CSS theme.

## Run the Project

Requires:

  - Java 8 (with bundled JavaFX or OpenJFX 8)
  - Jackson Databind (JAR files included in the project's `lib` directory)

Run using:
mvn javafx:run
*(Note: If not using Maven, run the compiled JAR with the appropriate classpath and module/bootclasspath arguments for JavaFX.)*

## License

MIT
