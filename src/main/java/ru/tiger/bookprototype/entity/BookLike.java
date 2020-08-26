package ru.tiger.bookprototype.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Igor
 */
@Entity
@IdClass(BookLikeId.class)
public class BookLike {

    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Id
    @Column(name = "BOOK_ID")
    private long bookId;
    @Column(name = "VALUE")
    private boolean value;

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

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 67 * hash + (int) (this.bookId ^ (this.bookId >>> 32));
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
        final BookLike other = (BookLike) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.bookId != other.bookId) {
            return false;
        }
        return true;
    }
}
