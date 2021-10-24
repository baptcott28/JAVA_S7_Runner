import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

import java.util.DoubleSummaryStatistics;


public class GameScene extends Scene {
    // on cree une scene qui s'appelle GameScene et on y introduit une camera
    double largeurFenetreAffichage;
    double hauteurFenetreAffichage;
    double rect_posX1;
    double rect_largeur1;
    double rect_posX2;
    double rect_largeur2;
    double posInFenetreX2;



    //camera Camera = new camera(200,200);

    public GameScene(Group group, double largeurFenetreAffichage, double hauteurFenetreAffichage, boolean b, double rect_posX1, double rect_largeur1, double rect_posX2, double rect_largeur2, double posInFenetreX2 ) {
        super(group,largeurFenetreAffichage,hauteurFenetreAffichage,b);

        staticThing BackgroundRight = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",rect_posX1,0,rect_largeur1,400,0,0);
        staticThing BackgroundLeft = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",rect_posX2,0,rect_largeur2,400,800,0);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 150, 1);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        KeyValue kv = new KeyValue(BackgroundRight.getImageView().xProperty(), -800);
        KeyValue kv2 = new KeyValue(BackgroundLeft.getImageView().xProperty(), 0);
        KeyValue kv3 = new KeyValue(hero.getImageView().xProperty(), 400);
        KeyFrame kf = new KeyFrame(Duration.millis(2900), kv,kv2,kv3);
        timeline.getKeyFrames().add(kf);
        timeline.play();

        group.getChildren().add(hero.getImageView());
        group.getChildren().add(BackgroundRight.getImageView());
        group.getChildren().add(BackgroundLeft.getImageView());
    }

    public double getLargeurFenetreAffichage(){
        return largeurFenetreAffichage;
    }
    public double getHauteurFenetreAffichage(){
        return hauteurFenetreAffichage;
    }

}
