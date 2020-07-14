package cn.wjx.springboot_aop.entity;

import java.time.LocalDateTime;

/**
 * @author wjx
 * @date 2020/7/8 19:09
 * @description:
 */
public class UserOperateLog {
    private String operateContent;
    private String userId;
    private Integer operateType;
    private LocalDateTime createTime;

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
