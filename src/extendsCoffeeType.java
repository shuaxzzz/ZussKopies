public class extendsCoffeeType extends CoffeeType
{
    private String cold;
    private String typecoffee;
    private String cream;
    private String sugar;

    //default constructor
    public  extendsCoffeeType()
    {
        cold = "";
        typecoffee = "";
        cream = "";
        sugar = "";
    }
    //normal constructor
    public extendsCoffeeType(String coffee, double price, int quantity, String cold, String typecoffee, String cream, String sugar)
    {
        super(coffee,price,quantity);
        this.cold = cold;
        this.typecoffee = typecoffee;
        this.cream = cream;
        this.sugar = sugar;
    }
    //getters
    public String getCold()
    {
        return cold;
    }
    public String getTypecoffee()
    {
        return typecoffee;
    }
    public String getCream()
    {
        return cream;
    }
    public String getSugar()
    {
        return sugar;
    }

    //setters
    public void setCold(String cold)
    {
        this.cold = cold;
    }
    public void setTypecoffee(String typecoffee)
    {
        this.typecoffee = typecoffee;
    }
    public void setCream(String cream)
    {
        this.cream = cream;
    }
    public void setSugar(String sugar)
    {
        this.sugar = sugar;
    }

    //calculation
    public double sugarprice()
    {
        double price = 0;
        if(sugar == "no")
        {
            price = 0;
        }
        else if(sugar == "less")
        {
            price = 0.5;
        }
        else if(sugar == "normal")
        {
            price = 1;
        }
        return price;
    }
}