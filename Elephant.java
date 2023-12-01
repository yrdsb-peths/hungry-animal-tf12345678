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
    GreenfootImage idle [] = new GreenfootImage[8];
    GreenfootImage idleLeft [] = new GreenfootImage[8];
    
    boolean facingRight = true;
    
    public Elephant()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idle[i].scale(100, 100);
        }
        setImage(idle[0]);
        
        for(int i = 0; i < idle.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(facingRight == true)
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            facingRight = false;
            move(-3);
        }else if(Greenfoot.isKeyDown("right"))
        {
            facingRight = true;
            move(3);
        }
        
        // Eviscerate apple if the Elephant touches it
        eat();
        animateElephant();
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
