package org.debugroom.sample.aws.rds.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AffiliationPK implements Serializable {
    private String groupId;
    private String userId;

    @Column(name = "group_id", nullable = false, length = 10)
    @Id
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(name = "user_id", nullable = false, length = 8)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AffiliationPK that = (AffiliationPK) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, userId);
    }
}
