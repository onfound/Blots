package sample;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.MalformedURLException;

public class Cell extends StackPane {
    private ContentCell contentCell;
    private int x;
    private int y;

     private ImageView imageBaseRed;
     private ImageView imageBaseGreen;
     private ImageView imageRed;
     private ImageView imageGreen;

    {
        File baseRed = new File("resource/BaseRed.png");
        File baseGreen1 = new File("resource/BaseGreen1.png");
        File red = new File("resource/Red.png");
        File green = new File("resource/Green.png");
        try {
            String localUrlBaseRed = baseRed.toURI().toURL().toString();
            String localUrlBaseGreen = baseGreen1.toURI().toURL().toString();
            String localUrlRed = red.toURI().toURL().toString();
            String localUrlGreen = green.toURI().toURL().toString();
            imageBaseRed = new ImageView(localUrlBaseRed);
            imageBaseGreen = new ImageView(localUrlBaseGreen);
            imageRed = new ImageView(localUrlRed);
            imageGreen = new ImageView(localUrlGreen);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    Cell(ContentCell contentCell, int x, int y) {
        this.x = x;
        this.y = y;
        this.contentCell = contentCell;
        paintCell();
    }

    private void paintCell() {
        Rectangle rectangle = new Rectangle(Field.CELLSIZE, Field.CELLSIZE);
        rectangle.setStroke(Color.AQUA);
        getChildren().add(rectangle);
        switch (contentCell) {
            case BASEGREEN:
                getChildren().add(imageBaseGreen);
                break;
            case BASERED:
                getChildren().add(imageBaseRed);
                break;
            case BLOTGREEN:
                getChildren().add(imageGreen);
                break;
            case BLOTRED:
                getChildren().add(imageRed);
                break;
        }
        setTranslateX(x * Field.CELLSIZE);
        setTranslateY(y * Field.CELLSIZE);
    }

    @Override
    public String toString() {
        switch (this.contentCell) {
            case EMPTY:
                return "о";
            case BASERED:
                return "T";
            case BASEGREEN:
                return "F";
            case BLOTRED:
                return "r";
            case FILLRED:
                return "R";
            case BLOTGREEN:
                return "b";
            case FILLGREEN:
                return "B";
            default:
                return "x";
        }
    }

    ContentCell getContent() {
        return contentCell;
    }

    void setContentCell(ContentCell contentCell) {
        this.contentCell = contentCell;
        paintCell();
    }
}
