package com.mygdx.game.monster;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.monster.state.IMonsterState;
import lombok.Data;
import lombok.ToString;

/**
 * @author xiangchijie
 * @date 2021/4/4 11:33 下午
 */
@Data
@ToString
public class Monster {

    private int mid;

    private int pid;
    //点 格子坐标
    private int x;

    private int y;

    private float stateTime;

    private int direction = Input.Keys.LEFT;

    @ToString.Exclude
    private IMonsterState state;

    private Animation<TextureRegion> animation;

    public boolean isFlip(){
        return direction == Input.Keys.LEFT;
    }

}
