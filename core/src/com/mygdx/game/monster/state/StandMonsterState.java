package com.mygdx.game.monster.state;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.constants.ResPlayer;
import com.mygdx.game.monster.Monster;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class StandMonsterState implements IMonsterState {

    private Monster monster;

    public StandMonsterState(Monster monster) {
        TextureRegion[] frames = ResPlayer.getStandTextureRegion(monster.getPid());
        // 使用关键帧（纹理区域）数组 walkFrames 创建一个动画实例, 每一帧（一个小人单元格/纹理区域）播放 0.05 秒
        Animation<TextureRegion> animation = new Animation<TextureRegion>(0.2F, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        monster.setAnimation(animation);
        monster.setStateTime(0);
    }

    @Override
    public void update() {

    }

}
