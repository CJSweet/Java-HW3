/**
 * @author Casey Sweet 
 * Tucker
 * CS-372-Java
 * 1/8/2019
 */
public class Kid extends Person{
    private String FavCandy;

    /**
     * Default constructor to all fav candy as snickers
     */
    public Kid(){
        FavCandy = "Snickers";
    }

    /**
     * Overidden constructor to give Name, Age, and FavCandy
     * @param Name Name of kid
     * @param Age age of kid
     * @param FavCandy kids fav candy
     */
    public Kid(String Name, int Age, String FavCandy){
        this.FavCandy = FavCandy;
        Phone = 0;
        this.Name = Name;
        this.Age = Age;
    }

    /**
     * getter of fav candy
     * @return FavCandy
     */
    public String getFavCandy(){
        return FavCandy;
    }

    /**
     * setter of fav candy
     * @param candy new fav candy
     */
    public void setFavCandy(String candy){
        FavCandy = candy;
    }

}