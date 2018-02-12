package hammingDistance;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int dist = 0;
        while(temp != 0) {
            dist += (temp & 1);
            temp = temp >>> 1;
        }
        return dist;
    }
    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        System.out.println(obj.hammingDistance(0, 0));
        System.out.println(obj.hammingDistance(0, 1));
        System.out.println(obj.hammingDistance(23424, 789));
        System.out.println(obj.hammingDistance(345, 345));
    }
}
