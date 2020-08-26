package ru.tiger.bookprototype.entity;

/**
 *
 * @author Igor
 */
public class UserLikeId {

    private long userId;
    private long postId;

    public UserLikeId() {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 79 * hash + (int) (this.postId ^ (this.postId >>> 32));
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
        final UserLikeId other = (UserLikeId) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.postId != other.postId) {
            return false;
        }
        return true;
    }
    
    
}
