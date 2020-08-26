package ru.tiger.bookprototype.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Tiger
 */
@Entity
@IdClass(UserLikeId.class)
public class UserLike implements Serializable, AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name = "USER_ID")
    private long userId;
    @Id @Column(name = "POST_ID")
    private long postId;
    @Column(name = "VALUE")
    private boolean value;
    

    public UserLike() {}
    
    @Override
    public Long getId() {
        //return id;
        throw new UnsupportedOperationException("Have not simple key. Only complex key.");
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public boolean isValue() {
        return value;
    }
    
    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 97 * hash + (int) (this.postId ^ (this.postId >>> 32));
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
        final UserLike other = (UserLike) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.postId != other.postId) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ru.tiger.bookprototype.entity.Like[ userId=" + userId + ", postId=" + postId + " ]";
    }  
}
