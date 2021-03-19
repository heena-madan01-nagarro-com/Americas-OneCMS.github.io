/*
 * ***********************************************************************
 * ASSA ABLOY Americas Sites Project CONFIDENTIAL
 * ___________________
 *
 * Copyright 2021 ASSA ABLOY Americas Sites Project.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of ASSA ABLOY Americas Sites Project and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to ASSA ABLOY Americas Sites Project
 * and its suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from ASSA ABLOY Americas Sites Project.
 * ***********************************************************************
 */

package com.assaabloy.americas.onecms.core.models;

import java.util.List;
import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code FooterColumn} Sling Model used for the multifield in {@code onecms/components/content/footer} component.
 * 
 */
@ConsumerType
public interface FooterColumn
    extends ComponentExporter
{


    String getHeader();

    String getHeaderLink();

    List<FooterLink> getFooterLinks();

}