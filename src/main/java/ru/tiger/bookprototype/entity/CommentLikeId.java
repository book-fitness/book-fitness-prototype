package ru.tiger.bookprototype.entity;

/**
 *
 * @author Igor
 */
public class CommentLikeId {

    private long userId;
    private long commentLike;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(long commentLike) {
        this.commentLike = commentLike;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 13 * hash + (int) (this.commentLike ^ (this.commentLike >>> 32));
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
        if (this.commentLike != other.commentLike) {
            return false;
        }
        return true;
    }
}
