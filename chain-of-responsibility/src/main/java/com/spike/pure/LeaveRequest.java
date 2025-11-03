package com.spike.pure;

import lombok.Getter;

/**
 * 请求类，Handle类要处理的对象
 *
 * @author Ayanami
 * @date 2025/11/03
 */
@Getter
public class LeaveRequest {
    private final String name;
    private final int days;
    private final String reason;

    public LeaveRequest(String name, int days, String reason) {
        this.name = name;
        this.days = days;
        this.reason = reason;
    }
}
