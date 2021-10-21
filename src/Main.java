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
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        /*Image spriteSheet = new Image("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);*/

        primaryStage.setTitle("GameScene");
        /*Group root = new Group();
        Pane pane = new Pane(root);*/

        //Scene theScene = new Scene(pane,600,400,true);*/
        //camera Camera = new camera(200,200);
        //GameScene gameScene = new GameScene(Camera,pane,1000,500,true); // X et Y = format de la scene


        // affichage d'un rectangle bleu
        Group root = new Group();
        //Scene s = new Scene(root, 1000, 500);

        GameScene gameScene = new GameScene(root,600,400,true);

        //Rectangle r = new Rectangle(25,25,250,250);
        //r.setFill(Color.BLUE);

        // root.getChildren().add(r);
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //write your code here

    }
}
