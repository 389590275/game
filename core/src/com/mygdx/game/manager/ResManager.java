package com.mygdx.game.manager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.constants.ResPlayer;
import com.mygdx.game.constants.Res;

/**
 * @author xiangchijie
 * @date 2021/4/4 12:32 上午
 */
public class ResManager {

    public static final AssetManager ASSET_MANAGER = new AssetManager();

    public static void load() {
        ASSET_MANAGER.load(Res.START_BJ, Texture.class);
        ASSET_MANAGER.load(Res.START_BTN, Texture.class);
        ASSET_MANAGER.load(Res.BLOCKS, TextureAtlas.class);
        ASSET_MANAGER.load(Res.BATTLE_BJ1, Texture.class);
        for (int i = 1; i <= ResPlayer.PLAYER_SIZE; i++) {
            ASSET_MANAGER.load(ResPlayer.getPlayerPath(i), TextureAtlas.class);
        }
        // 等待资源加载完毕
        ASSET_MANAGER.finishLoading();
    }

    public static void dispose() {
        ASSET_MANAGER.dispose();
    }

    public static TextureAtlas.AtlasRegion findBlockTexture(int i, int j) {
        String name = Res.BLOCK_PRE + i + "-" + j;
        TextureAtlas textureAtlas = ASSET_MANAGER.get(Res.BLOCKS, TextureAtlas.class);
        return textureAtlas.findRegion(name);
    }

    public static TextureAtlas.AtlasRegion findBlockTexture(String name) {
        TextureAtlas textureAtlas = ASSET_MANAGER.get(Res.BLOCKS, TextureAtlas.class);
        return textureAtlas.findRegion(name);
    }

    /**
     * @param pid
     * @param index
     * @return
     */
    public static TextureAtlas.AtlasRegion findPlayerTexture(int pid, int index) {
        String indexName = index < 10 ? "0" + index : "" + index;
        TextureAtlas textureAtlas = ASSET_MANAGER.get(ResPlayer.getPlayerPath(pid), TextureAtlas.class);
        return textureAtlas.findRegion(indexName);
    }

}
