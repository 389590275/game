package com.mygdx.game.state;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.player.Player;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:32 下午
 */
public class MoveState implements IState {

    Player player;

    public MoveState(Player player) {
        this.player = player;
    }

    @Override
    public void keyDown(InputEvent event, int keycode) {

    }

    @Override
    public void keyUp(InputEvent event, int keycode) {

    }

    @Override
    public void update() {
        switch (player.getDirection()) {
            case Input.Keys.UP:
                player.setY(player.getY() + 1);
                break;
            case Input.Keys.DOWN:
                player.setY(player.getY() - 1);
                break;
            case Input.Keys.LEFT:
                player.setX(player.getX() - 1);
                break;
            case Input.Keys.RIGHT:
                player.setX(player.getX() + 1);
                break;
        }
        if (player.getX() == Constants.UNIT * player.getP()[0] && player.getY() == Constants.UNIT * player.getP()[1]) {
            player.setState(new StandState(player));
        }
    }

}
