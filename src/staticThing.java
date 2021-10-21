import javax.swing.text.html.ImageView;

public class staticThing {

    private ImageView ImageView;
    double longueur;
    double largeur;

    
    public staticThing(String fileName, ImageView ImageView, double longueur, double largeur){
        this.ImageView=ImageView;
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public ImageView getImageView(){
        return ImageView;
    }
}
