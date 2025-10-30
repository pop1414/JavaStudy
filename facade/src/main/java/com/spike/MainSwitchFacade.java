package com.spike;

import java.util.List;

/**
 * 外观角色，客户端可以调用它的方法，内部有子系统角色的引用，将客户端发来的请求，委派到相应的子系统中去处理
 *
 * @author Ayanami
 * @date 2025/10/30
 */
public class MainSwitchFacade {
    private final List<Dimmable> lights;
    private final TvLike tv;
    private final AirConLike ac;
    private final FanLike fan;

    public MainSwitchFacade(List<Dimmable> lights, TvLike tv, AirConLike airConditioner, FanLike fan) {
        this.lights = lights;
        this.tv = tv;
        this.ac = airConditioner;
        this.fan = fan;
    }

    public void allOn() {
        lights.forEach(Dimmable::switchOn);
        fan.switchOn();
        ac.switchOn();
        tv.switchOn();
        System.out.println("All On");
    }

    public void allOff() {
        lights.forEach(Dimmable::switchOff);
        fan.switchOff();
        ac.switchOff();
        tv.switchOff();
        System.out.println("All Off");
    }

    public void sleepScene() {
        // 睡眠场景：关电视，灯光调暗，空调舒适温度，风扇低速
        lights.forEach(l -> l.dim(10));
        tv.switchOff();
        ac.switchOn();
        ac.coolMode();
        ac.setTemp(24);
        fan.switchOn();
        fan.setSpeed(1);
        System.out.println("Sleep Scene");
    }

    public void movieNight() {
        // 观影场景：灯光30%，电视HDMI1，空调制冷23℃
        lights.forEach(l -> l.dim(30));
        tv.switchOn();
        tv.setInput("HDMI1");
        ac.switchOn();
        ac.coolMode();
        ac.setTemp(23);
        fan.switchOff();
        System.out.println("Movie Night");
    }

    public void leaveHome() {
        // 离家场景：全关
        allOff();
        System.out.println("SCENE_LEAVE_HOME");
    }
}
