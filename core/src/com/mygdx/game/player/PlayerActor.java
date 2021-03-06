package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.player.state.StandPlayerState;
import com.mygdx.game.stage.GameStage;

/**
 * @author xiangchijie
 * @date 2021/4/4 3:31 下午
 */
public class PlayerActor extends Actor implements Disposable {

    private GameStage gameStage;
    private Player player = CacheManager.INSTANCE.player;
    public static final int PID = 1;

    public PlayerActor(GameStage gameStage) {
        this.gameStage = gameStage;
        player.setState(new StandPlayerState());
        init();
    }

    private void init() {
        //添加移动事件
        gameStage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                player.getState().keyDown(event, keycode);
                return true;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                player.getState().keyUp(event, keycode);
                return false;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        player.getState().update();
        player.setStateTime(player.getStateTime() + Gdx.graphics.getDeltaTime());
        // 得到下一帧
        TextureRegion currentFrame = player.getPlayerAnimation().getKeyFrame(player.getStateTime(), true); // 循环
        // 以(0,0)绘制为起点（左下角为100，100）画出动画，大小128*128
        float h = (float) Constants.ROLE_WIDTH / currentFrame.getRegionWidth() * currentFrame.getRegionHeight();
        batch.draw(currentFrame, player.getX(),  Constants.ROLE_Y,
                Constants.ROLE_WIDTH, h );
    }

    @Override
    public void dispose() {

    }

}
