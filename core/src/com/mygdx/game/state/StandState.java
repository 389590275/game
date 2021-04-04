package com.mygdx.game.state;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.constants.Res;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.player.Player;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class StandState implements IState {

    private Player player = CacheManager.INSTANCE.player;

    public StandState() {
        TextureRegion[] frames = Res.Player.getStandTextureRegion(1);
        // 使用关键帧（纹理区域）数组 walkFrames 创建一个动画实例, 每一帧（一个小人单元格/纹理区域）播放 0.05 秒
        Animation<TextureRegion> playerAnimation = new Animation<TextureRegion>(0.2F, frames);
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP);
        player.setPlayerAnimation(playerAnimation);
        player.setStateTime(0);
    }

    @Override
    public void keyDown(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
            case Input.Keys.DOWN:
            case Input.Keys.LEFT:
            case Input.Keys.RIGHT:
                if (player.updateDir(keycode)) {
                    player.setState(new MoveState());
                }
                break;
            case Input.Keys.A:
                player.setState(new AtkState());
                break;
        }
    }

    @Override
    public void keyUp(InputEvent event, int keycode) {

    }

    @Override
    public void update() {

    }

}
