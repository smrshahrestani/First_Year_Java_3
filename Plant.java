import java.util.List;

/**
 * A class representing shared characteristics of plants.
 * 
 * @author David J. Barnes and Michael Kölling
 * @author Amirali Koochaki . Marouane el Moubarik alaoui .Seyed Mohammad Reza Shahrestani
 * @version 21.02.2020 (2)
 */
public abstract class Plant
{

    // Whether the plant is alive or not.
    private boolean alive;

    // The plant's field.
    private Field field;

    // The plant's position in the field.
    private Location location;

    /**
     * Create a new plant at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Plant(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location); 
    }

    /**
     * Make this plant act - that is: make it do
     * whatever it wants/needs to do.
     * @param newPlants A list to receive newly born plants.
     */
    abstract public void act(List<Plant> newPlants);

    /**
     * Check whether the plant is alive or not.
     * @return true if the plant is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the plant is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the plant's location.
     * @return The plant's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the plant at the new location in the given field.
     * @param newLocation The plant's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the plant's field.
     * @return The plant's field.
     */
    protected Field getField()
    {
        return field;
    }

}
