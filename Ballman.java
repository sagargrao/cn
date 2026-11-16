import java.util.Scanner;

public class Ballman
{
    private int D[];
    private int num_ver;
    public static final int MAX_VALUE = 999;

    public Ballman(int num_ver)
    {
        this.num_ver = num_ver;
        D = new int[num_ver + 1];
    }

    public void BellmanFordEvaluation(int source, int A[][])
    {
        for(int node = 1; node <= num_ver; node++)
        {
            D[node] = MAX_VALUE;
        }

        D[source] = 0;

        for(int node = 1; node <= num_ver - 1; node++)
        {
            for(int sm = 1; sm <= num_ver; sm++)
            {
                for(int dm = 1; dm <= num_ver; dm++)
                {
                    if(A[sm][dm] != MAX_VALUE && D[sm] != MAX_VALUE)
                    {
                        if(D[dm] > D[sm] + A[sm][dm])
                        {
                            D[dm] = D[sm] + A[sm][dm];
                        }
                    }
                }
            }
        }

        for(int sm = 1; sm <= num_ver; sm++)
        {
            for(int dm = 1; dm <= num_ver; dm++)
            {
                if(A[sm][dm] != MAX_VALUE && D[sm] != MAX_VALUE)
                {
                    if(D[dm] > D[sm] + A[sm][dm])
                    {
                        System.out.println("The graph contains negative edge cycle");
                        return;
                    }
                }
            }
        }

        for(int vertex = 1; vertex <= num_ver; vertex++)
        {
            System.out.println("Distance of source " + source + " to "
                    + vertex + " is " + D[vertex]);
        }
    }

    public static void main(String[] args)
    {
        int num_ver = 0;
        int source;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        num_ver = scanner.nextInt();

        int A[][] = new int[num_ver + 1][num_ver + 1];

        System.out.println("Enter the adjacency matrix");

        for(int sm = 1; sm <= num_ver; sm++)
        {
            for(int dm = 1; dm <= num_ver; dm++)
            {
                A[sm][dm] = scanner.nextInt();

                if(sm == dm)
                {
                    A[sm][dm] = 0;
                    continue;
                }

                if(A[sm][dm] == 0)
                {
                    A[sm][dm] = MAX_VALUE;
                }
            }
        }

        System.out.println("Enter the source vertex");
        source = scanner.nextInt();

        Ballman b = new Ballman(num_ver);

        b.BellmanFordEvaluation(source, A);

        scanner.close();
    }
}
