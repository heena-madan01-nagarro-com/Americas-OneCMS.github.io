package com.assaabloy.americas.onecms.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ActionCard {

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

	@ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
	private List<ActionCardCta> ctaItems;

	public String getCardVariant() {
		return cardVariant;
	}

	public String getHoverEffect() {

		return hoverEffect;
	}

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

	@JsonProperty(value = "cta")
	public List<ActionCardCta> getCtaItems() {
		return ctaItems;
	}

}