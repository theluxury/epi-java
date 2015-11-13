/**
 * Created by theluxury on 11/12/15.
 */
public class Problem_5_1 {

    public static void main(String[] args) {
        int[] parityArray = new int[(int) Math.pow(2, 16)];
        makeParityMap(parityArray);
        Long l1 = Long.parseUnsignedLong("3");
        int first16ones = (int) Math.pow(2, 16) - 1;

        int parity = 0;
        for (int i = 0; i < 64; i += 16) {
            parity ^= parityArray[(int) (l1 >>> i) & first16ones];
        }
        System.out.print(parity);

    }

    public static void makeParityMap(int[] parityArray) {
        for (int i = 0; i < Math.pow(2, 16); i++) {
            findParity(i, parityArray);
        }
    }

    public static void findParity(int number, int[] parityArray) {
        int count = 0;
        int temp = number;
        while (temp != 0) {
            if ((temp & 1) == 1) {
                count++;
            }
            temp >>>= 1;
        }
        parityArray[number] = count & 1;
    }
}
