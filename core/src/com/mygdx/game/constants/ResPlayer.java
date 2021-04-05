package com.mygdx.game.constants;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.manager.ResManager;

/**
 * @author xiangchijie
 * @date 2021/4/4 11:28 下午
 */
public class ResPlayer {

    public static final String frameNames[] = {
            "01.png", "02.png", "03.png", "04.png", "05.png", "06.png", "07.png", "08.png", "09.png",
            "10.png", "11.png", "12.png", "13.png", "14.png"
    };
    public static final int playerFrameSize = frameNames.length;
    public static final int PLAYER_SIZE = 2;

    private static final String PLAYER_PATH = "atlas/player%s.atlas";

    public static String getPlayerPath(int pid) {
        String id = String.valueOf(pid);
        for (int i = id.length(); i < 4; i++) {
            id = "0" + id;
        }
        return String.format(PLAYER_PATH, id);
    }

    public static TextureRegion[] getStandTextureRegion(int pid) {
        return getTextureRegionArr(pid, 1, 4);
    }

    public static TextureRegion[] getRunTextureRegion(int pid) {
        return getTextureRegionArr(pid, 6, 9);
    }

    public static TextureRegion[] getAtkTextureRegion(int pid) {
        return getTextureRegionArr(pid, 10, 14);
    }

    private static TextureRegion[] getTextureRegionArr(int pid, int start, int end) {
        TextureRegion[] frames = new TextureRegion[end - start + 1];
        for (int i = start; i <= end; i++) {
            frames[i - start] = ResManager.findPlayerTexture(pid, i);
        }
        return frames;
    }

}
