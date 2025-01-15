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
    public double calcTotal()
    {
        double totalprice = 0;
        if(super.getCoffee() == "Americano")
           totalprice = super.getPrice()*super.getQuantity();
        else if(super.getCoffee() == "Cappucino")
            totalprice = super.getPrice()*super.getQuantity();
        else if(super.getCoffee() == "VanillaLatte")
            totalprice = super.getPrice()*super.getQuantity();
        else if(super.getCoffee() == "Mocha")
            totalprice = super.getPrice()*super.getQuantity();
        else if(super.getCoffee() == "CaramelLatte")
            totalprice = super.getPrice()*super.getQuantity();

        if(cream == "yes")
            totalprice += + 2*super.getQuantity();

        return totalprice;
    }

}