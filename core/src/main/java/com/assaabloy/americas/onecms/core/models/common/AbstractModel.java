package com.assaabloy.americas.onecms.core.models.common;

import org.apache.log4j.Logger;
import org.apache.sling.api.SlingHttpServletRequest;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public abstract class AbstractModel {
    private static Logger log = Logger.getLogger(AbstractModel.class);
    @PostConstruct
    private void initialize() {
        try {
            init();
        } catch (RuntimeException e) {
            log.error("Error initializing model!", e);
        }
    }

    protected abstract void init();

}
