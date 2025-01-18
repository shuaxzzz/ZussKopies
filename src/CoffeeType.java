

public class CoffeeType
{
    private String coffee;
    private int quantity;
    private String cold;
    private String typecoffee;
    private String cream;
    private String sugar;


    //default constructor
    public CoffeeType()
    {
        coffee = "None";
        quantity = 0;
        cold = "None";
        typecoffee = "None";
        cream = "None";
        sugar = "None";
    }
    //normal constructor
    public CoffeeType(String coffee, int quantity, String cold, String typecoffee, String cream, String sugar)
    {
        this.coffee = coffee;
        this.quantity = quantity;
        this.cold = cold;
        this.typecoffee = typecoffee;
        this.cream = cream;
        this.sugar = sugar;
    }
    //setter
    public void setCoffee(String coffee)
    {
        this.coffee = coffee;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public void setCold(String cold) {this.cold = cold;}
    public void setTypecoffee(String typecoffee) {this.typecoffee = typecoffee;}
    public void setCream(String cream) {this.cream = cream;}
    public void setSugar(String sugar) {this.sugar = sugar;}
    //getter
    public String getCoffee()
    {
        return coffee;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public String getCold() {return cold;}
    public String getTypecoffee() {return typecoffee;}
    public String getCream() {return cream;}
    public String getSugar() {return sugar;}

    public double calcTotal()
    {
        double totalprice = 0;
        if(coffee == "Americano")
            totalprice = 6.90*quantity;
        else if(coffee == "Cappucino")
            totalprice = 9.90*quantity;
        else if(coffee == "Vanilla Latte")
            totalprice = 10.90*quantity;
        else if(coffee == "Mocha")
            totalprice = 12.90*quantity;
        else if(coffee == "Caramel Latte")
            totalprice = 10.90*quantity;

        if(cream == "yes")
            totalprice += + 2*quantity;

        return totalprice;
    }
}

