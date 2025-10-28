package com.spike;

/**
 * 扩充抽象类，(Override)扩展由抽象类定义的接口( play() )
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class WindowsVersion extends OperatingSystemVersion {
    public WindowsVersion() {
    }

    public WindowsVersion(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    protected void initStack() {
        System.out.println("[Windows] 调用 DirectShow/Media Foundation 初始化...");
    }

    @Override
    protected void present() {
        System.out.println("[Windows] 使用 GDI/DirectX 显示输出");
    }
}
