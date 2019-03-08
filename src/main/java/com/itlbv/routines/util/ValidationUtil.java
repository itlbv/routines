package com.itlbv.routines.util;

import com.itlbv.routines.model.AbstractBaseEntity;

public class ValidationUtil {

    public static void checkNew(AbstractBaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new (id = null)");
        }
    }

    public static void checkIdConsistency(AbstractBaseEntity entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }

    //TODO rewrite all this checkNotFound mess
    public static <T> T checkNotFound(T entity, int id) {
        if (entity == null) {
            checkNotFound(false, id);
        }
        return entity;
    }

    public static void checkNotFound(boolean found, int id) {
        if (!found) {
            throw new NotFoundException("Not found entity with id=" + id);
        }
    }
}
