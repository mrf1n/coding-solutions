package com.github.mrf1n;

public class T0278_FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(new T0278_FirstBadVersion().firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    public boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}
