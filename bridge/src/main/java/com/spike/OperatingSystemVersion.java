package com.spike;

/**
 * 抽象类，与接口有关联
 * 其中包含了一个接口类型的对象(VideoFile videoFile)并可以维护对象
 * 包含了具体（或抽象）的业务方法
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public abstract class OperatingSystemVersion {
    protected VideoFile videoFile;

    public OperatingSystemVersion() {
    }

    public OperatingSystemVersion(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public OperatingSystemVersion setVideoFile(VideoFile videoFile) {
        this.videoFile = java.util.Objects.requireNonNull(videoFile, "videoFile 不能为空");
        return this;
    }

    // ★ 统一的“模板方法”：固定流程在这里，不允许子类改动顺序
    public final void play(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("fileName 不能为空");
        }
        initStack();
        openWindow(fileName);
        videoFile.decode(fileName);
        drawFrame();
        present();
        closeWindow();
        System.out.println();
    }

    // —— 子类需要实现的“差异化填空” ——
    protected abstract void initStack();

    protected abstract void present();


    // ——模板方法里各平台可能共用/扩展的钩子（演示用）——
    protected final void openWindow(String title) {
        System.out.println("  打开播放窗口：《" + title + "》");
    }

    protected final void drawFrame() {
        System.out.println("  渲染视频帧...");
    }

    protected final void closeWindow() {
        System.out.println("  关闭播放窗口");
    }
}
