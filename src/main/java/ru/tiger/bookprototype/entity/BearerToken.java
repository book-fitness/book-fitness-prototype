package ru.tiger.bookprototype.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tiger
 */
@Entity
@Table(name = "BEARER_TOKEN")
public class BearerToken implements Serializable {
    @Id
    private String token;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    
    @Column(name = "USER_ID")
    private long userId;

    public BearerToken() {}

    public BearerToken(String token, Date expires, long userId) {
        this.token = token;
        this.expires = expires;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.token);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BearerToken other = (BearerToken) obj;
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        return true;
    }
}
