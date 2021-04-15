package com.assaabloy.americas.onecms.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ActionCardCta {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String ctaText;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String ctaPath;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String ctaType;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String ctaTheme;

	public String getCtaText() {
		return ctaText;
	}

	public String getCtaPath() {
		return ctaPath;
	}

	public String getCtaType() {
		return ctaType;
	}

	public String getCtaTheme() {
		return ctaTheme;
	}

}
