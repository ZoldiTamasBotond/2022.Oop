package extra01;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int binarySearch2(int array[], int l, int r, int number)
    {
        if (r >= l) {
            if (array[l + (r - l) / 2] == number)
                return l + (r - l) / 2;
            if (array[l + (r - l) / 2] > number)
                return binarySearch2(array, l, l + (r - l) / 2 - 1, number);
            return binarySearch2(array, l + (r - l) / 2 + 1, r, number);
        }
        return -1;
    }


    public static int binarySearch(int array[],int r,int number)
    {
        int l=0;
        while(r>=l)
        {
            if (number==array[l + (r - l) / 2])
            {
                return l + (r - l) / 2;
            }
            else if(number<array[l + (r - l) / 2])
            {
                r=l + (r - l) / 2 - 1;
            }
            else {
                l=l + (r - l) / 2 + 1;
            }
        }
        return -1;
    }



        public static int Random (int n) {
            Random rand = new Random();
            int counter = 0;
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = rand.nextInt();
            }
            Arrays.sort(x);
            for (int i = 0; i < n - 1; i++) {
                if (x[i] == x[i + 1]) {
                    counter++;
                }
            }
            return counter;
        }

    public static void main(String[] args) {

        Random rand = new Random();
        int n=1000000;
        int num=88;
        System.out.println(Random(n));
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(0, n);
        }
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, num));
        System.out.println(binarySearch(a, n - 1, num));
        System.out.println(binarySearch2(a, 0, n - 1, num));
    }
}
