import javafx.animation.AnimationTimer;
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

        //code 2 : test update hero et superposition hero + desert (fonctionne)
        Group root = new Group();
        Scene s = new Scene(root, 1000, 400, true);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png",10,100,1);
        staticThing back1 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,800,0);
        staticThing back2 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,800,800);

        /*for(Integer i=0;i<10;i++){
            back1.updateBck1();
        }*/
        root.getChildren().add(back1.getImageView());
        root.getChildren().add(back2.getImageView());
        root.getChildren().add(hero.getImageView());

        primaryStage.setScene(s);
        primaryStage.show();

        //code 3 :test
        /*Group root = new Group();
        GameScene Gamescene = new GameScene(root, 800, 400, true);
        root.getChildren().add(Gamescene.getBackgroundLeft().getImageView());
        root.getChildren().add(Gamescene.getBackgroundRight().getImageView());
        root.getChildren().add(Gamescene.getHero().getImageView());
        primaryStage.setScene(Gamescene);
        Gamescene.getTimer().handle(0);
        Gamescene.getTimer().start();
        primaryStage.show();*/


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

        //code 6 : test update
        /*Group root= new Group();
        Scene scene = new Scene(root,1000,400);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 150, 1);

        Integer i=1;
        for(i=1;i<6;i++){
            hero.update();
            root.getChildren().add(hero.getImageView());
        }

        primaryStage.setScene(scene);
        primaryStage.show();*/


    }


    public static void main(String[] args) {
        launch(args);
        //write your code here

    }
}
