package com.mygdx.game.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.constants.Constants;
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

    //状态刷新时间 s
    private float stateTime;

    private IPlayerState state;

    // 1上 2左 3下 4右
    private int direction = Input.Keys.RIGHT;

    private Animation<TextureRegion> playerAnimation;

    //速度
    private int v;

    public boolean isFlip() {
        return direction == Input.Keys.LEFT;
    }

    /**
     * 获取攻击范围
     *
     * @return
     */
    public int[] getAtkXRange() {
        if (direction == Input.Keys.RIGHT) {
            return new int[]{x + Constants.ROLE_WIDTH, +x + Constants.ROLE_WIDTH + Constants.ATK_RANGE};
        } else {
            return new int[]{x, +x - Constants.ATK_RANGE};
        }
    }

}
