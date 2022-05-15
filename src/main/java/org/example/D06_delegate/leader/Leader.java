package org.example.D06_delegate.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 86158
 */
public class Leader {

    private Map<String, Target> targetMap = new HashMap<>();

    public Leader() {
        this.targetMap.put("加密", new Target());
    }

    public void doWork(String command) {
        System.out.println("开始协调人员，分配工作");
        targetMap.get(command).doWork();
    }


}
