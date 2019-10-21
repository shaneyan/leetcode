import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem31 {
    private static List<Integer> NEXT_PERMUTATION = new ArrayList<>();
    private static List<Integer> LOWEST_PERMUTATION = new ArrayList<>();

    public static void main(String[] args) {
        //int[] a = {3,2,1};
        //int[] a = {1,2,3};
        int[] a = {1,1,5};
        List<Integer> selected = new ArrayList<>();
        for(int i = 0;i < a.length;i++) {
            selected.add(i);
            tryIt(a,selected);
            selected.remove(selected.size()-1);
        }
        System.out.println(Arrays.toString(a));
        if(NEXT_PERMUTATION.isEmpty()) {
            System.out.println(LOWEST_PERMUTATION);
        } else {
            System.out.println(NEXT_PERMUTATION);
        }
    }

    private static void tryIt(int[] a,List<Integer> selected) {
        if(a.length == selected.size()) {
            List<Integer> list = getList(a,selected);
            if(LOWEST_PERMUTATION.isEmpty()) {
                LOWEST_PERMUTATION.addAll(list);
            } else {
                if(compare(LOWEST_PERMUTATION,list) > 0) { // LOWEST_PERMUTATION > list
                    LOWEST_PERMUTATION.clear();
                    LOWEST_PERMUTATION.addAll(list);
                }
            }
            if(NEXT_PERMUTATION.isEmpty()) {
                if(compare(a,list) < 0) {
                    NEXT_PERMUTATION.addAll(list);
                }
            } else {
                if(compare(a,list) < 0 && compare(NEXT_PERMUTATION,list) > 0) {  // a < list && NEXT_PERMUTATION > list
                    NEXT_PERMUTATION.clear();
                    NEXT_PERMUTATION.addAll(list);
                }
            }
            return;
        }
        for(int i = 0;i < a.length;i++) {
            if(!selected.contains(i)) {
                selected.add(i);
                tryIt(a,selected);
                selected.remove(selected.size()-1);
            }
        }
    }

    private static List<Integer> getList(int[] a,List<Integer> selected) {
        List<Integer> list = new ArrayList<>();
        for(int i : selected) {
            list.add(a[i]);
        }
        return list;
    }

    private static int compare(int[] a,List<Integer> list) {
        for(int i = 0;i < a.length;i++) {
            if(a[i] > list.get(i)) {
                return 1;
            }
            if(a[i] < list.get(i)) {
                return -1;
            }
        }
        return 0;
    }

    private static int compare(List<Integer> list1,List<Integer> list2) {
        for(int i = 0;i < list1.size();i++) {
            if(list1.get(i) > list2.get(i)) {
                return 1;
            }
            if(list1.get(i) < list2.get(i)) {
                return -1;
            }
        }
        return 0;
    }
}
