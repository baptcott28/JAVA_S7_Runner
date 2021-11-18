import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;
import java.util.Random;

public class staticThing {

    private ImageView ImageView;
    private double rect_posX;
    private double rect_posY;
    private double rect_largeur;
    private double rect_hauteur;
    private double X_pos;
    private double Y_pos;
    private double pos_in_fenetreY;
    private Integer lifeState=0;
    private Integer mechant_est_touché=0;

    public staticThing(String fileName,double rect_posX,double rect_posY,double rect_largeur,double rect_hauteur,double pos_in_fenetreX, double pos_in_fenetreY){
        Image ImageBackground = new Image(fileName);
        ImageView imgBackground = new ImageView(ImageBackground);
        imgBackground.setViewport(new Rectangle2D(rect_posX,rect_posY,rect_largeur,rect_hauteur));
        this.rect_posX=rect_posX;
        this.X_pos=pos_in_fenetreX;
        this.Y_pos=pos_in_fenetreY;
        this.rect_largeur=rect_largeur;
        this.ImageView=imgBackground;
        this.rect_hauteur=rect_hauteur;
        imgBackground.setX(pos_in_fenetreX);
        imgBackground.setY(pos_in_fenetreY);
    }

    public ImageView getImageView(){
        return ImageView;
    }

    public void updateLeft(){
        if(this.getImageView().getX()>-800){
            this.getImageView().setX(this.getImageView().getX() - 8);
        }
        else{
            this.getImageView().setX(0);
        }
    }

    public void updateRight(){
        if(this.getImageView().getX()>0){
            this.getImageView().setX(this.getImageView().getX() - 8);
        }
        else{
            this.getImageView().setX(800);
        }
    }


    public void updateMechant(){
        double alea= ((int)(10*Math.random()))%5;
        if(alea==1){
            if(this.getImageView().getX()>(-100)){
                this.getImageView().setX((this.getImageView().getX()-8));
            }
            else{
                this.getImageView().setX(800);
            }
        }
        else{
            if(this.getImageView().getX()>(-100)){
                this.getImageView().setX((this.getImageView().getX()-8));
            }
        }

    }


    public void lifeUpdate(){
        if(lifeState==0){
            this.getImageView().setViewport(new Rectangle2D(0,12,233,31));
        }
        if (lifeState==1){
            this.getImageView().setViewport(new Rectangle2D(0,53,233,39));
        }
        if(lifeState==2){
            this.getImageView().setViewport(new Rectangle2D(0,93,233,31));
        }
        if(lifeState==3){
            this.getImageView().setViewport(new Rectangle2D(0,132,233,31));
        }
        if(lifeState==4){
            this.getImageView().setViewport(new Rectangle2D(0,172,233,31));
        }
        lifeState=(lifeState+1)%5;
        System.out.println("lifeState="+lifeState);
    }

    public double getRect_posX() {
        return rect_posX;
    }

}

