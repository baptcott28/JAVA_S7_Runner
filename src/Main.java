import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("GameScene");

        //code 1 test setup image
        /*Group root = new Group();
        Scene theScene = new Scene(root,600,636,true);
        //set up d'une image
        Image imageHero = new Image("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png");
        ImageView imgHero = new ImageView(imageHero);
        imgHero.setViewport(new Rectangle2D(20,0,60,100));
        imgHero.setX(0);
        imgHero.setY(0);
        root.getChildren().add(imgHero);
        primaryStage.setScene(theScene);
        primaryStage.show();*/

        //code 2 : test hero
        /*Group root = new Group();
        Scene s = new Scene(root, 1000, 400, true);

        Hero hero1 = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 150, 1);
        Hero hero2 = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 200, 150, 2);
        Hero hero3 = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 300, 150, 3);
        Hero hero4 = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 400, 150, 4);
        Hero hero5 = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 500, 150, 5);
        Hero hero6 = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 600, 150, 6);
        root.getChildren().add(hero1.getImageView());
        root.getChildren().add(hero2.getImageView());
        root.getChildren().add(hero3.getImageView());
        root.getChildren().add(hero4.getImageView());
        root.getChildren().add(hero5.getImageView());
        root.getChildren().add(hero6.getImageView());

        primaryStage.setScene(s);
        primaryStage.show();*/

        //code 3 :test
        Group root= new Group();
        GameScene Gamescene = new GameScene(root,800,400,true,0,800,0,800,800);
        primaryStage.setScene(Gamescene);
        primaryStage.show();


        /*// code 4 : test d'affichage backgroundRight et backgroundLeft
        GameScene Gamescene = new GameScene(root,1000,400,true,0,800,0,400,800);
        primaryStage.setScene(Gamescene);
        primaryStage.show();*/

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
    }

    public static void main(String[] args) {
        launch(args);
        //write your code here

    }
}
