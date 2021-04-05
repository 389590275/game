package com.mygdx.game.monster.state;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.constants.ResPlayer;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.monster.Monster;
import com.mygdx.game.player.Player;
import com.mygdx.game.player.PlayerActor;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class AtkMonsterState implements IMonsterState {

    private Monster monster;
    private int frameNum;

    public AtkMonsterState(Monster monster) {
        this.monster = monster;
        TextureRegion[] frames = ResPlayer.getAtkTextureRegion(monster.getPid(),monster.isFlip());
        frameNum = frames.length;
        // 使用关键帧（纹理区域）数组 walkFrames 创建一个动画实例, 每一帧（一个小人单元格/纹理区域）播放 0.05 秒
        Animation<TextureRegion> animation = new Animation<TextureRegion>(0.1F, frames);
        animation.setPlayMode(Animation.PlayMode.NORMAL);
        monster.setAnimation(animation);
        monster.setStateTime(0);
    }

    @Override
    public void update() {
        if (monster.getStateTime() > frameNum * 0.1f) {
            monster.setState(new StandMonsterState(monster));
        }
    }

}
