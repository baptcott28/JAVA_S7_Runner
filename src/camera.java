public class camera {
    private Integer X;
    private Integer Y;

    public camera (Integer X, Integer Y) {
        this.X = X;
        this.Y = Y;
    }

    public Integer getX(){
        return X;
    }

    public Integer getY(){
        return Y;
    }

    @Override
    public String toString() {
        return "camera{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
