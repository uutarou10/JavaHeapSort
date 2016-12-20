
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author uutarou
 */
public class Heap {

    private int size;
    private final ArrayList<Integer> tree;

    public Heap() {
        size = 0;
        tree = new ArrayList<>();
        tree.add(null);
    }

    private void swap(int i, int j) {
        if (i != j) {
            int tmp = tree.get(i);
            tree.set(i, tree.get(j));
            tree.set(j, tmp);
        }
    }

    public void pushHeap(int x) {
        size = size + 1;
        tree.add(size, x);
        int k = size;
        while ((k > 1) && (tree.get(k) > tree.get(k / 2))) {
            swap(k, k/2);
            k = k / 2;
        }
    }
    
    public int deleteMaximum() {
        int max = tree.get(1);
        tree.set(1, tree.get(size));
        tree.set(size, -1);
        size = size - 1;
        int k = 1;
        
        while (2*k <= size) {
                if (2*k == size) {
                    if(tree.get(k) < tree.get(2*k)) {
                        swap(k, 2*k);
                        k = 2*k;
                    } else {
                        break;
                    }
                } else {
                    int big = tree.get(2*k) > tree.get(2*k+1) ? 2*k : 2*k+1;
                    if (tree.get(k) < tree.get(big)) {
                        swap(k,big);
                        k = big;
                    } else {
                        break;
                    }
                }
        }       
        return max;
    }
    
    @Override
    public String toString() {
        Integer[] a = (Integer[])tree.toArray(new Integer[0]);
        String str = "{ ";
        for (int i = 1; i < a.length; i++) {
            if (i > 1) {
                str += ", ";
            }
            str += a[i];
        }
        str += " }";
        return str;
    }
    
}
