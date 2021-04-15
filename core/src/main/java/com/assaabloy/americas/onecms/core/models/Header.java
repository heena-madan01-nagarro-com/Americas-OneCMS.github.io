/* * *********************************************************************** * ASSA ABLOY Americas CONFIDENTIAL * ___________________ * * Copyright 2021 ASSA ABLOY Americas. * All Rights Reserved. * * NOTICE:  All information contained herein is, and remains the property * of ASSA ABLOY Americas and its suppliers, if any. The intellectual and * technical concepts contained herein are proprietary to ASSA ABLOY Americas * and its suppliers and are protected by trade secret or copyright law. * Dissemination of this information or reproduction of this material * is strictly forbidden unless prior written permission is obtained * from ASSA ABLOY Americas. * *********************************************************************** */package com.assaabloy.americas.onecms.core.models;import java.util.List;import com.adobe.cq.export.json.ComponentExporter;import com.assaabloy.americas.onecms.core.models.impl.NavigationData;import org.osgi.annotation.versioning.ConsumerType;/** * Defines the {@code Header} Sling Model used for the * {@code onecms/components/content/header} component. * */@ConsumerTypepublic interface Header        extends ComponentExporter {     /**     * Get the title.     *      * @return String     *      */    String getTitle();    /**     * Get the description.     *      * @return String     *      */    String getDescription();    /**     * Get the NavigationData.     *      * @return NavigationData     *      */    NavigationData getNavigationData();    BrandData getbrandData();    FeaturedProduct getFeaturedProduct();        String getJsonData();    /**     * Get the navItems.     *     * @return List&lt;NavItems&gt;     *     */    List<NavItems> getNavItems();    /**     * Get the brandLogo.     *     * @return String     *     */    String getBrandLogo();    /**     * Get the brandLogoAltText.     *     * @return String     *     */    String getBrandLogoAltText();    /**     * Get the brandDivision.     *     * @return String     *     */    String getBrandDivision();    /**     * Get the actions.     *     * @return List&lt;ActionIcons&gt;     *     */    List<ActionIcons> getActions();}