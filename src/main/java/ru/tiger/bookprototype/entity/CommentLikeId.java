package ru.tiger.bookprototype.entity;

import java.io.Serializable;

/**
 *
 * @author Igor
 */
public class CommentLikeId implements Serializable {

    private long userId;
    private long commentId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCommentLike() {
        return commentId;
    }

    public void setCommentLike(long commentLike) {
        this.commentId = commentLike;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 13 * hash + (int) (this.commentId ^ (this.commentId >>> 32));
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
        final CommentLikeId other = (CommentLikeId) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.commentId != other.commentId) {
            return false;
        }
        return true;
    }
}
