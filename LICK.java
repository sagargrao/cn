
import java.util.Scanner;
import java.lang.*;

public class LICK
{
    public static void main(String[] args)
    {
        int i;
        int a[] = new int[20];

        int buck_sum = 0, buck_cap = 4, rate = 3, sent, user;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of packets");
        int m = in.nextInt();

        System.out.println("Enter the packets");

        for(i = 1; i <= m; i++)
        {
            a[i] = in.nextInt();
        }

        System.out.println("Clock\tPacket Size\tAccept\tSent\tRemaining");

        for(i = 1; i <= m; i++)
        {
            if(a[i] != 0)
            {
                if(buck_sum + a[i] > buck_cap)
                {
                    user = -1;
                }
                else
                {
                    user = a[i];
                    buck_sum += a[i];
                }
            }
            else
            {
                user = 0;
            }

            if(buck_sum != 0)
            {
                if(buck_sum < rate)
                {
                    sent = buck_sum;
                    buck_sum = 0;
                }
                else
                {
                    sent = rate;
                    buck_sum = buck_sum - rate;
                }
            }
            else
            {
                sent = 0;
            }

            if(user == -1)
            {
                System.out.println(i + "\t\t" + a[i] + "\t\tDropped\t"
                        + sent + "\t" + buck_sum);
            }
            else
            {
                System.out.println(i + "\t\t" + a[i] + "\t\t" + user
                        + "\t" + sent + "\t" + buck_sum);
            }
        }

        in.close();
    }
}
