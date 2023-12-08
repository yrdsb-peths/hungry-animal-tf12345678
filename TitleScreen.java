import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Elephant elephant = new Elephant();
    Label titleLabel = new Label("Hungry Elephant", 70);
    Label instructionLabel = new Label("Eat all the apples!", 60);
    Label controlLabel1 = new Label("Use \u2190 and \u2192 keys to move.", 50);
    Label controlLabel2 = new Label("Press 1 for easy difficulty", 40);
    Label controlLabel3 = new Label("Press 2 for normal difficulty", 40);
    Label controlLabel4 = new Label("Press 3 for hard difficulty", 40);
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(elephant,540,60);
        addObject(titleLabel, 250, 50);
        addObject(instructionLabel, getWidth() / 2, 150);
        addObject(controlLabel1, getWidth() / 2, 225);
        addObject(controlLabel2, getWidth() / 2, 300);
        addObject(controlLabel3, getWidth() / 2 + 17, 330);
        addObject(controlLabel4, getWidth() / 2 - 1, 360);
    }

    /**
     * starts the game when space is pressed
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            startGame(1);
        }
        if(Greenfoot.isKeyDown("2"))
        {
            startGame(2);
        }
        if(Greenfoot.isKeyDown("3"))
        {
            startGame(3);
        }
    }

    private void clearObjs(){
        titleLabel = null;
        instructionLabel = null;
        controlLabel1 = null;
        controlLabel2 = null;
        controlLabel3 = null;
        controlLabel4 = null;
    }

    private void startGame(int diff){
        clearObjs();
        MyWorld gameWorld = new MyWorld(diff);
        Greenfoot.setWorld(gameWorld);
    }
}