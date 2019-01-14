package by.kolbun.pokercards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Assets {

    private static final String png = ".png";
    private static final String PNG = ".PNG";

    private static final String logicPath = "logic/";
    private static final String imgPath = "img/";

    public static Texture bg;
    public static Texture btnUp;
    public static Texture btnDown;
    public static Map<Integer, ArrayList<ArrayList<Texture>>> logicImgs = new HashMap<Integer, ArrayList<ArrayList<Texture>>>();
    public static Texture helloImg;


    public static void load(String assetsPath) {

//        imgPath = "android/" + imgPath;
        bg = new Texture(Gdx.files.internal(assetsPath + imgPath + "bg" + png));
        btnUp = new Texture(Gdx.files.internal(assetsPath + imgPath + "btn_up" + png));
        btnDown = new Texture(Gdx.files.internal(assetsPath + imgPath + "btn_down" + png));

        fillLogicImagesMap(assetsPath);

        helloImg = new Texture(Gdx.files.internal(assetsPath + imgPath + "hello" + png));

        System.out.println("assets loading complete");
    }

    private static void fillLogicImagesMap(String assetsPath) {
        ArrayList<ArrayList<Texture>> group1 = new ArrayList<ArrayList<Texture>>();
        ArrayList<ArrayList<Texture>> group2 = new ArrayList<ArrayList<Texture>>();
        ArrayList<ArrayList<Texture>> group3 = new ArrayList<ArrayList<Texture>>();
        ArrayList<ArrayList<Texture>> group4 = new ArrayList<ArrayList<Texture>>();
        ArrayList<ArrayList<Texture>> group5 = new ArrayList<ArrayList<Texture>>();

        group1.add(new ArrayList<Texture>());

        for (int i = 0; i < 4; i++)
            group2.add(new ArrayList<Texture>());

        group3.add(new ArrayList<Texture>());

        for (int i = 0; i < 5; i++)
            group4.add(new ArrayList<Texture>());

        for (int i = 0; i < 13; i++)
            group5.add(new ArrayList<Texture>());

        for (int i = 1; i <= 6; i++)
            group1.get(0).add(new Texture(Gdx.files.internal(assetsPath + logicPath + "1/1/" + i + PNG)));
        for (int j = 1; j <= 4; j++)
            for (int i = 1; i <= 6; i++)
                group2.get(j - 1).add(new Texture(Gdx.files.internal(assetsPath + logicPath + "2/" + j + "/" + i + PNG)));
        for (int i = 1; i <= 6; i++)
            group3.get(0).add(new Texture(Gdx.files.internal(assetsPath + logicPath + "3/1/" + i + PNG)));
        for (int j = 1; j <= 5; j++)
            for (int i = 1; i <= 6; i++)
                group4.get(j - 1).add(new Texture(Gdx.files.internal(assetsPath + logicPath + "4/" + j + "/" + i + PNG)));
        for (int j = 1; j <= 13; j++)
            for (int i = 1; i <= 6; i++)
                group5.get(j - 1).add(new Texture(Gdx.files.internal(assetsPath + logicPath + "5/" + j + "/" + i + PNG)));

        logicImgs.put(1, group1);
        logicImgs.put(2, group2);
        logicImgs.put(3, group3);
        logicImgs.put(4, group4);
        logicImgs.put(5, group5);
    }


    public static void dispose() {
        bg.dispose();
        btnUp.dispose();
        btnDown.dispose();

        for (ArrayList<ArrayList<Texture>> listsOfLists : logicImgs.values()) {
            for (ArrayList<Texture> lists : listsOfLists)
                for (Texture t : lists) {
                    t.dispose();
                }
        }

        helloImg.dispose();

        System.out.println("assets disposing complete");
    }


}
