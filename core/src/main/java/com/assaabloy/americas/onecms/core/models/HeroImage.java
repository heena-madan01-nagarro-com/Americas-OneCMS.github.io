package com.assaabloy.americas.onecms.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.adobe.cq.export.json.ExporterConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(adaptables = Resource.class, resourceType = "onecms/components/heroImage")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = HeroImage.class)
public class HeroImage {

	//private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Self
	private Resource resource;

	private String jsonData;

	@Inject
	@Optional
	private String fileName;

	@Inject
	@Optional
	private String altText;

	@Inject
	@Required
	private String title;

	@Inject
	@Required
	private String description;

	@Inject
	@Required
	private String ctaText;

	@Inject
	@Required
	private String ctaPath;

	@Inject
	@Required
	private String alignment;

	@PostConstruct
	protected void init() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = objectMapper.writeValueAsString(this);

		} catch (JsonProcessingException ex) {

		}
	}

	@JsonIgnore
	public String getJsonData() {
		return jsonData;
	}

	public String getFileName() {
		return fileName;
	}

	public String getAltText() {
		return altText;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getCtaText() {
		return ctaText;
	}

	public String getCtaPath() {
		return ctaPath;
	}

	public String getAlignment() {
		return alignment;
	}

}