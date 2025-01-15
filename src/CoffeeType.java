

public class CoffeeType
{
    private String coffee;
    private double price;
    private int quantity;


    //default constructor
    public CoffeeType()
    {
        coffee = "";
        price = 0.0;
        quantity = 0;
    }
    //normal constructor
    public CoffeeType(String coffee, double price, int quantity)
    {
        this.coffee = coffee;
        this.price = price;
        this.quantity = quantity;
    }
    //setter
    public void setCoffee(String coffee)
    {
        this.coffee = coffee;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    //getter
    public String getCoffee()
    {
        return coffee;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }

    public double caclTotal()
    {
        return 0;
    }
}

