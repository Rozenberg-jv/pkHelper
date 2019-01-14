package by.kolbun.pokercards;

import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class KeyUtils {

    private static final Map<Integer, Array<Integer>> graph = new HashMap<Integer, Array<Integer>>();

    static {
        for (int i = 0; i <= 23; i++)
            graph.put(i, new Array<Integer>());

        graph.get(0).add(0, 2, 0, 1);
        graph.get(1).add(0, 4, 3, 2);
        graph.get(2).add(0, 4, 1, 3);
        graph.get(3).add(0, 4, 2, 4);
        graph.get(4).add(1, 5, 3, 5);
        graph.get(5).add(4, 7, 4, 6);
        graph.get(6).add(5, 9, 5, 7);
        graph.get(7).add(5, 9, 6, 8);
        graph.get(8).add(5, 10, 7, 9);
        graph.get(9).add(6, 11, 8, 10);
        graph.get(10).add(8, 13, 9, 11);
        graph.get(11).add(9, 14, 10, 12);
        graph.get(12).add(9, 15, 11, 13);
        graph.get(13).add(10, 16, 12, 14);
        graph.get(14).add(11, 17, 13, 15);
        graph.get(15).add(12, 18, 14, 16);
        graph.get(16).add(13, 19, 15, 17);
        graph.get(17).add(14, 20, 16, 18);
        graph.get(18).add(15, 21, 17, 19);
        graph.get(19).add(16, 22, 18, 20);
        graph.get(20).add(17, 23, 19, 21);
        graph.get(21).add(18, 23, 20, 22);
        graph.get(22).add(19, 23, 21, 23);
        graph.get(23).add(20, 23, 22, 21);
    }

    public static int getTransferButtonIndex(int curBtnInd, int moveDirection) {
        if (curBtnInd < 0) return 0;
        return graph.get(curBtnInd).get(moveDirection);
    }

    public static String getString(int keyCode) {
        if (keyCode == 45) return "0-7";
        else if (keyCode == 51) return "7-10";
        else if (keyCode == 33) return "10-13";
        else if (keyCode == 29) return "13-17";
        else if (keyCode == 47) return "17-21";
        else if (keyCode == 32) return "21+";
        else if (keyCode == 54) return "push";
        else if (keyCode ==52) return "call";
        else if (keyCode ==31) return "agro";
        return "null";
    }


    public static boolean isInBotGroup(int code) {
        return code == 45 || code == 51 || code == 33 || code == 29 || code == 47 || code == 32;
    }

    public static boolean isInTopGroup(int code) {
        return (code >= 8 && code <= 13) || code == 61;
    }

    public static boolean isInNashGroup(int code) {
        return code == 54 || code == 52 || code == 31;
    }
}
