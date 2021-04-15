package com.assaabloy.americas.onecms.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SocialLinks {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String fileName;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String fileReference;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String altText;


	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String socialLinkUrl;

	public String getFileName() {
		return fileName;
	}

	public String getFileReference() {
		return fileReference;
	}

	public String getAltText() {
		return altText;
	}



	public String getSocialLinkUrl() {
		return socialLinkUrl;
	}

}