import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Friday
{
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
     //   System.out.println(calendar.getTime()); // ??????? ????
        //calendar.set(calendar.MONTH,0);
       // calendar.set(calendar.DAY_OF_MONTH,13);
       // System.out.println(calendar.getTime());
        int a = Calendar.DAY_OF_WEEK;
        int b = Calendar.SHORT;
        Locale c = Locale.US;
        System.out.println(calendar.getDisplayName(a, b, c));
        Scanner scanner = new Scanner(System.in);
        System.out.println("vvedi dannie!!");
        String lol = scanner.nextLine();
        int year = Integer.parseInt(lol);
        System.out.println(year-10);
    }
}
