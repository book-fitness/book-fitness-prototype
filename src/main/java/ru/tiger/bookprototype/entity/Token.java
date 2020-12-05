package ru.tiger.bookprototype.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Igor
 */
@Entity
public class Token implements AbstractEntity {
    @Id
    @Column(name = "TOKEN")
    private String tokenValue;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    public Token() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return tokenValue;
    }

    public void setToken(String token) {
        this.tokenValue = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void resetExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        calendar.add(Calendar.HOUR, 1);
        expirationDate = calendar.getTime();
    }
    
    public boolean isExpired() {
        return (new Date()).after(expirationDate);
    }
    
    @Override
    public Long getId() {
        return userId;
    }
}
