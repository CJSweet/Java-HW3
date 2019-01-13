 /**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */


public class Police extends Person implements Employee
{
    public enum PoliceRole {
        Patrol, Sargent, Captain, Chief };
    PoliceRole role;
    private static int id = 1;
    private int PolID;

    /**
     * default constructor to set person as patrol officer
     */
    public Police(){
        role = PoliceRole.Patrol;
        Pay = 500;
    }

    /**
     * overidden constructor
     * @param Name name of officer
     * @param Age age of officer
     * @param Phone number of officer
     * @param role the ranking of the officer
     */
    public Police(String Name, int Age, int Phone, PoliceRole role){
        this.role = role;
        this.Name = Name;
        this.Age = Age;
        this.Phone = Phone;
        Pay = 500;
    }

    //Description in Person class
    public int PayDay(){
        Bank = Bank + Pay;
        return Pay;
    }

     /**
      * getter of EmpID of police officer
        @return the ID
      */
    public int getID(){
        PolID = id;
        id++;
        return PolID;
    }

    /**
     * overiden toString to give the officer's ranking as well
     */
    public String toString(){
        return (role + " " + Name + " is " + Age + " years old and has the phone number: " + Phone + "\n");
    }

}