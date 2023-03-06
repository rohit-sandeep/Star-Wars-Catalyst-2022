import bagel.*;

public class Animation {
    private final Image LUKE = new Image("resource/luke.png");
    private final Image VADER = new Image("resource/vader.png");
    private final DrawOptions scale = new DrawOptions();
    private double lukeX;
    private double lukeY;
    private double vaderX;
    private double vaderY;
    public Animation() {
        this.lukeX = 100 - 50;
        this.lukeY = 600;
        this.vaderX = 650 + 50;
        this.vaderY = 640;
    }
    public void drawAnimation(){
        LUKE.draw(getLukeX(), getLukeY(), scale.setScale(0.75, 0.75));
        VADER.draw(getVaderX(),getVaderY(), scale.setScale(0.25, 0.25));
    }

    public void setLukeX(double lukeX) {
        this.lukeX = lukeX;
    }
    public void setLukeY(double lukeY) {
        this.lukeY = lukeY;
    }
    public double getLukeX() {
        return lukeX;
    }
    public double getLukeY() {
        return lukeY;
    }
    public void setVaderX(double vaderX) {
        this.vaderX = vaderX;
    }
    public void setVaderY(double vaderY) {
        this.vaderY = vaderY;
    }
    public double getVaderX() {
        return vaderX;
    }
    public double getVaderY() {
        return vaderY;
    }
}
