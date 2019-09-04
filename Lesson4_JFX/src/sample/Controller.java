package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Controller {

    final String crossPath = "resources/images/cross.png";
    final String zeroPath = "resources/images/zero.png";
    final int CELLS_COUNT = 9;

    boolean playerTurn = true;

    public Button btn00;
    public Button btn01;
    public Button btn02;
    public Button btn10;
    public Button btn11;
    public Button btn12;
    public Button btn20;
    public Button btn21;
    public Button btn22;

    public void clickNewGame(ActionEvent actionEvent) {
        playerTurn = true;

        btn00.setGraphic(null);
        btn01.setGraphic(null);
        btn02.setGraphic(null);
        btn10.setGraphic(null);
        btn11.setGraphic(null);
        btn12.setGraphic(null);
        btn20.setGraphic(null);
        btn21.setGraphic(null);
        btn22.setGraphic(null);
    }

    public void click(ActionEvent actionEvent) {
        Button b =(Button)actionEvent.getSource();
        if(b.getGraphic() == null) {
            try {
                if(playerTurn){
                    setButtonImage(b, crossPath);
                }
                else {
                    setButtonImage(b, zeroPath);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
            playerTurn = !playerTurn;
        }

    }

    void setButtonImage(Button button, String imagePath) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(imagePath);
        Image image = new Image(input, button.getWidth()*0.9, button.getHeight()*0.9, false,true);
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
    }

}
