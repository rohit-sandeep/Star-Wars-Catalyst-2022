import bagel.*;
import bagel.util.*;

public class TieFighter {
    private final DrawOptions scale = new DrawOptions();
    private static Image TIE_SPRITE = new Image("resource/tie.png");
    private double x;
    private double y;
    private int speed = 4;
    private double StartY;
    private double StartX;
    private boolean f;
    private boolean g;
    private boolean turn;
    private boolean isDead;

    public TieFighter(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.setF(false);
        this.setG(false);
        this.setTurn(true);
        this.setStatus(false);
    }

    public void movement(int distance) {
        if (getF() == false) {
            setStartY(this.getY());
            setF(true);
        }
        else {
            if (getY() < getStartY() + 240) {
                moveDown();
            }
            else {
                if (getG() == false) {
                    setStartX(this.getX());
                    setG(true);
                }
                if (getTurn()) {
                    if (getX() < getStartX() + distance) {
                        moveRight();
                    }
                    else {
                        setF(false);
                        setG(false);
                        setTurn(false);
                    }
                }
                else {
                    if (getX() > getStartX() - distance) {
                        moveLeft();
                    }
                    else {
                        setF(false);
                        setG(false);
                        setTurn(true);
                    }

                }
            }
        }
    }

    public void drawSprite() {
        TIE_SPRITE.draw(getX(), getY(), scale.setScale(0.125, 0.125));
    }

    public void moveRight() {
        this.x += speed;
    }

    public void moveLeft() {
        this.x -= speed;
    }

    public void moveDown() {
        this.y += speed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setStartY(double StartY) {
        this.StartY = StartY;
    }

    public double getStartY() {
        return StartY;
    }

    public void setF(boolean f) {
        this.f = f;
    }

    public boolean getF() {
        return f;
    }

    public void setStartX(double StartX) {
        this.StartX = StartX;
    }

    public double getStartX() {
        return StartX;
    }

    public void setG(boolean g) {
        this.g = g;
    }

    public boolean getG() {
        return g;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setStatus(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean getStatus() {
        return isDead;
    }

    public double calculateDistance(double coord_x, double coord_y) {
        Point destination = new Point(coord_x, coord_y);
        return new Point(this.getX(), this.getY()).distanceTo(destination);
    }
}
