package com.spike.pure;

import lombok.Setter;

/**
 * 抽象处理者角色，定义了一个抽象请求处理方法(handleRequest()), 还有一个抽象处理者类型的对象，作为对下家的引用（链表）
 *
 * @author Ayanami
 * @date 2025/11/03
 */
@Setter
public abstract class Leader {
    protected Leader successor;

    public abstract void handleRequest(LeaveRequest request);

}
