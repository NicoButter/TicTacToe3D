package com.tictactoe3d;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear el contenedor principal (VBox)
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER); 

        // Crear el logo (ImageView)
        ImageView logo = new ImageView(new Image(getClass().getResource("resources/logo.png").toExternalForm()));
        logo.setFitWidth(200);
        logo.setPreserveRatio(true);

        // Crear botones
        Button newGameButton = new Button("Nuevo Juego");
        newGameButton.setStyle("-fx-font-size: 18px; -fx-padding: 10px 20px;");
        newGameButton.setOnAction(e -> startGame(primaryStage));

        Button exitButton = new Button("Salir");
        exitButton.setStyle("-fx-font-size: 18px; -fx-padding: 10px 20px;");
        exitButton.setOnAction(e -> System.exit(0)); 

        // Añadir elementos al VBox
        root.getChildren().addAll(logo, newGameButton, exitButton);

        // Configurar escena y ventana
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Ta Te Ti 3D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para iniciar el juego (ventana del tablero)
    private void startGame(Stage primaryStage) {
        // Crear el GridPane (tablero)
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        // Crear botones para las casillas
        Button[][] buttons = new Button[3][3]; // 3x3 Ta Te Ti

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setMinSize(100, 100); 
                buttons[i][j].setStyle("-fx-font-size: 24px;"); 
                buttons[i][j].setOnAction(e -> {
                    Button btn = (Button) e.getSource();
                    btn.setText("X"); // Marcar con X (por ahora)
                    btn.setDisable(true); // Desactivar botón después de jugar
                });
                grid.add(buttons[i][j], j, i); // Añadir botones al grid
            }
        }

        // Configurar escena y ventana para el tablero
        Scene gameScene = new Scene(grid, 350, 350);
        primaryStage.setTitle("Ta Te Ti 3D - Tablero");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Lanzar la aplicación JavaFX
    }
}
