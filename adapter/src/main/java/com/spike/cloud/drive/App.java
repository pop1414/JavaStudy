package com.spike.cloud.drive;

import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * client调用一个接口target，想使用adaptee，但是target与adaptee接口不匹配，无法使用adaptee
 * 此时就需要一个adapter 实现target的接口，类内拥有adaptee的对象
 * Override target的接口，用adaptee的对象调用其接口
 * 就可以实现适配
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class App {

    public static void main(String[] args) {
        // === 选择并组装依赖（DI） ===
        // 若你已给适配器加了 DI 构造器，推荐用如下方式：
        UnifiedStorage ftp = new FtpStorageAdapter(new LegacyFtpClient());
        UnifiedStorage oss = new ObjectStorageAdapter(new ObjectStorageSdk());


        // 阶段B：默认/缺省适配器（只关心“上传成功”事件）
        StorageEventListener listener = new FtpOnlyOnSuccess();

        // 运行两组演示（分别用 FTP 与 对象存储）
        runDemo("FTP", ftp, listener);
        runDemo("OSS", oss, listener);

      /*  // —— 可选：若你已实现双向适配器（Stage C），可解开下面的注释演示 —— //
        TwoWayStorageAdapter twoWay = new TwoWayStorageAdapter(new , oss);
        runDemo("TwoWay as UnifiedStorage (→FTP)", twoWay, listener);

        // 也演示旧接口一侧如何通过 twoWay 访问“新端”：
        twoWay.putFile("/legacy/b.txt", "from-legacy-side".getBytes(StandardCharsets.UTF_8));
        byte[] ld = twoWay.getFile("/legacy/b.txt");
        System.out.println("[TwoWay as LegacyFileOps] download size = " + (ld == null ? "null" : ld.length));*/
    }

    /**
     * 用统一接口做一次完整 CRUD 演示，并在上传前后触发阶段B的事件回调。
     */
    private static void runDemo(String name, UnifiedStorage storage, StorageEventListener listener) {
        final String dir = "/docs";
        final String path = dir + "/demo.txt";
        final byte[] data = "hello-adapter".getBytes(StandardCharsets.UTF_8);

        System.out.println("\n=== [" + name + "] demo begin ===");

        // --- upload（带事件回调：阶段B） ---
        safeCall(() -> listener.onUploadStart(path));
        try {
            storage.upload(path, data);
            System.out.println("[" + name + "] uploaded: " + path);
            safeCall(() -> listener.onUploadSuccess(path));
        } catch (RuntimeException ex) {
            safeCall(() -> listener.onUploadFailure(path, ex));
            System.err.println("[" + name + "] upload failed: " + ex.getMessage());
        }

        // --- download ---
        try {
            byte[] out = storage.download(path);
            System.out.println("[" + name + "] download size: " + (out == null ? "null" : out.length));
        } catch (RuntimeException ex) {
            System.err.println("[" + name + "] download failed: " + ex.getMessage());
        }

        // --- list ---
        try {
            List<String> list = storage.list(dir);
            System.out.println("[" + name + "] list result: " + (list == null ? "null" : list));
        } catch (RuntimeException ex) {
            System.err.println("[" + name + "] list failed: " + ex.getMessage());
        }

        // --- delete ---
        try {
            storage.delete(path);
            System.out.println("[" + name + "] deleted: " + path);
        } catch (RuntimeException ex) {
            System.err.println("[" + name + "] delete failed: " + ex.getMessage());
        }

        System.out.println("=== [" + name + "] demo end ===");
    }

    /**
     * 防御式调用监听器，避免监听器异常影响主流程
     */
    private static void safeCall(Runnable r) {
        try {
            r.run();
        } catch (Throwable ignored) { /* 忽略监听器异常 */ }
    }
}

