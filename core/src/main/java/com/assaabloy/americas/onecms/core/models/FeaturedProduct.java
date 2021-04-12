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

/**
 *
 * /**
 * Defines the {@code FeaturedProduct} Sling Model used for the FeaturedProduct in {@code onecms/components/content/header} component.
 * 
 */
 
public class FeaturedProduct {

    private String title;
    private String description;
    private String imageUrl;
    private String productUrl;
    private String target;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
