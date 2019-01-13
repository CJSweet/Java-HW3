/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */

public class City{

    private String Name;

    /**
     * default constructor that names the city
     */
    City(){
        Name = "Chattanooga, Pennsylvania";
    }

    /**
     * get Name function
     * @return Name of the city
     */
    public String getCityName(){
        return Name;
    }

    /**
     * set city name function
     * @param Name new city name
     */
    public void setCityName(String Name){
        this.Name = Name;
    }

    /**
     * overidden toString to welcome people to the city
     */
    public String toString(){
        return ("Welcome to the city of " + Name +"!\n");
    }

}