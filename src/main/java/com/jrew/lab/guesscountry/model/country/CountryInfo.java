package com.jrew.lab.guesscountry.model.country;

import com.javadocmd.simplelatlng.LatLng;

/**
 * Created by Kazak_VV on 29.08.2014.
 */
public class CountryInfo {

    /** **/
    private String name;

    /** **/
    private String domain;

    /** **/
    private LatLng center;

    /**
     *
     * @param name
     * @param domain
     */
    public CountryInfo(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    /**
     *
     * @param name
     * @param domain
     * @param center
     */
    public CountryInfo(String name, String domain, LatLng center) {
        this.name = name;
        this.domain = domain;
        this.center = center;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDomain() {
        return domain;
    }

    /**
     *
     * @param domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     *
     * @return
     */
    public LatLng getCenter() {
        return center;
    }

    /**
     *
     * @param center
     */
    public void setCenter(LatLng center) {
        this.center = center;
    }

}
