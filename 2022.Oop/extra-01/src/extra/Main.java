package extra;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int BinarySearch2(int array[], int l, int r, int number)
    {
        if (r >= l) {
            if (array[l + (r - l) / 2] == number)
                return l + (r - l) / 2;
            if (array[l + (r - l) / 2] > number)
                return BinarySearch2(array, l, l + (r - l) / 2 - 1, number);
            return BinarySearch2(array, l + (r - l) / 2 + 1, r, number);
        }
        return -1;
    }


    public static int BinarySearch(int array[],int r,int number)
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



        public static int Random () {
            Random rand = new Random();
            int counter = 0;
            int[] x = new int[1000000];
            for (int i = 0; i < 1000000; i++) {
                x[i] = rand.nextInt();
            }
            Arrays.sort(x);
            for (int i = 0; i < 1000000 - 1; i++) {
                if (x[i] == x[i + 1]) {
                    counter++;
                }
            }
            return counter;
        }

    public static void main(String[] args) {
        System.out.println(Random());
        Random rand = new Random();
        int[] a = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            a[i] = rand.nextInt(0, 1000000);
        }
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, 88));
        System.out.println(BinarySearch(a, 1000000 - 1, 88));
        System.out.println(BinarySearch2(a, 0, 1000000 - 1, 88));
    }
}
