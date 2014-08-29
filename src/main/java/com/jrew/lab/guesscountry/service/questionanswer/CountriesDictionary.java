package com.jrew.lab.guesscountry.service.questionanswer;

import com.jrew.lab.guesscountry.model.questionanswer.CountryInfo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Kazak_VV on 29.08.2014.
 */
public interface CountriesDictionary {

    /**
     *
     * @return
     */
    public List<CountryInfo> getCountriesInfo();

    /**
     *
     * @param value
     * @return
     */
    public Optional<CountryInfo> getCountryInfo(String value);

}
