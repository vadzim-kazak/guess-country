package com.jrew.lab.guesscountry.model.questionanswer;

import com.javadocmd.simplelatlng.LatLng;

/**
 * Created by Kazak_VV on 29.08.2014.
 */
public class CountryInfo {

    /** **/
    private String country;

    /** **/
    private String domain;

    /** **/
    private LatLng center;

    /**
     *
     * @param country
     * @param domain
     */
    public CountryInfo(String country, String domain) {
        this.country = country;
        this.domain = domain;
    }

    /**
     *
     * @param country
     * @param domain
     * @param center
     */
    public CountryInfo(String country, String domain, LatLng center) {
        this.country = country;
        this.domain = domain;
        this.center = center;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
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
