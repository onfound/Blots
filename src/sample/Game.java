package sample;

import com.sun.javafx.geom.Edge;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import sun.security.provider.certpath.Vertex;

import java.util.Random;


public class Game {
    private Field field;
    private Player player;
    private Bot bot;
    private boolean playersTurn; // if true player's turn

    Game() {
        field = new Field();
        player = new Player();
        bot = new Bot(field);
//        playersTurn = new Random().nextBoolean();
        playersTurn = true;
        printField();
    }

    private EventHandler<MouseEvent> mouseHandler = mouseEvent -> {
        if (playersTurn) {
            int y = Double.valueOf(mouseEvent.getY()).intValue() / Field.CELLSIZE;
            int x = Double.valueOf(mouseEvent.getX()).intValue() / Field.CELLSIZE;
            if (field.setPoint(x, y)) {
                if (playersTurn = player.makeMove()) printField();
                else playersTurn = bot.makeMove();
            }
        }
    };

    Parent getContent() {
        return field.getContent();
    }

    EventHandler<MouseEvent> getMouseHandler() {
        return mouseHandler;
    }

    private void printField() {
        System.out.println(field);
        System.out.println("--------------------------");
    }
}
