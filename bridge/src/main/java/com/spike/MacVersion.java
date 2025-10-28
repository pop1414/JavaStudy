package com.spike;

/**
 * 扩充抽象类，(Override)扩展由抽象类定义的接口( play() )
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class MacVersion extends OperatingSystemVersion {
    public MacVersion() {
    }

    public MacVersion(VideoFile videoFile) {
        super(videoFile);
    }


    @Override
    protected void initStack() {
        System.out.println("[Mac] 初始化系统多媒体子系统...");
    }

    @Override
    protected void present() {
        System.out.println("[Mac] 使用本地窗口系统输出");
    }
}

