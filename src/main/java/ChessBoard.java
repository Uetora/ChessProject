import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.ImageIcon;

public class ChessBoard extends JPanel {

    public void display() {
    }

    private Image imgBackground;

    private ArrayList<Piece> pieces = new ArrayList<Piece>();


    public ChessBoard() {
        URL urlBackgroundImg = getClass().getClassLoader().getResource("board.png");
        this.imgBackground = new ImageIcon(urlBackgroundImg).getImage();

        this.createAndAddPiece(0, 1, 301, 401);
        this.createAndAddPiece(0, 2, 351, 401);
        this.createAndAddPiece(0, 3, 401, 401);
        this.createAndAddPiece(0, 5, 451, 401);
        this.createAndAddPiece(0, 4, 501, 401);
        this.createAndAddPiece(0, 3, 551, 401);
        this.createAndAddPiece(0, 2, 601, 401);
        this.createAndAddPiece(0, 1, 651, 401);

        int i;
        for(i = 0; i < 8; ++i) {
            this.createAndAddPiece(0, 6, 301 + 50 * i, 351);
        }


        this.createAndAddPiece(1, 1, 301, 51);
        this.createAndAddPiece(1, 2, 351, 51);
        this.createAndAddPiece(1, 3, 401, 51);
        this.createAndAddPiece(1, 4, 451, 51);
        this.createAndAddPiece(1, 5, 501, 51);
        this.createAndAddPiece(1, 3, 551, 51);
        this.createAndAddPiece(1, 2, 601, 51);
        this.createAndAddPiece(1, 1, 651, 51);

        for(i = 0; i < 8; ++i) {
            this.createAndAddPiece(1, 6, 301 + 50 * i, 101);
        }


        PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this.pieces, this);
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(this);
        f.setResizable(false);
        f.setSize(this.imgBackground.getWidth(null), this.imgBackground.getHeight(null));
    }


    private void createAndAddPiece(int color, int type, int x, int y) {
        Image img = this.getImageForPiece(color, type);
        Piece piece = new Piece(img, x, y);
        this.pieces.add(piece);
    }

    private Image getImageForPiece(int color, int type) {
        String filename = "";
        filename = filename + (color == 0 ? "w" : "b");
        switch(type) {
            case 1:
                filename = filename + "r";
                break;
            case 2:
                filename = filename + "n";
                break;
            case 3:
                filename = filename + "b";
                break;
            case 4:
                filename = filename + "q";
                break;
            case 5:
                filename = filename + "k";
                break;
            case 6:
                filename = filename + "p";
        }

        filename = filename + ".png";
        URL urlPieceImg = this.getClass().getResource("/" + filename);
        return (new ImageIcon(urlPieceImg)).getImage();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.imgBackground, 0, 0, null);
        Iterator<Piece> var2 = this.pieces.iterator();

        while(var2.hasNext()) {
            Piece piece = var2.next();
            g.drawImage(piece.getImage(), piece.getX(), piece.getY(), null);
        }

    }


}