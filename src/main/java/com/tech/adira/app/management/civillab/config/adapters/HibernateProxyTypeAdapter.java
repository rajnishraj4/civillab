package com.tech.adira.app.management.civillab.config.adapters;

import com.google.gson.*;
import org.hibernate.proxy.HibernateProxy;

import java.lang.reflect.Type;

public class HibernateProxyTypeAdapter implements JsonSerializer<HibernateProxy> {
    @Override
    public JsonElement serialize(HibernateProxy proxy, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(proxy.getHibernateLazyInitializer().getImplementation());
    }
}