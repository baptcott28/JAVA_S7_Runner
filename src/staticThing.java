import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;

public class staticThing {

    private ImageView ImageView;
    private double rect_posX;
    private double rect_posY=0;
    private double rect_largeur;
    private double rect_hauteur=400;
    private double pos_in_fenetreX;
    private double pos_in_fenetreY=0;

    public staticThing(String fileName,double rect_posX,double rect_largeur,double pos_in_fenetreX){
        Image ImageBackground = new Image(fileName);
        ImageView imgBackground = new ImageView(ImageBackground);
        imgBackground.setViewport(new Rectangle2D(rect_posX,rect_posY,rect_largeur,rect_hauteur));
        this.rect_posX=rect_posX;
        this.pos_in_fenetreX=pos_in_fenetreX;
        this.rect_largeur=rect_largeur;
        this.ImageView=imgBackground;
        imgBackground.setX(pos_in_fenetreX);
        imgBackground.setY(pos_in_fenetreY);
    }

    public ImageView getImageView(){
        return ImageView;
    }

    public void updateBck1(){
        if(pos_in_fenetreX>-800){
            pos_in_fenetreX=pos_in_fenetreX-1;
        }
        else{
            pos_in_fenetreX=0;
        }
    }

    public void updateBck2(){
        if(pos_in_fenetreX>0){
            pos_in_fenetreX=pos_in_fenetreX-1;
        }
        else{
            pos_in_fenetreX=800;
        }
    }

}

