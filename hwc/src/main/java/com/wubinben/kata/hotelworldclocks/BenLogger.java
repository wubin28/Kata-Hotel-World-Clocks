package com.wubinben.kata.hotelworldclocks;

/**
 * A simple logger.
 * User: Ben
 * Date: 13-9-10
 * Time: 下午1:11
 * To change this template use File | Settings | File Templates.
 */
public class BenLogger {
    public static final int LEVEL_ON = 1;
    public static final int LEVEL_OFF = 0;
    private final int level;

    public BenLogger(int level) {
        this.level = level;
    }

    public static BenLogger getLogger(int level) {
        return new BenLogger(level);
    }

    public void info(String log) {
        if (this.level == LEVEL_ON) {
            System.out.println("===" + log);
        }
    }
}
