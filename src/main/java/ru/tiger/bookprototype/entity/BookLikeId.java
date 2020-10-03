package ru.tiger.bookprototype.entity;

import java.io.Serializable;

/**
 *
 * @author Igor
 */
public class BookLikeId implements Serializable {

    private long userId;
    private long bookId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 29 * hash + (int) (this.bookId ^ (this.bookId >>> 32));
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
        if (this.bookId != other.bookId) {
            return false;
        }
        return true;
    } 
}
