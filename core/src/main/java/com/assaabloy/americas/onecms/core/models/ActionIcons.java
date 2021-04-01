/*
 * ***********************************************************************
 * ASSA ABLOY Americas CONFIDENTIAL
 * ___________________
 *
 * Copyright 2021 ASSA ABLOY Americas.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of ASSA ABLOY Americas and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to ASSA ABLOY Americas
 * and its suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from ASSA ABLOY Americas.
 * ***********************************************************************
 */

package com.assaabloy.americas.onecms.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code ActionIcons} Sling Model used for the multifield in {@code onecms/components/content/header} component.
 * 
 */
@ConsumerType
public interface ActionIcons
    extends ComponentExporter
{


    /**
     * Get the iconUrl.
     * 
     * @return String
     * 
     */
    String getIconUrl();

    /**
     * Get the iconAltText.
     * 
     * @return String
     * 
     */
    String getIconAltText();

    /**
     * Get the iconTooltipText.
     * 
     * @return String
     * 
     */
    String getIconTooltipText();

}
