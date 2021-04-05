package com.mygdx.game.player.state;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.constants.ResPlayer;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.monster.Monster;
import com.mygdx.game.player.Player;
import com.mygdx.game.player.PlayerActor;

import java.util.List;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class AtkPlayerState implements IPlayerState {

    private Player player = CacheManager.INSTANCE.player;
    int frameNum;

    public AtkPlayerState() {
        TextureRegion[] frames = ResPlayer.getAtkTextureRegion(PlayerActor.PID, player.isFlip());
        frameNum = frames.length;
        // 使用关键帧（纹理区域）数组 walkFrames 创建一个动画实例, 每一帧（一个小人单元格/纹理区域）播放 0.05 秒
        Animation<TextureRegion> playerAnimation = new Animation<TextureRegion>(0.1F, frames);
        playerAnimation.setPlayMode(Animation.PlayMode.NORMAL);
        player.setPlayerAnimation(playerAnimation);
        player.setStateTime(0);
    }

    @Override
    public void keyDown(InputEvent event, int keycode) {

    }

    @Override
    public void keyUp(InputEvent event, int keycode) {

    }

    @Override
    public void update() {
        if (player.getStateTime() > frameNum * 0.1f) {
            int[] xRange = player.getAtkXRange();
            List<Monster> monsters = CacheManager.INSTANCE.getMonsterByXRange(xRange[0], xRange[1]);
            for(Monster monster: monsters){
                CacheManager.INSTANCE.monsterMap.remove(monster.getMid());
            }
            //击杀怪物
            player.setState(new StandPlayerState());
        }
    }

}
