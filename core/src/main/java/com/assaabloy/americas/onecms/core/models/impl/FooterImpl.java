/* * *********************************************************************** * ASSA ABLOY Americas Sites Project CONFIDENTIAL * ___________________ * * Copyright 2021 ASSA ABLOY Americas Sites Project. * All Rights Reserved. * * NOTICE:  All information contained herein is, and remains the property * of ASSA ABLOY Americas Sites Project and its suppliers, if any. The intellectual and * technical concepts contained herein are proprietary to ASSA ABLOY Americas Sites Project * and its suppliers and are protected by trade secret or copyright law. * Dissemination of this information or reproduction of this material * is strictly forbidden unless prior written permission is obtained * from ASSA ABLOY Americas Sites Project. * *********************************************************************** */package com.assaabloy.americas.onecms.core.models.impl;import java.util.Collections;import java.util.List;import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;import com.adobe.cq.export.json.ComponentExporter;import com.adobe.cq.export.json.ExporterConstants;import com.assaabloy.americas.onecms.core.models.CopyrightLink;import com.assaabloy.americas.onecms.core.models.Footer;import com.fasterxml.jackson.annotation.JsonIgnore;import com.fasterxml.jackson.annotation.JsonProperty;import com.fasterxml.jackson.core.JsonProcessingException;import com.fasterxml.jackson.databind.ObjectMapper;import javax.annotation.PostConstruct;import org.apache.commons.lang3.StringUtils;import org.apache.sling.api.SlingHttpServletRequest;import org.apache.sling.api.resource.Resource;import org.apache.sling.models.annotations.Exporter;import org.apache.sling.models.annotations.Model;import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;import org.apache.sling.models.annotations.injectorspecific.SlingObject;import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import com.assaabloy.americas.onecms.core.models.Column;@Model(adaptables = {    SlingHttpServletRequest.class}, adapters = {    Footer.class,    ComponentExporter.class}, resourceType = "onecms/components/content/footer")@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)public class FooterImpl    implements Footer {    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)    private List<Column> footerColumns;    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)    private List<CopyrightLink> copyrightLinks;    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)    private String copyrightLogo;        @SlingObject    private Resource resource;        private String jsonData;    private final Logger LOGGER = LoggerFactory.getLogger(FooterImpl.class);        @PostConstruct    protected void init() {        LOGGER.debug("Starting init method of Footer");            ObjectMapper objectMapper = new ObjectMapper();        try {              jsonData = "{\"footer\":"+objectMapper.writeValueAsString(this)+ "}";         } catch (JsonProcessingException ex) {            LOGGER.error("Error in parsing JSON Data for Footer component {}",ex.getMessage());        }        LOGGER.debug("Exiting init method of Footer");    }    @JsonIgnore    @Override    public String getJsonData() {        return jsonData;    }    @Override    @JsonProperty(value = "footerLinks")    public List<Column> getFooterColumns() {        return footerColumns != null ? Collections.unmodifiableList(footerColumns) : null;    }    @Override    public String getCopyrightLogo() {        return copyrightLogo;    }    @Override    public List<CopyrightLink> getCopyrightLinks() {        return copyrightLinks != null ? Collections.unmodifiableList(copyrightLinks) : null;    }    @Override    @JsonIgnore    public String getExportedType() {        return resource.getResourceType();    }}