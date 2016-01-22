import java.util.Calendar;
import java.util.Scanner;

/*
Вывести все года где пятница 13го попадается в указанном месяце. Вывести количество найденных годов.
Input : Ввести номер месяца
Output : Перечислить года, вывести их количество.
*/

public class Friday_in_month
{
    public static void res(int month)
    {
        int kol_year = 0;
        Calendar calendar = Calendar.getInstance();
        month--;
        calendar.set(calendar.MONTH, month);
        for(int i=1800; i<=2020; i++)
        {
            calendar.set(calendar.YEAR, i);
            calendar.set(calendar.DAY_OF_MONTH, 12);
            if (calendar.get(calendar.DAY_OF_WEEK)==5)
            {
                System.out.println(calendar.get(calendar.YEAR));
                kol_year++;
            }
        }
        System.out.println("Всего годков: " + kol_year);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a month: ");
        String lol = scanner.nextLine();
        try
        {
            int month = Integer.parseInt(lol);
            if (month > 0 && month <= 12) {
                month++;
                res(month);
            }
            else
                System.err.println("0<month<13");
        }
        catch (NumberFormatException e)
        {
            System.err.println("Неверный формат месяца!");
        }
    }
}