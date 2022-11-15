/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjs2w6chessf21;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author matthewschutz         
 */
public class AboutController implements Initializable {

    // Following code referenced from https://umsystem.instructure.com/courses/6718/pages/lecture-31-switch-scenes-switcher-example?module_item_id=2923622
    private Stage stage;
    public Scene chessScene;
    public FXMLDocumentController fxmlDocumentController;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void start(Stage stage){
        this.stage = stage;
        System.out.println("About has started!");
    }
    
    @FXML
    private void returnToGame(ActionEvent event){
        stage.setScene(chessScene);
    }
    // end of referenced code
    
}
