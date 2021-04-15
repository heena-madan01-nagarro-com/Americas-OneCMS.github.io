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
 * Defines the {@code MegaMenuItem} Sling Model used for the multifield in {@code onecms/components/content/mega-enu} component.
 * 
 */
@ConsumerType
public interface MegaMenuItem
    extends ComponentExporter
{


    /**
     * Get the megaMenuItemLabelLevel1.
     * 
     * @return String
     * 
     */
    String getMegaMenuItemLabelLevel1();

    /**
     * Get the megaMenuItemLinkLevel1.
     * 
     * @return String
     * 
     */
    String getMegaMenuItemLinkLevel1();

    /**
     * Get the megaMenuItemDescriptionLevel1.
     * 
     * @return String
     * 
     */
    String getMegaMenuItemDescriptionLevel1();

    /**
     * Get the megaMenuItemsL2.
     * 
     * @return List&lt;MegaMenuL2&gt;
     * 
     */
    List<MegaMenuL2> getMegaMenuItemsL2();

}
