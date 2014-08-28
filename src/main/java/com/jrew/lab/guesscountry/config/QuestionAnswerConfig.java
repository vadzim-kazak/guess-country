package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.questionanswer.CountryLocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.CountryQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
public class QuestionAnswerConfig {

    // Question 1
    @Bean
    public QuestionAnswer question1_en() {
        return new CountryQuestionAnswer("Belarus", "by");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question1_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question1_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 2
    @Bean
    public QuestionAnswer question2_en() {
        return new CountryQuestionAnswer("Russia", "ru");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question2_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question2_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }


    // Question 3
    @Bean
    public QuestionAnswer question3_en() {
        return new CountryQuestionAnswer("Ukraine", "ua");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question3_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question3_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }


    // Question 4
    @Bean
    public QuestionAnswer question4_en() {
        return new CountryQuestionAnswer("Georgia", "ge");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question4_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question4_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 5
    @Bean
    public QuestionAnswer question5_en() {
        return new CountryQuestionAnswer("Poland", "pl");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question5_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question5_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 6
    @Bean
    public QuestionAnswer question6_en() {
        return new CountryQuestionAnswer("Netherlands", "nl");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question6_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question6_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 7
    @Bean
    public QuestionAnswer question7_en() {
        return new CountryQuestionAnswer("Australia", "au");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question7_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question7_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
}

    // Question 8
    @Bean
    public QuestionAnswer question8_en() {
        return new CountryQuestionAnswer("Vietnam", "vn");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question8_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question8_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 9
    @Bean
    public QuestionAnswer question9_en() {
        return new CountryQuestionAnswer("Uganda", "ug");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question9_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question9_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 10
    @Bean
    public QuestionAnswer question10_en() {
        return new CountryQuestionAnswer("Uruguay", "uy");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question10_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question10_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 11
    @Bean
    public QuestionAnswer question11_en() {
        return new CountryQuestionAnswer("Canada", "ca");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question11_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question11_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 12
    @Bean
    public QuestionAnswer question12_en() {
        return new CountryQuestionAnswer("Ecuador", "ec");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question12_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question12_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 13
    @Bean
    public QuestionAnswer question13_en() {
        return new CountryQuestionAnswer("Egypt", "eg");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question13_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question13_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 14
    @Bean
    public QuestionAnswer question14_en() {
        return new CountryQuestionAnswer("Yemen", "ye");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question14_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question14_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 15
    @Bean
    public QuestionAnswer question15_en() {
        return new CountryQuestionAnswer("Nepal", "np");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question15_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question15_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 16
    @Bean
    public QuestionAnswer question16_en() {
        return new CountryQuestionAnswer("Japan", "jp");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question16_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question16_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 17
    @Bean
    public QuestionAnswer question17_en() {
        return new CountryQuestionAnswer("Indonesia", "id");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question17_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question17_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 18
    @Bean
    public QuestionAnswer question18_en() {
        return new CountryQuestionAnswer("Mongolia", "mn");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question18_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question18_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 19
    @Bean
    public QuestionAnswer question19_en() {
        return new CountryQuestionAnswer("Namibia", "na");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question19_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question19_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 20
    @Bean
    public QuestionAnswer question20_en() {
        return new CountryQuestionAnswer("Chad", "td");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question20_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question20_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 21
    @Bean
    public QuestionAnswer question21_en() {
        return new CountryQuestionAnswer("Mexico", "mx");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question21_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question21_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 22
    @Bean
    public QuestionAnswer question22_en() {
        return new CountryQuestionAnswer("Chile", "cl");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question22_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question22_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 23
    @Bean
    public QuestionAnswer question23_en() {
        return new CountryQuestionAnswer("Brazil", "br");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question23_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question23_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 24
    @Bean
    public QuestionAnswer question24_en() {
        return new CountryQuestionAnswer("Argentina", "ar");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question24_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question24_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 25
    @Bean
    public QuestionAnswer question25_en() {
        return new CountryQuestionAnswer("Panama", "pa");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question25_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question25_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 26
    @Bean
    public QuestionAnswer question26_en() {
        return new CountryQuestionAnswer("United States", "us");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question26_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question26_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 27
    @Bean
    public QuestionAnswer question27_en() {
        return new CountryQuestionAnswer("Morocco", "ma");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question27_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question27_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 28
    @Bean
    public QuestionAnswer question28_en() {
        return new CountryQuestionAnswer("Cameroon", "cm");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question28_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question28_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 29
    @Bean
    public QuestionAnswer question29_en() {
        return new CountryQuestionAnswer("Uzbekistan", "uz");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question29_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question29_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 30
    @Bean
    public QuestionAnswer question30_en() {
        return new CountryQuestionAnswer("Kyrgyzstan", "kg");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question30_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question30_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 31
    @Bean
    public QuestionAnswer question31_en() {
        return new CountryQuestionAnswer("Afghanistan", "af");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question31_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question31_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 32
    @Bean
    public QuestionAnswer question32_en() {
        return new CountryQuestionAnswer("Laos", "la");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question32_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question32_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 33
    @Bean
    public QuestionAnswer question33_en() {
        return new CountryQuestionAnswer("Iceland", "is");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question33_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question33_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 34
    @Bean
    public QuestionAnswer question34_en() {
        return new CountryQuestionAnswer("Ireland", "ie");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question34_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question34_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 35
    @Bean
    public QuestionAnswer question35_en() {
        return new CountryQuestionAnswer("United Kingdom", "gb");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question35_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question35_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 36
    @Bean
    public QuestionAnswer question36_en() {
        return new CountryQuestionAnswer("New Zealand", "nz");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question36_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question36_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 37
    @Bean
    public QuestionAnswer question37_en() {
        return new CountryQuestionAnswer("Turkey", "tr");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question37_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question37_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 38
    @Bean
    public QuestionAnswer question38_en() {
        return new CountryQuestionAnswer("Syria", "sy");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question38_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question38_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 39
    @Bean
    public QuestionAnswer question39_en() {
        return new CountryQuestionAnswer("Iraq", "iq");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question39_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question39_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 40
    @Bean
    public QuestionAnswer question40_en() {
        return new CountryQuestionAnswer("Slovakia", "sk");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question40_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question40_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 41
    @Bean
    public QuestionAnswer question41_en() {
        return new CountryQuestionAnswer("Andorra", "ad");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question41_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question41_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    public void getEnglishCountryDomainPairs() {

        List<CountryDomainPair> countries = new ArrayList<>();

        countries.add(new CountryDomainPair("Ascension Island","ac"));
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
        countries.add(new CountryDomainPair("Western Sahara","eh"));
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

    }


    private static class CountryDomainPair {
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




