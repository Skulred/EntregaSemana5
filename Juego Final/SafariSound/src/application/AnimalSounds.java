package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.File;
import javafx.scene.media.AudioClip;

public class AnimalSounds extends Application {

    private List<String> animalSounds = Arrays.asList(
            "Lion.wav", "sound2.wav", "sound3.wav", "sound4.wav", "sound5.wav", 
            "sound6.wav", "sound7.wav", "sound8.wav", "sound9.wav", "sound10.wav"
    );

    private List<String> animalImages = Arrays.asList(
            "1.jpeg", "2.jpeg", "3.jpg", "4.jpg", "5.jpg","6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg"
    );

    private AudioClip audioClip;
    private ImageView[] imageViews = new ImageView[4];
    private int correctImageIndex;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

      
        List<String> randomImages = getRandomImages();
        for (int i = 0; i < 4; i++) {
            Image image = new Image(randomImages.get(i));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            imageViews[i] = imageView;

            int index = i; 
            imageView.setOnMouseClicked(event -> handleImageClick(index));

            gridPane.add(imageView, i, 0);
        }

        Button playButton = new Button("Reproducir sonido");
        playButton.setOnAction(event -> playAnimalSound());

        gridPane.add(playButton, 0, 1, 4, 1);

        Scene scene = new Scene(gridPane, 900, 400);
        primaryStage.setTitle("Animal Sounds");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<String> getRandomImages() {
        List<String> imagesCopy = new ArrayList<>(animalImages);
        Collections.shuffle(imagesCopy);
        return imagesCopy.subList(0, 4);
    }

    private void playAnimalSound() {
        if (audioClip != null) {
            audioClip.stop();
        }

        Random random = new Random();
        correctImageIndex = random.nextInt(4); 

        String soundFile = animalSounds.get(correctImageIndex);
        audioClip = new AudioClip(); 
        audioClip.play();
    }

    private void handleImageClick(int clickedIndex) {
        if (clickedIndex == correctImageIndex) {
            System.out.println("¡Respuesta correcta!");
        } else {
            System.out.println("Respuesta incorrecta");
        }
    }
}