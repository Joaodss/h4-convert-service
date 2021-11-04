package com.ironhack.convert.util.validator;

import com.ironhack.convert.util.validator.anotations.ValidCountry;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {

  private final List<String> validCountryAToD = Arrays.asList(
      "AFGHANISTAN", "ALBANIA", "ALGERIA", "AMERICAN SAMOA", "ANDORRA", "ANGOLA", "ANGUILLA", "ANTARCTICA",
      "ANTIGUA & BARBUDA", "ARGENTINA", "ARMENIA", "ARUBA", "AUSTRALIA", "AUSTRIA", "AZERBAIJAN", "ÅLAND ISLANDS",
      "BAHAMAS", "BAHRAIN", "BANGLADESH", "BARBADOS", "BELARUS", "BELGIUM", "BELIZE", "BENIN", "BERMUDA", "BHUTAN",
      "BOLIVIA", "BOSNIA & HERZEGOVINA", "BOTSWANA", "BOUVET ISLAND", "BRAZIL", "BRITISH INDIAN OCEAN TERRITORY",
      "BRITISH VIRGIN ISLANDS", "BRUNEI", "BULGARIA", "BURKINA FASO", "BURUNDI",
      "CAMEROON", "CANADA", "CAPE VERDE", "CARIBBEAN NETHERLANDS", "CAYMAN ISLANDS", "CENTRAL AFRICAN REPUBLIC", "CHAD",
      "CHILE", "CHINA", "CHRISTMAS ISLAND", "COCOS KEELING ISLANDS", "COLOMBIA", "CONGO - BRAZZAVILLE",
      "CONGO - KINSHASA", "COOK ISLANDS", "COSTA RICA", "CROATIA", "CUBA", "CURAÇAO", "CYPRUS", "CZECH REPUBLIC",
      "CÔTE D’IVOIRE", "DENMARK", "DJIBOUTI", "DOMINICA", "DOMINICAN REPUBLIC"
  );

  private final List<String> validCountryEToH = Arrays.asList(
      "ECUADOR", "EGYPT", "EL SALVADOR", "EQUATORIAL GUINEA", "ERITREA", "ESTONIA", "ESWATINI", "ETHIOPIA",
      "FALKLAND ISLANDS", "FAROE ISLANDS", "FIJI", "FINLAND", "FRANCE", "FRENCH GUIANA", "FRENCH POLYNESIA",
      "FRENCH SOUTHERN TERRITORIES", "GABON", "GAMBIA", "GEORGIA", "GERMANY", "GHANA", "GIBRALTAR", "GREECE",
      "GREENLAND", "GRENADA", "GUADELOUPE", "GUAM", "GUATEMALA", "GUERNSEY", "GUINEA", "GUINEA-BISSAU", "GUYANA",
      "HAITI", "HEARD & MCDONALD ISLANDS", "HONDURAS", "HONG KONG SAR CHINA", "HUNGARY"
  );

  private final List<String> validCountryIToN = Arrays.asList(
      "ICELAND", "INDIA", "INDONESIA", "IRAN", "IRAQ", "IRELAND", "ISLE OF MAN", "ISRAEL", "KAZAKHSTAN", "KUWAIT",
      "LAOS", "LATVIA", "LEBANON", "LESOTHO", "LIBERIA", "LIBYA", "LIECHTENSTEIN", "LITHUANIA", "LUXEMBOURG",
      "MACAO SAR CHINA", "MADAGASCAR", "MALAWI", "MALAYSIA", "MALDIVES", "MALI", "MALTA", "MARSHALL ISLANDS",
      "MARTINIQUE", "MAURITANIA", "MAURITIUS", "MAYOTTE", "MEXICO", "MICRONESIA", "MOLDOVA", "MONACO", "MONGOLIA",
      "MONTENEGRO", "MONTSERRAT", "MOROCCO", "MOZAMBIQUE", "MYANMAR BURMA", "NAMIBIA", "NAURU", "NEPAL", "NETHERLANDS",
      "NEW CALEDONIA", "NEW ZEALAND", "NICARAGUA", "NIGER", "NIGERIA", "NIUE", "NORFOLK ISLAND", "NORTH KOREA",
      "NORTH MACEDONIA", "NORTHERN MARIANA ISLANDS", "NORWAY", "NONE"
  );

  private final List<String> validCountryOToT = Arrays.asList(
      "OMAN", "PAKISTAN", "PALAU", "PALESTINIAN TERRITORIES", "PANAMA", "PAPUA NEW GUINEA", "PARAGUAY", "PERU",
      "PHILIPPINES", "PITCAIRN ISLANDS", "POLAND", "PORTUGAL", "PUERTO RICO", "QATAR", "ROMANIA", "RUSSIA", "RWANDA",
      "RÉUNION", "SAMOA", "SAN MARINO", "SAUDI ARABIA", "SENEGAL", "SERBIA", "SEYCHELLES", "SIERRA LEONE", "SINGAPORE",
      "SINT MAARTEN", "SLOVAKIA", "SLOVENIA", "SOLOMON ISLANDS", "SOMALIA", "SOUTH AFRICA",
      "SOUTH GEORGIA & SOUTH SANDWICH ISLANDS", "SOUTH KOREA", "SOUTH SUDAN", "SPAIN", "SRI LANKA", "ST BARTHÉLEMY",
      "ST HELENA", "ST KITTS & NEVIS", "ST LUCIA", "ST MARTIN", "ST PIERRE & MIQUELON", "ST VINCENT & THE GRENADINES",
      "SUDAN", "SURINAME", "SVALBARD & JAN MAYEN", "SWEDEN", "SWITZERLAND", "SYRIA", "SÃO TOMÉ & PRÍNCIPE", "TAIWAN",
      "TAJIKISTAN", "TANZANIA", "THAILAND", "TIMOR-LESTE", "TOGO", "TOKELAU", "TONGA", "TRINIDAD & TOBAGO", "TUNISIA",
      "TURKEY", "TURKMENISTAN", "TURKS & CAICOS ISLANDS", "TUVALU"
  );

  private final List<String> validCountryUToZ = Arrays.asList(
      "UGANDA", "UKRAINE", "UNITED ARAB EMIRATES", "UNITED KINGDOM", "UNITED STATES", "URUGUAY", "US OUTLYING ISLANDS",
      "US VIRGIN ISLANDS", "UZBEKISTAN", "VANUATU", "VATICAN CITY", "VENEZUELA", "VIETNAM", "WALLIS & FUTUNA",
      "WESTERN SAHARA", "YEMEN", "ZAMBIA", "ZIMBABWE"
  );


  @Override
  public void initialize(ValidCountry country) {
  }

  @Override
  public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
    if (country == null) return true;
    if (country.trim().equals("")) return true; // It just checks if it exists.

    // Lists where separated to avoid iterating through the list as a whole.
    char firstLetterUpperCase = country.trim().toUpperCase().charAt(0);
    if (firstLetterUpperCase >= 'A' && firstLetterUpperCase < 'E' || firstLetterUpperCase == 'Å') {
      return validCountryAToD.contains(country.trim().toUpperCase());
    } else if (firstLetterUpperCase >= 'E' && firstLetterUpperCase < 'I') {
      return validCountryEToH.contains(country.trim().toUpperCase());
    } else if (firstLetterUpperCase >= 'I' && firstLetterUpperCase < 'O') {
      return validCountryIToN.contains(country.trim().toUpperCase());
    } else if (firstLetterUpperCase >= 'O' && firstLetterUpperCase < 'U') {
      return validCountryOToT.contains(country.trim().toUpperCase());
    } else if (firstLetterUpperCase >= 'U' && firstLetterUpperCase < 'Z') {
      return validCountryUToZ.contains(country.trim().toUpperCase());
    } else {
      return false;
    }
  }

}
