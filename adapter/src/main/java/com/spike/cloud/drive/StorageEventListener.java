package com.spike.cloud.drive;

/**
 * target接口非常多，如果直接让Adapter实现，会被迫实现所有接口
 * 这时候就需要一个默认抽象的Adapter，为target接口的每个方法提供空实现，具体业务类只需要重写需要的方法
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public interface StorageEventListener {
    void onUploadStart(String path);

    void onUploadSuccess(String path);

    void onUploadFailure(String path, Throwable t);

    void onDownload(String path);

    void onDelete(String path);

    void onList(String dir);
}
