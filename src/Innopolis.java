
import java.util.*;
import java.io.*;

public class Innopolis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] gendalf = new int[n];
        int[] saruman = new int[m];
        for (int i = 0; i < gendalf.length; i++) {
            gendalf[i] = sc.nextInt();
        }
        for (int i = 0; i < saruman.length; i++) {
            saruman[i] = sc.nextInt();
        }
        int i = 0;
        int hod = 0;
        while (!((contains(gendalf)) || (contains(saruman)))) {
            i = 0;
            if (hod % 2 == 0) {
                while (gendalf[i] == -1) {
                    i++;
                }
                int a = gendalf[i];
                gendalf[i] = -1;
                int j = 0;
                while ((j < a) && (i < saruman.length)) {
                    if (saruman[i] != 0) {
                        saruman[i] = -1;
                        j++;
                    }
                    i++;
                }
            } else {
                while (saruman[i] == -1) {
                    i++;
                }
                int a = saruman[i];
                saruman[i] = -1;
                int j = 0;
                i++;
                while ((j < a) && (i < gendalf.length)) {
                    if (gendalf[i] != 0) {
                        gendalf[i] = -1;
                        j++;
                    }
                    i++;
                }
            }

        hod++;
    }
        out.println(Arrays.toString(gendalf));
        out.println(Arrays.toString(saruman));
        out.close();

}
    public static boolean contains(int[] array) {
        int i = 0;
        while (i < array.length) {
            if (array[i] != -1) {
                return false;
            }
        }
        return true;
    }
}
