package com.spike;

/**
 * 便利贴工厂类，负责根据原型对象创建新实例。
 *
 * <p>演示了原型模式（Prototype Pattern）中通过克隆对象来复制实例，
 * 避免了重复的构造开销。</p>
 *
 * <ul>
 *     <li>{@link #createGroupNote()} — 浅拷贝，适用于共享引用的场景。</li>
 *     <li>{@link #creatIsolateNote()} — 深拷贝，适用于完全独立的对象。</li>
 * </ul>
 *
 * @author Ayanami
 * @date 2025/10/23
 */
public class BoardFactory {
    private final StickyNote notePrototype;

    public BoardFactory(StickyNote notePrototype) {
        this.notePrototype = notePrototype;
    }

    public StickyNote createGroupNote() throws CloneNotSupportedException {
        return notePrototype.copyShallow();
    }

    public StickyNote creatIsolateNote() throws CloneNotSupportedException {
        return notePrototype.copyDeep();
    }
}
