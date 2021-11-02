import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class Main extends Application {

    private MouseButton mouse;
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
        /*Group root = new Group();
        Scene s = new Scene(root, 1000, 400, true);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png",10,100,1);
        staticThing back1 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,800,0);
        staticThing back2 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,800,800);

        for(Integer i=0;i<10;i++){
            back1.updateLeft();
        }
        back1.getImageView().setX(back1.getX_pos());
        root.getChildren().add(back1.getImageView());
        root.getChildren().add(back2.getImageView());
        root.getChildren().add(hero.getImageView());

        primaryStage.setScene(s);
        primaryStage.show();*/

        //code 3 :test
        Group root = new Group();
        GameScene Gamescene = new GameScene(root, 800, 400, true);

        //root.getChildren().add(Gamescene.getImgDesertRight());
        root.getChildren().add(Gamescene.getBackgroundLeft().getImageView());
        root.getChildren().add(Gamescene.getBackgroundRight().getImageView());
        root.getChildren().add(Gamescene.getHero().getImageView());
        root.getChildren().add(Gamescene.getCoeur1().getImageView());
        root.getChildren().add(Gamescene.getCoeur2().getImageView());
        root.getChildren().add(Gamescene.getCoeur3().getImageView());
        root.getChildren().add(Gamescene.getMechant().getImageView());
        primaryStage.setScene(Gamescene);
        Gamescene.getTimer().handle(0);
        Gamescene.getTimer().start();
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

        //code 7 : test animation background
        /*Group group = new Group();
        Scene scene = new Scene(group, 800,400);

        Rectangle r = new Rectangle(100,100,200,200);
        r.setStroke(Color.GREEN);

        Image imagedesert = new Image("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png");
        ImageView imgDesert = new ImageView(imagedesert);
        imgDesert.setViewport(new Rectangle2D(0,0,800,400));

        group.getChildren().add(imgDesert);

        AnimationTimer aT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(imgDesert.getX()>-800){
                    imgDesert.setX(imgDesert.getX()-1);
                }else {
                    imgDesert.setX(0);
                }
            }
        };
        aT.start();

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



    }

    public static void main(String[] args) {
        launch(args);
        //write your code here

    }
}
