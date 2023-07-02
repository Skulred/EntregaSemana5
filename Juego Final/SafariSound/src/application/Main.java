package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    private static final int NUM_IMAGES = 10;
    private static final int NUM_DISPLAYED_IMAGES = 4;

    private List<Image> images;
    private List<Image> displayedImages;

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 700, 500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("SafariSounds");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            Label labelTexto = new Label("SAFARI SOUNDS");
            HBox centerContainer = new HBox(labelTexto);
            centerContainer.setAlignment(Pos.CENTER);
            root.setTop(centerContainer);

            TextField textField = new TextField();
            textField.setText("Nombre");
            textField.setPrefWidth(220);
            textField.setPrefHeight(30);
            root.setCenter(textField);

            Button closeButton = new Button("SALIR");
            closeButton.setOnAction(e -> primaryStage.close());

            Button openButton = new Button("JUGAR");
            openButton.setOnAction(e -> {
                String texto = textField.getText();
                if (!texto.equals("Nombre")) {
                    BorderPane newRoot = new BorderPane();
                    Scene newScene = new Scene(newRoot, 700, 500);
                    newScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    primaryStage.setTitle("SafariSounds");
                    primaryStage.setScene(newScene);

                    loadImages();
                    selectRandomImages();

                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setHgap(10);
                    gridPane.setVgap(10);
                    gridPane.setPadding(new Insets(10));

                    int col = 0;
                    for (Image image : displayedImages) {
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(200);
                        imageView.setFitHeight(200);
                        gridPane.add(imageView, col, 0);
                        col++;
                    }

                    newRoot.setCenter(gridPane);

                    Button closeButton1 = new Button("SALIR");
                    closeButton1.setOnAction(event -> primaryStage.close());

                    HBox buttonContainer = new HBox(280);
                    buttonContainer.setAlignment(Pos.CENTER_LEFT);
                    buttonContainer.getChildren().addAll(closeButton1, new Region(), openButton);

                    VBox bottomContainer = new VBox(10);
                    bottomContainer.setPadding(new Insets(10));
                    bottomContainer.setAlignment(Pos.CENTER_RIGHT);
                    bottomContainer.getChildren().add(buttonContainer);

                    newRoot.setBottom(bottomContainer);
                    openButton.setVisible(false);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Faltan Datos");
                    alert.setHeaderText(null);
                    alert.setContentText("Debe ingresar un nombre");
                    alert.showAndWait();
                }
            });

            HBox buttonContainer = new HBox(280);
            buttonContainer.setAlignment(Pos.CENTER_LEFT);
            buttonContainer.getChildren().addAll(closeButton, new Region(), openButton);

            VBox bottomContainer = new VBox(10);
            bottomContainer.setPadding(new Insets(10));
            bottomContainer.setAlignment(Pos.CENTER_RIGHT);
            bottomContainer.getChildren().add(buttonContainer);

            root.setBottom(bottomContainer);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadImages() {
        images = new ArrayList<>();
        for (int i = 1; i <= NUM_IMAGES; i++) {
            String filename = "SafariSound/Imagenes" + i + ".jpg";
            Image image = new Image(getClass().getResource(filename).toExternalForm());
            images.add(image);
        }
    }

    private void selectRandomImages() {
        displayedImages = new ArrayList<>(images);
        Collections.shuffle(displayedImages);
        displayedImages = displayedImages.subList(0, NUM_DISPLAYED_IMAGES);
    }

    public static void main(String[] args) {
        launch(args);
    }
}