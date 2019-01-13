/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */
public class Person {

    protected String Name;
    protected int Age;
    private static int _PHONE_ = 1111111;
    protected int Phone;
    protected int Bank = 0;
    protected int Pay = 0;


    /**
     * Constructor to give no name, age, but will assign a static phone number
     */
    Person(){
        Name = "No-Name";
        Age = 0;
        Phone = _PHONE_;
        _PHONE_++;
    }

    /**
     * getter of Name
     * @return Name of person
     */
    public String getName(){
        return Name;
    }

    /**
     * getter of age
     * @return Age of person
     */
    public int getAge(){
        return Age;
    }

    /**
     * getter of phone number
     * @return Phone number of person
     */
    public int getPhone(){
        return Phone;
    }

    /**
     * setter of Name
     * @param name new name of person
     */
    public void setName(String name){
        Name = name;
    }

    /**
     * setter of age
     * @param age new age of person
     */
    public void setAge(int age){
        //PT -- Make sure you're getting a valid age and phone. -2
        Age = age;
    }

    /**
     * setter of phone number
     * @param phone new phone number
     */
    public void setPhone(int phone){
        Phone = phone;
    }

    /**
     * getter of amount in the bank
     * @return Bank which is the amount in the Bank
     */
    public int getBankAmount(){
        return Bank;
    }

    /**
     * setter of Bank Amount
     * @param Bank new Bank amount
     */
    public void setBankAmount(int Bank){
        this.Bank = Bank;
    }

    /**
     * getter of Pay Amount
     * @return the pay amount
     */
    public int getPayAmount(){
        //PT -- not all people will get paid, so this functionality shouldn't be here. -2
        return Pay;
    }

    /**
     * It's pay day! adds money to the bank account 
     * @return the amount of pay received
     */
    public int PayDay(){
        return 0;
    }

    /**
     * overidden toString to show the Name, Age, and Phone of the person in a sentence
     */
    public String toString() {
        return (Name + " is " + Age + " years old and has the phone number: " + Phone + "\n");
    }
}
