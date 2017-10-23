package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Game game = new Game();
        Scene scene = new Scene(game.getContent());
        scene.setOnMouseClicked(game.getMouseHandler());
        primaryStage.setTitle("Blots");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
