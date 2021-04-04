package com.mygdx.game.constants;

/**
 * @author xiangchijie
 * @date 2021/4/4 12:33 上午
 */
public class Res {

    public static final String START_BJ = "start_bj.jpg";
    public static final String START_BTN = "start_btn.png";
    public static final String BLOCKS = "atlas/blocks.atlas";

    public static final String BLOCK_PRE = "block";

    public static class Block {

        public static String[] blockNames = {
                "block0-0", "block1-0", "block2-0", "block3-0", "block4-0"
                , "block5-0", "block6-0", "block7-0", "block8-0", "block9-0"
                , "block10-0", "block11-0", "block12-0", "block13-0", "block14-0",
                "block15-0", "block0-1", "block1-1", "block2-1", "block3-1"
                , "block4-1", "block5-1", "block6-1", "block7-1", "block8-1"
                , "block9-1", "block10-1", "block11-1", "block12-1", "block13-1"
                , "block14-1", "block15-1", "block7-2", "block8-2", "block9-2"
                , "block10-2", "block11-2", "block12-2", "block13-2", "block14-2"
                , "block15-2", "block15-3", "block15-4"
        };

        public static final int blockSize = blockNames.length;

    }

    public static class Player {


        public static final String frameNames[] = {
                "01.png", "02.png", "03.png", "04.png", "05.png", "06.png", "07.png", "08.png", "09.png",
                "10.png", "11.png", "12.png", "13.png", "14.png"
        };
        public static final int playerFrameSize = frameNames.length;
        public static final int PLAYER_SIZE = 1;

        private static final String PLAYER_PATH = "atlas/player%s.atlas";
        public static String getPlayerPath(int pid) {
            String id = String.valueOf(pid);
            for (int i = id.length(); i < 4; i++) {
                id = "0" + id;
            }
            return String.format(PLAYER_PATH, id);
        }

    }

}
