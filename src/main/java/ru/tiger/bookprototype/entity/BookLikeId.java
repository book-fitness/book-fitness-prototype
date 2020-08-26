package ru.tiger.bookprototype.entity;

/**
 *
 * @author Igor
 */
public class BookLikeId {

    private long userId;
    private long bookLike;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookLike() {
        return bookLike;
    }

    public void setBookLike(long bookLike) {
        this.bookLike = bookLike;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 29 * hash + (int) (this.bookLike ^ (this.bookLike >>> 32));
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
        final BookLikeId other = (BookLikeId) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.bookLike != other.bookLike) {
            return false;
        }
        return true;
    } 
}
