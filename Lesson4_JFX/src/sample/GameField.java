package sample;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GameField {
    static final int FIELD_SIZE = 3;
    static String crossPath = "resources/images/cross.png";
    static String zeroPath = "resources/images/zero.png";

    Cell[] cells;

    public GameField(GridPane gridPane) {
        int cellsCount = FIELD_SIZE*FIELD_SIZE;
        cells = new Cell[cellsCount];

        for (int i = 0; i < (cellsCount); i++){
            Button button = new Button("");
            cells[i] = new Cell(button);

            gridPane.add(button, i%FIELD_SIZE, i/FIELD_SIZE);
            button.setMaxWidth(Double.MAX_VALUE);
            button.setMaxHeight(Double.MAX_VALUE);
            GridPane.setHgrow(button, Priority.ALWAYS);
            GridPane.setVgrow(button, Priority.ALWAYS);
        }
    }

    public void clear() {
        for(Cell cell : cells){
            cell.clear();
        }
    }


}
