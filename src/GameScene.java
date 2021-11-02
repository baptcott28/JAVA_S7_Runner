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
    private staticThing coeur1;
    private staticThing coeur2;
    private staticThing coeur3;
    private staticThing mechant;


    public GameScene(Group group, double largeurFenetreAffichage, double hauteurFenetreAffichage, boolean b) {
        super(group,largeurFenetreAffichage,hauteurFenetreAffichage,b);

        staticThing BackgroundRight = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,800,0);
        //BackgroundRight.getImageView().setX(800);
        staticThing BackgroundLeft = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,0,0);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, -50, 1);

        staticThing mechant = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\mechant.png",144,0,48,48,800,260);
        mechant.getImageView().setFitHeight(100);
        mechant.getImageView().setFitWidth(100);

        staticThing coeur1 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\coeur.png",7,5,28,27,674,10);
        staticThing coeur2 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\coeur.png",7,5,28,27,716,10);
        staticThing coeur3 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\coeur.png",7,5,28,27,758,10);

        this.BackgroundLeft=BackgroundLeft;
        this.BackgroundRight=BackgroundRight;
        this.hero=hero;
        this.imgDesertRight=imgDesertRight;
        this.coeur1=coeur1;
        this.coeur2=coeur2;
        this.coeur3=coeur3;
        this.mechant=mechant;

        AnimationTimer timer = new AnimationTimer() {
            long time = 0;

            public void handle(long l) {
                if (l - time > 80000000) {
                    hero.update();
                    BackgroundLeft.updateLeft();
                    BackgroundRight.updateRight();
                    mechant.updateMechant();
                    time = l;
                }

            }
        };
        timer.start();
        this.timer=timer;
    }

    private void setOnMouseClick(Object jump) {

    }


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

    public staticThing getCoeur1(){
        return coeur1;
    }

    public staticThing getCoeur2(){
        return coeur2;
    }

    public staticThing getCoeur3(){
        return coeur3;
    }

    public staticThing getMechant(){
        return mechant;
    }
}
