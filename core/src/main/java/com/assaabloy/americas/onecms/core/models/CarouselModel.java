package com.assaabloy.americas.onecms.core.models;

import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, resourceType = "onecms/components/content/carousel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CarouselModel {

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    @JsonProperty(value = "autoSlide")
    boolean autoplay;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    String delay;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    String carouselTitle;

    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
    List<CarouselSlides> carouselComponents;

    @SlingObject
    private Resource resource;

    private String jsonData;

    private final Logger logger = LoggerFactory.getLogger(CarouselModel.class);

    @PostConstruct
    protected void init() {
        logger.info("Starting init method of CarouselModel");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonData = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            logger.error("Error in parsing JSON Data for CarouselModel component {}", ex.getMessage());
        }
        logger.info("Exiting init method of CarouselModel");
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    @JsonProperty(value = "title")
    public String getCarouselTitle() {
        return carouselTitle;
    }

    @JsonProperty(value = "slideInterval")
    public String getDelay() {
        return delay;
    }

    @JsonProperty(value = "carouselList")
    public List<CarouselSlides> getCarouselComponents() {
        return carouselComponents;
    }

    @JsonIgnore
    public String getJsonData() {
        return jsonData;
    }

    @JsonIgnore
    public String getExportedType() {
        return resource.getResourceType();
    }

}
