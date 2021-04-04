package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MainGame;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.stage.StartStage;

/**
 * 开始场景
 *
 * @author xiangchijie
 * @date 2021/4/4 2:21 下午
 */
public class StartScreen extends ScreenAdapter {

    private StartStage startStage;
    private MainGame mainGame;

    public StartScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    private void init() {
        // 1. 创建主游戏舞台
        startStage = new StartStage(
                mainGame,
                new StretchViewport(
                        Constants.WIDTH,
                        Constants.HIGH
                )
        );
        // 把输入处理设置到主游戏舞台（必须设置, 否则无法接收用户输入）
        Gdx.input.setInputProcessor(startStage);
    }

    @Override
    public void render(float delta) {
        // 使用背景颜色清屏
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /*
         * 更新舞台逻辑, 绘制舞台
         */
        // 1. 主游戏舞台始终都需要绘制, 并且最先绘制
        startStage.act();
        startStage.draw();
    }

    @Override
    public void dispose() {
        // 场景销毁时, 同时销毁所有舞台
        if (startStage != null) {
            startStage.dispose();
        }
    }


}
