package ArrayListNStringBuilder;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Solutions {
    static void sum(int[] a, int[] b) {
        ArrayList<Integer> finalsum = new ArrayList<>();
        int carry = 0;
        for (int i = a.length - 1, j = b.length - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = 0;
            sum += carry;
            if (i >= 0) {
                sum += a[i];
            }
            if (j >= 0) {
                sum += b[j];
            }
            int rem = sum % 10;
            carry = sum / 10;
            finalsum.add(0, rem);
        }
        if (carry != 0)
            finalsum.add(0, carry);
        System.out.println(finalsum);
    }

    static void intersection(int[] a, int[] b) {
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                intersection.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(intersection);
    }

    static void toggle(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            char ans=' ';
            if(ch>='a'&&ch<='z'){
                ans = (char)(ch-'a'+'A');
            } else if(ch>='A'&&ch<='Z'){
                ans=(char)(ch-'A'+'a');
            }
            sb.append(ans);

        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        //intersection(new int[]{1,1,2,3,4,7,8},new int[]{0,1,3,3,4,5});
        //sum(new int[]{9,9,9},new int[]{9,9,9,9});
        toggle("A");
    }
}
