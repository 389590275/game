package com.mygdx.game;

/**
 * @author xiangchijie
 * @date 2021/4/4 12:50 下午
 */
public class Test {

    public static void main(String[] args) {
//        b01
//        xy: 0, 0
//        size: 32, 32
        for (int i = 0; i < 16; i++) { // y
            for (int j = 0; j < 16; j++) { // x
                System.out.println("block"+j+"-"+i);
                System.out.println("xy:"+j*32 +","+i*32);
                System.out.println("size: 32, 32");
            }
        }
    }

}
