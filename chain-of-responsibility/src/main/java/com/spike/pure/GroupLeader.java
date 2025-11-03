package com.spike.pure;

/**
 * 具体处理类角色
 * 在处理请求之前需要进行判断，看是否有相应的处理权限，如果可以处理请求就处理它，否则将请求转发给后继者
 *
 * @author Ayanami
 * @date 2025/11/03
 */
public class GroupLeader extends Leader {

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= 1) {
            System.out.println("组长批准了 " + request.getName() + " 的 " + request.getDays() + " 天假");
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            } else {
                System.out.println("无人可批：请假天数超过1天");
            }
        }
    }
}
