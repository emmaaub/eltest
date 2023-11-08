import java.util.ArrayList;

/**
 * Represents a world where robots exist and can perform actions within defined boundaries.
 * Manages the creation of robots, their movements, and interaction within the world space.
 *
 * @author Emma AUBERTOT, Maxence BERRY, Noah CHEMIN,
 *          Emma FOULON, Camille MAISON, Edouard RIGAUX
 * @version 31/10/23
 */
public class World
{
    // Constants defining the boundaries of the world
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 30;
    // Maximum number of robots allowed in the world
    private int MAX_Robot=15;
    // List to store robot instances in the world
    private static ArrayList<Robot> robotList = new ArrayList<Robot>();

    /**
     * Constructor for creating a World instance.
     */
    public World()
    {
        // initialisation des variables d'instance
    }
    
     /**
     * Executes a test scenario in the world with a specified number of robots.
     *
     * @param nbRobots The number of robots to be created and tested within the world.
     */

    public void testWorld(int nbRobots){
        createLife(nbRobots);
        for (int i = 0; i < 100; i++){
            for (Robot robot : robotList){
                robot.move();
            }
        }
    }
    
     /**
     * Moves all robots in the world for a specified number of iterations.
     *
     * @param nbItera The number of iterations for moving the robots.
     */

    public void MoveAll(int nbItera){
    for (int i = 0; i < nbItera; i++){
            for (Robot robot : robotList){
                robot.move();
            }
        }
    }
    
      /**
     * Creates life by adding robots to the world, considering specified numbers and random positions.
     *
     * @param nbRobots The number of robots to be created and placed within the world.
     */

    public void createLife(int nbRobots){
        for (int i = 0; i < nbRobots; i++){
            int newXPosition = 0;
            int newYPosition = 0;
            while (isOccupied(newXPosition, newYPosition)){
                newXPosition = randomPosition();
                newYPosition = randomPosition();
            }
            new FrogRobot("", newXPosition, newYPosition);
        }
    }
    
    /**
     * Generates a random position within the boundaries of the world.
     *
     * @return a random position within the world.
     */
    public int randomPosition(){
        int position = (int)(MIN_POSITION + Math.random() * (MAX_POSITION + MIN_POSITION));
        return position;
    }
    //----------------------GETTEURS--------------------------------------
    /**
     * Gets the minimum position of the world.
     * @return The minimum position value.
     */
    public static int getMinPosition()
    {
        return MIN_POSITION;
    }
    
    /**
     * Gets the max position of the world.
     * @return The max position value.
     */
    public static int getMaxPosition()
    {
        return MAX_POSITION;
    }
    
    /**
     * Gets the maximum number of robots allowed in the world.
     *
     * @return The maximum number of robots.
     */
    public int getMaxRobot()
    {
        return MAX_Robot;
    }
    //------------------------------------------------------------
    
    /**
     * Gets the current number of robots in the world.
     * By using the size of the array.
     *
     * @return The current number of robots in the world.
     */
    public int getNbRobot()
    {
        return robotList.size();
    }
    
    /**
     * Retrieves the list of robots currently present in the world.
     *
     * @return An ArrayList containing the robots in the world.
     */
    public ArrayList<Robot> getRobotList(){
        return robotList;
    }
    
    /**
     * Checks if a given position in the world is already occupied by a robot.
     *
     * @param x The X-coordinate to check.
     * @param y The Y-coordinate to check.
     * @return `true` if the position is occupied, `false` otherwise.
     */
    public boolean isOccupied(int x, int y){
        for (Robot ot : robotList){
            if ((ot.getXPosition() == x) && (ot.getYPosition() == y)){
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Checks if a specified position is outside the boundaries of the world.
     *
     * @param xR The X-coordinate to check.
     * @param yR The Y-coordinate to check.
     * @return `true` if the position is out of bounds, `false` otherwise.
     */
    private boolean outOfCanvas(int xR, int yR) {
        if ((xR<MIN_POSITION) || (yR<MIN_POSITION) || (xR>MAX_POSITION) || (yR>MAX_POSITION)) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a robot can move to a specified position in the world.
     *
     * @param xR The X-coordinate to check for movement.
     * @param yR The Y-coordinate to check for movement.
     * @return `true` if movement is possible, `false` if the position is occupied or out of bounds.
     */
    public boolean movePossible(int xR, int yR){
        if(isOccupied(xR,yR) || outOfCanvas(xR,yR)){
            return false;  
        }
        else{
            return true;
        }
    }
    
}


