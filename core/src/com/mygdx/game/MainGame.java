package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.manager.ResManager;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.StartScreen;

public class MainGame extends Game {

    /**
     * 主游戏场景
     */
    private Screen gameScreen;

    @Override
    public void create() {
        // 设置 log 输出级别
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        ResManager.load();
        // 创建主游戏场景
        gameScreen = new StartScreen(this);
        // 设置当前场景
        setScreen(gameScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
        // 应用退出时, 需要手动销毁场景
        if (gameScreen != null) {
            gameScreen.dispose();
        }
        // 应用退出时释放资源
        ResManager.dispose();
    }

    public void startGame() {
        gameScreen.dispose();
        gameScreen = new GameScreen(this);
        setScreen(gameScreen);
    }


}
