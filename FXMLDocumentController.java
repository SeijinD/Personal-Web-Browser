package my_simple_web_browser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    String httpLink = "http://";
    
    @FXML
    private Button fullScreen;
    
    @FXML
    private TextField addressBar;
    
    String addressLink;
    
    @FXML
    WebView web;
    
    WebEngine engine;
    
    public void go(ActionEvent event){
        addressLink = addressBar.getText();
        engine.load(httpLink+addressLink);
    }
        
    public void pressAddressBar(KeyEvent key){
        if (key.getCode().equals(KeyCode.ENTER))
        {
            addressLink = addressBar.getText();
            engine.load(httpLink+addressLink);
        }
    }
    
    public void refresh(ActionEvent event){
        web.getEngine().reload();
    }
    
    public void pressWeb(KeyEvent key){
        
        if (key.getCode().equals(KeyCode.F5))
        {
            web.getEngine().reload();
        }
        else if (key.getCode().equals(KeyCode.F6))
        {
            web.getEngine().getHistory().go(-1);
        }
    }
    
    public void back(ActionEvent event){
        web.getEngine().getHistory().go(-1);
    }
    
    public void forward(ActionEvent event){
        web.getEngine().getHistory().go(1);
    }
    
    public void plusWeb(ActionEvent event) throws Exception{
        Stage plusStage = new Stage();
        My_Simple_Web_Browser menu = new My_Simple_Web_Browser();
        menu.start(plusStage);
        plusStage.show();
    }
    
    public void fullScreen(ActionEvent event){
        Stage stage = (Stage) fullScreen.getScene().getWindow();
        if (stage.isFullScreen()==true)
            stage.setFullScreen(false);
        else
            stage.setFullScreen(true); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = web.getEngine();
        engine.load(httpLink+"www.google.com");
    }    
    
}
