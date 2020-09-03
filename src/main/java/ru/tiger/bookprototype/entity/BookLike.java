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
    private Long userId;
    @Id
    @Column(name = "BOOK_ID")
    private Long bookId;
    @Column(name = "VALUE")
    private boolean value;

    public BookLike() {}

    public BookLike(long userId, long bookId, boolean value) {
        this.userId = userId;
        this.bookId = bookId;
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
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
