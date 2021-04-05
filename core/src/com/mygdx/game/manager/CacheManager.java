package com.mygdx.game.manager;

import com.mygdx.game.constants.Constants;
import com.mygdx.game.constants.ResBlock;
import com.mygdx.game.monster.Monster;
import com.mygdx.game.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存管理器
 *
 * @author xiangchijie
 * @date 2021/4/4 6:48 下午
 */
public class CacheManager {

    public static final CacheManager INSTANCE = new CacheManager();

    private int monsterId;

    public Player player = new Player();

    public Map<Integer, Monster> monsterMap = new HashMap<>();

    public int getIncMonsterId() {
        return ++monsterId;
    }

    // y = 10 , x = 16
    public int[][] gameMaps = {
            {6, 26, 26, 26, 25, 1, 1, 1, 1, 1, 1, 1, 31, 29, 39, 39},
            {6, 6, 23, 23, 24, 1, 1, 1, 1, 1, 1, 1, 29, 37, 38, 1},
            {1, 6, 6, 23, 23, 1, 1, 2, 1, 1, 1, 1, 36, 36, 1, 1},
            {1, 1, 1, 1, 20, 20, 21, 20, 21, 1, 1, 37, 36, 1, 1, 1},
            {1, 1, 1, 1, 1, 21, 22, 22, 22, 20, 39, 38, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 20, 20, 21, 22, 1, 36, 36, 39, 1, 1, 1},
            {12, 0, 12, 1, 24, 24, 35, 35, 36, 38, 1, 1, 1, 1, 1, 1},
            {33, 17, 17, 23, 23, 37, 35, 36, 36, 38, 1, 1, 1, 1, 1, 1},
            {33, 16, 16, 1, 1, 1, 35, 35, 36, 37, 38, 1, 1, 1, 1, 1},
            {33, 34, 34, 12, 12, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    /**
     * 目标位置可以通过么
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isAccept(int x, int y) {
        if (x < 0 || y < 0)
            return false;
        if (x >= Constants.MAX_X || y >= Constants.MAX_Y)
            return false;
        int blockIndex = gameMaps[y][x];
        String blockName = ResBlock.blockNames[blockIndex];
        if (!ResBlock.ROAD_BLOCK.contains(blockName)) {
            return false;
        }
        int monsterId = x * 100 + y;
        if (monsterMap.containsKey(monsterId)) {
            return false;
        }
        return true;
    }


}
