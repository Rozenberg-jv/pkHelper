package by.kolbun.pokercards.ui;

import by.kolbun.pokercards.Assets;
import by.kolbun.pokercards.KeyUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.HashMap;
import java.util.Map;

public class Gui extends Table {

    private Image currentImage;
    private ButtonGroup<TextButton> topBGroup;
    private ButtonGroup<TextButton> botBGroup;
    private ButtonGroup<TextButton> nashBGroup;
    private int lastKeyCode = 8;
    private Map<Integer, Integer> keyCodeGroupTabCapacity = new HashMap<Integer, Integer>();
    private final BitmapFont FONT = new BitmapFont();
    private final Label.LabelStyle LABEL_STYLE = new Label.LabelStyle(FONT, Color.WHITE);

    public Gui() {
        this.setFillParent(true);
//        this.debugAll();

        keyCodeGroupTabCapacity.put(8, 1);
        keyCodeGroupTabCapacity.put(9, 4);
        keyCodeGroupTabCapacity.put(10, 1);
        keyCodeGroupTabCapacity.put(11, 5);
        keyCodeGroupTabCapacity.put(12, 9);
        keyCodeGroupTabCapacity.put(13, 4);

        currentImage = new Image(Assets.helloImg);

        TextButton.TextButtonStyle tbStyle = new TextButton.TextButtonStyle(
                new TextureRegionDrawable(new TextureRegion(Assets.btnUp)),
                new TextureRegionDrawable(new TextureRegion(Assets.btnDown)),
                new TextureRegionDrawable(new TextureRegion(Assets.btnDown)),
                FONT
        );

        Label labelNash = new Label("NASH", LABEL_STYLE);
        Label label1 = new Label("HU SB", LABEL_STYLE);
        Label label2 = new Label("HU BB", LABEL_STYLE);
        Label label3 = new Label("3MAX BU", LABEL_STYLE);
        Label label4 = new Label("3MAX SB", LABEL_STYLE);
        Label label5 = new Label("3MAX BB", LABEL_STYLE);
        Label label6 = new Label("EFFECTIVE STACK SIZE", LABEL_STYLE);

        // group 1
        TextButton tb1_1 = new TextButton("ACTION", tbStyle);

        TextButton tb2_1 = new TextButton("SB MINRAISE", tbStyle);
        TextButton tb2_2 = new TextButton("SB 3x RAISE", tbStyle);
        TextButton tb2_3 = new TextButton("SB PUSH", tbStyle);
        TextButton tb2_4 = new TextButton("SB COMPLETE", tbStyle);

        TextButton tb3_1 = new TextButton("ACTION", tbStyle);

        TextButton tb4_1 = new TextButton("BU MINRAISE", tbStyle);
        TextButton tb4_2 = new TextButton("BU 3x RAISE", tbStyle);
        TextButton tb4_3 = new TextButton("BU PUSH", tbStyle);
        TextButton tb4_4 = new TextButton("BU LIMP", tbStyle);
        TextButton tb4_5 = new TextButton("BU FOLD", tbStyle);

        TextButton tb5_01 = new TextButton("BU MINRAISE", tbStyle);
        TextButton tb5_02 = new TextButton("BU 3x RAISE", tbStyle);
        TextButton tb5_03 = new TextButton("BU PUSH", tbStyle);
        TextButton tb5_04 = new TextButton("BU MINRAISE/SB CALL", tbStyle);
        TextButton tb5_05 = new TextButton("BU MINRAISE/SB 3BET PUSH", tbStyle);
        TextButton tb5_06 = new TextButton("BU PUSH/SB CALL", tbStyle);
        TextButton tb5_07 = new TextButton("BU LIMP", tbStyle);
        TextButton tb5_08 = new TextButton("BU LIMP/SB COMPLETE", tbStyle);
        TextButton tb5_09 = new TextButton("BU LIMP/SB ISO RAISE 3BB", tbStyle);
        TextButton tb5_10 = new TextButton("SB MINRAISE", tbStyle);
        TextButton tb5_11 = new TextButton("SB 3x RAISE", tbStyle);
        TextButton tb5_12 = new TextButton("SB PUSH", tbStyle);
        TextButton tb5_13 = new TextButton("SB COMPLETE", tbStyle);

        // group 2
        TextButton tb6_1 = new TextButton("0-7", tbStyle);
        TextButton tb6_2 = new TextButton("7-10", tbStyle);
        TextButton tb6_3 = new TextButton("10-13", tbStyle);
        TextButton tb6_4 = new TextButton("13-17", tbStyle);
        TextButton tb6_5 = new TextButton("17-21", tbStyle);
        TextButton tb6_6 = new TextButton("21+", tbStyle);

        // nash group
        TextButton nashB_push = new TextButton("push", tbStyle);
        TextButton nashB_call = new TextButton("call", tbStyle);
        TextButton nashB_agro = new TextButton("agro", tbStyle);

        //
        Table btnTable = new Table();
        btnTable.defaults().space(3);

        btnTable.row();
        btnTable.add(labelNash);
        btnTable.row();
        btnTable.add(nashB_push);
        btnTable.add(nashB_call);
        btnTable.add(nashB_agro);

        btnTable.row().padTop(10);
        btnTable.add(label1);
        btnTable.add(tb1_1).colspan(2).fillX();

        btnTable.row().padTop(10);
        btnTable.add(label2);
        btnTable.row();
        btnTable.add(tb2_1);
        btnTable.add(tb2_2);
        btnTable.add(tb2_3);
        btnTable.row();
        btnTable.add(tb2_4);

        btnTable.row().padTop(10);
        btnTable.add(label3);
        btnTable.add(tb3_1).colspan(2).fillX();

        btnTable.row().padTop(10);
        btnTable.add(label4);
        btnTable.row();
        btnTable.add(tb4_1);
        btnTable.add(tb4_2);
        btnTable.add(tb4_3);
        btnTable.row();
        btnTable.add(tb4_4);
        btnTable.add();
        btnTable.add(tb4_5);

        btnTable.row().padTop(10);
        btnTable.add(label5);
        btnTable.row();
        btnTable.add(tb5_01);
        btnTable.add(tb5_02);
        btnTable.add(tb5_03);
        btnTable.row();
        btnTable.add(tb5_04);
        btnTable.add(tb5_05);
        btnTable.add(tb5_06);
        btnTable.row();
        btnTable.add(tb5_07);
        btnTable.add(tb5_08);
        btnTable.add(tb5_09);
        btnTable.row().padTop(5);
        btnTable.add(tb5_10);
        btnTable.add(tb5_11);
        btnTable.add(tb5_12);
        btnTable.row();
        btnTable.add(tb5_13);

        btnTable.row().padTop(10);
        btnTable.add(label6);
        btnTable.row();
        btnTable.add(tb6_1);
        btnTable.add(tb6_2);
        btnTable.add(tb6_3);
        btnTable.row();
        btnTable.add(tb6_4);
        btnTable.add(tb6_5);
        btnTable.add(tb6_6);


        // grouping
        topBGroup = new ButtonGroup<TextButton>(
                tb1_1, tb2_1, tb2_2, tb2_3, tb2_4, tb3_1, tb4_1, tb4_2, tb4_3, tb4_4, tb4_5,
                tb5_01, tb5_02, tb5_03, tb5_04, tb5_05, tb5_06, tb5_07, tb5_08, tb5_09, tb5_10, tb5_11, tb5_12, tb5_13);
        botBGroup = new ButtonGroup<TextButton>(tb6_1, tb6_2, tb6_3, tb6_4, tb6_5, tb6_6);
        nashBGroup = new ButtonGroup<TextButton>(nashB_push, nashB_call, nashB_agro);

        topBGroup.setMinCheckCount(1);
        topBGroup.setMaxCheckCount(1);
        botBGroup.setMinCheckCount(0);
        botBGroup.setMaxCheckCount(1);
        nashBGroup.setMinCheckCount(0);
        nashBGroup.setMaxCheckCount(1);

        Table outer = new Table();
        outer.defaults().space(7);
        outer.setBackground(new TextureRegionDrawable(
                new TextureRegion(Assets.bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight())));

        outer.row();
        outer.add(btnTable).width(640);
        outer.add(currentImage).width(640);

        this.row();
        this.add(outer);

        // listener
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int nashIndex = nashBGroup.getCheckedIndex();
                if (nashIndex != -1) {
                    currentImage.setDrawable(getImage(nashIndex));
                    return;
                }

                int topIndex = topBGroup.getCheckedIndex();
                int botIndex = botBGroup.getCheckedIndex();
                if (topIndex >= 0 && botIndex >= 0) {
                    currentImage.setDrawable(getImage(topIndex, botIndex));
                }
            }
        });
    }

    private Drawable getImage(int nashIndex) {
        return new TextureRegionDrawable(new TextureRegion(Assets.logicImgs.get(6).get(0).get(nashIndex)));
    }

    private Drawable getImage(int topIndex, int botIndex) {
        int group = 0;
        int btnInd = 0;

        if (topIndex == 0) {
            group = 1;
            btnInd = 1;
        } else if (topIndex > 0 && topIndex <= 4) {
            group = 2;
            btnInd = topIndex;
        } else if (topIndex == 5) {
            group = 3;
            btnInd = 1;
        } else if (topIndex > 5 && topIndex <= 10) {
            group = 4;
            btnInd = topIndex - 5;
        } else if (topIndex > 10 && topIndex <= 23) {
            group = 5;
            btnInd = topIndex - 10;
        }

        // botIndex = folder
        // 5 = 1, 4 = 2, 3 = 3, 2 = 4, 1 = 5, 0 = 6
        return new TextureRegionDrawable(
                new TextureRegion(Assets.logicImgs.get(group).get(btnInd - 1).get(5 - botIndex)));
    }


    public void keyPressed(int keyCode) {

        System.out.println("Pressed KeyCode: " + keyCode);

        if (KeyUtils.isInNashGroup(keyCode)) {
            botBGroup.uncheckAll();
            topBGroup.uncheckAll();
            nashBGroup.setChecked(KeyUtils.getString(keyCode));
            return;
        } else {
            nashBGroup.uncheckAll();
        }

        if (KeyUtils.isInBotGroup(keyCode)) {
            botBGroup.setChecked(KeyUtils.getString(keyCode));
            return;
        }

        if (KeyUtils.isInTopGroup(keyCode)) {
            if (keyCode == lastKeyCode || keyCode == 61) {
                topBGroup.getButtons().get(getLoopNextIndex()).setChecked(true);
            } else {
                topBGroup.getButtons().get(getFirstGroupIndex(keyCode)).setChecked(true);
                lastKeyCode = keyCode;
            }
        }

        if (keyCode >= 19 & keyCode <= 22) {
            int moveDir = keyCode - 19;
            int checkedIndex = topBGroup.getCheckedIndex();
            int transferButtonIndex = KeyUtils.getTransferButtonIndex(checkedIndex, moveDir);

            topBGroup.getButtons().get(transferButtonIndex).setChecked(true);
        }
    }

    private int getLoopNextIndex() {

        System.out.println("LastKeyCode: " + lastKeyCode);
        int firstGroupIndex = getFirstGroupIndex(lastKeyCode);

        int delta = topBGroup.getCheckedIndex() - firstGroupIndex + 1;

        if (delta >= keyCodeGroupTabCapacity.get(lastKeyCode)) {
            delta = 0;
        }

        return delta + firstGroupIndex;
    }

    private int getFirstGroupIndex(int keyCode) {

        int result;

        switch (keyCode) {
            case 8:
                result = 0;
                break;
            case 9:
                result = 1;
                break;
            case 10:
                result = 5;
                break;
            case 11:
                result = 6;
                break;
            case 12:
                result = 11;
                break;
            case 13:
                result = 20;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }

}