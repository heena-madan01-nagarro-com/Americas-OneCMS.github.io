package com.assaabloy.americas.onecms.core.models;

import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;


@Model(adaptables = SlingHttpServletRequest.class, resourceType = "onecms/components/content/card")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ActionCardMulti {

	private String jsonData;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private int cardColumns;

	@ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)

	private List<ActionCard> products;

	private final Logger LOGGER = LoggerFactory.getLogger(ActionCardMulti.class);

	@PostConstruct
	protected void init() {
		LOGGER.debug("Starting init method of Footer");

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = "{\"card\":" + objectMapper.writeValueAsString(this) + "}";
		} catch (JsonProcessingException ex) {
			LOGGER.error("Error in parsing JSON Data for Header component {}", ex.getMessage());
		}
		LOGGER.debug("Exiting init method of Footer");
		LOGGER.debug("Count is " + cardColumns);
	}

	@JsonIgnore
	public String getJsonData() {
		return jsonData;
	}

	@JsonProperty(value = "cardItems")
	public List<ActionCard> getProducts() {
		return products != null ? Collections.unmodifiableList(products) : null;
	}

	public int getCardColumns() {
		return cardColumns;
	}

}