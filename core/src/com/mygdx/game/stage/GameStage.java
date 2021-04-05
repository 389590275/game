package com.mygdx.game.stage;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MainGame;
import com.mygdx.game.constants.Res;
import com.mygdx.game.manager.CacheManager;
import com.mygdx.game.manager.ResManager;
import com.mygdx.game.monster.MonsterActor;
import com.mygdx.game.player.Player;
import com.mygdx.game.player.PlayerActor;

/**
 * 游戏场景
 *
 * @author xiangchijie
 * @date 2021/4/4 1:00 下午
 */
public class GameStage extends BaseStage {

    Image bgImage;
    Player player = CacheManager.INSTANCE.player;


    public GameStage(MainGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
        init();
    }

    @Override
    public void init() {
        //背景
        bgImage = new Image(ResManager.ASSET_MANAGER.get(Res.BATTLE_BJ1, Texture.class));
        bgImage.setOrigin(0, 0);
        // 缩放到铺满整个舞台
        bgImage.setScale(getHeight() / bgImage.getHeight(), getHeight() / bgImage.getHeight());
        addActor(bgImage);

        intPlayer();
        initMonster();
    }

    //初始化角色
    private void intPlayer() {
        PlayerActor playerActor = new PlayerActor(this);
        addActor(playerActor);
    }

    //初始化怪物
    private void initMonster() {
        MonsterActor monsterActor = new MonsterActor(this);
        addActor(monsterActor);
    }

    @Override
    public void act() {
    }

}
