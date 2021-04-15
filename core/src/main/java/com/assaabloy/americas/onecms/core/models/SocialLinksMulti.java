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

@Model(adaptables = SlingHttpServletRequest.class,  resourceType = "onecms/components/socialLinks")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = SocialLinksMulti.class)
public class SocialLinksMulti {

	private String jsonData;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String socialLinksHeading;

	@ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
	private List<SocialLinks> items;

	private final Logger LOGGER = LoggerFactory.getLogger(SocialLinksMulti.class);

	@PostConstruct
	protected void init() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = "{\"socialLinks\":" + objectMapper.writeValueAsString(this) + "}";
		} catch (JsonProcessingException ex) {
			LOGGER.error("Error in parsing JSON Data for Header component {}", ex.getMessage());
		}

	}

	@JsonIgnore
	public String getJsonData() {
		return jsonData;
	}

	public String getSocialLinksHeading() {
		return socialLinksHeading;
	}

	@JsonProperty(value = "socialLinkItems")
	public List<SocialLinks> getItems() {
		return items != null ? Collections.unmodifiableList(items) : null;
	}

}