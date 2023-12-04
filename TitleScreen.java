import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 70);
    Label instructionLabel = new Label("Eat all the apples!", 60);
    Label controlLabel1 = new Label("Use \u2190 and \u2192 keys to move.", 50);
    Label controlLabel2 = new Label("Press space to start", 40);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, 250, 50);
        addObject(instructionLabel, getWidth() / 2, 150);
        addObject(controlLabel1, getWidth() / 2, 225);
        addObject(controlLabel2, getWidth() / 2, 300);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,540,60);
    }
}