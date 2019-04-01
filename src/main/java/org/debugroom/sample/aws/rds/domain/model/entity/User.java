package org.debugroom.sample.aws.rds.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usr", schema = "public", catalog = "sample_database")
public class User {
    private String userId;
    private String userName;
    private String loginId;
    private Integer ver;
    private Timestamp lastUpdatedDate;
    private Address addressByUserId;
    private Collection<Affiliation> affiliationsByUserId;
    private Collection<Email> emailsByUserId;

    @Id
    @Column(name = "user_id", nullable = false, length = 8)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "login_id", nullable = true, length = 64)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "ver", nullable = true)
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @Basic
    @Column(name = "last_updated_date", nullable = true)
    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(loginId, user.loginId) &&
                Objects.equals(ver, user.ver) &&
                Objects.equals(lastUpdatedDate, user.lastUpdatedDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, loginId, ver, lastUpdatedDate);
    }

    @OneToOne(mappedBy = "usrByUserId")
    public Address getAddressByUserId() {
        return addressByUserId;
    }

    public void setAddressByUserId(Address addressByUserId) {
        this.addressByUserId = addressByUserId;
    }

    @OneToMany(mappedBy = "usrByUserId")
    public Collection<Affiliation> getAffiliationsByUserId() {
        return affiliationsByUserId;
    }

    public void setAffiliationsByUserId(Collection<Affiliation> affiliationsByUserId) {
        this.affiliationsByUserId = affiliationsByUserId;
    }

    @OneToMany(mappedBy = "usrByUserId")
    public Collection<Email> getEmailsByUserId() {
        return emailsByUserId;
    }

    public void setEmailsByUserId(Collection<Email> emailsByUserId) {
        this.emailsByUserId = emailsByUserId;
    }
}
