package com.mygdx.game.state;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:43 下午
 */
public interface IState {

    /**
     * 键盘按下
     *
     * @param event
     * @param keycode
     */
    void keyDown(InputEvent event, int keycode);

    /**
     * 键盘松开
     *
     * @param event
     * @param keycode
     */
    void keyUp(InputEvent event, int keycode);

    void update();

}
