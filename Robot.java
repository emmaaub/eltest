
/**
 * The `Robot` class is an abstract class representing a robot with various properties and behaviors.
 * Subclasses can implement the `move` method to define specific robot movements.
 *
 * @author Emma AUBERTOT, Maxence BERRY, Noah CHEMIN,
 *          Emma FOULON, Camille MAISON, Edouard RIGAUX
 * @version 01/11/2023
 */
abstract public class Robot
{
    // X-coordinate position of the robot.
    private int xPosition;
    // Y-coordinate position of the robot.
    private int yPosition;
    private boolean isVisible = true;
    // The color of the robot's body.
    private String colorBody;
    // The name of the robot.
    private String name;
    // The current direction of the robot (1: North, 2: East, 3: South, 4: West).
    private int direction;
    // The minimum length required for a valid robot name.
    private final static int MIN_NAME_LENGTH = 3;
    // The minimum allowable position in the world.
    private final static int MIN_POSITION = 0;
    // The maximum allowable position in the world.
    private final static int MAX_POSITION = 30;
    // Count of unnamed robots.
    private static int numberOfUnnamedRobots = 0;
    // The world in which the robot exists.
    private static World world = new World();
    // The CanvasRobot used for visualization.
    private CanvasRobot canvasRobot = new CanvasRobot(colorBody);

    /**
     * Constructor for creating Robot objects.
     * Verification of name and if there is no name, the
     * robot have a name by default
     * 
     *
     * @param newName   The name of the robot.
     * @param color     The color of the robot.
     * @param newPosX   The initial X-coordinate position of the robot.
     * @param newPosY   The initial Y-coordinate position of the robot.
     */
    public Robot(String newName, String color, int newPosX, int newPosY)
    {
        if (world.getNbRobot()!=world.getMaxRobot()){
            if (newName.trim().length() >= MIN_NAME_LENGTH)
            {
                this.name = newName.trim();
            }else{
                numberOfUnnamedRobots += 1;
                name = "iRobot" + numberOfUnnamedRobots;
            }
            
            if (newPosX <= MAX_POSITION && newPosX >= MIN_POSITION)
            {
            this.xPosition = newPosX;
            }else{
            xPosition = 0;
            }
            
            if (newPosY <= MAX_POSITION && newPosY >= MIN_POSITION)
            {
            this.yPosition = newPosY;
            }else{
            yPosition = 0;
            }
            
            this.colorBody = color;
            canvasRobot.drawRobot(this.xPosition,this.yPosition);
            canvasRobot.setColourBody(colorBody);
            world.getRobotList().add(this);
            }
    }   
    
    /**
     * Abstract method for defining robot movement in subclasses.
     */
    abstract public void move(); 
    
     /**
     * Moves the robot upwards by one unit and updates its position.
     */
    public void moveUp()
    {
        
        this.yPosition-=1;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
    }
    
    /**
     * Moves the robot downwards by one unit and updates its position.
     */
    public void moveDown()
    {
    
        this.yPosition+=1;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
    
    }
    
    /**
     * Moves the robot to the left by one unit and updates its position.
     */
    public void moveLeft()
    {
        
        this.xPosition-=1;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
        
    }
    
    /**
     * Moves the robot to the right by one unit and updates its position.
     */
    public void moveRight()
    {
        
        this.xPosition+=1;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
        
    }
    
    //-------------------GETTEURS--------------------
    /**
     * Gets the current X-coordinate position of the robot.
     *
     * @return The X-coordinate position of the robot.
     */
    public int getXPosition(){
        return xPosition;
    }
    
    /**
     * Gets the current Y-coordinate position of the robot.
     *
     * @return The Y-coordinate position of the robot.
     */
    public int getYPosition(){
        return yPosition;
    }
    
    /**
     * Gets the current Y-coordinate position of the robot.
     *
     * @return The Y-coordinate position of the robot.
     */
    public int getMaxPosition(){
        return MAX_POSITION;
    }
    
    /**
     * Gets the minimum allowable position in the world.
     *
     * @return The minimum position value in the world.
     */
    public int getMinPosition(){
        return MIN_POSITION;
    }
    
    /**
     * Gets the current direction of the robot.
     *
     * @return The current direction of the robot (1: North, 2: East, 3: South, 4: West).
     */
    public int getDirection(){
        return direction;
    }
    
    /**
     * Gets the name of the robot.
     *
     * @return The name of the robot.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the color of the robot's body.
     *
     * @return The color of the robot's body.
     */
    public String getColorBody(){
        return colorBody;
    }
    
    /**
     * Gets the reference to the world in which the robot exists.
     *
     * @return The world in which the robot exists.
     */
    public World getWorld(){
        return world;
    }
    
    /**
     * Gets the reference to the CanvasRobot used for drawing and visualization.
     *
     * @return The CanvasRobot used for drawing and visualization.
     */
    public CanvasRobot getCanvasRobot(){
        return canvasRobot;
    }
    
    //------------------SETTEURS--------------------------------------
    /**
     * Sets the X-coordinate position of the robot to the specified value.
     *
     * @param xPosition The new X-coordinate position of the robot.
     */
    public void setXPosition(int xPosition){
        this.xPosition = xPosition;
    }
    
    /**
     * Sets the Y-coordinate position of the robot to the specified value.
     *
     * @param yPosition The new Y-coordinate position of the robot.
     */
    public void setYPosition(int yPosition){
        this.yPosition = yPosition;
    }
    
    /**
     * Sets the direction of the robot to the specified value.
     *
     * @param direction The new direction of the robot (1: North, 2: East, 3: South, 4: West).
     */
    public void setDirection(int direction){
        this.direction = direction;
    }
    
    /**
     * Changes the direction of the robot by turning 90 degrees clockwise.
     * If the current direction is West (4), it turn to North (1).
     */
    public void turn(){
        if (direction == 4) {
            direction = 1;
        } else {
            direction++;
        }
        
    }
    
    /**
     * Sets the color of the robot's body to the specified value.
     * If the provided color is not recognized, the default color is set to "BLUE."
     *
     * @param newColor The new color for the robot's body.
     */
    public void setColorBody(String newColor) {
    newColor = newColor.toUpperCase();
    if (newColor.equals("BLUE") || newColor.equals("GREEN") || newColor.equals("YELLOW") ||
        newColor.equals("ORANGE") || newColor.equals("BLACK") || newColor.equals("RED") ||
        newColor.equals("WHITE") || newColor.equals("MAGENTA") || newColor.equals("PURPLE"))
    {
        this.colorBody = newColor;
    }else{
        this.colorBody = "BLUE";
    }
    updateColor();
    }
    
    /**
     * Updates the color of the robot's body on the associated CanvasRobot for visualization.
     * This method is intended for internal use.
     */
    private void updateColor(){
        canvasRobot.setColourBody(this.colorBody);
    }
}


