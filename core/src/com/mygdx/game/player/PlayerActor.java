package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.manager.ResManager;
import com.mygdx.game.stage.GameStage;
import com.mygdx.game.state.StandState;

/**
 * @author xiangchijie
 * @date 2021/4/4 3:31 下午
 */
public class PlayerActor extends Actor implements Disposable {

    Animation<TextureRegion> playerAnimation;
    float stateTime;
    private GameStage gameStage;
    private Player player = CacheManager.INSTANCE.player;


    public PlayerActor(GameStage gameStage) {
        this.gameStage = gameStage;
        player.setState(new StandState());
        init();
    }

    private void init() {
        TextureRegion[] walkFrames = new TextureRegion[4];
        for (int i = 1; i <= walkFrames.length; i++) {
            walkFrames[i - 1] = ResManager.findPlayerTexture(1, i);
        }
        // 使用关键帧（纹理区域）数组 walkFrames 创建一个动画实例, 每一帧（一个小人单元格/纹理区域）播放 0.05 秒
        playerAnimation = new Animation(0.2F, walkFrames);
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //添加移动事件
        gameStage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                player.getState().keyDown(event, keycode);
                return true;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                player.getState().keyDown(event, keycode);
                return false;
            }

        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        player.getState().update();
        stateTime += Gdx.graphics.getDeltaTime();
        // 得到下一帧
        TextureRegion currentFrame = playerAnimation.getKeyFrame(stateTime, true); // 循环
        // 以(0,0)绘制为起点（左下角为100，100）画出动画，大小128*128
        float h = (float) Constants.UNIT / currentFrame.getRegionWidth() * currentFrame.getRegionHeight();
        batch.draw(currentFrame, player.getX() - 16, player.getY(),
                Constants.UNIT * 1.5f,
                h * 1.5f);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return this;
    }

    @Override
    public void dispose() {

    }
}
