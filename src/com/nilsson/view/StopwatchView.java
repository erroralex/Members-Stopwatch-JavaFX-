package com.nilsson.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StopwatchView {

    private final BorderPane root = new BorderPane();
    public Label header = new Label("Stopwatch");
    public Label timerLabel = new Label("00:00:00");
    public Button startButton = new Button("Start");
    public Button stopButton = new Button("Stop");
    public Button resetButton = new Button("Reset");
    public Button backButton = new Button("Back");

    public StopwatchView() {
        VBox centerPane = new VBox(25);
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setPadding(new Insets(40));

        header.getStyleClass().add("stopwatch-title");
        timerLabel.getStyleClass().add("timer");

        timerLabel.setMaxWidth(Double.MAX_VALUE);
        timerLabel.setAlignment(Pos.CENTER);

        // Buttons
        HBox buttonBox = new HBox(15, startButton, stopButton, resetButton);
        buttonBox.setAlignment(Pos.CENTER);

        startButton.setPrefWidth(100);
        stopButton.setPrefWidth(100);
        resetButton.setPrefWidth(100);

        // Styling
        resetButton.getStyleClass().add("red-button");
        centerPane.getChildren().addAll(header, timerLabel, buttonBox);
        BorderPane bottom = new BorderPane();
        backButton.getStyleClass().add("red-button");
        bottom.setLeft(backButton);
        bottom.setPadding(new Insets(10, 20, 10, 20));

        root.setCenter(centerPane);
        root.setBottom(bottom);
    }

    public BorderPane getRoot() {
        return root;
    }
}