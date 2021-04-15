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

import java.util.List;
import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code MegaMenuL2} Sling Model used for the multifield in {@code onecms/components/content/mega-enu} component.
 * 
 */
@ConsumerType
public interface MegaMenuL2
    extends ComponentExporter
{


    /**
     * Get the megaMenuItemLabelLevel2.
     * 
     * @return String
     * 
     */
    String getMegaMenuItemLabelLevel2();

    /**
     * Get the megaMenuItemLinkLevel2.
     * 
     * @return String
     * 
     */
    String getMegaMenuItemLinkLevel2();

    /**
     * Get the megaMenuItemDescriptionLevel2.
     * 
     * @return String
     * 
     */
    String getMegaMenuItemDescriptionLevel2();

    /**
     * Get the megaMenuItemsL3.
     * 
     * @return List&lt;MegaMenuL3&gt;
     * 
     */
    List<MegaMenuL3> getMegaMenuItemsL3();

}
