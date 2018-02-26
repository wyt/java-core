package org.wangyt.jdk.event;

import java.util.EventListener;

/**
 * 监听器接口, 实现监听事件执行动作.
 */
public interface DemoListener extends EventListener {
    public void demoEvent(DemoEvent dm);
}
