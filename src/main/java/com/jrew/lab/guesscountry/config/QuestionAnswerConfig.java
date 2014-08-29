package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.questionanswer.CountryLocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.CountryQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
public class QuestionAnswerConfig {

    @Bean(name="countryDomainPairs")
    public List<CountryDomainPair> getCountryDomainPairs() {

        List<CountryDomainPair> countries = new ArrayList<>();

        countries.add(new CountryDomainPair("Andorra", "ad"));
        countries.add(new CountryDomainPair("United Arab Emirates","ae"));
        countries.add(new CountryDomainPair("Afghanistan", "af"));
        countries.add(new CountryDomainPair("Antigua and Barbuda","ag"));
        countries.add(new CountryDomainPair("Anguilla","ai"));
        countries.add(new CountryDomainPair("Albania","al"));
        countries.add(new CountryDomainPair("Armenia","am"));
        countries.add(new CountryDomainPair("Angola","ao"));
        countries.add(new CountryDomainPair("Argentina","ar"));
        countries.add(new CountryDomainPair("Austria","at"));
        countries.add(new CountryDomainPair("Australia","au"));
        countries.add(new CountryDomainPair("Azerbaijan","az"));
        countries.add(new CountryDomainPair("Bosnia and Herzegovina","ba"));
        countries.add(new CountryDomainPair("Barbados","bb"));
        countries.add(new CountryDomainPair("Bangladesh","bd"));
        countries.add(new CountryDomainPair("Belgium","be"));
        countries.add(new CountryDomainPair("Burkina Faso","bf"));
        countries.add(new CountryDomainPair("Bulgaria","bg"));
        countries.add(new CountryDomainPair("Bahrain","bh"));
        countries.add(new CountryDomainPair("Burundi","bi"));
        countries.add(new CountryDomainPair("Benin","bj"));
        countries.add(new CountryDomainPair("Bermuda","bm"));
        countries.add(new CountryDomainPair("Brunei","bn"));
        countries.add(new CountryDomainPair("Bolivia","bo"));
        countries.add(new CountryDomainPair("Brazil","br"));
        countries.add(new CountryDomainPair("Bahamas","bs"));
        countries.add(new CountryDomainPair("Bhutan","bt"));
        countries.add(new CountryDomainPair("Belarus","by"));
        countries.add(new CountryDomainPair("Belize","bz"));
        countries.add(new CountryDomainPair("Canada","ca"));
        countries.add(new CountryDomainPair("Democratic Republic of the Congo","cd"));
        countries.add(new CountryDomainPair("Central African Republic","cf"));
        countries.add(new CountryDomainPair("Republic of the Congo","cg"));
        countries.add(new CountryDomainPair("Switzerland","ch"));
        countries.add(new CountryDomainPair("Ivory Coast","ci"));
        countries.add(new CountryDomainPair("Chile","cl"));
        countries.add(new CountryDomainPair("Cameroon","cm"));
        countries.add(new CountryDomainPair("China","cn"));
        countries.add(new CountryDomainPair("Colombia","co"));
        countries.add(new CountryDomainPair("Costa Rica","cr"));
        countries.add(new CountryDomainPair("Cyprus","cy"));
        countries.add(new CountryDomainPair("Czech Republic","cz"));
        countries.add(new CountryDomainPair("Germany","de"));
        countries.add(new CountryDomainPair("Djibouti","dj"));
        countries.add(new CountryDomainPair("Denmark","dk"));
        countries.add(new CountryDomainPair("Dominican Republic","do"));
        countries.add(new CountryDomainPair("Algeria","dz"));
        countries.add(new CountryDomainPair("Ecuador","ec"));
        countries.add(new CountryDomainPair("Estonia","ee"));
        countries.add(new CountryDomainPair("Egypt","eg"));
        countries.add(new CountryDomainPair("Eritrea","er"));
        countries.add(new CountryDomainPair("Spain","es"));
        countries.add(new CountryDomainPair("Ethiopia","et"));
        countries.add(new CountryDomainPair("Finland","fi"));
        countries.add(new CountryDomainPair("Fiji","fj"));
        countries.add(new CountryDomainPair("France","fr"));
        countries.add(new CountryDomainPair("Gabon","ga"));
        countries.add(new CountryDomainPair("United Kingdom","gb"));
        countries.add(new CountryDomainPair("Grenada","gd"));
        countries.add(new CountryDomainPair("Georgia","ge"));
        countries.add(new CountryDomainPair("Ghana","gh"));
        countries.add(new CountryDomainPair("Gibraltar","gi"));
        countries.add(new CountryDomainPair("Greenland","gl"));
        countries.add(new CountryDomainPair("The Gambia","gm"));
        countries.add(new CountryDomainPair("Guadeloupe","gp"));
        countries.add(new CountryDomainPair("Equatorial Guinea","gq"));
        countries.add(new CountryDomainPair("Greece","gr"));
        countries.add(new CountryDomainPair("Guatemala","gt"));
        countries.add(new CountryDomainPair("Guinea-Bissau","gw"));
        countries.add(new CountryDomainPair("Guyana","gy"));
        countries.add(new CountryDomainPair("Hong Kong","hk"));
        countries.add(new CountryDomainPair("Honduras","hn"));
        countries.add(new CountryDomainPair("Croatia","hr"));
        countries.add(new CountryDomainPair("Haiti","ht"));
        countries.add(new CountryDomainPair("Hungary","hu"));
        countries.add(new CountryDomainPair("Indonesia","id"));
        countries.add(new CountryDomainPair("Ireland","ie"));
        countries.add(new CountryDomainPair("Israel","il"));
        countries.add(new CountryDomainPair("India","in"));
        countries.add(new CountryDomainPair("Iraq","iq"));
        countries.add(new CountryDomainPair("Iran","ir"));
        countries.add(new CountryDomainPair("Iceland","is"));
        countries.add(new CountryDomainPair("Italy","it"));
        countries.add(new CountryDomainPair("Jamaica","jm"));
        countries.add(new CountryDomainPair("Jordan","jo"));
        countries.add(new CountryDomainPair("Japan","jp"));
        countries.add(new CountryDomainPair("Kenya","ke"));
        countries.add(new CountryDomainPair("Kyrgyzstan","kg"));
        countries.add(new CountryDomainPair("Cambodia","kh"));
        countries.add(new CountryDomainPair("Democratic People's Republic of Korea","kp"));
        countries.add(new CountryDomainPair("Republic of Korea","kr"));
        countries.add(new CountryDomainPair("Kuwait","kw"));
        countries.add(new CountryDomainPair("Kazakhstan","kz"));
        countries.add(new CountryDomainPair("Laos","la"));
        countries.add(new CountryDomainPair("Lebanon","lb"));
        countries.add(new CountryDomainPair("Liechtenstein","li"));
        countries.add(new CountryDomainPair("Sri Lanka","lk"));
        countries.add(new CountryDomainPair("Liberia","lb"));
        countries.add(new CountryDomainPair("Lesotho","ls"));
        countries.add(new CountryDomainPair("Lithuania","lt"));
        countries.add(new CountryDomainPair("Luxembourg","lu"));
        countries.add(new CountryDomainPair("Latvia","lv"));
        countries.add(new CountryDomainPair("Libya","ly"));
        countries.add(new CountryDomainPair("Morocco","ma"));
        countries.add(new CountryDomainPair("Monaco","mc"));
        countries.add(new CountryDomainPair("Moldova","md"));
        countries.add(new CountryDomainPair("Montenegro","me"));
        countries.add(new CountryDomainPair("Madagascar","mg"));
        countries.add(new CountryDomainPair("Macedonia","mk"));
        countries.add(new CountryDomainPair("Mali","ml"));
        countries.add(new CountryDomainPair("Myanmar","mm"));
        countries.add(new CountryDomainPair("Mongolia","mn"));
        countries.add(new CountryDomainPair("Mauritania","mr"));
        countries.add(new CountryDomainPair("Malta","mt"));
        countries.add(new CountryDomainPair("Malawi","mw"));
        countries.add(new CountryDomainPair("Mexico","mx"));
        countries.add(new CountryDomainPair("Malaysia","my"));
        countries.add(new CountryDomainPair("Mozambique","mz"));
        countries.add(new CountryDomainPair("Namibia","na"));
        countries.add(new CountryDomainPair("Niger","ne"));
        countries.add(new CountryDomainPair("Nigeria","ng"));
        countries.add(new CountryDomainPair("Nicaragua","ni"));
        countries.add(new CountryDomainPair("Netherlands","nl"));
        countries.add(new CountryDomainPair("Norway","no"));
        countries.add(new CountryDomainPair("Nepal","np"));
        countries.add(new CountryDomainPair("New Zealand","nz"));
        countries.add(new CountryDomainPair("Oman","om"));
        countries.add(new CountryDomainPair("Panama","pa"));
        countries.add(new CountryDomainPair("Peru","pe"));
        countries.add(new CountryDomainPair("Papua New Guinea","pg"));
        countries.add(new CountryDomainPair("Philippines","ph"));
        countries.add(new CountryDomainPair("Pakistan","pk"));
        countries.add(new CountryDomainPair("Poland","pl"));
        countries.add(new CountryDomainPair("Puerto Rico","pr"));
        countries.add(new CountryDomainPair("Palestine","ps"));
        countries.add(new CountryDomainPair("Portugal","pt"));
        countries.add(new CountryDomainPair("Paraguay","py"));
        countries.add(new CountryDomainPair("Qatar","qa"));
        countries.add(new CountryDomainPair("Romania","ro"));
        countries.add(new CountryDomainPair("Serbia","rs"));
        countries.add(new CountryDomainPair("Russia","ru"));
        countries.add(new CountryDomainPair("Rwanda","rw"));
        countries.add(new CountryDomainPair("Saudi Arabia","sa"));
        countries.add(new CountryDomainPair("Sudan","sd"));
        countries.add(new CountryDomainPair("Sweden","sw"));
        countries.add(new CountryDomainPair("Singapore","sg"));
        countries.add(new CountryDomainPair("Slovenia","si"));
        countries.add(new CountryDomainPair("Slovakia","sk"));
        countries.add(new CountryDomainPair("Sierra Leone","sl"));
        countries.add(new CountryDomainPair("San Marino","sm"));
        countries.add(new CountryDomainPair("Senegal","sn"));
        countries.add(new CountryDomainPair("Somalia","so"));
        countries.add(new CountryDomainPair("Suriname","sr"));
        countries.add(new CountryDomainPair("South Sudan","ss"));
        countries.add(new CountryDomainPair("El Salvador","sv"));
        countries.add(new CountryDomainPair("Syria","sy"));
        countries.add(new CountryDomainPair("Swaziland","sz"));
        countries.add(new CountryDomainPair("Chad","td"));
        countries.add(new CountryDomainPair("Togo","tg"));
        countries.add(new CountryDomainPair("Thailand","th"));
        countries.add(new CountryDomainPair("Tajikistan","tj"));
        countries.add(new CountryDomainPair("Turkmenistan","tm"));
        countries.add(new CountryDomainPair("Tunisia","tn"));
        countries.add(new CountryDomainPair("Tonga","to"));
        countries.add(new CountryDomainPair("Trinidad and Tobago","tt"));
        countries.add(new CountryDomainPair("Taiwan","tw"));
        countries.add(new CountryDomainPair("Tanzania","tz"));
        countries.add(new CountryDomainPair("Ukraine","ua"));
        countries.add(new CountryDomainPair("Uganda","ug"));
        countries.add(new CountryDomainPair("United States of America","us"));
        countries.add(new CountryDomainPair("Uruguay","uy"));
        countries.add(new CountryDomainPair("Uzbekistan","uz"));
        countries.add(new CountryDomainPair("Venezuela","ve"));
        countries.add(new CountryDomainPair("Vietnam","vn"));
        countries.add(new CountryDomainPair("Yemen","ye"));
        countries.add(new CountryDomainPair("South Africa","za"));
        countries.add(new CountryDomainPair("Zambia","zm"));
        countries.add(new CountryDomainPair("Zimbabwe","zw"));

        return countries;
    }

    /**
     *
     */
    public static class CountryDomainPair {
        private String country;
        private String domain;

        private CountryDomainPair(String country, String domain) {
            this.country = country;
            this.domain = domain;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }

}




