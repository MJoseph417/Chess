/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjs2w6chessf21;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author matthewschutz
 */
public class Mjs2w6ChessF21 extends Application {
    
    // following code referenced from https://umsystem.instructure.com/courses/6718/pages/lecture-31-switch-scenes-switcher-example?module_item_id=2923622
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        controller.start(stage);
    }
    // end of referenced code

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
