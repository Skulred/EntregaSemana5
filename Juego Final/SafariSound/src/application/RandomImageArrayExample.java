package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomImageArrayExample extends Application {
	private List<Image> imageList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        imageList = new ArrayList<>();
        imageList.add(new Image("/SafariSound/Imagenes/1.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/2.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/3.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/4.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/5.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/6.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/7.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/8.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/9.jpg"));
        imageList.add(new Image("/SafariSound/Imagenes/10.jpg"));

        
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);

        
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            Image randomImage = getRandomImage(random);
            ImageView imageView = new ImageView(randomImage);
            pane.getChildren().add(imageView);
        }

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Image Array Example");
        primaryStage.show();
    }

    private Image getRandomImage(Random random) {
        int randomIndex = random.nextInt(imageList.size());
        return imageList.get(randomIndex);
    }
}

