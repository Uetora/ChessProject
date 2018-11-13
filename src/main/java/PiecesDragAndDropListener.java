import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class PiecesDragAndDropListener implements MouseListener, MouseMotionListener {
    private List<Piece> pieces;
    private ChessBoard chessBoard;
    private Piece dragPiece;
    private int dragOffsetX;
    private int dragOffsetY;

    public PiecesDragAndDropListener(List<Piece> pieces, ChessBoard chessBoard) {
        this.pieces = pieces;
        this.chessBoard = chessBoard;
    }

    public void mousePressed(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        for(int i = this.pieces.size() - 1; i >= 0; --i) {
            Piece piece = this.pieces.get(i);
            if (this.mouseOverPiece(piece, x, y)) {
                this.dragOffsetX = x - piece.getX();
                this.dragOffsetY = y - piece.getY();
                this.dragPiece = piece;
                break;
            }
        }

        if (this.dragPiece != null) {
            this.pieces.remove(this.dragPiece);
            this.pieces.add(this.dragPiece);
        }

    }

    private boolean mouseOverPiece(Piece piece, int x, int y) {
        return piece.getX() <= x && piece.getX() + piece.getWidth() >= x && piece.getY() <= y && piece.getY() + piece.getHeight() >= y;
    }

    public void mouseReleased(MouseEvent arg0) {
        this.dragPiece = null;
    }

    public void mouseDragged(MouseEvent evt) {
        if (this.dragPiece != null) {
            this.dragPiece.setX(evt.getPoint().x - this.dragOffsetX);
            this.dragPiece.setY(evt.getPoint().y - this.dragOffsetY);
            this.chessBoard.repaint();
        }

    }

    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mouseMoved(MouseEvent arg0) {
    }
}
