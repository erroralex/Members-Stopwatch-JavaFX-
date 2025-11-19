package com.nilsson.controller;

import com.nilsson.view.StopwatchView;
import javafx.animation.AnimationTimer;

public class StopwatchController {

    private final StopwatchView view;
    private long startTime = 0;
    private long pauseOffset = 0;
    private boolean running = false;
    private AnimationTimer timer;

    public StopwatchController(StopwatchView view) {
        this.view = view;
        setupTimer();
    }

    private void setupTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedNanos = now - startTime + pauseOffset;
                long totalMillis = elapsedNanos / 1_000_000;
                long minutes = (totalMillis / 60000) % 60;
                long seconds = (totalMillis / 1000) % 60;
                long millis = (totalMillis % 1000) / 10;
                view.timerLabel.setText(String.format("%02d:%02d:%02d", minutes, seconds, millis));
            }
        };

        view.startButton.setOnAction(e -> start());
        view.stopButton.setOnAction(e -> stop());
        view.resetButton.setOnAction(e -> reset());
    }

    private void start() {
        if (!running) {
            startTime = System.nanoTime();
            timer.start();
            running = true;
        }
    }

    private void stop() {
        if (running) {
            timer.stop();
            pauseOffset += System.nanoTime() - startTime;
            running = false;
        }
    }

    private void reset() {
        timer.stop();
        startTime = 0;
        pauseOffset = 0;
        running = false;
        view.timerLabel.setText("00:00:00");
    }
}