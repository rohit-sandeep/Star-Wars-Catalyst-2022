import bagel.*;
import bagel.util.Point;
import bagel.util.Rectangle;

public class Player {
    private final int MAX_HEALTH = 3;
    private Rectangle boundingBox;
    private int movementSpeed=3;
    private int currHealth;
    private int player_score;
    private double x_coordinate;
    private double y_coordinate;
    private boolean isDrawn;
    private final Image ship = new Image("resource/falcon.png");
    private final Image health= new Image("resource/health.png");
    private final DrawOptions scale = new DrawOptions();
    public Player(double height, double width ) {
        this.x_coordinate= width;
        this.y_coordinate= height;
        this. currHealth=this.getMAX_HEALTH();
        this.player_score=0;
        this.setIsDrawn(true);
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public boolean getIsDrawn() {
        return isDrawn;
    }

    public void setIsDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public Image getShip() {
        return ship;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public void move(Input input){
        double currX=this.getX_coordinate();
        double currY=this.getY_coordinate();
        if (input.isDown(Keys.RIGHT)) {
            this.setX_coordinate(currX + this.getMovementSpeed());
        }
        if (input.isDown(Keys.LEFT)) {
            this.setX_coordinate(currX - this.getMovementSpeed());
        }
        if (input.isDown(Keys.UP)) {
            this.setY_coordinate(currY - this.getMovementSpeed());
        }
        if (input.isDown(Keys.DOWN)) {
            this.setY_coordinate(currY + this.getMovementSpeed());
        }
    }

    public boolean checkWithinBound(Player player){
        Point centre= player.getBoundingBox().centre();
        if(centre.y>= 1024 || centre.y<=0){
            return false;
        }
        else if(centre.x>=768|| centre.x<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public void restrictMove(Input input, Point position){
        double currX=this.getX_coordinate();
        double currY=this.getY_coordinate();
        if(position.x>=768 && position.y<=0){
            if (input.isDown(Keys.LEFT)) {
                this.setX_coordinate(currX - this.getMovementSpeed());
            }
            if (input.isDown(Keys.DOWN)) {
                this.setY_coordinate(currY + this.getMovementSpeed());
            }
        }
        else if(position.x<=0 && position.y<=0){

            if (input.isDown(Keys.DOWN)) {
                this.setY_coordinate(currY + this.getMovementSpeed());
            }
            if (input.isDown(Keys.RIGHT)) {
                this.setX_coordinate(currX + this.getMovementSpeed());
            }
        }
        else if(position.x>=768 && position.y>=1024) {
            if (input.isDown(Keys.LEFT)) {
                this.setX_coordinate(currX - this.getMovementSpeed());
            }
            if (input.isDown(Keys.UP)) {
                this.setY_coordinate(currY - this.getMovementSpeed());

            }
        }
        else if(position.x<=0 && position.y>=1024) {
            if (input.isDown(Keys.RIGHT)) {
                this.setX_coordinate(currX + this.getMovementSpeed());
            }
            if (input.isDown(Keys.UP)) {
                this.setY_coordinate(currY - this.getMovementSpeed());

            }
        }


        else if(position.x>=768){
            if (input.isDown(Keys.LEFT)) {
                this.setX_coordinate(currX - this.getMovementSpeed());
            }
            if (input.isDown(Keys.UP)) {
                this.setY_coordinate(currY - this.getMovementSpeed());
            }
            if (input.isDown(Keys.DOWN)) {
                this.setY_coordinate(currY + this.getMovementSpeed());
            }
        }
        else if(position.x<=0){
            if (input.isDown(Keys.RIGHT)) {
                this.setX_coordinate(currX + this.getMovementSpeed());
            }
            if (input.isDown(Keys.UP)) {
                this.setY_coordinate(currY - this.getMovementSpeed());
            }
            if (input.isDown(Keys.DOWN)) {
                this.setY_coordinate(currY + this.getMovementSpeed());
            }
        }
        else if(position.y>=1024){
            if (input.isDown(Keys.LEFT)) {
                this.setX_coordinate(currX - this.getMovementSpeed());
            }
            if (input.isDown(Keys.RIGHT)) {
                this.setX_coordinate(currX + this.getMovementSpeed());
            }
            if (input.isDown(Keys.UP)) {
                this.setY_coordinate(currY - this.getMovementSpeed());
            }
        }
        else if(position.y<=0){
            if (input.isDown(Keys.RIGHT)) {
                this.setX_coordinate(currX + this.getMovementSpeed());

            }
            if (input.isDown(Keys.LEFT)) {
                this.setX_coordinate(currX - this.getMovementSpeed());
            }
            if (input.isDown(Keys.DOWN)) {
                this.setY_coordinate(currY + this.getMovementSpeed());
            }
        }
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Image getImage(){
        return ship;
    }

    public void renderHealth(Player player,int yPosition){
        player.health.draw(40, yPosition,scale.setScale(0.1,0.1));
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public void renderScore(Font font,Player player){
        font.drawString(String.valueOf(player.getPlayer_score()),650,40);
    }

    public int getPlayer_score() {
        return player_score;
    }

    public void setPlayer_score(int player_score) {
        this.player_score = player_score;
    }
}
