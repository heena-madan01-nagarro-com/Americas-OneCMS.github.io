/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assaabloy.americas.onecms.core.models.impl;

import com.assaabloy.americas.onecms.core.models.NavItems;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author anshuljain01
 */
public class NavigationData {

    @JsonProperty("navItems")
    private List<NavItems> navItems;

    public List<NavItems> getNavItems() {
        return navItems;
    }

    public void setNavItems(List<NavItems> navItems) {
        this.navItems = navItems;
    }

}
