import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
    private Integer pause=0;
    private double score;
    private Text Scoretext;
    private Stage primaryStage;

    public GameScene(Group group, double largeurFenetreAffichage, double hauteurFenetreAffichage, boolean b, Stage primaryStage) {
        super(group,largeurFenetreAffichage,hauteurFenetreAffichage,b);

        staticThing BackgroundRight = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,800,0);
        staticThing BackgroundLeft = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",0,0,800,400,0,0);

        Hero hero = new Hero("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\heros.png", 100, 250, 1);

        staticThing mechant = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\mechant.png",144,0,48,48,700,280);
        mechant.getImageView().setFitHeight(80);
        mechant.getImageView().setFitWidth(80);

        staticThing life = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\coeur_vie.png",0,0,233,43,0,0);

        Group groupFin = new Group();
        Scene fin = new Scene(groupFin,800,400,true);
        staticThing etoile = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\etoile_sheriff.png",0,0,450,500,100,100);
        etoile.getImageView().setFitWidth(200);
        etoile.getImageView().setFitHeight(200);
        groupFin.getChildren().add(etoile.getImageView());
        groupFin.getChildren().add(BackgroundRight.getImageView());
        groupFin.getChildren().add(hero.getImageView());

        Text Scoretext = new Text();
        Scoretext.setText("Score : "+score);
        Scoretext.setFont(new Font("Playbill",40));
        Scoretext.setX(650);
        Scoretext.setY(30);

        this.BackgroundLeft=BackgroundLeft;
        this.BackgroundRight=BackgroundRight;
        this.hero=hero;
        this.imgDesertRight=imgDesertRight;
        this.mechant=mechant;
        this.life=life;
        this.temps=temps;
        this.Scoretext=Scoretext;
        this.pause=pause;
        this.primaryStage=primaryStage;


        AnimationTimer timer = new AnimationTimer() {
            long time = 0;
            public void handle(long l) {

                if (l - time > temps) {
                    if (pause==0){
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
                                    System.out.println(hero.getLifeNumber());
                                    if(hero.getLifeNumber()==0){

                                        // definition de la scene de fin

                                        Group groupFin = new Group();
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
                                        primaryStage.show();
                                    }
                                }
                            }
                        }
                    } else{

                    }
                    time = l;
                    score=score+1;
                    //System.out.println("score : "+score);
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
                if (keyEvent.getCode()== KeyCode.ESCAPE){
                    pause = 1-pause;
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

    public Text getScoretext(){
        return Scoretext;
    }

    public Integer getPause(){
        return pause;
    }
}
