package com.spike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 优点 原型模式提供了简化的创建结构，产品的复制是通过封装在原型类中的克隆方法实现的
 * 缺点 需要为每一个类配备一个克隆方法，对于已有的类进行改造时，违背了“开闭原则”
 * 深克隆需要较为复杂的代码，如何类之间相互嵌套，那么进行深克隆的时候，需要每一个都配备深克隆方法，较为繁琐
 *
 * @author Ayanami
 * @date 2025/10/23
 */
public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Style groupStyle = new Style("#FFF8B1", "#333333", "Inter");

        List<String> tags = new ArrayList<>(Arrays.asList("todo", "groupA"));
        List<String> comments = new ArrayList<>(Arrays.asList("init"));

        StickyNote note = new StickyNote("Prototype", groupStyle, tags, comments);
        BoardFactory factory = new BoardFactory(note);

        // 浅拷贝
        StickyNote groupNoteA = factory.createGroupNote();
        StickyNote groupNoteB = factory.createGroupNote();

        System.out.println(note.toString() + "This is note");
        System.out.println(groupNoteA.toString() + "This is A");
        System.out.println(groupNoteB.toString() + "This is B");

        // 深拷贝
        StickyNote isolatedNote = factory.creatIsolateNote();

        groupNoteA.getStyle().setBgColor("#D0F0C0");
        groupNoteB.getComments().add("from B");

        System.out.println(note.toString() + "This is note");
        System.out.println(groupNoteA.toString() + "This is A");
        System.out.println(groupNoteB.toString() + "This is B");
        System.out.println(isolatedNote.toString() + "This is isolated note");

        isolatedNote.getStyle().setBgColor("#D0F0C1");
        isolatedNote.getComments().add("from isolated");

        System.out.println(note.toString() + "This is note");
        System.out.println(groupNoteA.toString() + "This is A");
        System.out.println(groupNoteB.toString() + "This is B");
        System.out.println(isolatedNote.toString() + "This is isolated note");
    }
}
