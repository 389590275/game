package com.mygdx.game.state;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.player.Player;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class StandState implements IState {

    private Player player = CacheManager.INSTANCE.player;

    @Override
    public void keyDown(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
            case Input.Keys.DOWN:
            case Input.Keys.LEFT:
            case Input.Keys.RIGHT:
                player.updateDir(keycode);
                player.setState(new MoveState(player));
                break;
            case Input.Keys.A:
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
