import javafx.animation.AnimationTimer;
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
    private double largeurFenetreAffichage;
    private double hauteurFenetreAffichage;
    private staticThing BackgroundLeft;
    private staticThing BackgroundRight;
    private Hero hero;
    private AnimationTimer timer;
    private ImageView imgDesertRight;


    public GameScene(Group group, double largeurFenetreAffichage, double hauteurFenetreAffichage, boolean b) {
        super(group,largeurFenetreAffichage,hauteurFenetreAffichage,b);

        staticThing BackgroundRight = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,800,800);
        BackgroundRight.getImageView().setX(800);
        staticThing BackgroundLeft = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,800,0);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 230, 1);

        this.BackgroundLeft=BackgroundLeft;
        this.BackgroundRight=BackgroundRight;
        this.hero=hero;
        this.imgDesertRight=imgDesertRight;

        AnimationTimer timer = new AnimationTimer() {
            long time = 0;

            public void handle(long l) {
                if (l - time > 80000000) {
                    hero.update();
                    BackgroundLeft.updateLeft();
                    BackgroundRight.updateRight();
                    time = l;
                }

            }
        };
        timer.start();
        this.timer=timer;
    };


    public staticThing getBackgroundLeft() {
        return BackgroundLeft;
    }

    public staticThing getBackgroundRight(){
        return BackgroundRight;
    }

    public ImageView getImgDesertRight(){
        return imgDesertRight;
    }

    public Hero getHero(){
        return hero;
    }

    public AnimationTimer getTimer() {
        return timer;
    }
}
