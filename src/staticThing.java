import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;

public class staticThing {

    private ImageView ImageView;
    double rect_posX;
    double rect_posY;
    double rect_largeur;
    double rect_hauteur;
    double pos_in_fenetreX;
    double pos_in_fenetreY;

    public staticThing(String fileName,double rect_posX, double rect_posY, double rect_largeur, double rect_hauteur,double pos_in_fenetreX, double pos_in_fenetreY){
        Image ImageBackground = new Image(fileName);
        ImageView imgBackground = new ImageView(ImageBackground);
        imgBackground.setViewport(new Rectangle2D(rect_posX,rect_posY,rect_largeur,rect_hauteur));
        imgBackground.setX(pos_in_fenetreX);
        imgBackground.setY(pos_in_fenetreY);
        this.ImageView=imgBackground;
        this.rect_posX=rect_posX;
        this.rect_posY=rect_posY;
        this.pos_in_fenetreX=pos_in_fenetreX;
        this.pos_in_fenetreY=pos_in_fenetreY;
        this.rect_hauteur=rect_hauteur;
        this.rect_largeur=rect_largeur;
    }

    public ImageView getImageView(){
        return ImageView;
    }

}

