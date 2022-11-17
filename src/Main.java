import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean inputIsNotCorrect = true;
        String testTime = "000000";
        inputIsNotCorrect = true;
        Scanner in = new Scanner(System.in);
        while (inputIsNotCorrect) {
            System.out.print("Введите время в формате ЧЧММСС: ");
            testTime = in.next();
            inputIsNotCorrect = (!(testTime.matches("\\d{6}")));
        }
        Time time = new Time(testTime);
        if (time.checkIsNoTime()){
            return;
        }
        System.out.print("Введите формат, используя символы h,H,m,s: ");
        String format = in.next();
        System.out.print("Введите количество добавляемы секунд: ");
        int testSec = in.nextInt();
        System.out.printf("%s + %s секунд, получаем %s \n",time.format(format), testSec,time.addSeconds(testSec, format));
        System.out.print("Введите количество добавляемых минут: ");
        int testMin = in.nextInt();
        System.out.printf("%s + %s минут, получаем %s \n",time.format(format),testMin, time.addMinutes(testMin, format));
        System.out.print("Введите количество добавляемых часов: ");
        int testHours = in.nextInt();
        System.out.printf("%s + %s часов, получаем %s \n",time.format(format), testHours,time.addHours(testHours, format));
    }
}