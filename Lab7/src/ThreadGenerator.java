import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadGenerator {
    private static int a;
    private static int thrCount;
    static List<Double> threads = new ArrayList<>();
    static String action;

    public static void main(String[] args) {
        System.out.println("Enter number of threads");
        try (Scanner sc = new Scanner(System.in)) {
            thrCount = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number");
            a = Integer.parseInt(sc.nextLine());
            System.out.println("Enter action symbol (+/-/*)");
            action = sc.nextLine();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        execute();
        getResult();
    }

    public static void execute() {
        List<CalculatorThread> calculatorThreads = new ArrayList<>();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 500, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), threadFactory);
        for (int i = 0; i < thrCount; i++) {
            CalculatorThread calculatorThread = new CalculatorThread(a);
            calculatorThreads.add(calculatorThread);
            poolExecutor.execute(calculatorThread);
        }
        poolExecutor.shutdown();
        for (var s : calculatorThreads) {
            try{
                while(poolExecutor.getActiveCount() != 0){
                    Thread.sleep(400);
                }
            }
            catch (InterruptedException e){
                System.out.println("Interrupted exception.");
                Thread.currentThread().interrupt();
            }
            threads.add(s.getResult());
        }
    }

    public static void getResult(){
        double res = 0;
        switch (action) {
            case "+" -> {
                for (double d : threads) {
                    res += d;
                }
            }
            case "-" -> {
                for (double d : threads) {
                    res -= d;
                }
            }
            case "*" -> {
                res = 1;
                for (double d : threads) {
                    res *= d;
                }
            }
            default -> System.out.println("Def");
        }
        System.out.println("Result = " + res);
    }
}