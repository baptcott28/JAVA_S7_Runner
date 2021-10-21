import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;

public class staticThing {

    private ImageView ImageView;
    double longueur;
    double largeur;


    public staticThing(String fileName, double longueur, double largeur){
        Image spritesheet = new Image(fileName);
        ImageView sprite = new ImageView(spritesheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);
        this.ImageView=sprite;
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public ImageView getImageView(){
        return ImageView;
    }

    static public void main(String[] arg){
        staticThing t = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",600,630);
        System.out.println(t.getImageView());
    }
}
