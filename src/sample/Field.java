package sample;


import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class Field {
    private static final int COLUMN = 15;
    private static final int ROW = 20;
    static final int CELLSIZE = 20;
    private Cell[][] fieldCell;

    /**
     * height = 20; width = 15;
     */
    Field() {
        fieldCell = new Cell[ROW][COLUMN]; // [y][x]
        for (int x = 0; x < COLUMN; x++) {
            for (int y = 0; y < ROW; y++) {
                if (x == 3 && y == ROW - 4) fieldCell[y][x] = new Cell(ContentCell.BASEGREEN, x, y);
                else {
                    if (x == COLUMN - 4 && y == 3) fieldCell[y][x] = new Cell(ContentCell.BASERED, x, y);
                    else fieldCell[y][x] = new Cell(ContentCell.EMPTY, x, y);
                }
            }
        }
    }

    boolean setPoint(int x, int y) {
        if (canMove(x, y)) {
            fieldCell[y][x].setContentCell(ContentCell.BLOTGREEN);
            return true;
        }
        return false;
    }

    private boolean canMove(int x, int y) {
        if (fieldCell[y][x].getContent() == ContentCell.EMPTY || fieldCell[y][x].getContent() == ContentCell.BLOTRED)
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i != 0 || j != 0) && x + i >= 0 && y + j >= 0 && x + i <= COLUMN - 1 && y + j <= ROW - 1) {
                        if (canMoveGreen(x + i, y + j)) return true;
                    }
                }
            }
        return false;
    }

    boolean canMoveRed(int x, int y) {
        switch (fieldCell[y][x].getContent()) {
            case BASERED:
            case BLOTRED:
            case FILLRED:
                return true;
            default:
                return false;
        }
    }

    private boolean canMoveGreen(int x, int y) {
        switch (fieldCell[y][x].getContent()) {
            case BASEGREEN:
            case BLOTGREEN:
            case FILLGREEN:
                return true;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Cell[] row : fieldCell) {
            for (Cell cell : row) {
                stringBuilder.append(cell);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    Parent getContent() {
        Pane pane = new Pane();
        pane.setPrefSize(COLUMN * CELLSIZE, ROW * CELLSIZE);
        for (Cell[] row : fieldCell) {
            for (Cell cell : row) {
                pane.getChildren().add(cell);
            }
        }
        return pane;
    }
}
