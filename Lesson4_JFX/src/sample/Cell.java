package sample;

import javafx.scene.control.*;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cell {
    Button button;
    char playerSymbol;
    boolean isAvailable;
    static String crossPath = "resources/images/cross.png";

    public Cell(Button button) {
        this.button = button;
        isAvailable = true;
        try {
            setButtonImage(button, crossPath);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void occupy(char playerSymbol, String imagePath){
        if(isAvailable){
            this.playerSymbol = playerSymbol;
            isAvailable = false;

            try {
                setButtonImage(button, imagePath);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void clear(){
        button.setGraphic(null);
        isAvailable = true;
    }

    void setButtonImage(Button button, String imagePath) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(imagePath);
        Image image = new Image(input, button.getWidth()*0.9, button.getHeight()*0.9, false,true);
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
    }
}
