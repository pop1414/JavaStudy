package com.spike;

/**
 * 扩充抽象类，(Override)扩展由抽象类定义的接口( play() )
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class LinuxVersion extends OperatingSystemVersion {
    public LinuxVersion() {

    }

    public LinuxVersion(VideoFile videoFile) {
        super(videoFile);
    }


    @Override
    protected void initStack() {
        System.out.println("[Linux] 初始化 GStreamer/FFmpeg 管线...");
    }

    @Override
    protected void present() {
        System.out.println("[Linux] 初始化 GStreamer/FFmpeg 管线...");
    }
}
