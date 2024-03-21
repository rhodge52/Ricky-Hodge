import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment15.java {
    private Button[][] buttons = new Button[5][5];
    private boolean playerXTurn = true;
    private boolean gameOver = false;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Button button = new Button();
                button.setPrefSize(80, 80);
                button.setOnAction(e -> {
                    if (!gameOver && ((Button) e.getSource()).getText().isEmpty()) {
                        if (playerXTurn) {
                            ((Button) e.getSource()).setText("X");
                            if (checkWin("X")) {
                                System.out.println("Player X wins!");
                                gameOver = true;
                            }
                        } else {
                            ((Button) e.getSource()).setText("O");
                            if (checkWin("O")) {
                                System.out.println("Player O wins!");
                                gameOver = true;
                            }
                        }
                        playerXTurn = !playerXTurn;
                    }
                });
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    private boolean checkWin(String player) {
        // Check rows
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (buttons[i][j].getText().equals(player)) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check columns
        for (int j = 0; j < 5; j++) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (buttons[i][j].getText().equals(player)) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (i + j < 5) {
                    if (buttons[i + j][j].getText().equals(player)) {
                        count++;
                        if (count == 5) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        for (int j = 1; j < 5; j++) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (i + j < 5) {
                    if (buttons[i][i + j].getText().equals(player)) {
                        count++;
                        if (count == 5) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }


