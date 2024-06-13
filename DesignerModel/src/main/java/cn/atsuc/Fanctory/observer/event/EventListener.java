package cn.atsuc.Fanctory.observer.event;

import cn.atsuc.Fanctory.observer.LotteryResult;

/**
 * @author csup
 * @creatTime 2024/5/21 12:33
 * @description
 */
public interface EventListener {
    void doEvent(LotteryResult result);
}
