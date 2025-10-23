package com.spike;

/**
 * 原型模式基类，定义了对象的浅拷贝与深拷贝接口。
 *
 * <p>该抽象类实现 {@link Cloneable} 接口，
 * 子类可继承并根据需要扩展深拷贝逻辑。</p>
 *
 * @param <T> 表示克隆目标的类型
 * @author Ayanami
 * @date 2025/10/22
 */
public abstract class Prototype<T> implements Cloneable {
    public T copyShallow() throws CloneNotSupportedException {
        return (T) super.clone();
    }

    public T copyDeep() throws CloneNotSupportedException {
        return (T) this.clone();
    }
}
