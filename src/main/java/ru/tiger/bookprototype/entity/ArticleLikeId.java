package ru.tiger.bookprototype.entity;

import java.io.Serializable;

/**
 *
 * @author Igor
 */
public class ArticleLikeId implements Serializable {
    private long userId;
    private long articleId;

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
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 19 * hash + (int) (this.articleId ^ (this.articleId >>> 32));
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
        final ArticleLikeId other = (ArticleLikeId) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.articleId != other.articleId) {
            return false;
        }
        return true;
    }
}
