package com.mygdx.game.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MainGame;
import com.mygdx.game.constants.Constants;
import com.mygdx.game.constants.Res;
import com.mygdx.game.manager.ResManager;

/**
 * @author xiangchijie
 * @date 2021/4/4 12:47 上午
 */
public class StartStage extends BaseStage {

    /**
     * 背景
     */
    private Image bgImage;
    private Button startButton;

    //地图
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;


    public StartStage(MainGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
        init();
    }

    @Override
    public void init() {
        //背景
        bgImage = new Image(ResManager.ASSET_MANAGER.get(Res.START_BJ, Texture.class));
        bgImage.setOrigin(0, 0);
        // 缩放到铺满整个舞台
        bgImage.setScale(getWidth() / bgImage.getWidth(), getHeight() / bgImage.getHeight());
        addActor(bgImage);

        //开始游戏按钮
        Button.ButtonStyle backStyle = new Button.ButtonStyle();
        backStyle.up = new TextureRegionDrawable(ResManager.ASSET_MANAGER.get(Res.START_BTN, Texture.class));
        backStyle.down = new TextureRegionDrawable(ResManager.ASSET_MANAGER.get(Res.START_BTN, Texture.class));
        startButton = new Button(backStyle);
        startButton.setBounds(Constants.WIDTH / 2 - 100, 50, 200, 100);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMainGame().startGame();
            }
        });
        addActor(startButton);

        //TODO
        initMapBlock();
    }

    private void initMapBlock() {
        camera = new OrthographicCamera();
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(Res.BLOCKS);
        renderer = new OrthogonalTiledMapRenderer(map, 1 / 32f);
        camera.setToOrtho(false, 16, 10);
    }

    @Override
    public void draw() {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setView(camera);
        renderer.render();
    }
}
