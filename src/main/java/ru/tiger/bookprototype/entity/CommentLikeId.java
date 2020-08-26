package ru.tiger.bookprototype.entity;

/**
 *
 * @author Igor
 */
public class CommentLikeId {

    private long userId;
    private long commentLike;

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
