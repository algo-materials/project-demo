import java.util.List;

public class SortedSearches {
    // why not
    // https://en.wikipedia.org/wiki/Jump_search
    public static boolean jumpSearch(List<Integer> sorted, Integer tofind)
    {
        int n = sorted.size();
        int a = 0;
        int b = (int)Math.floor(Math.sqrt(n));
        while (sorted.get(Math.min(b, n)-1) < tofind)
        {
            a = b;
            b += (int)Math.floor(Math.sqrt(n));
            if (a >= n)
                return false;
        }
        while (sorted.get(a) < tofind)
        {
            a++;
            if (a == Math.min(b,n)) return false;
        }
        if (sorted.get(a).equals(tofind)) return true;
        return false;
    }

    // and the classic
    public static boolean binarySearch(List<Integer> sorted, Integer tofind)
    {
        int start = 0, end = sorted.size();
        int mid;
        do {
            mid = (end-start) / 2 + start;
            if (sorted.get(mid) < tofind) start = mid+1;
            else if (sorted.get(mid) > tofind) end = mid;
        } while (start < end && !sorted.get(mid).equals(tofind));
        // gotta love getting stuck at the top and bottom SUCKS
        return sorted.get(mid).equals(tofind);
    }
}
