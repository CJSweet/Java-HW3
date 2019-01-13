 /**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */

 

public class Teacher extends Person implements Employee{
	
	public enum Certification {Masters, Phd};
	Certification cert;
    private String GradeLevel; //using as a string so that kindergarden, pre-K, and college can be used
    private static int id = 5000;
    private int TeachID;

    /**
     * default constructor to set the teaching level to K and cert to Master's
     */
    public Teacher(){
        GradeLevel = "Kindergarden";
        cert = Certification.Masters;
        Pay = 400;
    }

    /**
     * overidden constructor
     * @param Name of teacher
     * @param Age of teacher
     * @param Phone of teacher
     * @param GradeLevel teaching level of teacher
     * @param cert teaching level of certification
     */
    public Teacher(String Name, int Age, int Phone, String GradeLevel, Certification cert){
        this.Name = Name;
        this.Age = Age;
        this.Phone = Phone;
        this.GradeLevel = GradeLevel;
        this.cert = cert;
        Pay = 400; //PT -- Again, not all teachers make the same amount of money. -1
    }

    /**
     * getter of teaching level
     * @return grade level
     */
    public String getGradeLevel(){
        return GradeLevel;
    }

    /**
     * get cert level
     * @return either Masters or Phd
     */
    public Certification getCertification(){
        return cert;
    }

    /**
     * setter of grade level
     * @param GradeLevel teaching level of teacher
     */
    public void setGradeLevel(String GradeLevel){
        this.GradeLevel = GradeLevel;
    }

    /**
     * setter of cert level
     * @param cert certification level (either Master's or Phd)
     */
    public void setCertification(Certification cert){
        this.cert = cert;
    }

    //see Person Class
    public int PayDay(){
        Bank = Bank + Pay;
        return Pay;
    }

    /**
     * returns employee ID of Teacher
     * @return employee ID
     */
    public int getID(){
        TeachID = id;
        id++;
        return TeachID;
    }

    /**
     * overidden toString to let user know this is a teacher.
     */
    public String toString(){
        return ("Instructor " + Name + " has a " + cert + " certification, is " + Age + " years old, and has the phone number: " + Phone + " \n");
    }
}
