package guice;

public class BI_Implementation implements BI{
    @Override
    public void execute() {
        System.out.println("BI");
    }

    @Override
    public int getSum() {
        return 9;
    }
}
