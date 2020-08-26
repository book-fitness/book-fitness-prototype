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
@IdClass(ArticleLikeId.class)
public class ArticleLike {

    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Id
    @Column(name = "ARTICLE_ID")
    private long articleId;
    @Column(name = "VALUE")
    private boolean value;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
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
        hash = 73 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 73 * hash + (int) (this.articleId ^ (this.articleId >>> 32));
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
        final ArticleLike other = (ArticleLike) obj;
        if (this.articleId != other.articleId) {
            return false;
        }
        return true;
    }
}
