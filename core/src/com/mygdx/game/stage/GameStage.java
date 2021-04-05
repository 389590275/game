package com.mygdx.game.stage;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MainGame;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.constants.ResBlock;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.manager.ResManager;
import com.mygdx.game.monster.MonsterActor;
import com.mygdx.game.player.PlayerActor;

/**
 * 游戏场景
 *
 * @author xiangchijie
 * @date 2021/4/4 1:00 下午
 */
public class GameStage extends BaseStage {

    int[][] gameMap = CacheManager.INSTANCE.gameMaps;

    public GameStage(MainGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
        init();
    }

    @Override
    public void init() {
        initBlock();
        intPlayer();
        initMonster();
    }

    //初始化角色
    private void intPlayer() {
        PlayerActor playerActor = new PlayerActor(this);
        addActor(playerActor);
    }

    //初始化怪物
    private void initMonster() {
        MonsterActor monsterActor = new MonsterActor(this);
        addActor(monsterActor);
    }

    // 初始化地图
    private void initBlock() {
        for (int y = 0; y < gameMap.length; y++) {
            int[] arr = gameMap[y];
            for (int x = 0; x < arr.length; x++) {
                int blockIndex = arr[x];
                String name = ResBlock.blockNames[blockIndex];
                Image blockImage = new Image(ResManager.findBlockTexture(name));
                blockImage.setX(x * Constants.UNIT);
                blockImage.setY(y * Constants.UNIT);
                addActor(blockImage);
            }
        }
    }

}
