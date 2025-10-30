package com.spike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子系统不知道外观角色的存在，对他来说，外观角色只是一个客户端
 * 优点：减少了客户端处理所需对象的数目，使得使用各个子系统更加方便；外观角色减少了客户端与子系统的耦合；而且也只是增加了一个访问子系统的统一接口，客户端也可以直接使用各个子系统
 * <p>
 * 缺点：若设计不当，增加新的子系统可能需要修改外观类的源代码（使用窄接口细分种类可以避免），违背开闭原则
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public class App {
    public static void main(String[] args) {
        List<Dimmable> lights = new ArrayList<>(Arrays.asList(
                new Light(1), new Light(2), new Light(3), new Light(4)));

        MainSwitchFacade facade = new MainSwitchFacade(
                lights,
                new Tv(),
                new AirConditioner(),
                new Fan()
        );
        facade.allOn();
        facade.movieNight();
        facade.sleepScene();
        facade.leaveHome();
    }
}
