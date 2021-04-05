package com.mygdx.game.manager;

import com.mygdx.game.constants.Constants;
import com.mygdx.game.monster.Monster;
import com.mygdx.game.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 目标位置可以通过么
     *
     * @param x
     * @return
     */
    public boolean isAccept(int x) {
        if (x < 0) {
            return false;
        } else if (x + Constants.ROLE_WIDTH > Constants.WIDTH) {
            return false;
        }
        if (!getMonsterByXRange(x, x + Constants.ROLE_WIDTH).isEmpty()) {
            return false;
        }
        return true;
    }

    public Monster getMonsterByX(int x) {
        for (Monster monster : monsterMap.values()) {
            if (monster.getX() < x && monster.getX() + Constants.ROLE_WIDTH > x) {
                return monster;
            }
        }
        return null;
    }

    /**
     * 在指定x1-x2 范围的所有怪物
     *
     * @param x1
     * @param x2
     * @return
     */
    public List<Monster> getMonsterByXRange(int x1, int x2) {
        List<Monster> monsters = new ArrayList<>();
        int max = Math.max(x1, x2);
        int min = Math.min(x1, x2);
        for (Monster monster : monsterMap.values()) {
            int distance = Math.max(Math.abs(max - monster.getX()),
                    Math.abs(monster.getX() + Constants.ROLE_WIDTH - min));
            if (max - min + Constants.ROLE_WIDTH >= distance)
                monsters.add(monster);
        }
        return monsters;
    }
}
