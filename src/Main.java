import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    private MouseButton mouse;
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("GameScene");
        primaryStage.setResizable(false);

        // code 2 test de la scene fin

        /*Group groupFin = new Group();
        StaticScene fin = new StaticScene(groupFin,800,400,true);
        Text Scoretext = new Text("score");
        Label words = new Label("Seems you get arrested cowboy");
        words.setLayoutX(400);
        words.setLayoutY(140);
        words.setFont(new Font("Playbill",50));
        words.setTextFill(Color.BLACK);

        Label tryAgain = new Label("Re run to try again");
        tryAgain.setLayoutX(650);
        tryAgain.setLayoutY(360);
        tryAgain.setFont(new Font("Playbill",25));
        tryAgain.setTextFill(Color.BLACK);

        groupFin.getChildren().add(fin.getBackground().getImageView());
        groupFin.getChildren().add(fin.getHero().getImageView());
        groupFin.getChildren().add(fin.getMechant().getImageView());
        groupFin.getChildren().add(words);
        groupFin.getChildren().add(tryAgain);

        staticThing etoile = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\etoile_sheriff.png",0,0,465,512,100,100);
        etoile.getImageView().setFitWidth(325);
        etoile.getImageView().setFitHeight(325);
        etoile.getImageView().setX(60);
        etoile.getImageView().setY(5);
        groupFin.getChildren().add(etoile.getImageView());

        Scoretext.setX(300);
        Scoretext.setY(350);
        groupFin.getChildren().add(Scoretext);

        primaryStage.setScene(fin);
        primaryStage.show();*/


        //code 3 :test

        Group group1 = new Group();
        StaticScene sceneIntro = new StaticScene(group1,800,400,true);
        Group root = new Group();
        GameScene Gamescene = new GameScene(root, 800, 400, true,primaryStage);
        Group group2 = new Group();
        StaticScene sceneFinale = new StaticScene(group2,800,400, true);
        Group group3 = new Group();
        StaticScene sceneCommand = new StaticScene(group3,800,400,true);

        //sceneIntro
        Button button1= new Button("Play");
        button1.setOnAction(e -> primaryStage.setScene(Gamescene));
        Button button4 = new Button("Command");
        button4.setOnAction(e -> primaryStage.setScene(sceneCommand));
        Label labelBienvenue = new Label("BIENVENUE", new Rectangle(300,600,1,1));
        Label signature = new Label("Baptiste Cottu - 2021", new Rectangle(300,600,1,1));

        group1.getChildren().add(sceneIntro.getBackground().getImageView());
        group1.getChildren().add(sceneIntro.getHero().getImageView());
        group1.getChildren().add(sceneIntro.getMechant().getImageView());

        button1.setLayoutX(300);
        button1.setLayoutY(200);
        button4.setLayoutX(450);
        button4.setLayoutY(200);

        labelBienvenue.setLayoutX(320);
        labelBienvenue.setLayoutY(50);
        labelBienvenue.setFont(new Font("Playbill",50));
        labelBienvenue.setTextFill(Color.RED);

        signature.setFont(new Font("Playbill",25));
        signature.setTextFill(Color.BLACK);
        signature.setLayoutX(620);
        signature.setLayoutY(370);

        group1.getChildren().add(button1);
        group1.getChildren().add(button4);
        group1.getChildren().add(labelBienvenue);
        group1.getChildren().add(signature);

        // GameScene
        root.getChildren().add(Gamescene.getBackgroundLeft().getImageView());
        root.getChildren().add(Gamescene.getBackgroundRight().getImageView());
        root.getChildren().add(Gamescene.getHero().getImageView());
        root.getChildren().add(Gamescene.getLife().getImageView());
        root.getChildren().add(Gamescene.getMechant().getImageView());
        root.getChildren().add(Gamescene.getScoretext());
        Gamescene.getTimer().handle(0);
        Gamescene.getTimer().start();

        //SceneCommands
        Button button3= new Button("Back to menu");
        button3.setOnAction(e -> primaryStage.setScene(sceneIntro));

        Label labelCommands = new Label("Commands",new Rectangle(300,600,1,1));
        Label instructions = new Label("ESC : Pause\nUP : Jump\nRIGHT : Boost\nLEFT : Stop Boost", new Rectangle(300,600,1,1));
        group3.getChildren().add(sceneCommand.getBackground().getImageView());
        group3.getChildren().add(sceneCommand.getMechant().getImageView());
        group3.getChildren().add(sceneCommand.getHero().getImageView());

        button3.setLayoutX(600);
        button3.setLayoutY(350);

        labelCommands.setFont(new Font("Playbill",50));
        labelCommands.setTextFill(Color.RED);
        labelCommands.setLayoutX(320);
        labelCommands.setLayoutY(20);

        instructions.setLayoutY(145);
        instructions.setLayoutX(340);
        instructions.setFont(new Font("Playbill",25));
        instructions.setTextFill(Color.RED);

        group3.getChildren().add(button3);
        group3.getChildren().add(labelCommands);
        group3.getChildren().add(instructions);


        primaryStage.setScene(sceneIntro);
        primaryStage.show();


        /*// code 5 : exemple timeline
        Group root = new Group();
        Scene scene = new Scene(root,800,400);

        //cree le rect rouge
        final Rectangle rectBasicTimeline = new Rectangle(100, 50, 100, 50);
        rectBasicTimeline.setFill(Color.RED);
        //cree la timeline
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 300);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();

        root.getChildren().add(rectBasicTimeline);
        primaryStage.setScene(scene);
        primaryStage.show();*/


        /*//code8 : test event fonctionnel

        BorderPane root = new BorderPane();
        ToggleButton button = new ToggleButton("Click");
        //MouseButton mouse = null;

        final StringProperty btnText = button.textProperty();

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 150, 1);
        
        button.setOnAction((event) -> {    // lambda expression
            ToggleButton source = (ToggleButton) event.getSource();
            if(source.isSelected()) {
                btnText.set("Clicked!");
                hero.getImageView().setY(0);
            } else {
                btnText.set("Click!");
                hero.getImageView().setY(300);
            }
        });
        root.setCenter(hero.getImageView());
        root.setBottom(button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();*/

        //code 9 : test sceneIntro
        /*Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();

        StaticScene sceneIntro = new StaticScene(group1,800,400,true);
        StaticScene sceneFinale = new StaticScene(group2,800,400, true);
        StaticScene sceneCommand = new StaticScene(group3,800,400,true);

        //sceneIntro
        Button button1= new Button("Play");
        button1.setOnAction(e -> primaryStage.setScene(sceneFinale));
        Button button4 = new Button("Command");
        button4.setOnAction(e -> primaryStage.setScene(sceneCommand));
        Label labelBienvenue = new Label("BIENVENUE", new Rectangle(300,600,1,1));
        Label signature = new Label("Baptiste Cottu - 2021", new Rectangle(300,600,1,1));

        group1.getChildren().add(sceneIntro.getBackground().getImageView());
        group1.getChildren().add(sceneIntro.getHero().getImageView());
        group1.getChildren().add(sceneIntro.getMechant().getImageView());

        button1.setLayoutX(300);
        button1.setLayoutY(200);
        button4.setLayoutX(450);
        button4.setLayoutY(200);

        labelBienvenue.setLayoutX(320);
        labelBienvenue.setLayoutY(50);
        labelBienvenue.setFont(new Font("Playbill",50));
        labelBienvenue.setTextFill(Color.RED);

        signature.setFont(new Font("Playbill",25));
        signature.setTextFill(Color.BLACK);
        signature.setLayoutX(620);
        signature.setLayoutY(370);

        group1.getChildren().add(button1);
        group1.getChildren().add(button4);
        group1.getChildren().add(labelBienvenue);
        group1.getChildren().add(signature);

        //sceneFinale
        Button button2= new Button("Try again");
        button2.setOnAction(e -> primaryStage.setScene(sceneIntro));

        Label GameOver = new Label("GAME OVER",new Rectangle(300,600,1,1));
        group2.getChildren().add(sceneFinale.getBackground().getImageView());
        group2.getChildren().add(sceneFinale.getMechant().getImageView());
        group2.getChildren().add(sceneFinale.getHero().getImageView());

        button2.setLayoutX(380);
        button2.setLayoutY(200);

        GameOver.setLayoutX(330);
        GameOver.setLayoutY(100);
        GameOver.setTextFill(Color.RED);
        GameOver.setFont(new Font("Playbill",50));
        group2.getChildren().add(button2);
        group2.getChildren().add(GameOver);

        //scene de commandes
        Button button3= new Button("Back to menu");
        button3.setOnAction(e -> primaryStage.setScene(sceneIntro));

        Label labelCommands = new Label("Commands",new Rectangle(300,600,1,1));
        Label instructions = new Label("UP : Jump\nRIGHT : Boost\nLEFT : Stop Boost", new Rectangle(300,600,1,1));
        group3.getChildren().add(sceneCommand.getBackground().getImageView());
        group3.getChildren().add(sceneCommand.getMechant().getImageView());
        group3.getChildren().add(sceneCommand.getHero().getImageView());

        button3.setLayoutX(600);
        button3.setLayoutY(350);

        labelCommands.setFont(new Font("Playbill",50));
        labelCommands.setTextFill(Color.RED);
        labelCommands.setLayoutX(320);
        labelCommands.setLayoutY(20);

        instructions.setLayoutY(160);
        instructions.setLayoutX(340);
        instructions.setFont(new Font("Playbill",25));
        instructions.setTextFill(Color.RED);

        group3.getChildren().add(button3);
        group3.getChildren().add(labelCommands);
        group3.getChildren().add(instructions);



        primaryStage.setScene(sceneCommand);
        primaryStage.show();*/

    }

    public static void main(String[] args) {
        launch(args);
        //write your code here

    }
}
