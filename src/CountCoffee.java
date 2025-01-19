public class CountCoffee
{
    private double countkopi;
    private double totalall;

    public CountCoffee()
    {countkopi = 0;
        totalall= 0;}

    public CountCoffee(double countkopi)
    {this.countkopi = countkopi;
        this.totalall = countkopi;}

    public void setCountkopi(double countkopi) {this.countkopi = countkopi;}
    public double getCountkopi() {return countkopi;}

    public void setCountt(double countt) {this.countkopi = countkopi;}

    public double totalcountkopi()
    {
        double total = totalall;
        total = countkopi + totalall;
        totalall = total;
        return total;
    }
}
