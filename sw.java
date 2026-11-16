import java.util.Scanner;

class sw
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int w, n;
        int[] frame = new int[50];

        System.out.print("Enter window size: ");
        w = sc.nextInt();

        System.out.print("Enter number of frames: ");
        n = sc.nextInt();

        System.out.println("Enter frame numbers:");

        for(int i = 0; i < n; i++)
        {
            frame[i] = sc.nextInt();
        }

        System.out.println("\nSending frames...");

        for(int p = 0; p < n; p += w)
        {
            System.out.println("Frames sent:");

            for(int j = p; j < p + w && j < n; j++)
            {
                System.out.print(frame[j] + " ");
            }

            System.out.println();
            System.out.println("ACK received.");
        }

        System.out.println("All frames sent.");

        sc.close();
    }
}
