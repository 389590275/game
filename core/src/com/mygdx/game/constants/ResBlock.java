package com.mygdx.game.constants;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.google.common.collect.Sets;
import com.mygdx.game.manager.ResManager;

import java.util.Set;

/**
 * @author xiangchijie
 * @date 2021/4/4 11:27 下午
 */
public class ResBlock {

    public static String[] blockNames = {
            "block0-0", "block1-0", "block2-0", "block3-0", "block4-0"
            , "block5-0", "block6-0", "block7-0", "block8-0", "block9-0"
            , "block10-0", "block11-0", "block12-0", "block13-0", "block14-0"
            , "block15-0", "block0-1", "block1-1", "block2-1", "block3-1"
            , "block4-1", "block5-1", "block6-1", "block7-1", "block8-1"
            , "block9-1", "block10-1", "block11-1", "block12-1", "block13-1"
            , "block14-1", "block15-1", "block8-2", "block9-2", "block10-2"
            , "block11-2", "block12-2", "block13-2", "block14-2", "block15-2"
            , "block15-3", "block15-4"
    };

    public static final int blockSize = blockNames.length;

    // 可以走的路
    public static final Set<String> ROAD_BLOCK = Sets.newHashSet(
            "block0-0", "block6-0", "block7-0", "block9-0"
            , "block11-0", "block0-1", "block4-1", "block5-1", "block6-1", "block7-1", "block8-1"
            , "block8-2", "block9-2", "block10-2", "block11-2", "block12-2", "block13-2", "block14-2", "block15-2"
    );

}
