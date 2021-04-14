package com.assaabloy.americas.onecms.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CarouselSlides {

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cardVariant;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hoverEffect;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String fileName;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String fileReference;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String altText;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String onHoverFileReference;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaText;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaPath;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaTheme;

    private List<Cta> ctaList;

    private final Logger logger = LoggerFactory.getLogger(CarouselModel.class);

    @PostConstruct
    protected void init() {
        logger.info("Starting init method of CarouselSlide");
        generateCtaJson();
        logger.info("Exiting init method of CarouselSlide");
    }

    private void generateCtaJson() {
        ctaList = new ArrayList<>();
        Cta cta = new Cta();
        cta.setCtaPath(ctaPath != null ? ctaPath : StringUtils.EMPTY);
        cta.setCtaText(ctaText != null ? ctaText : StringUtils.EMPTY);
        cta.setCtaTheme(ctaTheme != null ? ctaTheme : StringUtils.EMPTY);
        ctaList.add(cta);
    }

    public String getCardVariant() {
        return cardVariant;
    }

    public String getHoverEffect() {
        return hoverEffect;
    }

    @JsonIgnore
    public String getFileName() {
        return fileName;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getAltText() {
        return altText;
    }

    public String getOnHoverFileReference() {
        return onHoverFileReference;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public String getCtaText() {
        return ctaText;
    }

    @JsonIgnore
    public String getCtaPath() {
        return ctaPath;
    }

    @JsonIgnore
    public String getCtaTheme() {
        return ctaTheme;
    }

    @JsonProperty(value = "cta")
    public List<Cta> getCtaList() {
        return ctaList;
    }

}
