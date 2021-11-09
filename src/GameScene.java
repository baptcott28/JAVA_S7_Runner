import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;


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
    private double temps=80000000;


    public GameScene(Group group, double largeurFenetreAffichage, double hauteurFenetreAffichage, boolean b) {
        super(group,largeurFenetreAffichage,hauteurFenetreAffichage,b);

        staticThing BackgroundRight = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,800,0);
        //BackgroundRight.getImageView().setX(800);
        staticThing BackgroundLeft = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,0,0);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 250, 1);

        staticThing mechant = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\mechant.png",144,0,48,48,800,280);
        mechant.getImageView().setFitHeight(80);
        mechant.getImageView().setFitWidth(80);

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
        this.temps=temps;


        AnimationTimer timer = new AnimationTimer() {
            long time = 0;
            public void handle(long l) {

                if (l - time > temps) {
                    if(hero.getboostorder()==1){
                        temps=55000000;
                        //System.out.println("temps_reduit");
                    }
                    if(hero.getboostorder()==0){
                        temps=80000000;
                        //System.out.println("temps_allongé");
                    }
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

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.UP) {
                    hero.jump();
                    System.out.println("jump");
                }
            }
            // mettre le boost avec Key_Pressed
            /*public void handle(javafx.scene.input.KeyEvent.KEY_PRESSED){
                 if(KeyEvent.KEY_PRESSED){
                     hero.boost();
                     System.out.println("envolatiooon");
                 }
            }*/
        });
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
