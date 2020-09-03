package ru.tiger.bookprototype.entity;

/**
 *
 * @author Igor
 */
public interface AbstractLikeEntity {
    public void setUserId(Long userId);
    public void setValue(boolean value);
    public boolean getValue();
    public Long getEntityId();
    public void setEntityId(Long entityId);
}
