import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double principal = scanner.nextDouble();
        double rate = scanner.nextDouble();
        double finalAmount = scanner.nextDouble();

        double years = Math.log(finalAmount / principal) / Math.log((100 + rate) / 100);
        if (years % 1 == 0) {
            System.out.println((int)years);
        }
        else {
            years+=1;
            System.out.println((int)years);
        }
    }
}