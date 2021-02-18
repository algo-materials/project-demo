import java.util.ArrayList;
import java.util.Random;

public class Timer {
    static Random rando = new Random();
    public static int ITERS = 100;
    public static double AVG = 1.0/ITERS;
    public static int [] SIZES = {5, 10, 50, 100, 1000, 10000, 100000};

    public static double  timeJumpSearch(ArrayList<Integer> list, Integer tofind)
    {
        // this is easy; the operation doesn't change the size of the list, so it's nice and easy
        // just ensure it's sorted, but don't time it since it's not interesting to us for this algorithm
        list.sort(Integer::compareTo);
        long end, start = System.nanoTime();
        for (int i=0; i<ITERS; i++)
            SortedSearches.jumpSearch(list, tofind);
        end = System.nanoTime();
        return (end-start)*AVG;
    }

    public static double timeBinarySearch(ArrayList<Integer> list, Integer tofind)
    {
        // this is easy; the operation doesn't change the size of the list, so it's nice and easy
        // just ensure it's sorted, but don't time it since it's not interesting to us for this algorithm
        list.sort(Integer::compareTo);
        long end, start = System.nanoTime();
        for (int i=0; i<ITERS; i++)
            SortedSearches.binarySearch(list, tofind);
        end = System.nanoTime();
        return (end-start)*AVG;
    }

    public static ArrayList<Integer> randomList(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++)
            list.add(rando.nextInt());
        return list;
    }
    public static void main(String [] args)
    {
        ArrayList<Double> binaryTimes = new ArrayList<>();
        ArrayList<Double> jumpTimes = new ArrayList<>();


        for (int size: SIZES)
        {
            System.out.print("\t" + size);
            ArrayList<Integer> searchlist = randomList(size);
            int tofind = rando.nextInt(); // notice, I'm using the SAME list and search key for all timing
            // this keeps things consistent
            binaryTimes.add(timeBinarySearch(searchlist, tofind));
            jumpTimes.add(timeJumpSearch(searchlist, tofind));
        }
        System.out.println("");
        System.out.print("Binary");
        for(Double time: binaryTimes)
            System.out.print("\t"+time);
        System.out.println("");
        System.out.print("Jump");
        for(Double time: jumpTimes)
            System.out.print("\t"+time);
        System.out.println("");
    }
}
