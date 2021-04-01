/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assaabloy.americas.onecms.core.models;

import java.util.List;

/**
 *
 * @author anshuljain01
 */
public class BrandData {

    private String brandLogo;
    private String brandLogoAltText;
    private String brandDivision;
    private List<ActionIcons> actions;

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandLogoAltText() {
        return brandLogoAltText;
    }

    public void setBrandLogoAltText(String brandLogoAltText) {
        this.brandLogoAltText = brandLogoAltText;
    }

    public String getBrandDivision() {
        return brandDivision;
    }

    public void setBrandDivision(String brandDivision) {
        this.brandDivision = brandDivision;
    }

    public List<ActionIcons> getActions() {
        return actions;
    }

    public void setActions(List<ActionIcons> actions) {
        this.actions = actions;
    }


}
