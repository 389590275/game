package com.mygdx.game.player.state;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.constants.ResPlayer;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.player.Player;
import com.mygdx.game.player.PlayerActor;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class MovePlayerState implements IPlayerState {

    private Player player = CacheManager.INSTANCE.player;

    public MovePlayerState() {
        TextureRegion[] frames = ResPlayer.getRunTextureRegion(PlayerActor.PID, player.isFlip());

        // 使用关键帧（纹理区域）数组 walkFrames 创建一个动画实例, 每一帧（一个小人单元格/纹理区域）播放 0.05 秒
        Animation<TextureRegion> playerAnimation = new Animation<TextureRegion>(0.2F, frames);
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP);
        player.setPlayerAnimation(playerAnimation);
        player.setStateTime(0);
    }

    @Override
    public void keyDown(InputEvent event, int keycode) {

    }

    @Override
    public void keyUp(InputEvent event, int keycode) {
        if (player.getDirection() != keycode) {
            return;
        }
        //待机模式
        player.setState(new StandPlayerState());
    }

    @Override
    public void update() {
        Player player = CacheManager.INSTANCE.player;
        int targetX = player.getX();
        switch (player.getDirection()) {
            case Input.Keys.LEFT:
                targetX -= player.getV();
                break;
            case Input.Keys.RIGHT:
                targetX += player.getV();
                break;
        }
        if (CacheManager.INSTANCE.isAccept(targetX)) {
            player.setX(targetX);
        }
    }

}
