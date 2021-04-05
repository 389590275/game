package com.mygdx.game.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.constants.ResBlock;
import com.mygdx.game.constants.ResPlayer;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.monster.state.StandMonsterState;
import com.mygdx.game.stage.GameStage;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author xiangchijie
 * @date 2021/4/4 3:31 下午
 */
public class MonsterActor extends Actor implements Disposable {

    private GameStage gameStage;

    public MonsterActor(GameStage gameStage) {
        this.gameStage = gameStage;
        init();
    }

    private void init() {
        //初始化怪物
        int[][] mapArr = CacheManager.INSTANCE.gameMaps;
        for (int y = 1; y < mapArr.length; y++) {
            int[] xArr = mapArr[y];
            for (int x = 1; x < xArr.length; x++) {
                int blockIndex = xArr[x];
                String blockName = ResBlock.blockNames[blockIndex];
                if (!ResBlock.ROAD_BLOCK.contains(blockName)) {
                    continue;
                }
                //四分之一
                if (RandomUtils.nextInt(1, 5) < 4) {
                    continue;
                }
                //随机一个怪物
                int monsterPid = RandomUtils.nextInt(1, ResPlayer.PLAYER_SIZE + 1);
                Monster monster = new Monster();
                monster.setMid(x * 100 + y);
                monster.setPid(monsterPid);
                monster.setPx(x);
                monster.setPy(y);
                monster.setState(new StandMonsterState(monster));
                CacheManager.INSTANCE.monsterMap.put(monster.getMid(), monster);
                Gdx.app.log("刷新怪物:{}", monster.toString());
            }

        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Monster monster : CacheManager.INSTANCE.monsterMap.values()) {
            monster.getState().update();
            monster.setStateTime(monster.getStateTime() + Gdx.graphics.getDeltaTime());
            // 得到下一帧
            TextureRegion currentFrame = monster.getAnimation().getKeyFrame(monster.getStateTime(), true); // 循环
            // 以(0,0)绘制为起点（左下角为100，100）画出动画，大小128*128
            float h = (float) Constants.UNIT / currentFrame.getRegionWidth() * currentFrame.getRegionHeight();
            batch.draw(currentFrame, monster.getPx() * Constants.UNIT - 16, monster.getPy() * Constants.UNIT,
                    Constants.UNIT * 1.5f, h * 1.5f);
        }
    }

    @Override
    public void dispose() {

    }

}
