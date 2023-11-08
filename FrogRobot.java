import java.util.Random;

/**
 * The `FrogRobot` class represents a frog robot capable of moving in all directions but at 2 squares each time
 * The movement recreate a jump.
 * Each 4 moves it turns clockwise. 
 * Each 7 moves the direction is change randomly. 
 * 
 * This class is a subclass of the `Robot` class.
 * 
 * @author Aubertot Emma
 * @version 01/11/2023
 */
public class FrogRobot extends Robot
{
    private int nbMouv; //number of robot movements

    /**
     * Constructs a `FrogRobot` object with the specified name, initial X-coordinate position, and initial Y-coordinate position.
     * The robot is initially colored "GREEN" and faces north (direction 1).
     * The number of robot movements is initialize at 0.
     * AVOID create a frog robot from here and create it from World class. !!!!
     * 
     *
     * @param newName   The name of the FrogRobot.
     * @param newPosX   The initial X-coordinate position of the robot.
     * @param newPosY   The initial Y-coordinate position of the robot.
     */
    public FrogRobot(String newName, int newPosX, int newPosY)
    {
        
        super(newName, "GREEN", newPosX, newPosY);
        this.nbMouv = 0;
        super.setDirection(1);
        
    }

    /**
     * Moves the `FrogRobot` in the current direction, updating its position and direction.
     * The robot can change direction periodically, turning every 4 movements and changing direction every 7 movements.
     */
    @Override
    public void move()
    {
        Random random = new Random();
        this.nbMouv++;

        if (this.nbMouv % 4 == 0) {
            super.turn();
        }
        if (this.nbMouv % 7 == 0) {
            int alea = random.nextInt(4) + 1;
            setDirection((getDirection() + alea) % 4);
        }
        
        switch (super.getDirection()) {
            case 1:
                if (getWorld().movePossible(super.getXPosition(), super.getYPosition()-2)) {
                    moveUp();
                }
                break;

            case 2:
                if (getWorld().movePossible(super.getXPosition()+2, super.getYPosition())) {
                    moveRight();
                }
                break;

            case 3:
                if (getWorld().movePossible(super.getXPosition(), super.getYPosition()+2)) {
                    moveDown();
                }
                break;

            case 4:
                if (getWorld().movePossible(super.getXPosition()-2, super.getYPosition())) {
                    moveLeft();
                }
                break;
        }

        getCanvasRobot().getCanvas().wait(100);
    }
    
    /**
     * Moves the robot upwards by 2 unit and updates its position.
     */
    @Override
    public void moveUp()
    {
        super.setYPosition(super.getYPosition()-2);
        super.getCanvasRobot().drawRobot(getXPosition(),getYPosition());
    }
    
    /**
     * Moves the robot downwards by 2 unit and updates its position.
     */
    @Override
    public void moveDown()
    {
        super.setYPosition(super.getYPosition()+2);
        super.getCanvasRobot().drawRobot(getXPosition(),getYPosition());
    }
    
    /**
     * Moves the robot to the left by 2 unit and updates its position.
     */
    public void moveLeft()
    {
        super.setXPosition(super.getXPosition()-2);
        super.getCanvasRobot().drawRobot(getXPosition(),getYPosition());
    }
    
    /**
     * Moves the robot to the right by 2 unit and updates its position.
     */
    public void moveRight()
    {
        super.setXPosition(super.getXPosition()+2);
        super.getCanvasRobot().drawRobot(getXPosition(),getYPosition());
    }
}
