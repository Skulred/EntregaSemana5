module SafarySound {
	import javax.sound.sampled.*;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	public class AnimalSoundsApp extends JFrame {
	    private JButton playButton;
	    private JComboBox<String> animalComboBox;
	    private JLabel imageLabel;

	    public AnimalSoundsApp() {
	        setTitle("SafarySound");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 300);
	        setLayout(new FlowLayout());

	        playButton = new JButton("Sonido");
	        playButton.addActionListener(new ButtonListener());
	        add(playButton);

	        animalComboBox = new JComboBox<>();
	        animalComboBox.addItem("Perro");
	        animalComboBox.addItem("Gato");
	        animalComboBox.addItem("Ave");
	        add(animalComboBox);

	        imageLabel = new JLabel();
	        add(imageLabel);

	        setVisible(true);
	    }

	    private class ButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            String selectedAnimal = (String) animalComboBox.getSelectedItem();
	            String soundFile = selectedAnimal.toLowerCase() + ".wav";
	            String imageFile = selectedAnimal.toLowerCase() + ".jpg";

	            playSound(soundFile);
	            displayImage(imageFile);
	        }
	    }

	    private void playSound(String soundFile) {
	        try {
	            File file = new File(soundFile);
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioStream);
	            clip.start();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private void displayImage(String imageFile) {
	        ImageIcon icon = new ImageIcon(imageFile);
	        imageLabel.setIcon(icon);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new AnimalSoundsApp();
	            }
	        });
	    }
	}
