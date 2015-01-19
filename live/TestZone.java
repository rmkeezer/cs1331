import java.util.Scanner;

public class TestZone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 0) {
            System.out.println("Please input a number");
        } else {
            System.out.println(num);
        }
        System.out.println(sc.nextLine());
    }

}