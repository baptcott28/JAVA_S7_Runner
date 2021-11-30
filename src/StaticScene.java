import javafx.scene.Group;
import javafx.scene.Scene;

public class StaticScene extends Scene {

    private Hero hero2;
    private staticThing mechant2;
    private staticThing background3;

    // Pour les scenes d'intro et de fin

    public StaticScene(Group group, double largeur_fenetre, double hauteur_fenetre,boolean b){
        super(group, largeur_fenetre,hauteur_fenetre,b);

        staticThing background3= new staticThing("C:\\Users\\bapti\\IdeaProjects\\Runner\\images\\desert.png",0,0,800,400,0,0);

        Hero hero2= new Hero("C:\\Users\\bapti\\IdeaProjects\\Runner\\images\\heros.png", 100, 250, 1);

        staticThing mechant2 = new staticThing("C:\\Users\\bapti\\IdeaProjects\\Runner\\images\\mechant.png",144,0,48,48,700,260);
        mechant2.getImageView().setFitHeight(100);
        mechant2.getImageView().setFitWidth(100);

        this.background3=background3;
        this.hero2=hero2;
        this.mechant2=mechant2;
    }

    public Hero getHero(){
        return hero2;
    }

    public staticThing getMechant(){
        return mechant2;
    }

    public staticThing getBackground(){
        return background3;
    }

}
