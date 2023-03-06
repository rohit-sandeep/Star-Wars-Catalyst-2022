import bagel.*;
import bagel.util.Point; 
import java.util.*;

public class StarWars extends AbstractGame {
    private final static int WINDOW_WIDTH = 768;
    private final static int WINDOW_HEIGHT = 1024;
    private final static String GAME_TITLE = "StarWars x Fight: Horizon Odyssey";
    private final Image BACKGROUND = new Image("resource/space_background.png");

    private static int MESSAGE1_COORD = 402;
    private final static int MESSAGE2_COORD = 472;
    private final static int MESSAGE3_COORD = 542;

    private final DrawOptions scale = new DrawOptions();
    private final DrawOptions color = new DrawOptions();

    private final Font starwars_font;
    private final String FONT_STYLE = "resource/starwars.otf";
    Player player = new Player(Window.getHeight() / 2 + 200, Window.getWidth() / 2);
    private final static int FONT_SIZE = 40;

    private final String START_MESSAGE = "PRESS SPACE TO START";
    private final String TITLE_MESSAGE = "STARWARS X FIGHT: HORIZON ODYSSEY";

    private boolean pressed_enter = false;

    private ArrayList<TieFighter> ties = new ArrayList<>();

    private Animation animation = new Animation();

    public StarWars() {
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
        starwars_font = new Font(FONT_STYLE, FONT_SIZE);
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        StarWars game = new StarWars();
        game.run();
    }

    public void addEnemies() {
        int x_minimum=0;
        int x_maximum=768;
        for(int i=0;i<4;i++){
            int x_coordinate= (int)Math.floor(Math.random()*(x_maximum-x_minimum+1)+x_minimum);
            ties.add(new TieFighter(x_coordinate, 0));
        }
        projectiles.add(new Projectile());
        projectiles.add(new Projectile());
        projectiles.add(new Projectile());
    }

    public void drawMessage(Input input) {
        if (input.wasPressed(Keys.SPACE)) {
            pressed_enter = true;
        } else {
            animation.drawAnimation();
            if (animation.getLukeX() < 100) {
                animation.setLukeX(animation.getLukeX() + 2);
            }
            if (animation.getVaderX() > 650) {
                animation.setVaderX(animation.getVaderX() - 2);
            }
            starwars_font.drawString(TITLE_MESSAGE, (WINDOW_WIDTH - starwars_font.getWidth
                    (TITLE_MESSAGE)) / 2, MESSAGE1_COORD, color.setBlendColour(1, 1, 0));
            starwars_font.drawString(START_MESSAGE, (WINDOW_WIDTH - starwars_font.getWidth
                    (START_MESSAGE)) / 2, MESSAGE2_COORD, color.setBlendColour(1, 1, 0));

        }
    }

    private int frames = 0;
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    @Override
    public void update(Input input) {
        BACKGROUND.draw(Window.getWidth() / 2.0, Window.getHeight() / 2.0, scale.setScale(1.5, 2));
        if (!pressed_enter) {
            drawMessage(input);
            addEnemies();
        } else if (player.getCurrHealth() != 0) {
            player.getShip().draw(player.getX_coordinate(), player.getY_coordinate(), scale.setScale(0.5, 0.5));
            Point currPosition= new Point(player.getX_coordinate(),player.getY_coordinate());
            player.setBoundingBox(player.getImage().getBoundingBoxAt(currPosition));
            if(player.checkWithinBound(player)==true){
                player.move(input);
            }

            else{
                player.restrictMove(input,currPosition );
            }
            int health_position=40;
            for(int i=0;i<player.getCurrHealth();i++){
                player.renderHealth(player,health_position);
                health_position+=80;
            }
            player.renderScore(starwars_font,player);

            for (Projectile p_proj : projectiles) {
                if (p_proj.getSpawn() == false) {
                    p_proj.setX(player.getX_coordinate());
                    p_proj.setY(player.getY_coordinate() - 50);
                    p_proj.setSpawn(true);
                }
                if (p_proj.getTimer() >= 200) {
                    p_proj.setSpawn(false);
                    p_proj.setTimer(0);
                }
                
                if (!ties.get(0).getStatus()){
                    if (p_proj.calculateDistance(ties.get(0).getX(), ties.get(0).getY()) <= 20) {
                        ties.get(0).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(1).getStatus()){
                    if (p_proj.calculateDistance(ties.get(1).getX(), ties.get(1).getY()) <= 20) {
                        ties.get(1).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(2).getStatus()){
                    if (p_proj.calculateDistance(ties.get(2).getX(), ties.get(2).getY()) <= 20) {
                        ties.get(2).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(3).getStatus()){
                    if (p_proj.calculateDistance(ties.get(3).getX(), ties.get(3).getY()) <= 20) {
                        ties.get(3).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(4).getStatus()){
                    if (p_proj.calculateDistance(ties.get(4).getX(), ties.get(4).getY()) <= 20) {
                        ties.get(4).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(5).getStatus()){
                    if (p_proj.calculateDistance(ties.get(5).getX(), ties.get(5).getY()) <= 20) {
                        ties.get(5).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(6).getStatus()){
                    if (p_proj.calculateDistance(ties.get(6).getX(), ties.get(6).getY()) <= 20) {
                        ties.get(6).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
                if (!ties.get(7).getStatus()){
                    if (p_proj.calculateDistance(ties.get(7).getX(), ties.get(7).getY()) <= 20) {
                        ties.get(7).setStatus(true);
                        player.setPlayer_score(player.getPlayer_score() + 100);
                    }
                }
            }

            for (TieFighter tie : ties) {
                if (tie.calculateDistance(player.getX_coordinate(), player.getY_coordinate()) <= 50) {
                    player.setCurrHealth(player.getCurrHealth()-1);
                    tie.setStatus(true);
                }
                if (tie.getStatus()) {
                    tie.setY(0);
                    tie.setStatus(false);
                }
            }
            
            if (frames > 50) {
                if (!projectiles.get(0).getStatus()) {
                    projectiles.get(0).drawProjectile();
                    projectiles.get(0).move();
                }
                projectiles.get(0).setTimer(projectiles.get(0).getTimer() + 1);
                int distance; 
                if (!ties.get(0).getStatus()) {
                    ties.get(0).drawSprite();
                    distance = (int)Math.floor(Math.random()*(400-(-400*1)+-400));
                    ties.get(0).movement(distance);
                }
                if (!ties.get(4).getStatus()) {
                    ties.get(4).drawSprite();
                    distance = (int)Math.floor(Math.random()*(400-(-400*1)+-400));
                    ties.get(4).movement(distance);
                }
            }
            
            if (frames > 100) {
                if (!projectiles.get(1).getStatus()) {
                    projectiles.get(1).drawProjectile();
                    projectiles.get(1).move();
                }
                projectiles.get(1).setTimer(projectiles.get(1).getTimer() + 1);
                int distance; 
                if (!ties.get(0).getStatus()) {
                    ties.get(1).drawSprite();
                    distance= (int)Math.floor(Math.random()*(400-(-4001)+-400));
                    ties.get(1).movement(distance);
                }
                if (!ties.get(5).getStatus()) {
                    ties.get(5).drawSprite();
                    distance= (int)Math.floor(Math.random()*(400-(-4001)+-400));
                    ties.get(5).movement(distance);
                }

            }

            if (frames > 150) {
                if (!projectiles.get(2).getStatus()) {
                    projectiles.get(2).drawProjectile();
                    projectiles.get(2).move();
                }
                projectiles.get(2).setTimer(projectiles.get(2).getTimer() + 1);
                int distance; 
                if (!ties.get(2).getStatus()) {
                    ties.get(2).drawSprite();
                    distance = (int)Math.floor(Math.random()*(400-(-400*1)+-400));
                    ties.get(2).movement(distance);
                }
                if (!ties.get(6).getStatus()) {
                    ties.get(6).drawSprite();
                    distance = (int)Math.floor(Math.random()*(400-(-400*1)+-400));
                    ties.get(6).movement(distance);
                }
            }
            if (frames > 200) {
                if (!projectiles.get(3).getStatus()) {
                    projectiles.get(3).drawProjectile();
                    projectiles.get(3).move();
                }
                projectiles.get(3).setTimer(projectiles.get(3).getTimer() + 1);
                int distance; 
                if (!ties.get(3).getStatus()) {
                    ties.get(3).drawSprite();
                    distance= (int)Math.floor(Math.random()*(400-(-400*1)+-400));
                    ties.get(3).movement(distance);
                }
                if (!ties.get(7).getStatus()) {
                    ties.get(7).drawSprite();
                    distance= (int)Math.floor(Math.random()*(400-(-400*1)+-400));
                    ties.get(7).movement(distance);
                }
            }
            
                for (TieFighter fighters : ties) {
                    if (fighters.getY() == WINDOW_HEIGHT) {
                        int x_minimum=0;
                        int x_maximum=768;
                        int x_coordinate= (int)Math.floor(Math.random()*(x_maximum-x_minimum+1)+x_minimum);
                        fighters.setX(x_coordinate);
                        fighters.setY(0);
                        fighters.setF(false);
                        fighters.setG(false);
                        fighters.setTurn(true);
                    }
                }
                
            frames++;
        }
        else{
            starwars_font.drawString("GAME OVER", (WINDOW_WIDTH - starwars_font.getWidth
                    ("GAME OVER")) / 2, MESSAGE1_COORD, color.setBlendColour(1, 1, 0));
            starwars_font.drawString("Score : "+String.valueOf(player.getPlayer_score()), (WINDOW_WIDTH - starwars_font.getWidth
                    ("Score : "+String.valueOf(player.getPlayer_score()))) / 2, MESSAGE2_COORD, color.setBlendColour(1, 1, 0));
            starwars_font.drawString("Press Space to Restart", (WINDOW_WIDTH - starwars_font.getWidth
                    ("Press Space to Restart")) / 2, MESSAGE3_COORD, color.setBlendColour(1, 1, 0));
            if (input.wasPressed(Keys.SPACE)) {
                player.setCurrHealth(3);
                player.setPlayer_score(0);
                player.setY_coordinate(Window.getHeight() / 2 + 200);
                player.setX_coordinate(Window.getWidth() / 2);
            }
        }
    }
}