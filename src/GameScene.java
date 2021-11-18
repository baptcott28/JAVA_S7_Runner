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
    private staticThing mechant;
    private staticThing life;
    private double temps;
    private Integer mechant_est_touché=0;

    public GameScene(Group group, double largeurFenetreAffichage, double hauteurFenetreAffichage, boolean b) {
        super(group,largeurFenetreAffichage,hauteurFenetreAffichage,b);

        staticThing BackgroundRight = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,800,0);
        //BackgroundRight.getImageView().setX(800);
        staticThing BackgroundLeft = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,0,0);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 250, 1);

        staticThing mechant = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\mechant.png",144,0,48,48,209,280);
        mechant.getImageView().setFitHeight(80);
        mechant.getImageView().setFitWidth(80);

        staticThing life = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\coeur_vie.png",0,0,233,43,0,0);


        this.BackgroundLeft=BackgroundLeft;
        this.BackgroundRight=BackgroundRight;
        this.hero=hero;
        this.imgDesertRight=imgDesertRight;
        this.mechant=mechant;
        this.life=life;
        this.temps=temps;


        AnimationTimer timer = new AnimationTimer() {
            long time = 0;
            public void handle(long l) {

                if (l - time > temps) {
                    if(hero.getboostorder()==1){
                        temps=10000000;
                        //System.out.println("temps_reduit");
                    }
                    if(hero.getboostorder()==0){
                        temps=65000000;
                        //System.out.println("temps_allongé");
                    }
                    hero.update();
                    BackgroundLeft.updateLeft();
                    BackgroundRight.updateRight();
                    mechant.updateMechant();
                    if(mechant.getImageView().getX()==800){
                        mechant_est_touché=0;
                    }
                    if((mechant.getImageView().getX()<hero.getImageView().getX()+60)&&(hero.getImageView().getX()<mechant.getImageView().getX()+30)){
                        if(hero.getImageView().getY()+60>mechant.getImageView().getY()){
                            if(mechant_est_touché==0){
                                life.lifeUpdate();
                                mechant_est_touché=mechant_est_touché+1;
                                hero.UpdateLifeNumber();
                            }
                        }

                    }
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

                if(keyEvent.getCode()== KeyCode.RIGHT){
                    hero.boost();
                }
                if (keyEvent.getCode()== KeyCode.LEFT){
                    hero.stopBoost();
                }
            }
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

    public staticThing getLife(){
        return life;
    }

    public staticThing getMechant(){
        return mechant;
    }
}
