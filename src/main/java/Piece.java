import java.awt.Image;
import java.awt.image.ImageObserver;

public class Piece {
    private Image img;
    private int x;
    private int y;

    public Piece(Image img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return this.img;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.img.getHeight((ImageObserver) null);
    }

    public int getHeight() {
        return this.img.getHeight((ImageObserver) null);
    }
}