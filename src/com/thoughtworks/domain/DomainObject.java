package com.thoughtworks.domain;

import java.io.Serializable;

public abstract class DomainObject implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj.getClass() == this.getClass()) {
            if (this.id == null) return super.equals(obj);
            if (this.id.equals(((DomainObject) obj).id)) return true;
        }
        return false;
    }

    public String toString() {
        return this.getClass().getName() + ":id=" + id;
    }
}