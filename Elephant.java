import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Timothy
 * @version 11/24/2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("231873-d2d5b364-22b4-49f5-bf2b-76ed5b338a6e.mp3");
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        // Eviscerate apple if the Elephant touches it
        eat();
    }
    
    /**
     * eat apple and spawn a new one
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
