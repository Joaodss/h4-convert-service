package com.ironhack.convert.util.validator;

import com.ironhack.convert.util.validator.anotations.ValidCountry;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {

  private final List<String> validCountryAToD = List.of(
      "ANDORRA", "AFGHANISTAN", "ANTIGUA & BARBUDA", "ANTIGUA AND BARBUDA", "ANGUILLA",
      "ALBANIA", "ARMENIA", "ANGOLA", "ANTARCTICA", "ARGENTINA", "ALGERIA", "AMERICAN SAMOA", "AUSTRIA",
      "AUSTRALIA", "ARUBA", "ÅLAND ISLANDS", "ALAND ISLANDS", "AZERBAIJAN", "BOSNIA & HERZEGOVINA", "BOSNIA AND HERZEGOVINA", "BARBADOS",
      "BANGLADESH", "BELGIUM", "BURKINA FASO", "BULGARIA", "BAHRAIN", "BURUNDI", "BENIN", "BRITISH INDIAN OCEAN TERRITORY",
      "BERMUDA", "BRUNEI", "BOLIVIA", "CARIBBEAN NETHERLANDS", "BRAZZAVILLE", "BRAZIL", "BAHAMAS", "BHUTAN", "BOUVET ISLAND",
      "BOTSWANA", "BELARUS", "BELIZE", "BRITISH VIRGIN ISLANDS", "CANADA", "COCOS (KEELING) ISLANDS", "COCOS ISLANDS", "CONGO - KINSHASA", "CONGO", "CENTRAL AFRICAN REPUBLIC",
      "CONGO - BRAZZAVILLE", "CÔTE D’IVOIRE", "COTE D IVOIRE", "COOK ISLANDS", "CHILE", "CAMEROON", "CHINA", "CROATIA", "CAMBODIA", "COMOROS",
      "COLOMBIA", "COSTA RICA", "CUBA", "CAPE VERDE", "CURAÇAO", "CURACAO", "CHRISTMAS ISLAND", "CYPRUS", "CZECH REPUBLIC", "CAYMAN ISLANDS", "CHAD",
      "DJIBOUTI", "DENMARK", "DOMINICA", "DOMINICAN REPUBLIC");

  private final List<String> validCountryEToH = List.of(
      "ECUADOR", "ESTONIA", "EGYPT", "ERITREA", "ETHIOPIA", "EL SALVADOR", "ESWATINI", "FINLAND", "FIJI", "FALKLAND ISLANDS",
      "FAROE ISLANDS", "FRANCE", "GABON", "GRENADA", "GEORGIA", "FRENCH GUIANA", "FRENCH POLYNESIA", "FRENCH SOUTHERN TERRITORIES",
      "GUERNSEY", "GHANA", "GIBRALTAR", "GREENLAND", "GAMBIA", "GUINEA", "GUADELOUPE", "EQUATORIAL GUINEA", "GERMANY",
      "GREECE", "GUATEMALA", "GUAM", "GUINEA-BISSAU", "GUYANA", "HONG KONG SAR CHINA", "HEARD & MCDONALD ISLANDS",
      "HEARD AND MCDONALD ISLANDS", "HONDURAS", "HAITI", "HUNGARY");

  private final List<String> validCountryIToN = List.of(
      "INDONESIA", "IRELAND", "ISRAEL", "ISLE OF MAN", "INDIA", "IRAQ", "IRAN", "ICELAND",
      "ITALY", "JERSEY", "JAMAICA", "JORDAN", "JAPAN", "KENYA", "KEELING", "KINSHASA", "KYRGYZSTAN", "KIRIBATI",
      "KUWAIT", "KAZAKHSTAN", "LAOS", "LEBANON", "LIBERIA", "LESOTHO", "LITHUANIA", "LUXEMBOURG", "LATVIA", "LIBYA", "LIECHTENSTEIN",
      "MOROCCO", "MONACO", "MOLDOVA", "MONTENEGRO", "MADAGASCAR", "MARSHALL ISLANDS", "MALI", "MYANMAR (BURMA)", "MONGOLIA", "MACAO SAR CHINA",
      "MONTSERRAT", "MALTA", "MAURITIUS", "MALDIVES", "MALAWI", "MEXICO", "MALAYSIA", "MOZAMBIQUE", "MARTINIQUE", "MAURITANIA", "MAYOTTE",
      "MICRONESIA", "NORTH KOREA", "NORTH MACEDONIA", "NORTHERN MARIANA ISLANDS", "NAMIBIA", "NIUE", "NEW ZEALAND",
      "NEW CALEDONIA", "NIGER", "NORFOLK ISLAND", "NIGERIA", "NICARAGUA", "NETHERLANDS", "NORWAY", "NEPAL", "NAURU"
  );

  private final List<String> validCountryOToT = List.of(
      "OMAN", "PANAMA", "PERU", "PAPUA NEW GUINEA", "PHILIPPINES", "PAKISTAN", "POLAND", "PITCAIRN ISLANDS", "PUERTO RICO",
      "PALESTINIAN TERRITORIES", "PORTUGAL", "PALAU", "PARAGUAY", "QATAR", "RÉUNION", "ROMANIA", "SERBIA", "RUSSIA", "RWANDA",
      "ST KITTS & NEVIS", "ST KITTS AND NEVIS", "SOUTH KOREA", "ST LUCIA", "SRI LANKA", "ST MARTIN", "ST PIERRE & MIQUELON",
      "ST PIERRE AND MIQUELON", "SAUDI ARABIA", "SOLOMON ISLANDS", "SEYCHELLES", "SUDAN", "SENEGAL", "SOMALIA", "SURINAME",
      "SOUTH SUDAN", "ST VINCENT & THE GRENADINES", "ST VINCENT AND THE GRENADINES",
      "SWEDEN", "SINGAPORE", "ST HELENA", "SLOVENIA", "SVALBARD & JAN MAYEN", "SVALBARD AND JAN MAYEN", "SLOVAKIA", "SIERRA LEONE", "SAN MARINO",
      "SÃO TOMÉ & PRÍNCIPE", "SÃO TOMÉ AND PRÍNCIPE", "SINT MAARTEN", "SYRIA", "SAMOA", "SOUTH AFRICA", "SPAIN", "SWITZERLAND", "ST BARTHÉLEMY",
      "SOUTH GEORGIA & SOUTH SANDWICH ISLANDS", "TURKS & CAICOS ISLANDS", "SOUTH GEORGIA AND SOUTH SANDWICH ISLANDS",
      "TURKS AND CAICOS ISLANDS", "TOGO", "THAILAND", "TAJIKISTAN", "TANZANIA", "TOKELAU", "TIMOR-LESTE", "TURKMENISTAN",
      "TUNISIA", "TONGA", "TURKEY", "TRINIDAD & TOBAGO", "TRINIDAD AND TOBAGO", "TUVALU", "TAIWAN"
  );


  private final List<String> validCountryUToZ = List.of(
      "UNITED KINGDOM", "UNITED ARAB EMIRATES", "UKRAINE", "UGANDA", "US OUTLYING ISLANDS", "UNITED STATES", "URUGUAY", "UZBEKISTAN",
      "US VIRGIN ISLANDS", "VATICAN CITY", "VENEZUELA", "VIETNAM", "VANUATU", "WALLIS & FUTUNA", "WESTERN SAHARA", "US",
      "WALLIS AND FUTUNA", "YEMEN", "ZAMBIA", "ZIMBABWE"
  );


  @Override
  public void initialize(ValidCountry country) {
  }

  @Override
  public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
    if (country == null) return true;
    if (country.isBlank()) return true; // It just checks if it exists.

    // Lists where separated to avoid iterating through the list as a whole.
    var firstLetterUpperCase = country.toUpperCase().charAt(0);
    if (firstLetterUpperCase >= 'A' && firstLetterUpperCase < 'E') {
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
