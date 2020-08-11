package _1010_Rank_From_Stream;

public class TesterClass {

    public static void main(String[] args) {
        int[] array = {3, 7, 1, 1, 8, 9, 6, 12, 13, 10, 0};
        RankFromStream.trackNodes(array);
        System.out.println(RankFromStream.getRankOfNumber(1));
        System.out.println(RankFromStream.getRankOfNumber(3));
        System.out.println(RankFromStream.getRankOfNumber(13));
        System.out.println(RankFromStream.getRankOfNumber(0));
    }
}
