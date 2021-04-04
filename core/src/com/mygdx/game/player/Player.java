package com.mygdx.game.player;

import com.badlogic.gdx.Input;
import com.mygdx.game.stage.GameStage;
import com.mygdx.game.state.IState;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:46 下午
 */
public class Player {

    //绝对坐标
    private int x;

    private int y;

    private int[] p = new int[2];

    //状态刷新时间 s
    private float stateTime;

    private IState state;

    // 1上 2左 3下 4右
    private int direction;


    public boolean updateDir(int keycode) {
        int[] point = {p[0], p[1]};
        switch (keycode) {
            case Input.Keys.UP:
                point[1]++;
                break;
            case Input.Keys.DOWN:
                point[1]--;
                break;
            case Input.Keys.LEFT:
                point[0]--;
                break;
            case Input.Keys.RIGHT:
                point[0]++;
                break;
        }
        p = point;
        this.direction = keycode;
        return true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
        stateTime = 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
