package com.spike.pure;

/**
 * 此例是纯的职责链模式，要么承担全部责任，要么将责任推给下家
 * 不纯的是指允许某个请求被一个具体处理者部分处理后再向下传递，或者一个具体处理者处理完某请求后其后继处理者可以继续处理该请求，而且一个请求可以最终不被任何处理者对象所接收
 *
 * @author Ayanami
 * @date 2025/11/03
 */
public class App {
    public static void main(String[] args) {
        Leader groupLeader = new GroupLeader();
        Leader manager = new Manager();
        Leader director = new Director();

        // 构建链：组长 → 经理 → 总监
        groupLeader.setSuccessor(manager);
        manager.setSuccessor(director);

        // 测试

        // 组长批
        groupLeader.handleRequest(new LeaveRequest("张三", 1, "hhh"));
        // 经理批
        groupLeader.handleRequest(new LeaveRequest("李四", 2, "ddd"));
        // 总监批
        groupLeader.handleRequest(new LeaveRequest("王五", 5, "kkk"));
        // 拒绝
        groupLeader.handleRequest(new LeaveRequest("赵六", 10, "lll"));
    }
}
