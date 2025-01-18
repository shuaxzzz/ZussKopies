public class CountCoffee
{
    private int countkopi;
    private int countt;

    public CountCoffee()
    {countkopi = 0;
        countt= 0;}

    public CountCoffee(int countkopi)
    {this.countkopi = countkopi;
        this.countt = countkopi;}

    public void setCountkopi(int countkopi) {this.countkopi = countkopi;}
    public int getCountkopi() {return countkopi;}

    public void setCountt(int countt) {this.countkopi = countkopi;}

    public int totalcountkopi()
    {
        int total;
        total = countkopi + 1;
        countkopi = total;
        return total;
    }
}
