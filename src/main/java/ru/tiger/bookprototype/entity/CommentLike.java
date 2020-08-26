package ru.tiger.bookprototype.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Igor
 */
@Entity
@IdClass(CommentLikeId.class)
public class CommentLike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Id
    @Column(name = "COMMENT_ID")
    private long commentId;
    @Column(name = "VALUE")
    private boolean value;
    @Column(name = "PARENT_ID")
    private long parentId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCommentId() {
        return commentId;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 19 * hash + (int) (this.commentId ^ (this.commentId >>> 32));
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
        final CommentLike other = (CommentLike) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.commentId != other.commentId) {
            return false;
        }
        return true;
    }
}
