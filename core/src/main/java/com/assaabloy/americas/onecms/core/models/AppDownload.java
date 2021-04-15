package com.assaabloy.americas.onecms.core.models;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = AppDownload.class)
public class AppDownload {

	private String jsonData;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String heading;
	
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String description;

	@ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
	private List<AppDownloadButtons> items;

	private final Logger LOGGER = LoggerFactory.getLogger(AppDownload.class);

	@PostConstruct
	protected void init() {
		LOGGER.debug("Starting init method of Footer");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = "{\"appDownload\":" + objectMapper.writeValueAsString(this) + "}";
		} catch (JsonProcessingException ex) {
			LOGGER.error("Error in parsing JSON Data for Header component {}", ex.getMessage());
		}

	}

	@JsonIgnore
	public String getJsonData() {
		return jsonData;
	}

	public String getHeading() {
		return heading;
	}
	
	public String getDescription() {
		return description;
	}

	@JsonProperty(value = "cta")
	public List<AppDownloadButtons> getItems() {
		return items;
	}

}