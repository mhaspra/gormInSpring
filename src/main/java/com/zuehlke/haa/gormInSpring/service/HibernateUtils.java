package com.zuehlke.haa.gormInSpring.service;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

public class HibernateUtils {
  public static <T> T uwrapIfProxy(T entity) {
    if (entity == null) {
      return null;
    }

    Hibernate.initialize(entity);
    if (entity instanceof HibernateProxy) {
      //noinspection unchecked
      entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
    }
    return entity;
  }
}
