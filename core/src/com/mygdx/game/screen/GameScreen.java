package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MainGame;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.stage.GameStage;

/**
 * 游戏场景
 *
 * @author xiangchijie
 * @date 2021/4/4 12:41 上午
 */
public class GameScreen extends ScreenAdapter {

    private GameStage gameStage;

    private MainGame mainGame;

    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    private void init() {
        // 把输入处理设置到主游戏舞台（必须设置, 否则无法接收用户输入）
        gameStage = new GameStage(mainGame, new StretchViewport(
                Constants.WIDTH,
                Constants.HIGH
        ));
        gameStage.setVisible(true);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        // 使用背景颜色清屏
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /*
         * 更新舞台逻辑, 绘制舞台
         */
        // 1. 主游戏舞台始终都需要绘制, 并且最先绘制
        gameStage.act();
        gameStage.draw();
    }

    @Override
    public void dispose() {
        // 场景销毁时, 同时销毁所有舞台
        if (gameStage != null) {
            gameStage.dispose();
        }
    }

}
