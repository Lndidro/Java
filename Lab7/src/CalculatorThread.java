public class CalculatorThread implements Runnable{
    private int a;
    private double result;

    public CalculatorThread(int a) {
        this.a = a;
        this.result = 1;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println("Start thread: " + Thread.currentThread().getName());
        for (int i =1; i<= 2*a; i +=1) {
            result *= i;
        }
        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }
}