import bagel.*;
import bagel.util.*;

public class Projectile {
    private final Image red_projectile = new Image("resource/red_laser.png");
    private boolean spawned; 
    private double x;
    private double y;
    private int timer;
    private boolean isDead;
    private final DrawOptions rotation = new DrawOptions();

    public Projectile() {
        setSpawn(false);
        setTimer(0);
    }

    public void drawProjectile() {
        red_projectile.draw(getX(), getY(), rotation.setRotation(3.14/2));
    }

    public void move() {
        setY(getY() - 10);
    }

    public void setSpawn(boolean spawned) {
        this.spawned = spawned;
    }

    public boolean getSpawn() {
        return spawned;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTimer() {
        return timer;
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
