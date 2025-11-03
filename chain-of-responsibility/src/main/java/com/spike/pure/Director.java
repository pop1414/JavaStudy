package com.spike.pure;

/**
 * 具体处理类角色
 * 在处理请求之前需要进行判断，看是否有相应的处理权限，如果可以处理请求就处理它，否则将请求转发给后继者*
 *
 * @author Ayanami
 * @date 2025/11/03
 */
public class Director extends Leader {

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= 7) {
            System.out.println("总监批准了 " + request.getName() + " 的 " + request.getDays() + " 天假");
        } else {
            System.out.println("拒绝：" + request.getName() + " 请假 " + request.getDays() + " 天，超过7天");
        }
    }
}
