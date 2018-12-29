package my_simple_web_browser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class My_Simple_Web_Browser extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setTitle("SeijinD Browser");
        double width = 900;
        double height = 500;
        stage.setScene(new Scene(root, width, height));
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
    
}
