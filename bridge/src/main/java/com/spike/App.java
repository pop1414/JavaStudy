package com.spike;

/**
 * 将操作系统版本设为抽象类，因为操作系统与具体业务（播放视频）关系最为密切，此为第一维
 * 而播放视频通常需要解码不同种类的文件，此为第二维
 * <p>
 * 优点：桥接模式可以取代多重继承，which会违背“单一职责原则”，复用性较差；而bridge可以极大地减少子类的种类；多重继承m * n，bridge m + n
 * 将第二维作为抽象类的成员（关联），就可以减少因为多维度的变化，导致子类的爆炸性增长
 * 符合“开闭原则”
 * <p>
 * 缺点：增加系统设计难度与理解，需要正确识别系统中独立变化的两个维度，以及决定出哪个维度是合适的抽象类
 * <p>
 * // TODO bridge & adapter的联用
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class App {
    public static void main(String[] args) {
        OperatingSystemVersion win = new WindowsVersion().setVideoFile(new RMVBFile());

        win.play("111");

        win.setVideoFile(new AVIFile());
        win.play("222");

        OperatingSystemVersion mac = new MacVersion().setVideoFile(new RMVBFile());

        mac.play("333");

        mac.setVideoFile(new AVIFile());
        mac.play("444");

        mac.setVideoFile(new WMVFile());
        mac.play("555");
    }
}
