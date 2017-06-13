package ro.dutylabs.mpp.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.dutylabs.mpp.core.model.Entity;
import ro.dutylabs.mpp.core.repository.EntityRepository;

import java.util.List;

/**
 * Created by cosmin on 11/06/2017.
 */
@Service
public class EntityServiceImpl implements EntityService {

    private static final Logger log = LoggerFactory.getLogger(EntityServiceImpl.class);

    @Autowired
    private EntityRepository entityRepository;

    @Override
    public List<Entity> findAll() {
        return entityRepository.findAll();
    }

    @Override
    public Entity createEntity(String name) {
        Entity now = Entity.builder()
                .name(name)
                .build();
        now = entityRepository.save(now);
        return now;
    }

    @Override
    public Entity findOne(Long id) {
        return entityRepository.findOne(id);
    }

    @Override
    @Transactional
    public Entity updateEntity(Long id, String name) {
        Entity now = entityRepository.getOne(id);
        entityRepository.findOne(id);
        now.setName(name);
        return now;
    }

    @Override
    public void deleteEntity(Long id) {
        entityRepository.delete(id);
    }
}
