/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */

public class CityTest{
    public static void main(String[] args){
        
        Building[] CityBuildings = {new CityHall("Chattanooga City Hall", "100 Main Street"), new School("Chattanooga Public School", "333 W Meadows Road")};
        Person[] population = {new Police("Chris Sweet", 49, 3455432, Police.PoliceRole.Chief), new Police("Charlie Wilkins", 35, 6788765, Police.PoliceRole.Sargent), 
        new Police("Nicki Wilson", 28, 8900987, Police.PoliceRole.Patrol), new Police("Susan Sebastian", 42, 1234432, Police.PoliceRole.Captain), 
        new Police("Peyton Manning", 35, 4729111, Police.PoliceRole.Sargent), new Police("Serena Williams", 30, 9992221, Police.PoliceRole.Patrol), 
        new Teacher("Megan Lacey", 35, 1357986, "9th", Teacher.Certification.Masters), new Teacher("DeWayne McCabe", 32, 2468086, "10th", Teacher.Certification.Masters), 
        new Teacher("Patty Wise", 50, 1234567, "4th", Teacher.Certification.Masters), new Teacher("Kent Jones", 60, 5647382, "Professor", Teacher.Certification.Phd), 
        new Kid("Little Jordan Humphrey", 8, "Laffy Taffy"), new Kid("Little Susie Q", 9, "Oreos"), new Kid("Austin Post", 16, "M&M's"), 
        new Kid("David Burd", 15, "Three Musketeers"), new Kid("Marshawn Lynch", 12, "Skittles"), new Kid("Russell Westbrook", 11, "Twix"), 
        new Kid("Chancelor Bennett", 10, "Kit-Kat"), new Teacher("Kyrie Irving", 35, 11773311, "Preschool", Teacher.Certification.Masters), new Kid("Luka Doncic", 15, "Reese's")};

        //Welcome to the city
        City city = new City();
        System.out.printf(city.toString());

        //Add some police officers to the City Hall, then display their names.
        for(int i =0; i< 4; i++){
            CityBuildings[0].addtoVector(population[i]);
        }
        CityBuildings[0].WhoIn();

        //Add some teachers/kids to the school, then display their
        for(int i = 7; i < 17; i++){
            CityBuildings[1].addtoVector(population[i]);
        }
        CityBuildings[1].WhoIn();

        ///Names of everyone in town
        for(int i = 0; i < population.length; i++)
            System.out.printf(population[i].toString());

        ///Names of every building
        for(int i = 0; i< CityBuildings.length; i++)
        System.out.printf(CityBuildings[i].toString());

        //Pay the employees
        for (int i = 0; i < population.length; i++){
            if (population[i] instanceof Employee){
            System.out.printf(population[i].getName() + " has been paid $" + population[i].PayDay() + "\n");
            }
            else
            System.out.printf(population[i].getName() + " has not been paid, for they are a child.\n");
        }
        
    }
}