package bingo;

import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameWindow extends Application {

    @Override
        public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bingo");

        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
		Game g = new Game(3);
		g.run();
    }
    

}

