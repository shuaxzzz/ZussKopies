public class Customers  {
    private String username;
    private String password;
    private String name;
    private String birthday;


    //normal constructor
    public Customers(String username,String password){
        this.username=username;
        this.password=password;


    }
    //setter
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }



    //getter

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public String getBirthday(){
        return birthday;
    }
}
