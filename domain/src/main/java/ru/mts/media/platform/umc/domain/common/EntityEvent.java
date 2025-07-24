package ru.mts.media.platform.umc.domain.common;

import lombok.Data;

import java.util.Optional;

@Data
public abstract class EntityEvent<T> {
    private T entity;

    protected EntityEvent() {}

    public EntityEvent(T entity) {
        this.entity = entity;
    }

    public Optional<T> unwrap() {
        return Optional.ofNullable(entity);
    }
}
