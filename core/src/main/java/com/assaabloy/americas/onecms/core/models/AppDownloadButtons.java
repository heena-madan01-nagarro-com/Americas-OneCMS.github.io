package com.assaabloy.americas.onecms.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class AppDownloadButtons {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String fileName;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String fileReference;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String altText;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String downloadDescription;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String ctaText;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String ctaLink;

	public String getFileName() {
		return fileName;
	}

	public String getFileReference() {
		return fileReference;
	}

	public String getAltText() {
		return altText;
	}

	public String getDownloadDescription() {
		return downloadDescription;
	}

	public String getCtaText() {
		return ctaText;
	}

	public String getCtaLink() {
		return ctaLink;
	}

	
	
}