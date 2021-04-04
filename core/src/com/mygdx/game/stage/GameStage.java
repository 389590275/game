package com.mygdx.game.stage;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MainGame;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.constants.Res;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.manager.ResManager;
import com.mygdx.game.player.PlayerActor;

/**
 * 游戏场景
 *
 * @author xiangchijie
 * @date 2021/4/4 1:00 下午
 */
public class GameStage extends BaseStage {

    int[][] gameMap = CacheManager.INSTANCE.gameMaps;
    private SpriteBatch batch;

    public GameStage(MainGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
    }

    @Override
    public void init() {
        // 创建 Batch
        batch = new SpriteBatch();
        initBlock();
        intPlayer();
    }

    //初始化角色
    private void intPlayer() {
        PlayerActor playerActor = new PlayerActor(this);
        addActor(playerActor);
    }

    // 初始化地图
    private void initBlock() {
        for (int y = 0; y < gameMap.length; y++) {
            int[] arr = gameMap[y];
            for (int x = 0; x < arr.length; x++) {
                int blockIndex = arr[x];
                String name = Res.Block.blockNames[blockIndex];
                Image blockImage = new Image(ResManager.findBlockTexture(name));
                blockImage.setX(x * Constants.UNIT);
                blockImage.setY((9 - y) * Constants.UNIT);
                addActor(blockImage);
            }
        }
    }

}
