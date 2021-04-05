package com.mygdx.game.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.player.state.IPlayerState;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiangchijie
 * @date 2021/4/4 5:46 下午
 */
@Getter
@Setter
public class Player {

    //绝对坐标
    private int x;

    private int y;

    //点 格子坐标
    private int[] p = new int[2];

    //状态刷新时间 s
    private float stateTime;

    private IPlayerState state;

    // 1上 2左 3下 4右
    private int direction;

    private Animation<TextureRegion> playerAnimation;


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
        if (!CacheManager.INSTANCE.isAccept(point[0], point[1])) {
            return false;
        }
        p = point;
        this.direction = keycode;
        return true;
    }

}
