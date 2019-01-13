/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */
import java.util.Vector;

public class School extends Building{
     
    /**
     * overridden constructor
     * @param Name name of school
     * @param Address address of school
     */
    School(String Name, String Address){
        this.Name = Name;
        this.Address = Address;
    }
    
    School(){
    	Name = "Chattanooga School District";
    	Address = "132 Maple Street, Chattanooga, PA";
    }

    /**
     * vector of school occupants
     */
    public Vector<Person> SchoolOccupants = new Vector<Person>();

    //see Building Class 
    public Vector<Person> addtoVector(Person p){
        SchoolOccupants.addElement(p);
        return SchoolOccupants;
    }

    //see Building Class
    public void removefrom(Person p){
        SchoolOccupants.remove(p);
        SchoolOccupants.trimToSize();
    }

    //see Building Class
    public void WhoIn(){
        System.out.printf("\nHere's who is in %s right now: \n", Name);
        for (int i = 0; i < SchoolOccupants.size(); i++){
            System.out.printf(SchoolOccupants.elementAt(i).getName() + "\n");
        }
        System.out.printf("\n");
    }
}