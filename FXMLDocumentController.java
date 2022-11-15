/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjs2w6chessf21;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author matthewschutz
 */
public class FXMLDocumentController implements Initializable {
    
    // my own work
    @FXML
    private GridPane boardGridPane;
    @FXML
    private ImageView a1;
    @FXML
    private ImageView a2;
    @FXML
    private ImageView a3;
    @FXML
    private ImageView a4;
    @FXML
    private ImageView a5;
    @FXML
    private ImageView a6;
    @FXML
    private ImageView a7;
    @FXML
    private ImageView a8;
    @FXML
    private ImageView b1;
    @FXML
    private ImageView b2;
    @FXML
    private ImageView b3;
    @FXML
    private ImageView b4;
    @FXML
    private ImageView b5;
    @FXML
    private ImageView b6;
    @FXML
    private ImageView b7;
    @FXML
    private ImageView b8;
    @FXML
    private ImageView c1;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView c4;
    @FXML
    private ImageView c5;
    @FXML
    private ImageView c6;
    @FXML
    private ImageView c7;
    @FXML
    private ImageView c8;
    @FXML
    private ImageView d1;
    @FXML
    private ImageView d2;
    @FXML
    private ImageView d3;
    @FXML
    private ImageView d4;
    @FXML
    private ImageView d5;
    @FXML
    private ImageView d6;
    @FXML
    private ImageView d7;
    @FXML
    private ImageView d8;
    @FXML
    private ImageView e1;
    @FXML
    private ImageView e2;
    @FXML
    private ImageView e3;
    @FXML
    private ImageView e4;
    @FXML
    private ImageView e5;
    @FXML
    private ImageView e6;
    @FXML
    private ImageView e7;
    @FXML
    private ImageView e8;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView f2;
    @FXML
    private ImageView f3;
    @FXML
    private ImageView f4;
    @FXML
    private ImageView f5;
    @FXML
    private ImageView f6;
    @FXML
    private ImageView f7;
    @FXML
    private ImageView f8;
    @FXML
    private ImageView g1;
    @FXML
    private ImageView g2;
    @FXML
    private ImageView g3;
    @FXML
    private ImageView g4;
    @FXML
    private ImageView g5;
    @FXML
    private ImageView g6;
    @FXML
    private ImageView g7;
    @FXML
    private ImageView g8;
    @FXML
    private ImageView h1;
    @FXML
    private ImageView h2;
    @FXML
    private ImageView h3;
    @FXML
    private ImageView h4;
    @FXML
    private ImageView h5;
    @FXML
    private ImageView h6;
    @FXML
    private ImageView h7;
    @FXML
    private ImageView h8;
    
    @FXML
    private ImageView a1G;
    @FXML
    private ImageView a2G;
    @FXML
    private ImageView a3G;
    @FXML
    private ImageView a4G;
    @FXML
    private ImageView a5G;
    @FXML
    private ImageView a6G;
    @FXML
    private ImageView a7G;
    @FXML
    private ImageView a8G;
    @FXML
    private ImageView b1G;
    @FXML
    private ImageView b2G;
    @FXML
    private ImageView b3G;
    @FXML
    private ImageView b4G;
    @FXML
    private ImageView b5G;
    @FXML
    private ImageView b6G;
    @FXML
    private ImageView b7G;
    @FXML
    private ImageView b8G;
    @FXML
    private ImageView c1G;
    @FXML
    private ImageView c2G;
    @FXML
    private ImageView c3G;
    @FXML
    private ImageView c4G;
    @FXML
    private ImageView c5G;
    @FXML
    private ImageView c6G;
    @FXML
    private ImageView c7G;
    @FXML
    private ImageView c8G;
    @FXML
    private ImageView d1G;
    @FXML
    private ImageView d2G;
    @FXML
    private ImageView d3G;
    @FXML
    private ImageView d4G;
    @FXML
    private ImageView d5G;
    @FXML
    private ImageView d6G;
    @FXML
    private ImageView d7G;
    @FXML
    private ImageView d8G;
    @FXML
    private ImageView e1G;
    @FXML
    private ImageView e2G;
    @FXML
    private ImageView e3G;
    @FXML
    private ImageView e4G;
    @FXML
    private ImageView e5G;
    @FXML
    private ImageView e6G;
    @FXML
    private ImageView e7G;
    @FXML
    private ImageView e8G;
    @FXML
    private ImageView f1G;
    @FXML
    private ImageView f2G;
    @FXML
    private ImageView f3G;
    @FXML
    private ImageView f4G;
    @FXML
    private ImageView f5G;
    @FXML
    private ImageView f6G;
    @FXML
    private ImageView f7G;
    @FXML
    private ImageView f8G;
    @FXML
    private ImageView g1G;
    @FXML
    private ImageView g2G;
    @FXML
    private ImageView g3G;
    @FXML
    private ImageView g4G;
    @FXML
    private ImageView g5G;
    @FXML
    private ImageView g6G;
    @FXML
    private ImageView g7G;
    @FXML
    private ImageView g8G;
    @FXML
    private ImageView h1G;
    @FXML
    private ImageView h2G;
    @FXML
    private ImageView h3G;
    @FXML
    private ImageView h4G;
    @FXML
    private ImageView h5G;
    @FXML
    private ImageView h6G;
    @FXML
    private ImageView h7G;
    @FXML
    private ImageView h8G;
    
    Model model;
    
    public ArrayList<Square> moves;
    Square selectedSquare;
    
    Alert blackWinsAlert;
    Alert whiteWinsAlert;
    Alert stalemateAlert;
    
    Image wPawnImage;
    Image wKnightImage;
    Image wBishopImage;
    Image wRookImage;
    Image wQueenImage;
    Image wKingImage;
    Image bPawnImage;
    Image bKnightImage;
    Image bBishopImage;
    Image bRookImage;
    Image bQueenImage;
    Image bKingImage;
    Image greenSquareImage;
    
    String wPawnImageName = "WhitePawnImage.png";
    String wKnightImageName = "WhiteKnightImage.png";
    String wBishopImageName = "WhiteBishopImage.png";
    String wRookImageName = "WhiteRookImage.png";
    String wQueenImageName = "WhiteQueenImage.png";
    String wKingImageName = "WhiteKingImage.png";
    String bPawnImageName = "BlackPawnImage.png";
    String bKnightImageName = "BlackKnightImage.png";
    String bBishopImageName = "BlackBishopImage.png";
    String bRookImageName = "BlackRookImage.png";
    String bQueenImageName = "BlackQueenImage.png";
    String bKingImageName = "BlackKingImage.png";
    String greenSquareImageName = "GreenSquare.png";
    
    boolean pieceSelected;
    
    ImageView currentImage;
    
    private Stage stage;
    private Scene chessScene;
    private Scene aboutScene;
    private AboutController aboutController;
    
    Stack<ImageView> stack = new Stack<ImageView>();

    public FXMLDocumentController(){
        
        wPawnImage = new Image(getClass().getResourceAsStream(wPawnImageName));
        wKnightImage = new Image(getClass().getResourceAsStream(wKnightImageName));
        wBishopImage = new Image(getClass().getResourceAsStream(wBishopImageName));
        wRookImage = new Image(getClass().getResourceAsStream(wRookImageName));
        wQueenImage = new Image(getClass().getResourceAsStream(wQueenImageName));
        wKingImage = new Image(getClass().getResourceAsStream(wKingImageName));
        
        bPawnImage = new Image(getClass().getResourceAsStream(bPawnImageName));
        bKnightImage = new Image(getClass().getResourceAsStream(bKnightImageName));
        bBishopImage = new Image(getClass().getResourceAsStream(bBishopImageName));
        bRookImage = new Image(getClass().getResourceAsStream(bRookImageName));
        bQueenImage = new Image(getClass().getResourceAsStream(bQueenImageName));
        bKingImage = new Image(getClass().getResourceAsStream(bKingImageName));
        
        greenSquareImage = new Image(getClass().getResourceAsStream(greenSquareImageName));
        
        whiteWinsAlert = new Alert(AlertType.INFORMATION);
        whiteWinsAlert.setContentText("White has won!");
        whiteWinsAlert.setTitle("Game Over");
        whiteWinsAlert.setHeaderText("Checkmate!");
        
        blackWinsAlert = new Alert(AlertType.INFORMATION);
        blackWinsAlert.setContentText("Black has won!");
        blackWinsAlert.setTitle("Game Over");
        blackWinsAlert.setHeaderText("Checkmate!");
        
        stalemateAlert = new Alert(AlertType.INFORMATION);
        stalemateAlert.setContentText("Draw");
        stalemateAlert.setTitle("Game Over");
        stalemateAlert.setHeaderText("Stalemate");
        
        pieceSelected = false;
        moves = new ArrayList();
        model = new Model();
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    a1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,0,a1);
        }
        else{
            pieceMoved(7,0,a1);
        }
        
    });
        
    a2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,0,a2);
        }
        else{
            pieceMoved(6,0,a2);
        }
        
    });



    a3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,0,a3);
        }
        else{
            pieceMoved(5,0,a3);
        }
    });
    
    a4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,0,a4);
        }
        else{
            pieceMoved(4,0,a4);
        }
    });
    
    a5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,0,a5);
        }
        else{
            pieceMoved(3,0,a5);
        }
    });
    
    a6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,0,a6);
        }
        else{
            pieceMoved(2,0,a6);
        }
    });
    
    a7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,0,a7);
        }
        else{
            pieceMoved(1,0,a7);
        }
        
    });
    
    a8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,0,a8);
        }
        else{
            pieceMoved(0,0,a8);
        }
        
    });
    
    b1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,1,b1);
        }
        else{
            pieceMoved(7,1,b1);
        }
        
        
    });
    
    b2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,1,b2);
        }
        else{
            pieceMoved(6,1,b2);
        }
        
        
    });
    
    b3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,1,b3);
        }
        else{
            pieceMoved(5,1,b3);
        }
    });
    
    b4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,1,b4);
        }
        else{
            pieceMoved(4,1,b4);
        }
    });
    
    b5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,1,b5);
        }
        else{
            pieceMoved(3,1,b5);
        }
    });
    
    b6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,1,b6);
        }
        else{
            pieceMoved(2,1,b6);
        }
    });
    
    b7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,1,b7);
        }
        else{
            pieceMoved(1,1,b7);
        }
        
        
    });
    
    b8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,1,b8);
        }
        else{
            pieceMoved(0,1,b8);
        }
        
        
    });
    
    c1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,2,c1);
        }
        else{
            pieceMoved(7,2,c1);
        }
    });
    
    c2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,2,c2);
        }
        else{
            pieceMoved(6,2,c2);
        }
    });
    
    c3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,2,c3);
        }
        else{
            pieceMoved(5,2,c3);
        }
    });
    
    c4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,2,c4);
        }
        else{
            pieceMoved(4,2,c4);
        }
    });
    
    c5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,2,c5);
        }
        else{
            pieceMoved(3,2,c5);
        }
    });
    
    c6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,2,c6);
        }
        else{
            pieceMoved(2,2,c6);
        }
    });
    
    c7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,2,c7);
        }
        else{
            pieceMoved(1,2,c7);
        }
    });
    
    c8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,2,c8);
        }
        else{
            pieceMoved(0,2,c8);
        }
    });
    
    d1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,3,d1);
        }
        else{
            pieceMoved(7,3,d1);
        }
    });
    
    d2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,3,d2);
        }
        else{
            pieceMoved(6,3,d2);
        }
    });
    
    d3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,3,d3);
        }
        else{
            pieceMoved(5,3,d3);
        }
    });
    
    d4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,3,d4);
        }
        else{
            pieceMoved(4,3,d4);
        }
    });
    
    d5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,3,d5);
        }
        else{
            pieceMoved(3,3,d5);
        }
    });
    
    d6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,3,d6);
        }
        else{
            pieceMoved(2,3,d6);
        }
    });
    
    d7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,3,d7);
        }
        else{
            pieceMoved(1,3,d7);
        }
    });
    
    d8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,3,d8);
        }
        else{
            pieceMoved(0,3,d8);
        }
    });
    
    e1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,4,e1);
        }
        else{
            pieceMoved(7,4,e1);
        }
    });
    
    e2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,4,e2);
        }
        else{
            pieceMoved(6,4,e2);
        }
    });
    
    e3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,4,e3);
        }
        else{
            pieceMoved(5,4,e3);
        }
    });
    
    e4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,4,e4);
        }
        else{
            pieceMoved(4,4,e4);
        }
    });
    
    e5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,4,e5);
        }
        else{
            pieceMoved(3,4,e5);
        }
    });
    
    e6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,4,e6);
        }
        else{
            pieceMoved(2,4,e6);
        }
    });
    
    e7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,4,e7);
        }
        else{
            pieceMoved(1,4,e7);
        }
    });
    
    e8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,4,e8);
        }
        else{
            pieceMoved(0,4,e8);
        }
    });
    
    f1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,5,f1);
        }
        else{
            pieceMoved(7,5,f1);
        }
    });
    
    f2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,5,f2);
        }
        else{
            pieceMoved(6,5,f2);
        }
    });
    
    f3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,5,f3);
        }
        else{
            pieceMoved(5,5,f3);
        }
    });
    
    f4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,5,f4);
        }
        else{
            pieceMoved(4,5,f4);
        }
    });
    
    f5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,5,f5);
        }
        else{
            pieceMoved(3,5,f5);
        }
    });
    
    f6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,5,f6);
        }
        else{
            pieceMoved(2,5,f6);
        }
    });
    
    f7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,5,f7);
        }
        else{
            pieceMoved(1,5,f7);
        }
    });
    
    f8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,5,f8);
        }
        else{
            pieceMoved(0,5,f8);
        }
    });
    
    g1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,6,g1);
        }
        else{
            pieceMoved(7,6,g1);
        }
    });
    
    g2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,6,g2);
        }
        else{
            pieceMoved(6,6,g2);
        }
    });
    
    g3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,6,g3);
        }
        else{
            pieceMoved(5,6,g3);
        }
    });
    
    g4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,6,g4);
        }
        else{
            pieceMoved(4,6,g4);
        }
    });
    
    g5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,6,g5);
        }
        else{
            pieceMoved(3,6,g5);
        }
    });
    
    g6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,6,g6);
        }
        else{
            pieceMoved(2,6,g6);
        }
    });
    
    g7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,6,g7);
        }
        else{
            pieceMoved(1,6,g7);
        }
    });
    
    g8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,6,g8);
        }
        else{
            pieceMoved(0,6,g8);
        }
    });
    
    h1.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(7,7,h1);
        }
        else{
            pieceMoved(7,7,h1);
        }
    });
    
    h2.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(6,7,h2);
        }
        else{
            pieceMoved(6,7,h2);
        }
    });
    
    h3.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(5,7,h3);
        }
        else{
            pieceMoved(5,7,h3);
        }
    });
    
    h4.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(4,7,h4);
        }
        else{
            pieceMoved(4,7,h4);
        }
    });
    
    h5.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(3,7,h5);
        }
        else{
            pieceMoved(3,7,h5);
        }
    });
    
    h6.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(2,7,h6);
        }
        else{
            pieceMoved(2,7,h6);
        }
    });
    
    h7.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(1,7,h7);
        }
        else{
            pieceMoved(1,7,h7);
        }
    });
    
    h8.setOnMouseClicked((MouseEvent event) -> {
        
        if(pieceSelected == false){
            pieceClicked(0,7,h8);
        }
        else{
            pieceMoved(0,7,h8);
        }
    });
    }
    // end of own work
    
    // following code referenced from https://umsystem.instructure.com/courses/6718/pages/lecture-31-switch-scenes-switcher-example?module_item_id=2923622
    public void start(Stage stage){
        this.stage = stage; 
        chessScene = stage.getScene(); 
        System.out.println("Page 1 has started"); 
    }
    
    @FXML
    private void goToAbout(ActionEvent event){
        System.out.println("Going to about");
        
        try{
            if(aboutScene == null){
                System.out.println("AboutScene is null");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
                Parent aboutRoot = loader.load();
                aboutController = loader.getController();
                aboutController.chessScene = chessScene;
                aboutController.fxmlDocumentController = this;
                aboutScene = new Scene(aboutRoot);
            }
        } catch (Exception e){
            
        }
        
        stage.setScene(aboutScene);
        aboutController.start(stage);
    }
    // end of referenced code
    
    // my own work
    public void drawPath(ArrayList<Square> squares){
        
        for( Square s : squares){
            
            if(s.getX() >= 0 && s.getX() <= 7){
                ImageView iV = pickGSquare(s.getY(), s.getX());
                stack.push(iV);
                iV.setImage(greenSquareImage);
            }  
        }
        if(squares.isEmpty()) System.out.println("Empty set of moves");
        
        
    }
    
    public void pieceClicked(int y, int x, ImageView imageClicked){
        System.out.println(imageClicked);
        moves = model.pieceClicked(y, x);

        try{
            drawPath(moves);
            pieceSelected = true;
            selectedSquare = new Square(y,x);
            currentImage = imageClicked;

        }
        catch(NullPointerException e){
                System.out.println("No possible moves");
        }
    }
    
    public void pieceMoved(int y, int x, ImageView newImage){
        while(!stack.empty())
        {
            ImageView iV = stack.pop();
            iV.setImage(null);
        }
        for( Square s : moves){
                if(s.getX() == x && s.getY() == y){
                    Type pieceType = model.movePiece(s);
                    System.out.println("CI = " + currentImage + " : NI = " + newImage);
                    currentImage.setImage(null);
                    newImage.setImage(pickImage(pieceType, y, x));
                    if(s.getCastleType() != Castle.NONE) castle(s.getCastleType());
                    if(model.isEnPass())
                    {
                        int yOffset = model.enPassOffset();
                        ImageView enPassIV = pickEPSquare(y+yOffset, x);
                        enPassIV.setImage(null);
                    }
                }
            }
            pieceSelected = false;
            if(model.whiteCheckmate()){
                whiteWinsAlert.show();
            }
            if(model.blackCheckmate()){
                blackWinsAlert.show();
            }
            if(model.isStalemate()){
                stalemateAlert.show();
            }
    }
    
    private void castle(Castle castleType)
    {
        if(castleType == Castle.WA)
        {
            a1.setImage(null);
            d1.setImage(wRookImage);
            return;
        }
        if(castleType == Castle.WH)
        {
            h1.setImage(null);
            f1.setImage(wRookImage);
            return;
        }
        if(castleType == Castle.BA)
        {
            a8.setImage(null);
            d8.setImage(bRookImage);
            return;
        }
        if(castleType == Castle.BH)
        {
            h8.setImage(null);
            f8.setImage(bRookImage);
            return;
        }
    }
    
    public Image pickImage(Type type, int y, int x){
        
        Player p = model.getPlayer(y, x);
        
        if(p == Player.WHITE){
            
            if(type == Type.PAWN){
                return wPawnImage;
            }
            else if(type == Type.KNIGHT){
                return wKnightImage;
            }
            else if(type == Type.BISHOP){
                return wBishopImage;
            }
            else if(type == Type.ROOK){
                return wRookImage;
            }
            else if(type == Type.QUEEN){
                return wQueenImage;
            }
            else if(type == Type.KING){
                return wKingImage;
            }
            
        }
        else if(p == Player.BLACK){
            
            if(type == Type.PAWN){
                return bPawnImage;
            }
            else if(type == Type.KNIGHT){
                return bKnightImage;
            }
            else if(type == Type.BISHOP){
                return bBishopImage;
            }
            else if(type == Type.ROOK){
                return bRookImage;
            }
            else if(type == Type.QUEEN){
                return bQueenImage;
            }
            else if(type == Type.KING){
                return bKingImage;
            }
            
        }
        
        
        return null;
    }
    
    private ImageView pickEPSquare(int y, int x)
    {
        switch(x)
        {
            case 0:
                switch(y)
                {
                    case 3:
                        return a5;
                    case 4:
                        return a4;
                }
            case 1:
                switch(y)
                {
                    case 3:
                        return b5;
                    case 4:
                        return b4;
                }
            case 2:
                switch(y)
                {
                    case 3:
                        return c5;
                    case 4:
                        return c4;
                }
            case 3:
                switch(y)
                {
                    case 3:
                        return d5;
                    case 4:
                        return d4;
                }
            case 4:
                switch(y)
                {
                    case 3:
                        return e5;
                    case 4:
                        return e4;
                }
            case 5:
                switch(y)
                {
                    case 3:
                        return f5;
                    case 4:
                        return f4;
                }
            case 6:
                switch(y)
                {
                    case 3:
                        return g5;
                    case 4:
                        return g4;
                }
            case 7:
                switch(y)
                {
                    case 3:
                        return h5;
                    case 4:
                        return h4;
                }
        }
        return null;
    }
    
    private ImageView pickGSquare(int y, int x)
    {
        switch(x)
        {
            case 0:
                switch(y)
                {
                    case 0:
                        return a8G;
                    case 1:
                        return a7G;
                    case 2:
                        return a6G;
                    case 3:
                        return a5G;
                    case 4:
                        return a4G;
                    case 5:
                        return a3G;
                    case 6:
                        return a2G;
                    case 7:
                        return a1G;
                }
            case 1:
                switch(y)
                {
                    case 0:
                        return b8G;
                    case 1:
                        return b7G;
                    case 2:
                        return b6G;
                    case 3:
                        return b5G;
                    case 4:
                        return b4G;
                    case 5:
                        return b3G;
                    case 6:
                        return b2G;
                    case 7:
                        return b1G;
                }
            case 2:
                switch(y)
                {
                    case 0:
                        return c8G;
                    case 1:
                        return c7G;
                    case 2:
                        return c6G;
                    case 3:
                        return c5G;
                    case 4:
                        return c4G;
                    case 5:
                        return c3G;
                    case 6:
                        return c2G;
                    case 7:
                        return c1G;
                }
            case 3:
                switch(y)
                {
                    case 0:
                        return d8G;
                    case 1:
                        return d7G;
                    case 2:
                        return d6G;
                    case 3:
                        return d5G;
                    case 4:
                        return d4G;
                    case 5:
                        return d3G;
                    case 6:
                        return d2G;
                    case 7:
                        return d1G;
                }
            case 4:
                switch(y)
                {
                    case 0:
                        return e8G;
                    case 1:
                        return e7G;
                    case 2:
                        return e6G;
                    case 3:
                        return e5G;
                    case 4:
                        return e4G;
                    case 5:
                        return e3G;
                    case 6:
                        return e2G;
                    case 7:
                        return e1G;
                }
            case 5:
                switch(y)
                {
                    case 0:
                        return f8G;
                    case 1:
                        return f7G;
                    case 2:
                        return f6G;
                    case 3:
                        return f5G;
                    case 4:
                        return f4G;
                    case 5:
                        return f3G;
                    case 6:
                        return f2G;
                    case 7:
                        return f1G;
                }
            case 6:
                switch(y)
                {
                    case 0:
                        return g8G;
                    case 1:
                        return g7G;
                    case 2:
                        return g6G;
                    case 3:
                        return g5G;
                    case 4:
                        return g4G;
                    case 5:
                        return g3G;
                    case 6:
                        return g2G;
                    case 7:
                        return g1G;
                }
            case 7:
                switch(y)
                {
                    case 0:
                        return h8G;
                    case 1:
                        return h7G;
                    case 2:
                        return h6G;
                    case 3:
                        return h5G;
                    case 4:
                        return h4G;
                    case 5:
                        return h3G;
                    case 6:
                        return h2G;
                    case 7:
                        return h1G;
                }
        }
        return null;
    }
    //end of own work
}
