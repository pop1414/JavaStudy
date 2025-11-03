package com.spike.pure;

/**
 * 具体处理类角色
 * 在处理请求之前需要进行判断，看是否有相应的处理权限，如果可以处理请求就处理它，否则将请求转发给后继者*
 *
 * @author Ayanami
 * @date 2025/11/03
 */
public class Manager extends Leader {


    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= 3) {
            System.out.println("部门经理批准了 " + request.getName() + " 的 " + request.getDays() + " 天假");
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
}
