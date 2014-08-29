package com.jrew.lab.guesscountry.config;

import com.javadocmd.simplelatlng.LatLng;
import com.jrew.lab.guesscountry.model.country.CountryInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
public class QuestionAnswerConfig {

    @Bean(name="countriesInfo")
    public List<CountryInfo> getCountriesInfo() {

        List<CountryInfo> countriesInfo = new ArrayList<>();

        countriesInfo.add(new CountryInfo("Andorra", "ad", new LatLng(42.506285, 1.521801)));
        countriesInfo.add(new CountryInfo("United Arab Emirates", "ae", new LatLng(23.424076, 53.847818)));
        countriesInfo.add(new CountryInfo("Afghanistan", "af", new LatLng(33.93911, 67.709953)));
        countriesInfo.add(new CountryInfo("Albania", "al", new LatLng(41.153332, 20.168331)));
        countriesInfo.add(new CountryInfo("Armenia", "am", new LatLng(40.069099, 45.038188999999996)));
        countriesInfo.add(new CountryInfo("Angola", "ao", new LatLng(-11.202691999999999, 17.873887)));
        countriesInfo.add(new CountryInfo("Argentina", "ar", new LatLng(-38.416097, -63.616671)));
        countriesInfo.add(new CountryInfo("Austria", "at", new LatLng(47.516231, 14.550072)));
        countriesInfo.add(new CountryInfo("Australia", "au", new LatLng(-25.274397999999998, 133.775136)));
        countriesInfo.add(new CountryInfo("Azerbaijan", "az", new LatLng(40.143105, 47.576927)));
        countriesInfo.add(new CountryInfo("Bosnia and Herzegovina", "ba", new LatLng(43.915886, 17.679076)));
        countriesInfo.add(new CountryInfo("Barbados", "bb", new LatLng(13.193887, -59.543198)));
        countriesInfo.add(new CountryInfo("Bangladesh", "bd", new LatLng(23.684994, 90.356331)));
        countriesInfo.add(new CountryInfo("Belgium", "be", new LatLng(50.503887, 4.469936)));
        countriesInfo.add(new CountryInfo("Burkina Faso", "bf", new LatLng(12.238332999999999, -1.561593)));
        countriesInfo.add(new CountryInfo("Bulgaria", "bg", new LatLng(42.733883, 25.48583)));
        countriesInfo.add(new CountryInfo("Bahrain", "bh", new LatLng(26.066699999999997, 50.5577)));
        countriesInfo.add(new CountryInfo("Burundi", "bi", new LatLng(-3.373056, 29.918885999999997)));
        countriesInfo.add(new CountryInfo("Benin", "bj", new LatLng(9.30769, 2.3158339999999997)));
        countriesInfo.add(new CountryInfo("Brunei", "bn", new LatLng(4.535277, 114.72766899999999)));
        countriesInfo.add(new CountryInfo("Bolivia", "bo", new LatLng(-16.290153999999998, -63.588651999999996)));
        countriesInfo.add(new CountryInfo("Brazil", "br", new LatLng(-14.235004, -51.92528)));
        countriesInfo.add(new CountryInfo("Bahamas", "bs", new LatLng(25.03428, -77.39627999999999)));
        countriesInfo.add(new CountryInfo("Bhutan", "bt", new LatLng(27.514162, 90.433601)));
        countriesInfo.add(new CountryInfo("Belarus", "by", new LatLng(53.709807, 27.953388999999998)));
        countriesInfo.add(new CountryInfo("Belize", "bz", new LatLng(17.189877, -88.49765)));
        countriesInfo.add(new CountryInfo("Canada", "ca", new LatLng(56.130365999999995, -106.34677099999999)));
        countriesInfo.add(new CountryInfo("Democratic Republic of the Congo", "cd", new LatLng(-4.038333, 21.758664)));
        countriesInfo.add(new CountryInfo("Central African Republic", "cf", new LatLng(6.611110999999999, 20.939443999999998)));
        countriesInfo.add(new CountryInfo("Republic of the Congo", "cg", new LatLng(-0.228021, 15.827658999999999)));
        countriesInfo.add(new CountryInfo("Switzerland", "ch", new LatLng(46.818188, 8.227511)));
        countriesInfo.add(new CountryInfo("Ivory Coast", "ci", new LatLng(7.539988999999999, -5.547079999999999)));
        countriesInfo.add(new CountryInfo("Chile", "cl", new LatLng(-35.675146999999996, -71.542969)));
        countriesInfo.add(new CountryInfo("Cameroon", "cm", new LatLng(7.369721999999999, 12.354721999999999)));
        countriesInfo.add(new CountryInfo("China", "cn", new LatLng(35.86166, 104.195397)));
        countriesInfo.add(new CountryInfo("Colombia", "co", new LatLng(4.570868, -74.297333)));
        countriesInfo.add(new CountryInfo("Costa Rica", "cr", new LatLng(9.748916999999999, -83.753428)));
        countriesInfo.add(new CountryInfo("Cyprus", "cy", new LatLng(35.126413, 33.429859)));
        countriesInfo.add(new CountryInfo("Czech Republic", "cz", new LatLng(49.817491, 15.472961999999999)));
        countriesInfo.add(new CountryInfo("Germany", "de", new LatLng(51.165690999999995, 10.451526)));
        countriesInfo.add(new CountryInfo("Djibouti", "dj", new LatLng(11.825137999999999, 42.590275)));
        countriesInfo.add(new CountryInfo("Denmark", "dk", new LatLng(56.26392, 9.501785)));
        countriesInfo.add(new CountryInfo("Dominican Republic", "do", new LatLng(18.735692999999998, -70.162651)));
        countriesInfo.add(new CountryInfo("Algeria", "dz", new LatLng(28.033886, 1.6596259999999998)));
        countriesInfo.add(new CountryInfo("Ecuador", "ec", new LatLng(-1.8312389999999998, -78.18340599999999)));
        countriesInfo.add(new CountryInfo("Estonia", "ee", new LatLng(58.595271999999994, 25.013607)));
        countriesInfo.add(new CountryInfo("Egypt", "eg", new LatLng(26.820553, 30.802498)));
        countriesInfo.add(new CountryInfo("Eritrea", "er", new LatLng(15.179383999999999, 39.782334)));
        countriesInfo.add(new CountryInfo("Spain", "es", new LatLng(40.463667, -3.7492199999999998)));
        countriesInfo.add(new CountryInfo("Ethiopia", "et", new LatLng(9.145, 40.489672999999996)));
        countriesInfo.add(new CountryInfo("Finland", "fi", new LatLng(61.924108999999994, 25.748151)));
        countriesInfo.add(new CountryInfo("Fiji", "fj", new LatLng(-17.713371, 178.065032)));
        countriesInfo.add(new CountryInfo("France", "fr", new LatLng(46.227638, 2.213749)));
        countriesInfo.add(new CountryInfo("Gabon", "ga", new LatLng(-0.803689, 11.609444)));
        countriesInfo.add(new CountryInfo("United Kingdom", "gb", new LatLng(55.378051, -3.4359729999999997)));
        countriesInfo.add(new CountryInfo("Georgia", "ge", new LatLng(42.315407, 43.356891)));
        countriesInfo.add(new CountryInfo("Ghana", "gh", new LatLng(7.946527, -1.023194)));
        countriesInfo.add(new CountryInfo("Gibraltar", "gi", new LatLng(36.140751, -5.353585)));
        countriesInfo.add(new CountryInfo("Greenland", "gl", new LatLng(71.706936, -42.604303)));
        countriesInfo.add(new CountryInfo("The Gambia", "gm", new LatLng(13.443182, -15.310139)));
        countriesInfo.add(new CountryInfo("Equatorial Guinea", "gq", new LatLng(1.650801, 10.267895)));
        countriesInfo.add(new CountryInfo("Greece", "gr", new LatLng(39.074208, 21.824312)));
        countriesInfo.add(new CountryInfo("Guatemala", "gt", new LatLng(15.783470999999999, -90.23075899999999)));
        countriesInfo.add(new CountryInfo("Guinea-Bissau", "gw", new LatLng(11.803749, -15.180413)));
        countriesInfo.add(new CountryInfo("Guyana", "gy", new LatLng(4.860416, -58.93018)));
        countriesInfo.add(new CountryInfo("Hong Kong", "hk", new LatLng(22.396428, 114.10949699999999)));
        countriesInfo.add(new CountryInfo("Honduras", "hn", new LatLng(15.199999, -86.241905)));
        countriesInfo.add(new CountryInfo("Croatia", "hr", new LatLng(45.1, 15.2)));
        countriesInfo.add(new CountryInfo("Haiti", "ht", new LatLng(18.971187, -72.285215)));
        countriesInfo.add(new CountryInfo("Hungary", "hu", new LatLng(47.162493999999995, 19.503304)));
        countriesInfo.add(new CountryInfo("Indonesia", "id", new LatLng(-0.789275, 113.92132699999999)));
        countriesInfo.add(new CountryInfo("Ireland", "ie", new LatLng(53.41291, -8.24389)));
        countriesInfo.add(new CountryInfo("Israel", "il", new LatLng(31.046051, 34.851611999999996)));
        countriesInfo.add(new CountryInfo("India", "in", new LatLng(20.593684, 78.96288)));
        countriesInfo.add(new CountryInfo("Iraq", "iq", new LatLng(33.223191, 43.679291)));
        countriesInfo.add(new CountryInfo("Iran", "ir", new LatLng(32.427907999999995, 53.688046)));
        countriesInfo.add(new CountryInfo("Iceland", "is", new LatLng(64.96305, -19.020834999999998)));
        countriesInfo.add(new CountryInfo("Italy", "it", new LatLng(41.871939999999995, 12.56738)));
        countriesInfo.add(new CountryInfo("Jamaica", "jm", new LatLng(18.109581, -77.297508)));
        countriesInfo.add(new CountryInfo("Jordan", "jo", new LatLng(30.585164, 36.238414)));
        countriesInfo.add(new CountryInfo("Japan", "jp", new LatLng(36.204823999999995, 138.252924)));
        countriesInfo.add(new CountryInfo("Kenya", "ke", new LatLng(-0.023559, 37.906193)));
        countriesInfo.add(new CountryInfo("Kyrgyzstan", "kg", new LatLng(41.20438, 74.766098)));
        countriesInfo.add(new CountryInfo("Cambodia", "kh", new LatLng(12.565679, 104.990963)));
        countriesInfo.add(new CountryInfo("Democratic People's Republic of Korea", "kp", new LatLng(40.339852, 127.510093)));
        countriesInfo.add(new CountryInfo("Republic of Korea", "kr", new LatLng(35.907757, 127.766922)));
        countriesInfo.add(new CountryInfo("Kuwait", "kw", new LatLng(29.31166, 47.481766)));
        countriesInfo.add(new CountryInfo("Kazakhstan", "kz", new LatLng(48.019573, 66.923684)));
        countriesInfo.add(new CountryInfo("Laos", "la", new LatLng(19.85627, 102.49549599999999)));
        countriesInfo.add(new CountryInfo("Lebanon", "lb", new LatLng(33.854721, 35.862285)));
        countriesInfo.add(new CountryInfo("Liechtenstein", "li", new LatLng(47.166, 9.555373)));
        countriesInfo.add(new CountryInfo("Sri Lanka", "lk", new LatLng(7.873053, 80.77179699999999)));
        countriesInfo.add(new CountryInfo("Liberia", "lr", new LatLng(6.428055, -9.429499)));
        countriesInfo.add(new CountryInfo("Lesotho", "ls", new LatLng(-29.609987999999998, 28.233608)));
        countriesInfo.add(new CountryInfo("Lithuania", "lt", new LatLng(55.169438, 23.881275)));
        countriesInfo.add(new CountryInfo("Luxembourg", "lu", new LatLng(49.815273, 6.129582999999999)));
        countriesInfo.add(new CountryInfo("Latvia", "lv", new LatLng(56.879635, 24.603189)));
        countriesInfo.add(new CountryInfo("Libya", "ly", new LatLng(26.335099999999997, 17.228331)));
        countriesInfo.add(new CountryInfo("Morocco", "ma", new LatLng(31.791701999999997, -7.092619999999999)));
        countriesInfo.add(new CountryInfo("Monaco", "mc", new LatLng(43.738417, 7.424614999999999)));
        countriesInfo.add(new CountryInfo("Moldova", "md", new LatLng(47.411631, 28.369885)));
        countriesInfo.add(new CountryInfo("Montenegro", "me", new LatLng(42.708678, 19.37439)));
        countriesInfo.add(new CountryInfo("Madagascar", "mg", new LatLng(-18.766947, 46.869107)));
        countriesInfo.add(new CountryInfo("Macedonia", "mk", new LatLng(41.608635, 21.745275)));
        countriesInfo.add(new CountryInfo("Mali", "ml", new LatLng(17.570691999999998, -3.9961659999999997)));
        countriesInfo.add(new CountryInfo("Myanmar", "mm", new LatLng(21.913964999999997, 95.956223)));
        countriesInfo.add(new CountryInfo("Mongolia", "mn", new LatLng(46.862496, 103.846656)));
        countriesInfo.add(new CountryInfo("Mauritania", "mr", new LatLng(21.00789, -10.940835)));
        countriesInfo.add(new CountryInfo("Malta", "mt", new LatLng(35.937495999999996, 14.375416)));
        countriesInfo.add(new CountryInfo("Malawi", "mw", new LatLng(-13.254308, 34.301525)));
        countriesInfo.add(new CountryInfo("Mexico", "mx", new LatLng(23.634501, -102.55278399999999)));
        countriesInfo.add(new CountryInfo("Malaysia", "my", new LatLng(4.210484, 101.975766)));
        countriesInfo.add(new CountryInfo("Mozambique", "mz", new LatLng(-18.665695, 35.529562)));
        countriesInfo.add(new CountryInfo("Namibia", "na", new LatLng(-22.957639999999998, 18.49041)));
        countriesInfo.add(new CountryInfo("Niger", "ne", new LatLng(17.607789, 8.081666)));
        countriesInfo.add(new CountryInfo("Nigeria", "ng", new LatLng(9.081999, 8.675277)));
        countriesInfo.add(new CountryInfo("Nicaragua", "ni", new LatLng(12.865416, -85.207229)));
        countriesInfo.add(new CountryInfo("Netherlands", "nl", new LatLng(52.132633, 5.291265999999999)));
        countriesInfo.add(new CountryInfo("Norway", "no", new LatLng(60.472023, 8.468945999999999)));
        countriesInfo.add(new CountryInfo("Nepal", "np", new LatLng(28.394857, 84.12400799999999)));
        countriesInfo.add(new CountryInfo("New Zealand", "nz", new LatLng(-40.900557, 174.88597099999998)));
        countriesInfo.add(new CountryInfo("Oman", "om", new LatLng(21.512583, 55.923255)));
        countriesInfo.add(new CountryInfo("Panama", "pa", new LatLng(8.537981, -80.782127)));
        countriesInfo.add(new CountryInfo("Peru", "pe", new LatLng(-9.189967, -75.015152)));
        countriesInfo.add(new CountryInfo("Papua New Guinea", "pg", new LatLng(-6.314992999999999, 143.95555)));
        countriesInfo.add(new CountryInfo("Philippines", "ph", new LatLng(12.879721, 121.774017)));
        countriesInfo.add(new CountryInfo("Pakistan", "pk", new LatLng(30.375321, 69.34511599999999)));
        countriesInfo.add(new CountryInfo("Poland", "pl", new LatLng(51.919438, 19.145136)));
        countriesInfo.add(new CountryInfo("Puerto Rico", "pr", new LatLng(18.220833, -66.590149)));
        countriesInfo.add(new CountryInfo("Portugal", "pt", new LatLng(39.399871, -8.224454)));
        countriesInfo.add(new CountryInfo("Paraguay", "py", new LatLng(-23.442503, -58.443832)));
        countriesInfo.add(new CountryInfo("Qatar", "qa", new LatLng(25.354826, 51.183884)));
        countriesInfo.add(new CountryInfo("Romania", "ro", new LatLng(45.943160999999996, 24.966759999999997)));
        countriesInfo.add(new CountryInfo("Serbia", "rs", new LatLng(44.016521, 21.005858999999997)));
        countriesInfo.add(new CountryInfo("Russia", "ru", new LatLng(61.52401, 105.318756)));
        countriesInfo.add(new CountryInfo("Rwanda", "rw", new LatLng(-1.940278, 29.873887999999997)));
        countriesInfo.add(new CountryInfo("Saudi Arabia", "sa", new LatLng(23.885942, 45.079162)));
        countriesInfo.add(new CountryInfo("Sudan", "sd", new LatLng(12.862807, 30.217636)));
        countriesInfo.add(new CountryInfo("Sweden", "se", new LatLng(60.128161, 18.643501)));
        countriesInfo.add(new CountryInfo("Singapore", "sg", new LatLng(1.352083, 103.819836)));
        countriesInfo.add(new CountryInfo("Slovenia", "si", new LatLng(46.151241, 14.995462999999999)));
        countriesInfo.add(new CountryInfo("Slovakia", "sk", new LatLng(48.669025999999995, 19.699023999999998)));
        countriesInfo.add(new CountryInfo("Sierra Leone", "sl", new LatLng(8.460555, -11.779888999999999)));
        countriesInfo.add(new CountryInfo("San Marino", "sm", new LatLng(43.94236, 12.457777)));
        countriesInfo.add(new CountryInfo("Senegal", "sn", new LatLng(14.497401, -14.452361999999999)));
        countriesInfo.add(new CountryInfo("Somalia", "so", new LatLng(5.152149, 46.199616)));
        countriesInfo.add(new CountryInfo("Suriname", "sr", new LatLng(3.919305, -56.027783)));
        countriesInfo.add(new CountryInfo("South Sudan", "ss", new LatLng(7.963092, 30.158929999999998)));
        countriesInfo.add(new CountryInfo("El Salvador", "sv", new LatLng(13.794184999999999, -88.89653)));
        countriesInfo.add(new CountryInfo("Syria", "sy", new LatLng(34.802074, 38.996815)));
        countriesInfo.add(new CountryInfo("Swaziland", "sz", new LatLng(-26.522503, 31.465866)));
        countriesInfo.add(new CountryInfo("Chad", "td", new LatLng(15.454165999999999, 18.732207)));
        countriesInfo.add(new CountryInfo("Togo", "tg", new LatLng(8.619543, 0.824782)));
        countriesInfo.add(new CountryInfo("Thailand", "th", new LatLng(15.870032, 100.99254099999999)));
        countriesInfo.add(new CountryInfo("Tajikistan", "tj", new LatLng(38.861034, 71.276093)));
        countriesInfo.add(new CountryInfo("Turkmenistan", "tm", new LatLng(38.969719, 59.556278)));
        countriesInfo.add(new CountryInfo("Tunisia", "tn", new LatLng(33.886917, 9.537499)));
        countriesInfo.add(new CountryInfo("Trinidad and Tobago", "tt", new LatLng(10.691803, -61.222502999999996)));
        countriesInfo.add(new CountryInfo("Taiwan", "tw", new LatLng(23.69781, 120.960515)));
        countriesInfo.add(new CountryInfo("Tanzania", "tz", new LatLng(-6.369028, 34.888822)));
        countriesInfo.add(new CountryInfo("Ukraine", "ua", new LatLng(48.379433, 31.16558)));
        countriesInfo.add(new CountryInfo("Uganda", "ug", new LatLng(1.373333, 32.290275)));
        countriesInfo.add(new CountryInfo("United States of America", "us", new LatLng(37.09024, -95.712891)));
        countriesInfo.add(new CountryInfo("Uruguay", "uy", new LatLng(-32.522779, -55.765834999999996)));
        countriesInfo.add(new CountryInfo("Uzbekistan", "uz", new LatLng(41.377491, 64.585262)));
        countriesInfo.add(new CountryInfo("Venezuela", "ve", new LatLng(6.42375, -66.58973)));
        countriesInfo.add(new CountryInfo("Vietnam", "vn", new LatLng(14.058323999999999, 108.277199)));
        countriesInfo.add(new CountryInfo("Yemen", "ye", new LatLng(15.552726999999999, 48.516388)));
        countriesInfo.add(new CountryInfo("South Africa", "za", new LatLng(-30.559482, 22.937506)));
        countriesInfo.add(new CountryInfo("Zambia", "zm", new LatLng(-13.133897, 27.849332)));
        countriesInfo.add(new CountryInfo("Zimbabwe", "zw", new LatLng(-19.015438, 29.154857)));

        return countriesInfo;
    }
}




