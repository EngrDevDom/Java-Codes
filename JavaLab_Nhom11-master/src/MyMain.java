import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyMain extends Application{


    private Label pname;
    private Label names;
    private TextField data;
    private Button add,pop,size;
    private VBox tp;
    private Label dev_name;
    private Stack<Integer> stack;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pstage) throws Exception {
        pstage = new Stage();
        pstage.setTitle("MidTerm Project JavaLab");

        // Main Screen
        Parent MainScreen = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(MainScreen);
        pstage.setScene(scene);
        pstage.show();





    }






}