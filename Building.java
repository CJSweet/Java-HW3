/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */
import java.util.Vector;

public abstract class Building{

    protected String Name;
    protected String Address;

    /**Constructor,
     * no parameters
     */
    Building(){
        Name = "Building";
        Address = "Wallaby Way Syndey Australia";
    }
    
    
   Building(String Name, String Address){
	   this.Name = Name;
	   this.Address = Address;
   }

    /**
     * Get Name function 
     * @return Name
     */
    public String getName(){
        return Name;
    }

    /**
     * Get Address function
     * @return address
     */
    public String getAddress(){
        return Address;
    }

    /**
     * set name of building function
     * @param Name the name of the building
     */
    public void setName(String Name){
        this.Name = Name;
    }

    /**
     * set address of building function
     * @param Address the address of the building
     */
    public void setAddress(String Address){
        this.Address = Address;
    }

    /**
     * function so that each building objects occupant vectors can have people added to them
     * @param p a Person object
     * @return the associated vectors with each building class 
     */
    //PT -- I would think this function only needs to return a bool -- whether the person was added or not.
    public abstract Vector<Person> addtoVector(Person p);

    /**
     * function so that people who leave the building can be removed from the occupant vector
     * @param p a Person object
     */
    public abstract void removefrom(Person p);

    /**
     * Displays who is in each building
     * I left it abstract so each building can have it's own structure and info to display who is inside
     */
    //PT -- I would like this to return the Vector object so that the UI can display it how it'd like to
    public abstract void WhoIn();


    /**
     * overidden toString() so that name and Address are nicely diplayed
     */
    public String toString(){
        return ("Building Name: " + Name + "\nAddress: " + Address + "\n");
    }
}
