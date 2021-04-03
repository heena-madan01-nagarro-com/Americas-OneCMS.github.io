package com.assaabloy.americas.onecms.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(adaptables = SlingHttpServletRequest.class, resourceType = "onecms/components/heroImage")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = HeroImage.class)
public class HeroImage {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	// @Self
	// private Resource resource;

	 @Self
	 private SlingHttpServletRequest request;

	 @OSGiService
	 private ModelFactory modelFactory;

	private String jsonData;

	
	@Optional @ValueMapValue
	private String fileName;

	
	@Optional @ValueMapValue
	private String fileReference;

	
	@Optional @ValueMapValue
	private String altText;

	
	@ValueMapValue
	private String title;

	
	@ValueMapValue
	private String description;

	@ValueMapValue
	private String ctaText;

	@ValueMapValue
	private String ctaPath;

	@ValueMapValue
	private String alignment;

	private Image image;

	private String src;

	@PostConstruct
	protected void init() {
		 LOG.debug("Inside INIT");
		 image = modelFactory.getModelFromWrappedRequest(request,
		 request.getResource(), Image.class);
		 LOG.debug("Request " + request);
		 LOG.debug("Request resource " + request.getResource());
		 LOG.debug("Image is " + image);
		 
		 final Image componentImage = getImage();
			LOG.debug("Image " + componentImage);
			src = componentImage.getSrc();
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
		return src;
	}

	public String getFileReference() {
		return fileReference;
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

	@JsonIgnore
	private Image getImage() {
		return image;
	}

	@JsonIgnore
	public String getSrc() {		
		return src;
	}

}