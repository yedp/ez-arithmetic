package com.ez.arithmetic.array;

public class ArrayBase implements IArrayBase {
    @Override
    public int[] mergeArray(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0) {
            return a2;
        } else if (a2 == null || a2.length == 0) {
            return a1;
        }
        int[] numsAll = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                numsAll[k++] = a1[i++];
            } else {
                numsAll[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            numsAll[k++] = a1[i++];
        }
        while (j < a2.length) {
            numsAll[k++] = a2[j++];
        }
        return numsAll;
    }
}
