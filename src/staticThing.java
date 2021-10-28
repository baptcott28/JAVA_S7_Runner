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
    private double X_pos;
    private double pos_in_fenetreY=0;

    public staticThing(String fileName,double rect_posX,double rect_largeur,double pos_in_fenetreX){
        Image ImageBackground = new Image(fileName);
        ImageView imgBackground = new ImageView(ImageBackground);
        imgBackground.setViewport(new Rectangle2D(rect_posX,rect_posY,rect_largeur,rect_hauteur));
        this.rect_posX=rect_posX;
        this.X_pos=pos_in_fenetreX;
        this.rect_largeur=rect_largeur;
        this.ImageView=imgBackground;
    }

    public ImageView getImageView(){
        return ImageView;
    }

    public void updateLeft(){
        if(X_pos>-800){
            this.getImageView().setX(this.getImageView().getX() - 5);
        }
        else{
            this.getImageView().setX(0);
        }
    }

    public void updateRight(){
        if(X_pos>0){
            this.getImageView().setX(this.getImageView().getX() - 5);
        }
        else{
            this.getImageView().setX(800);
        }
    }

    public double getX_pos(){
        return X_pos;
    }

}

