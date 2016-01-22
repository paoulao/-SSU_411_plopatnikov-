import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/*
Вывести названия всех месяцев в которых есть пятница 13го в указанном году. \
Input: Ввести год
Output: Перечислить все месяцы
*/

public class Friday_in_year
{
    public static void res(int year)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.YEAR, year);
        for(int i=0; i<12; i++)
        {
            calendar.set(calendar.MONTH, i);
            calendar.set(calendar.DAY_OF_MONTH, 12);
            if (calendar.get(calendar.DAY_OF_WEEK)==5)
            {
                System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        String lol = scanner.nextLine();
        try
        {
            int year = Integer.parseInt(lol);
            if (year >= 1800 && year <=2020)
                res(year);
            else
                System.err.println("1800<=year<=2020");
        }
        catch (NumberFormatException e)
        {
            System.err.println("Неверный формат даты!");
        }
    }
}