import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author Timothy
 * @version 11/24/2023
 */
public class Apple extends Actor
{
    int speed = 1;
    
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeApple();
            if(MyWorld.decreaseLife() == 0)
            {
                world.gameOver();
                world.removeObject(this);
            }
            else
            {
                world.createApple();
            }
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
