package ro.dutylabs.mpp.core.service;

import ro.dutylabs.mpp.core.model.Entity;

import java.util.List;

/**
 * Created by cosmin on 11/06/2017.
 */
public interface EntityService {
    List<Entity> findAll();
    Entity createEntity(String name);
    Entity findOne(Long id);
    Entity updateEntity(Long id, String name);
    void deleteEntity(Long id);
}
