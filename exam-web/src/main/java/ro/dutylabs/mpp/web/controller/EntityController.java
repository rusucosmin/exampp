package ro.dutylabs.mpp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.dutylabs.mpp.core.model.Entity;
import ro.dutylabs.mpp.core.service.EntityService;
import ro.dutylabs.mpp.web.converter.EntityConverter;
import ro.dutylabs.mpp.web.dto.EntitiesDto;
import ro.dutylabs.mpp.web.dto.EntityDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cosmin on 11/06/2017.
 */
@RestController
public class EntityController {
    @Autowired
    private EntityService entityService;
    @Autowired
    private EntityConverter entityConverter;

    private static final Logger log = LoggerFactory.getLogger(EntityController.class);

    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public EntitiesDto getAll() {
        log.trace("EntityController::getAll()");
        return new EntitiesDto(entityConverter.convertModelsToDtos(entityService.findAll()));
    }

    @RequestMapping(value = "/entities", method = RequestMethod.POST)
    public Map<String, EntityDto> createEntity(@RequestBody final Map<String, EntityDto> map) {
        log.trace("EntityController::createEntity()");
        EntityDto entityDto = map.get("entity");
        Entity entity = entityService.createEntity(entityDto.getName());
        log.trace("created: " + entity.getName());
        Map<String, EntityDto> res = new HashMap<>();
        res.put("entity", entityConverter.convertModelToDto(entity));
        return res;
    }
}
