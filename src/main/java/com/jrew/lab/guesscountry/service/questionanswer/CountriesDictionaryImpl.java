package com.jrew.lab.guesscountry.service.questionanswer;

import com.jrew.lab.guesscountry.model.country.CountryInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kazak_VV on 29.08.2014.
 */
@Component
public class CountriesDictionaryImpl implements CountriesDictionary {

    /** **/
    @Resource
    private List<CountryInfo> countriesInfo;

    @Override
    public List<CountryInfo> getCountriesInfo() {
        return countriesInfo;
    }

    @Override
    public Optional<CountryInfo> getCountryInfo(String value) {

        Optional<CountryInfo> countryInfoOptional = countriesInfo.stream().filter(countryInfo -> {
            if (countryInfo.getName().equalsIgnoreCase(value) ||
                    countryInfo.getDomain().equalsIgnoreCase(value)) {
                return true;
            }

            return false;
        }).findFirst();

        return countryInfoOptional;
    }
}
