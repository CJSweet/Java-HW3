/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */
import java.util.Vector;

public class CityHall extends Building{

    /**
     * constructor to name CityHall, and give address
     * @param Name Name of building
     * @param Address address of building
     */
    CityHall(String Name, String Address){
        this.Name = Name;
        this.Address = Address;
    }
    
    CityHall(){
    	Name = "Chattanooga Police Department";
    	Address = "130 Maple Street, Chattanooga, PA";
    }

    /**
     * City Hall Occupant vector to be able to store all people in it
     */
    public Vector<Person> CHoccupants = new Vector<Person>();

    //Decription in Building class
    public Vector<Person> addtoVector(Person p){
        CHoccupants.addElement(p);
        return CHoccupants;
    }

    //Description in Building class
    public void removefrom(Person p){
        //PT -- what if the person isn't there?
        CHoccupants.remove(p);
        CHoccupants.trimToSize();
    }

    //Description in Building class
    public void WhoIn(){
        System.out.printf("\nHere's who is in %s right now: \n", Name);
        for (int i = 0; i < CHoccupants.size(); i++){
            System.out.printf(CHoccupants.elementAt(i).getName() + "\n");
        }
        System.out.printf("\n");
    }
}
