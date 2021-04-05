package com.mygdx.game.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.constants.Constants;
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
        //随机一个怪物
        int monsterPid = RandomUtils.nextInt(2, ResPlayer.PLAYER_SIZE + 1);
        Monster monster = new Monster();
        monster.setMid(CacheManager.INSTANCE.getIncMonsterId());
        monster.setPid(monsterPid);
        monster.setX(500);
        monster.setState(new StandMonsterState(monster));
        CacheManager.INSTANCE.monsterMap.put(monster.getMid(), monster);
        Gdx.app.log("刷新怪物:{}", monster.toString());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Monster monster : CacheManager.INSTANCE.monsterMap.values()) {
            monster.getState().update();
            monster.setStateTime(monster.getStateTime() + Gdx.graphics.getDeltaTime());
            // 得到下一帧
            TextureRegion currentFrame = monster.getAnimation().getKeyFrame(monster.getStateTime(), true); // 循环
            // 以(0,0)绘制为起点（左下角为100，100）画出动画，大小128*128
            float h = (float) Constants.ROLE_WIDTH / currentFrame.getRegionWidth() * currentFrame.getRegionHeight();
            batch.draw(currentFrame, monster.getX(),  Constants.ROLE_Y,
                    Constants.ROLE_WIDTH, h );
        }
    }

    @Override
    public void dispose() {

    }

}
