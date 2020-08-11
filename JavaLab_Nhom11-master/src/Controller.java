import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;


public class Controller {
    //    @FXML
    private Label pname;
    private Label names;
    private TextField data;
    private Button add,pop,size;
    private VBox tp;
    private Label dev_name;
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    LinearProbing hashTable = new LinearProbing();

    Scene scene;
    BorderPane root;
    Pane wrapperPane;

    Canvas canvas = new Canvas(970, 700);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    Button insert;
    Button remove;
    Button search;
    Button reset;
    Button create;

    Label valueL;
    Label keyL;
    Label tableSize;
    Label loadFactor;

    TextField keyTF;
    TextField valueTF;
    TextField tableSizeTF;
    TextField loadFactorTF;

    HBox commands;
    HBox newTable;
    VBox menu;

    public void changeStackScreen(ActionEvent event) throws IOException {
        stack = new Stack<>();


        GridPane root = new GridPane();
        root.setTranslateY(50);
        root.setAlignment(Pos.TOP_CENTER);


        HBox hb = new HBox();
        hb.setPadding(new Insets(20));
        hb.setSpacing(15);
        hb.setStyle("-fx-background-color: #fff;");

        data = new TextField();
        data.setPromptText("Enter data eg. 10");
        data.setId("data");
        hb.getChildren().add(data);

        add = new Button("PUSH");
        add.setId("add");
        add.setCursor(Cursor.HAND);
        hb.getChildren().add(add);

        pop = new Button("POP");
        pop.setId("pop");
        pop.setCursor(Cursor.HAND);
        hb.getChildren().add(pop);


        size = new Button("Size:"+stack.size());
        size.setId("pop");
        size.setCursor(Cursor.HAND);
        hb.getChildren().add(size);

        root.add(hb, 0, 2);



        ScrollPane sp = new ScrollPane();


        pname = new Label("STACK");
        pname.setStyle("-fx-text-fill:#000;");
        pname.setFont(Font.font("Arial", FontWeight.BOLD, 19));

        HBox hb1 = new HBox();
        hb1.setId("root1");
        hb1.getChildren().add(pname);

        root.add(hb1, 0, 1);

        tp = new VBox();
        tp.setPadding(new Insets(10,10,30,10));
        tp.setSpacing(5);
        sp.setStyle("-fx-background-color: #fff;-fx-background-radius:0px 0px 4px 4px;");

        sp.setContent(tp);
        sp.setPrefWidth(500);
        sp.setPrefHeight(500);
        root.add(sp, 0, 3);


        add.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {



                try{
                    Integer d = Integer.parseInt(data.getText().toString());


                    names = new Label(""+d);
                    names.setStyle("-fx-background-color: #fff;-fx-padding:10px 223px 10px 223px;-fx-background-radius:4px;-fx-border-color: black;-fx-border-radius:100px;-fx-background-radius:100px;");
                    names.setFont(Font.font("Arial",FontWeight.SEMI_BOLD, 17));


                    TranslateTransition translate = new TranslateTransition();
                    translate.setByY(20);
                    translate.setDuration(Duration.millis(1000));
                    translate.setCycleCount(1);
                    translate.setAutoReverse(true);
                    translate.setNode(names);
                    translate.play();


                    tp.getChildren().addAll(names);

                    stack.push(d);

                    //System.out.println(""+stack.size());
                    size.setText("Size:"+stack.size());

                }catch(NumberFormatException e){
                    System.out.println("please enter any number!");
                }

            }
        });


        pop.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent arg0) {

                if(stack.size() > 0){

                    tp.getChildren().remove(tp.getChildren().size()-1);
                    stack.pop();
                    size.setText("Size:"+stack.size());

                }else{
                    System.out.println("stack is empty");
                }


            }
        });


        Scene sceneStack = new Scene(root,600,600, Color.STEELBLUE);
        root.setId("root");
        sceneStack.getStylesheets().add("styles.css");

//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage window = new Stage();

        window.setScene(sceneStack);
        window.show();
    }


    // Queue
    public void changeQueueScreen(ActionEvent event) throws IOException {
        queue = new LinkedList<>();

        GridPane root = new GridPane();
        root.setTranslateY(50);
        root.setAlignment(Pos.TOP_CENTER);


        HBox hb = new HBox();
        hb.setPadding(new Insets(20));
        hb.setSpacing(15);
        hb.setStyle("-fx-background-color: #fff;");

        data = new TextField();
        data.setPromptText("Enter data eg. 10");
        data.setId("data");
        hb.getChildren().add(data);

        add = new Button("Enqueue");
        add.setId("add");
        add.setCursor(Cursor.HAND);
        hb.getChildren().add(add);

        pop = new Button("Dequeue");
        pop.setId("pop");
        pop.setCursor(Cursor.HAND);
        hb.getChildren().add(pop);


        size = new Button("Size:"+queue.size());
        size.setId("pop");
        size.setCursor(Cursor.HAND);
        hb.getChildren().add(size);

        root.add(hb, 0, 2);



        ScrollPane sp = new ScrollPane();


        pname = new Label("Queue");
        pname.setStyle("-fx-text-fill:#000;");
        pname.setFont(Font.font("Arial", FontWeight.BOLD, 19));

        HBox hb1 = new HBox();
        hb1.setId("root1");
        hb1.getChildren().add(pname);

        root.add(hb1, 0, 1);

        tp = new VBox();
        tp.setPadding(new Insets(10,10,30,10));
        tp.setSpacing(5);
        sp.setStyle("-fx-background-color: #fff;-fx-background-radius:0px 0px 4px 4px;");

        sp.setContent(tp);
        sp.setPrefWidth(500);
        sp.setPrefHeight(500);
        root.add(sp, 0, 3);


        add.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {



                try{
                    Integer d = Integer.parseInt(data.getText().toString());


                    names = new Label(""+d);
                    names.setStyle("-fx-background-color: #fff;-fx-padding:10px 223px 10px 223px;-fx-background-radius:4px;-fx-border-color: black;-fx-border-radius:100px;-fx-background-radius:100px;");
                    names.setFont(Font.font("Arial",FontWeight.SEMI_BOLD, 17));


                    TranslateTransition translate = new TranslateTransition();
                    translate.setByY(20);
                    translate.setDuration(Duration.millis(1000));
                    translate.setCycleCount(1);
                    translate.setAutoReverse(true);
                    translate.setNode(names);
                    translate.play();

                    tp.getChildren().addAll(names);

                    queue.add(d);

                    //System.out.println(""+stack.size());
                    size.setText("Size:"+queue.size());

                }catch(NumberFormatException e){
                    System.out.println("please enter any number!");
                }

            }
        });


        pop.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent arg0) {

                if(queue.size() > 0){

                    tp.getChildren().remove(0);
                    queue.remove();

                    size.setText("Size:"+queue.size());

                }else{
                    System.out.println("stack is empty");
                }


            }
        });


        Scene sceneQueue = new Scene(root,600,600, Color.STEELBLUE);
        root.setId("root");
        sceneQueue.getStylesheets().add("styles.css");

//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(sceneQueue);
        window.show();
    }
    // HashTable
    public void changeHashScreen() throws IOException {
        Stage primaryStage = new Stage();
        draw(" ");
        drawHeader();

        insert = new Button("Insert");
        remove = new Button("Remove");
        search = new Button("Search");
        reset = new Button("Reset");
        create = new Button("Create new table");

        keyL = new Label("Enter a key: ");
        keyL.setTextFill(Color.WHITE);
        valueL = new Label("Enter a value: ");
        valueL.setTextFill(Color.WHITE);
        tableSize = new Label("Table size: ");
        tableSize.setTextFill(Color.WHITE);
        loadFactor = new Label("Load factor: ");
        loadFactor.setTextFill(Color.WHITE);

        keyTF = new TextField();
        keyTF.setPrefWidth(60);
        valueTF = new TextField();
        valueTF.setPrefWidth(60);
        tableSizeTF = new TextField();
        tableSizeTF.setPrefWidth(50);
        tableSizeTF.setText("4");
        loadFactorTF = new TextField();
        loadFactorTF.setPrefWidth(50);
        loadFactorTF.setText("0.5");

        root = new BorderPane();
        wrapperPane = new Pane();
        wrapperPane.getChildren().add(canvas);
        wrapperPane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
        root.setCenter(wrapperPane);

        commands = new HBox();
        commands.setAlignment(Pos.CENTER);
        newTable = new HBox();
        newTable.setAlignment(Pos.CENTER);
        menu = new VBox();

        commands.getChildren().addAll(keyL, keyTF, valueL, valueTF, insert, remove, search);
        newTable.getChildren().addAll(tableSize, tableSizeTF, loadFactor, loadFactorTF, create, reset);
        menu.getChildren().addAll(commands, newTable);
        root.setBottom(menu);

        commands.setPadding(new Insets(15));
        commands.setSpacing(10);
        commands.setStyle("-fx-background-color: #4682B4; -fx-border-color: black; -fx-border-width: 2px; -fx-border-style: hidden solid solid solid;");

        newTable.setPadding(new Insets(15));
        newTable.setSpacing(10);
        newTable.setStyle("-fx-background-color: #4682B4; -fx-border-color: black; -fx-border-width: 2px; -fx-border-style: hidden solid solid solid;");

        insert.setOnAction((ActionEvent event) -> {
            if(hashTable.getCurrentSize() == 21) {
                JOptionPane.showMessageDialog(null, "The table is full!", "FULL TABLE!", JOptionPane.WARNING_MESSAGE);
                keyTF.clear();
                valueTF.clear();
                return;
            }

            String key = keyTF.getText().replaceAll("\\s+","");
            String value = valueTF.getText().replaceAll("\\s+","");

            if (key.equals("") || value.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter a key and a value!", "Enter key and value!", JOptionPane.WARNING_MESSAGE);
                keyTF.clear();
                valueTF.clear();
                return;
            }

            if(key.length() > 4) {
                key = key.substring(0, 4);
            }

            if (value.length() > 4) {
                value = value.substring(0, 4);
            }

            hashTable.insert(key, value);
            draw(" ");
            drawHeader();
            keyTF.clear();
            valueTF.clear();
        });

        remove.setOnAction((ActionEvent event) -> {
            String key = keyTF.getText().replaceAll("\\s+","");
            if (key.equals("")) {
                keyTF.clear();
                valueTF.clear();
                return;
            }

            if(key.length() > 4) {
                key = key.substring(0, 4);
            }

            boolean containsKey = hashTable.contains(key);

            if(containsKey) {
                hashTable.delete(key);
            } else  {
                JOptionPane.showMessageDialog(null, key + " is not in the table!", "Not found!", JOptionPane.INFORMATION_MESSAGE);
            }

            draw(" ");
            drawHeader();
            keyTF.clear();
            valueTF.clear();

        });

        search.setOnAction((ActionEvent event) -> {
            String key = keyTF.getText().replaceAll("\\s+","");
            if (key.equals("")) {
                keyTF.clear();
                valueTF.clear();
                return;
            }

            if(key.length() > 4) {
                key = key.substring(0, 4);
            }

            boolean containsKey = hashTable.contains(key);

            if (!containsKey) {
                JOptionPane.showMessageDialog(null, key + " is not in the table!", "Not found!", JOptionPane.INFORMATION_MESSAGE);
                draw(" ");
            } else {
                JOptionPane.showMessageDialog(null, key + " has been found!", "Success!", JOptionPane.OK_OPTION);
                draw(key);
            }

            drawHeader();
            keyTF.clear();
            valueTF.clear();
        });

        reset.setOnAction((ActionEvent event) -> {
            hashTable = new LinearProbing();
            draw(" ");
            drawHeader();
            keyTF.clear();
            valueTF.clear();
        });

        create.setOnAction((ActionEvent event) -> {
            int ts;
            double lf;

            if(tableSizeTF.getText().matches("^\\d+") && loadFactorTF.getText().matches("^\\d\\.\\d+")) {
                ts = Integer.parseInt(tableSizeTF.getText());
                lf = Double.parseDouble(loadFactorTF.getText());

                if((ts > 1 && ts < 22) && (lf > 0.0 && lf < 1.0)) {
                    hashTable = new LinearProbing(ts, lf);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Table size must be 1 < x < 22 !\nLoad factor must be 0 < x < 1 !", "Table not functional!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Table size must be 1 < x < 22 !\nLoad factor must be 0 < x < 1 !", "Table not functional!", JOptionPane.WARNING_MESSAGE);
            }

            draw(" ");
            drawHeader();
            tableSizeTF.clear();
            loadFactorTF.clear();
        });


        scene = new Scene(root, 960, 800);

        primaryStage.setTitle("Hash Table!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void draw(String str) {
        int width = (int) canvas.getWidth();
        int height = (int) canvas.getHeight();

        gc.clearRect(0, 0, width, height);
        gc.setFont(Font.font ("Verdana", 25));
        gc.setFill(Color.WHITE);

        int row = 0, n = 0, x = 1, y = 4;
        for (String key : hashTable.getKeys()) {
            if(row == 7) {
                x += 300;
                y = 4;
                row = 0;
            }

            if(key.equals(str)) {
                gc.setFill(Color.RED);
            } else {
                gc.setFill(Color.BLACK);
            }

            gc.fillText("(" + String.valueOf(n) + ")", x + 60, y * 60);
            gc.fillText("[" + key + "] -> " + String.valueOf(hashTable.getValue(key)), x + 135, y * 60);

            row++;
            y++;
            n++;
        }

    }

    public void drawHeader() {
        gc.setFont(Font.font ("Verdana", 25));

        gc.setFill(Color.BLACK);

        gc.fillText("Table Size: ", 161, 1*50);
        gc.fillText("Current Size: ", 161, 2*50);

        gc.fillText("Load Factor: ", 561, 1*50);
        gc.fillText("Current LF: ", 561, 2*50);

        gc.setFill(Color.RED);

        gc.fillText(String.valueOf(new DecimalFormat("#.##").format(hashTable.getLoadFactor())), 770, 1*50);
        gc.fillText(String.valueOf(hashTable.getMaxSize()), 370, 1*50);

        gc.setFill(Color.YELLOWGREEN);

        gc.fillText(String.valueOf(new DecimalFormat("#.##").format(hashTable.getCurrentLoadFactor())), 770, 2*50);
        gc.fillText(String.valueOf(hashTable.getCurrentSize()), 370, 2*50);

        gc.setStroke(Color.BLACK);

        gc.strokeLine(0, 150, 970, 150);

    }
}