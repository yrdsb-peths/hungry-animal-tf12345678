import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Timothy
 * @version 11/24/2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level;
    
    static int lifeCount;
    static Label lifeLabel;
    
    Apple apple;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        setLevel(difficulty);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 200, 300);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        lifeLabel = new Label("lives: " + lifeCount, 80);
        addObject(lifeLabel, 400, 50);
        
        createApple();
    }
    
    public void setLevel(int difficulty)
    {
        if(difficulty == 1)
        {
            level = 1;
            lifeCount = 3;
        }else if(difficulty == 2)
        {
            level = 2;
            lifeCount = 2;
        }else if(difficulty == 3)
        {
            level = 3;
            lifeCount = 1;
        }
    }
    
    /**
     * creates and adds a game over sign on the canvas
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("GameOver", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * increases the score by one
     */
    public void increaseScore()
    {
        score ++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level ++;
        }
    }
    
    /**
     * randomly create apples at the top of the screen
     */
    public void createApple()
    {
        apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    /**
     * removes the apple
     */
    public void removeApple()
    {
        removeObject(apple);
    }
    
    /**
     * lowers life count by one
     */
    public static int decreaseLife()
    {
        lifeCount --;
        lifeLabel.setValue(lifeCount);
        return lifeCount;
    }
}
