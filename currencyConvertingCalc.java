import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class currencyConvertingCalc {
	public static void main(String[] args) throws ClassCastException {
		/*
		 * Maven dependency for JSON-simple: <dependency>
		 * <groupId>com.googlecode.json-simple</groupId>
		 * <artifactId>json-simple</artifactId> <version>1.1.1</version> </dependency>
		 */
		Boolean choice = true;
		do { 
			HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

			// Add currency codes
			currencyCodes.put(1, "AED");
			currencyCodes.put(2, "AFN");
			currencyCodes.put(3, "ALL");
			currencyCodes.put(4, "AMD");
			currencyCodes.put(5, "ANG");
			currencyCodes.put(6, "AOA");
			currencyCodes.put(7, "ARS");
			currencyCodes.put(8, "AUD");
			currencyCodes.put(9, "AWG");
			currencyCodes.put(10, "AZN");
			currencyCodes.put(11, "BAM");
			currencyCodes.put(12, "BBD");
			currencyCodes.put(13, "BDT");
			currencyCodes.put(14, "BGN");
			currencyCodes.put(15, "BHD");
			currencyCodes.put(16, "BIF");
			currencyCodes.put(17, "BMD");
			currencyCodes.put(18, "BND");
			currencyCodes.put(19, "BOB");
			currencyCodes.put(20, "BRL");
			currencyCodes.put(21, "BSD");
			currencyCodes.put(22, "BTN");
			currencyCodes.put(23, "BWP");
			currencyCodes.put(24, "BYN");
			currencyCodes.put(25, "BZD");
			currencyCodes.put(26, "CAD");
			currencyCodes.put(27, "CDF");
			currencyCodes.put(28, "CHF");
			currencyCodes.put(29, "CLP");
			currencyCodes.put(30, "CNY");
			currencyCodes.put(31, "COP");
			currencyCodes.put(32, "CRC");
			currencyCodes.put(33, "CUP");
			currencyCodes.put(34, "CVE");
			currencyCodes.put(35, "CZK");
			currencyCodes.put(36, "DJF");
			currencyCodes.put(37, "DKK");
			currencyCodes.put(38, "DOP");
			currencyCodes.put(39, "DZD");
			currencyCodes.put(40, "EGP");
			currencyCodes.put(41, "ERN");
			currencyCodes.put(42, "ETB");
			currencyCodes.put(43, "EUR");
			currencyCodes.put(44, "FJD");
			currencyCodes.put(45, "FKP");
			currencyCodes.put(46, "FOK");
			currencyCodes.put(47, "GBP");
			currencyCodes.put(48, "GEL");
			currencyCodes.put(49, "GGP");
			currencyCodes.put(50, "GHS");
			currencyCodes.put(51, "GIP");
			currencyCodes.put(52, "GMD");
			currencyCodes.put(53, "GNF");
			currencyCodes.put(54, "GTQ");
			currencyCodes.put(55, "GYD");
			currencyCodes.put(56, "HKD");
			currencyCodes.put(57, "HNL");
			currencyCodes.put(58, "HRK");
			currencyCodes.put(59, "HTG");
			currencyCodes.put(60, "HUF");
			currencyCodes.put(61, "IDR");
			currencyCodes.put(62, "ILS");
			currencyCodes.put(63, "IMP");
			currencyCodes.put(64, "INR");
			currencyCodes.put(65, "IQD");
			currencyCodes.put(66, "IRR");
			currencyCodes.put(67, "ISK");
			currencyCodes.put(68, "JEP");
			currencyCodes.put(69, "JMD");
			currencyCodes.put(70, "JOD");
			currencyCodes.put(71, "JPY");
			currencyCodes.put(72, "KES");
			currencyCodes.put(73, "KGS");
			currencyCodes.put(74, "KHR");
			currencyCodes.put(75, "KID");
			currencyCodes.put(76, "KMF");
			currencyCodes.put(77, "KRW");
			currencyCodes.put(78, "KWD");
			currencyCodes.put(79, "KYD");
			currencyCodes.put(80, "KZT");
			currencyCodes.put(81, "LAK");
			currencyCodes.put(82, "LBP");
			currencyCodes.put(83, "LKR");
			currencyCodes.put(84, "LRD");
			currencyCodes.put(85, "LSL");
			currencyCodes.put(86, "LYD");
			currencyCodes.put(87, "MAD");
			currencyCodes.put(88, "MDL");
			currencyCodes.put(89, "MGA");
			currencyCodes.put(90, "MKD");
			currencyCodes.put(91, "MMK");
			currencyCodes.put(92, "MNT");
			currencyCodes.put(93, "MOP");
			currencyCodes.put(94, "MRU");
			currencyCodes.put(95, "MUR");
			currencyCodes.put(96, "MVR");
			currencyCodes.put(97, "MWK");
			currencyCodes.put(98, "MXN");
			currencyCodes.put(99, "MYR");
			currencyCodes.put(100, "MZN");
			currencyCodes.put(101, "NAD");
			currencyCodes.put(102, "NGN");
			currencyCodes.put(103, "NIO");
			currencyCodes.put(104, "NOK");
			currencyCodes.put(105, "NPR");
			currencyCodes.put(106, "NZD");
			currencyCodes.put(107, "OMR");
			currencyCodes.put(108, "PAB");
			currencyCodes.put(109, "PEN");
			currencyCodes.put(110, "PGK");
			currencyCodes.put(111, "PHP");
			currencyCodes.put(112, "PKR");
			currencyCodes.put(113, "PLN");
			currencyCodes.put(114, "PYG");
			currencyCodes.put(115, "QAR");
			currencyCodes.put(116, "RON");
			currencyCodes.put(117, "RSD");
			currencyCodes.put(118, "RUB");
			currencyCodes.put(119, "RWF");
			currencyCodes.put(120, "SAR");
			currencyCodes.put(121, "SBD");
			currencyCodes.put(122, "SCR");
			currencyCodes.put(123, "SDG");
			currencyCodes.put(124, "SEK");
			currencyCodes.put(125, "SGD");
			currencyCodes.put(126, "SHP");
			currencyCodes.put(127, "SLL");
			currencyCodes.put(128, "SOS");
			currencyCodes.put(129, "SRD");
			currencyCodes.put(130, "SSP");
			currencyCodes.put(131, "STN");
			currencyCodes.put(132, "SYP");
			currencyCodes.put(133, "SZL");
			currencyCodes.put(134, "THB");
			currencyCodes.put(135, "TJS");
			currencyCodes.put(136, "TMT");
			currencyCodes.put(137, "TND");
			currencyCodes.put(138, "TOP");
			currencyCodes.put(139, "TRY");
			currencyCodes.put(140, "TTD");
			currencyCodes.put(141, "TVD");
			currencyCodes.put(142, "TWD");
			currencyCodes.put(143, "TZS");
			currencyCodes.put(144, "UAH");
			currencyCodes.put(145, "UGX");
			currencyCodes.put(146, "USD");
			currencyCodes.put(147, "UYU");
			currencyCodes.put(148, "UZS");
			currencyCodes.put(149, "VES");
			currencyCodes.put(150, "VND");
			currencyCodes.put(151, "VUV");
			currencyCodes.put(152, "WST");
			currencyCodes.put(153, "XAF");
			currencyCodes.put(154, "XCD");
			currencyCodes.put(155, "XDR");
			currencyCodes.put(156, "XOF");
			currencyCodes.put(157, "XPF");
			currencyCodes.put(158, "YER");
			currencyCodes.put(159, "ZAR");
			currencyCodes.put(160, "ZMW");
			currencyCodes.put(161, "ZWL");

			Integer from;
			Integer to;
			String fromCurrency;
			String toCurrency;
			double amount;

			Scanner input = new Scanner(System.in);

			System.out.println("Welcome to the Currency Converter: ");
			System.out.println("Please type a number next to the Currency name to select the Associated Currency:");
			System.out.println();
			System.out.println("Currency you would like to convert from?");

			System.out.println("1:UAE Dirham\n" + " 2: Afghan Afghani\n" + " 3: Albanian Lek\n" + " 4: Armenian Dram\n"
					+ " 5: Netherlands Antillian Guilder\n" + " 6: Angolan Kwanza\n" + " 7: Argentine Peso\n"
					+ " 8: Australian Dollar\n" + " 9: Aruban Florin\n" + "10: Azerbaijani Manat\n"
					+ "11: Bosnia and Herzegovina Mark\n" + "12: Barbados Dollar\n" + "13: Bangladeshi Taka\n"
					+ "14: Bulgarian Lev\n" + "15: Bahraini Dinar\n" + "16: Burundian Franc\n"
					+ "17: Bermudian Dollar\n" + "18: Brunei Dollar\n" + "19: Bolivian Boliviano\n"
					+ "20: Brazilian Real\n" + "21: Bahamian Dollar\n" + "22: Bhutanese Ngultrum\n"
					+ "23: Botswana Pula\n" + "24: Belarusian Ruble\n" + "25: Belize Dollar\n" + "26: Canadian Dollar\n"
					+ "27: Congolese Franc\n" + "28: Swiss Franc\n" + "29: Chilean Peso\n" + "30: Chinese Renminbi\n"
					+ "31: Colombian Peso\n" + "32: Costa Rican Colon\n" + "33: Cuban Peso\n"
					+ "34: Cape Verdean Escudo\n" + "35: Czech Koruna\n" + "36: Djiboutian Franc\n"
					+ "37: Danish Krone\n" + "38: Dominican Peso\n" + "39: Algerian Dinar\n" + "40: Egyptian Pound\n"
					+ "41: Eritrean Nakfa\n" + "42: Ethiopian Birr\n" + "43: Euro\n" + "44: Fiji Dollar\n"
					+ "45: Falkland Islands Pound\n" + "46: Faroese Króna\n" + "47: Pound Sterling\n"
					+ "48: Georgian Lari\n" + "49: Guernsey Pound\n" + "50: Ghanaian Cedi\n" + "51: Gibraltar Pound\n"
					+ "52: Gambian Dalasi\n" + "53: Guinean Franc\n" + "54: Guatemalan Quetzal\n"
					+ "55: Guyanese Dollar\n" + "56: Hong Kong Dollar\n" + "57: Honduran Lempira\n"
					+ "58: Croatian Kuna\n" + "59: Haitian Gourde\n" + "60: Hungarian Forint\n"
					+ "61: Indonesian Rupiah\n" + "62: Israeli New Shekel\n" + "63: Manx Pound\n" + "64: Indian Rupee\n"
					+ "65: Iraqi Dinar\n" + "66: Iranian Rial\n" + "67: Icelandic Króna\n" + "68: Jersey Pound\n"
					+ "69: Jamaican Dollar\n" + "70: Jordanian Dinar\n" + "71: Japanese Yen\n" + "72: Kenyan Shilling\n"
					+ "73: Kyrgyzstani Som\n" + "74: Cambodian Riel\n" + "75: Kiribati Dollar\n"
					+ "76: Comorian Franc\n" + "77: South Korean Won\n" + "78: Kuwaiti Dinar\n"
					+ "79: Cayman Islands Dollar\n" + "80: Kazakhstani Tenge\n" + "81: Lao Kip\n"
					+ "82: Lebanese Pound\n" + "83: Sri Lanka Rupee\n" + "84: Liberian Dollar\n" + "85: Lesotho Loti\n"
					+ "86: Libyan Dinar\n" + "87: Moroccan Dirham\n" + "88: Moldovan Leu\n" + "89: Malagasy Ariary\n"
					+ "90: Macedonian Denar\n" + "91: Burmese Kyat\n" + "92: Mongolian Tögrög\n"
					+ "93: Macanese Pataca\n" + "94 :Mauritanian Ouguiya\n" + "95: Mauritian Rupee\n"
					+ "96: Maldivian Rufiyaa\n" + "97: Malawian Kwacha\n" + "98: Mexican Peso\n"
					+ "99: Malaysian Ringgit\n" + "100: Mozambican Metical\n" + "101: Namibian Dollar\n"
					+ "102: Nigerian Naira\n" + "103: Nicaraguan Córdoba\n" + "104: Norwegian Krone\n"
					+ "105: Nepalese Rupee\n" + "106: New Zealand Dollar\n" + "107: Omani Rial\n"
					+ "108: Panamanian Balboa\n" + "109: Peruvian Sol\n" + "110: Papua New Guinean Kina\n"
					+ "111: Philippine Peso\n" + "112: Pakistani Rupee\n" + "113: Polish Złoty\n"
					+ "114: Paraguayan Guaraní\n" + "115: Qatari Riyal\n" + "116: Romanian Leu\n"
					+ "117: Serbian Dinar\n" + "118: Russian Ruble\n" + "119: Rwandan Franc\n" + "120: Saudi Riyal\n"
					+ "121: Solomon Islands Dollar\n" + "122: Seychellois Rupee\n" + "123: Sudanese Pound\n"
					+ "124: Swedish Krona\n" + "125: Singapore Dollar\n" + "126: Saint Helena Pound\n"
					+ "127: Sierra Leonean Leone\n" + "128: Somali Shilling\n" + "129: Surinamese Dollar\n"
					+ "130: South Sudanese Pound\n" + "131: São Tomé and Príncipe Dobra\n" + "132: Syrian Pound\n"
					+ "133: Eswatini Lilangeni\n" + "134: Thai Baht\n" + "135: Tajikistani Somoni\n"
					+ "136: Turkmenistan Manat\n" + "137: Tunisian Dinar\n" + "138: Tongan Paʻanga\n"
					+ "139: Turkish Lira\n" + "140: Trinidad and Tobago Dollar\n" + "141: Tuvaluan Dollar\n"
					+ "142: New Taiwan Dollar\n" + "143: Tanzanian Shilling\n" + "144: Ukrainian Hryvnia\n"
					+ "145: Ugandan Shilling\n" + "146: United States Dollar\n" + "147: Uruguayan Peso\n"
					+ "148: Uzbekistani So'm\n" + "149: Venezuelan Bolívar Soberano\n" + "150: Vietnamese Đồng\n"
					+ "151: Vanuatu Vatu\n" + "152: Samoan Tālā\n" + "153: Central African CFA Franc\n"
					+ "154: East Caribbean Dollar\n" + "155: Special Drawing Rights\n" + "156: West African CFA franc\n"
					+ "157: CFP Franc\n" + "158: Yemeni Rial\n" + "159: South African Rand\n" + "160: Zambian Kwacha\n"
					+ "161: Zimbabwean Dollar\n" + "\n");

			from = input.nextInt();
			while (from < 1 || from > 161) {
				System.out.println("Please Select a Valid Currency Option (1-161)");
				System.out.println("1: UAE Dirham \n" + " 2: Afghan Afghani\n" + " 3: Albanian Lek\n"
						+ " 4: Armenian Dram\n" + " 5: Netherlands Antillian Guilder\n" + " 6: Angolan Kwanza\n"
						+ " 7: Argentine Peso\n" + " 8: Australian Dollar\n" + "9: Aruban Florin\n"
						+ "10: Azerbaijani Manat\n" + "11: Bosnia and Herzegovina Mark\n" + "12: Barbados Dollar\n"
						+ "13: Bangladeshi Taka\n" + "14: Bulgarian Lev\n" + "15: Bahraini Dinar\n"
						+ "16: Burundian Franc\n" + "17: Bermudian Dollar\n" + "18: Brunei Dollar\n"
						+ "19: Bolivian Boliviano\n" + "20: Brazilian Real\n" + "21: Bahamian Dollar\n"
						+ "22: Bhutanese Ngultrum\n" + "23: Botswana Pula\n" + "24: Belarusian Ruble\n"
						+ "25: Belize Dollar\n" + "26: Canadian Dollar\n" + "27: Congolese Franc\n"
						+ "28: Swiss Franc\n" + "29: Chilean Peso\n" + "30: Chinese Renminbi\n" + "31: Colombian Peso\n"
						+ "32: Costa Rican Colon\n" + "33: Cuban Peso\n" + "34: Cape Verdean Escudo\n"
						+ "35: Czech Koruna\n" + "36: Djiboutian Franc\n" + "37: Danish Krone\n"
						+ "38: Dominican Peso\n" + "39: Algerian Dinar\n" + "40: Egyptian Pound\n"
						+ "41: Eritrean Nakfa\n" + "42: Ethiopian Birr\n" + "43: Euro\n" + "44: Fiji Dollar\n"
						+ "45: Falkland Islands Pound\n" + "46: Faroese Króna\n" + "47: Pound Sterling\n"
						+ "48: Georgian Lari\n" + "49: Guernsey Pound\n" + "50: Ghanaian Cedi\n"
						+ "51: Gibraltar Pound\n" + "52: Gambian Dalasi\n" + "53: Guinean Franc\n"
						+ "54: Guatemalan Quetzal\n" + "55: Guyanese Dollar\n" + "56: Hong Kong Dollar\n"
						+ "57: Honduran Lempira\n" + "58: Croatian Kuna\n" + "59: Haitian Gourde\n"
						+ "60: Hungarian Forint\n" + "61: Indonesian Rupiah\n" + "62: Israeli New Shekel\n"
						+ "63: Manx Pound\n" + "64: Indian Rupee\n" + "65: Iraqi Dinar\n" + "66: Iranian Rial\n"
						+ "67: Icelandic Króna\n" + "68: Jersey Pound\n" + "69: Jamaican Dollar\n"
						+ "70: Jordanian Dinar\n" + "71: Japanese Yen\n" + "72: Kenyan Shilling\n"
						+ "73: Kyrgyzstani Som\n" + "74: Cambodian Riel\n" + "75: Kiribati Dollar\n"
						+ "76: Comorian Franc\n" + "77: South Korean Won\n" + "78: Kuwaiti Dinar\n"
						+ "79: Cayman Islands Dollar\n" + "80: Kazakhstani Tenge\n" + "81: Lao Kip\n"
						+ "82: Lebanese Pound\n" + "83: Sri Lanka Rupee\n" + "84: Liberian Dollar\n"
						+ "85: Lesotho Loti\n" + "86: Libyan Dinar\n" + "87: Moroccan Dirham\n" + "88: Moldovan Leu\n"
						+ "89: Malagasy Ariary\n" + "90: Macedonian Denar\n" + "91: Burmese Kyat\n"
						+ "92: Mongolian Tögrög\n" + "93: Macanese Pataca\n" + "94 :Mauritanian Ouguiya\n"
						+ "95: Mauritian Rupee\n" + "96: Maldivian Rufiyaa\n" + "97: Malawian Kwacha\n"
						+ "98: Mexican Peso\n" + "99: Malaysian Ringgit\n" + "100: Mozambican Metical\n"
						+ "101: Namibian Dollar\n" + "102: Nigerian Naira\n" + "103: Nicaraguan Córdoba\n"
						+ "104: Norwegian Krone\n" + "105: Nepalese Rupee\n" + "106: New Zealand Dollar\n"
						+ "107: Omani Rial\n" + "108: Panamanian Balboa\n" + "109: Peruvian Sol\n"
						+ "110: Papua New Guinean Kina\n" + "111: Philippine Peso\n" + "112: Pakistani Rupee\n"
						+ "113: Polish Złoty\n" + "114: Paraguayan Guaraní\n" + "115: Qatari Riyal\n"
						+ "116: Romanian Leu\n" + "117: Serbian Dinar\n" + "118: Russian Ruble\n"
						+ "119: Rwandan Franc\n" + "120: Saudi Riyal\n" + "121: Solomon Islands Dollar\n"
						+ "122: Seychellois Rupee\n" + "123: Sudanese Pound\n" + "124: Swedish Krona\n"
						+ "125: Singapore Dollar\n" + "126: Saint Helena Pound\n" + "127: Sierra Leonean Leone\n"
						+ "128: Somali Shilling\n" + "129: Surinamese Dollar\n" + "130: South Sudanese Pound\n"
						+ "131: São Tomé and Príncipe Dobra\n" + "132: Syrian Pound\n" + "133: Eswatini Lilangeni\n"
						+ "134: Thai Baht\n" + "135: Tajikistani Somoni\n" + "136: Turkmenistan Manat\n"
						+ "137: Tunisian Dinar\n" + "138: Tongan Paʻanga\n" + "139: Turkish Lira\n"
						+ "140: Trinidad and Tobago Dollar\n" + "141: Tuvaluan Dollar\n" + "142: New Taiwan Dollar\n"
						+ "143: Tanzanian Shilling\n" + "144: Ukrainian Hryvnia\n" + "145: Ugandan Shilling\n"
						+ "146: United States Dollar\n" + "147: Uruguayan Peso\n" + "148: Uzbekistani So'm\n"
						+ "149: Venezuelan Bolívar Soberano\n" + "150: Vietnamese Đồng\n" + "151: Vanuatu Vatu\n"
						+ "152: Samoan Tālā\n" + "153: Central African CFA Franc\n" + "154: East Caribbean Dollar\n"
						+ "155: Special Drawing Rights\n" + "156: West African CFA franc\n" + "157: CFP Franc\n"
						+ "158: Yemeni Rial\n" + "159: South African Rand\n" + "160: Zambian Kwacha\n"
						+ "161: Zimbabwean Dollar\n" + "\n");
				from = input.nextInt();
			}

			fromCurrency = currencyCodes.get(from);

			System.out.println("Currency converting TO?");
			System.out.println("1: UAE Dirham\n" + " 2: Afghan Afghani\n" + " 3: Albanian Lek\n" + " 4: Armenian Dram\n"
					+ " 5: Netherlands Antillian Guilder\n" + " 6: Angolan Kwanza\n" + " 7: Argentine Peso\n"
					+ " 8: Australian Dollar\n" + "9: Aruban Florin\n" + "10: Azerbaijani Manat\n"
					+ "11: Bosnia and Herzegovina Mark\n" + "12: Barbados Dollar\n" + "13: Bangladeshi Taka\n"
					+ "14: Bulgarian Lev\n" + "15: Bahraini Dinar\n" + "16: Burundian Franc\n"
					+ "17: Bermudian Dollar\n" + "18: Brunei Dollar\n" + "19: Bolivian Boliviano\n"
					+ "20: Brazilian Real\n" + "21: Bahamian Dollar\n" + "22: Bhutanese Ngultrum\n"
					+ "23: Botswana Pula\n" + "24: Belarusian Ruble\n" + "25: Belize Dollar\n" + "26: Canadian Dollar\n"
					+ "27: Congolese Franc\n" + "28: Swiss Franc\n" + "29: Chilean Peso\n" + "30: Chinese Renminbi\n"
					+ "31: Colombian Peso\n" + "32: Costa Rican Colon\n" + "33: Cuban Peso\n"
					+ "34: Cape Verdean Escudo\n" + "35: Czech Koruna\n" + "36: Djiboutian Franc\n"
					+ "37: Danish Krone\n" + "38: Dominican Peso\n" + "39: Algerian Dinar\n" + "40: Egyptian Pound\n"
					+ "41: Eritrean Nakfa\n" + "42: Ethiopian Birr\n" + "43: Euro\n" + "44: Fiji Dollar\n"
					+ "45: Falkland Islands Pound\n" + "46: Faroese Króna\n" + "47: Pound Sterling\n"
					+ "48: Georgian Lari\n" + "49: Guernsey Pound\n" + "50: Ghanaian Cedi\n" + "51: Gibraltar Pound\n"
					+ "52: Gambian Dalasi\n" + "53: Guinean Franc\n" + "54: Guatemalan Quetzal\n"
					+ "55: Guyanese Dollar\n" + "56: Hong Kong Dollar\n" + "57: Honduran Lempira\n"
					+ "58: Croatian Kuna\n" + "59: Haitian Gourde\n" + "60: Hungarian Forint\n"
					+ "61: Indonesian Rupiah\n" + "62: Israeli New Shekel\n" + "63: Manx Pound\n" + "64: Indian Rupee\n"
					+ "65: Iraqi Dinar\n" + "66: Iranian Rial\n" + "67: Icelandic Króna\n" + "68: Jersey Pound\n"
					+ "69: Jamaican Dollar\n" + "70: Jordanian Dinar\n" + "71: Japanese Yen\n" + "72: Kenyan Shilling\n"
					+ "73: Kyrgyzstani Som\n" + "74: Cambodian Riel\n" + "75: Kiribati Dollar\n"
					+ "76: Comorian Franc\n" + "77: South Korean Won\n" + "78: Kuwaiti Dinar\n"
					+ "79: Cayman Islands Dollar\n" + "80: Kazakhstani Tenge\n" + "81: Lao Kip\n"
					+ "82: Lebanese Pound\n" + "83: Sri Lanka Rupee\n" + "84: Liberian Dollar\n" + "85: Lesotho Loti\n"
					+ "86: Libyan Dinar\n" + "87: Moroccan Dirham\n" + "88: Moldovan Leu\n" + "89: Malagasy Ariary\n"
					+ "90: Macedonian Denar\n" + "91: Burmese Kyat\n" + "92: Mongolian Tögrög\n"
					+ "93: Macanese Pataca\n" + "94 :Mauritanian Ouguiya\n" + "95: Mauritian Rupee\n"
					+ "96: Maldivian Rufiyaa\n" + "97: Malawian Kwacha\n" + "98: Mexican Peso\n"
					+ "99: Malaysian Ringgit\n" + "100: Mozambican Metical\n" + "101: Namibian Dollar\n"
					+ "102: Nigerian Naira\n" + "103: Nicaraguan Córdoba\n" + "104: Norwegian Krone\n"
					+ "105: Nepalese Rupee\n" + "106: New Zealand Dollar\n" + "107: Omani Rial\n"
					+ "108: Panamanian Balboa\n" + "109: Peruvian Sol\n" + "110: Papua New Guinean Kina\n"
					+ "111: Philippine Peso\n" + "112: Pakistani Rupee\n" + "113: Polish Złoty\n"
					+ "114: Paraguayan Guaraní\n" + "115: Qatari Riyal\n" + "116: Romanian Leu\n"
					+ "117: Serbian Dinar\n" + "118: Russian Ruble\n" + "119: Rwandan Franc\n" + "120: Saudi Riyal\n"
					+ "121: Solomon Islands Dollar\n" + "122: Seychellois Rupee\n" + "123: Sudanese Pound\n"
					+ "124: Swedish Krona\n" + "125: Singapore Dollar\n" + "126: Saint Helena Pound\n"
					+ "127: Sierra Leonean Leone\n" + "128: Somali Shilling\n" + "129: Surinamese Dollar\n"
					+ "130: South Sudanese Pound\n" + "131: São Tomé and Príncipe Dobra\n" + "132: Syrian Pound\n"
					+ "133: Eswatini Lilangeni\n" + "134: Thai Baht\n" + "135: Tajikistani Somoni\n"
					+ "136: Turkmenistan Manat\n" + "137: Tunisian Dinar\n" + "138: Tongan Paʻanga\n"
					+ "139: Turkish Lira\n" + "140: Trinidad and Tobago Dollar\n" + "141: Tuvaluan Dollar\n"
					+ "142: New Taiwan Dollar\n" + "143: Tanzanian Shilling\n" + "144: Ukrainian Hryvnia\n"
					+ "145: Ugandan Shilling\n" + "146: United States Dollar\n" + "147: Uruguayan Peso\n"
					+ "148: Uzbekistani So'm\n" + "149: Venezuelan Bolívar Soberano\n" + "150: Vietnamese Đồng\n"
					+ "151: Vanuatu Vatu\n" + "152: Samoan Tālā\n" + "153: Central African CFA Franc\n"
					+ "154: East Caribbean Dollar\n" + "155: Special Drawing Rights\n" + "156: West African CFA franc\n"
					+ "157: CFP Franc\n" + "158: Yemeni Rial\n" + "159: South African Rand\n" + "160: Zambian Kwacha\n"
					+ "161: Zimbabwean Dollar\n" + "\n");

			to = input.nextInt();
			while (to < 1 || to > 161) {
				System.out.println("Please Select a Valid Currency Option (1-161)");
				System.out.println("1: UAE Dirham \n" + " 2 :Afghan Afghani\n" + " 3:Albanian Lek\n"
						+ " 4: Armenian Dram\n" + " 5: Netherlands Antillian Guilder\n" + " 6:Angolan Kwanza\n"
						+ " 7: Argentine Peso\n" + " 8: Australian Dollar\n" + "9: Aruban Florin\n"
						+ "10: Azerbaijani Manat\n" + "11: Bosnia and Herzegovina Mark\n" + "12: Barbados Dollar\n"
						+ "13: Bangladeshi Taka\n" + "14: Bulgarian Lev\n" + "15: Bahraini Dinar\n"
						+ "16: Burundian Franc\n" + "17: Bermudian Dollar\n" + "18: Brunei Dollar\n"
						+ "19: Bolivian Boliviano\n" + "20: Brazilian Real\n" + "21: Bahamian Dollar\n"
						+ "22: Bhutanese Ngultrum\n" + "23: Botswana Pula\n" + "24: Belarusian Ruble\n"
						+ "25: Belize Dollar\n" + "26: Canadian Dollar\n" + "27: Congolese Franc\n"
						+ "28: Swiss Franc\n" + "29: Chilean Peso\n" + "30: Chinese Renminbi\n" + "31: Colombian Peso\n"
						+ "32: Costa Rican Colon\n" + "33: Cuban Peso\n" + "34: Cape Verdean Escudo\n"
						+ "35: Czech Koruna\n" + "36: Djiboutian Franc\n" + "37: Danish Krone\n"
						+ "38: Dominican Peso\n" + "39: Algerian Dinar\n" + "40: Egyptian Pound\n"
						+ "41: Eritrean Nakfa\n" + "42: Ethiopian Birr\n" + "43: Euro\n" + "44: Fiji Dollar\n"
						+ "45: Falkland Islands Pound\n" + "46: Faroese Króna\n" + "47: Pound Sterling\n"
						+ "48: Georgian Lari\n" + "49: Guernsey Pound\n" + "50: Ghanaian Cedi\n"
						+ "51: Gibraltar Pound\n" + "52: Gambian Dalasi\n" + "53: Guinean Franc\n"
						+ "54: Guatemalan Quetzal\n" + "55: Guyanese Dollar\n" + "56: Hong Kong Dollar\n"
						+ "57: Honduran Lempira\n" + "58: Croatian Kuna\n" + "59: Haitian Gourde\n"
						+ "60: Hungarian Forint\n" + "61: Indonesian Rupiah\n" + "62: Israeli New Shekel\n"
						+ "63: Manx Pound\n" + "64: Indian Rupee\n" + "65: Iraqi Dinar\n" + "66: Iranian Rial\n"
						+ "67: Icelandic Króna\n" + "68: Jersey Pound\n" + "69: Jamaican Dollar\n"
						+ "70: Jordanian Dinar\n" + "71: Japanese Yen\n" + "72: Kenyan Shilling\n"
						+ "73: Kyrgyzstani Som\n" + "74: Cambodian Riel\n" + "75: Kiribati Dollar\n"
						+ "76: Comorian Franc\n" + "77: South Korean Won\n" + "78: Kuwaiti Dinar\n"
						+ "79: Cayman Islands Dollar\n" + "80: Kazakhstani Tenge\n" + "81: Lao Kip\n"
						+ "82: Lebanese Pound\n" + "83: Sri Lanka Rupee\n" + "84: Liberian Dollar\n"
						+ "85: Lesotho Loti\n" + "86: Libyan Dinar\n" + "87: Moroccan Dirham\n" + "88: Moldovan Leu\n"
						+ "89: Malagasy Ariary\n" + "90: Macedonian Denar\n" + "91: Burmese Kyat\n"
						+ "92: Mongolian Tögrög\n" + "93: Macanese Pataca\n" + "94 :Mauritanian Ouguiya\n"
						+ "95: Mauritian Rupee\n" + "96: Maldivian Rufiyaa\n" + "97: Malawian Kwacha\n"
						+ "98: Mexican Peso\n" + "99: Malaysian Ringgit\n" + "100: Mozambican Metical\n"
						+ "101: Namibian Dollar\n" + "102: Nigerian Naira\n" + "103: Nicaraguan Córdoba\n"
						+ "104: Norwegian Krone\n" + "105: Nepalese Rupee\n" + "106: New Zealand Dollar\n"
						+ "107: Omani Rial\n" + "108: Panamanian Balboa\n" + "109: Peruvian Sol\n"
						+ "110: Papua New Guinean Kina\n" + "111: Philippine Peso\n" + "112: Pakistani Rupee\n"
						+ "113: Polish Złoty\n" + "114: Paraguayan Guaraní\n" + "115: Qatari Riyal\n"
						+ "116: Romanian Leu\n" + "117: Serbian Dinar\n" + "118: Russian Ruble\n"
						+ "119: Rwandan Franc\n" + "120: Saudi Riyal\n" + "121: Solomon Islands Dollar\n"
						+ "122: Seychellois Rupee\n" + "123: Sudanese Pound\n" + "124: Swedish Krona\n"
						+ "125: Singapore Dollar\n" + "126: Saint Helena Pound\n" + "127: Sierra Leonean Leone\n"
						+ "128: Somali Shilling\n" + "129: Surinamese Dollar\n" + "130: South Sudanese Pound\n"
						+ "131: São Tomé and Príncipe Dobra\n" + "132: Syrian Pound\n" + "133: Eswatini Lilangeni\n"
						+ "134: Thai Baht\n" + "135: Tajikistani Somoni\n" + "136: Turkmenistan Manat\n"
						+ "137: Tunisian Dinar\n" + "138: Tongan Paʻanga\n" + "139: Turkish Lira\n"
						+ "140: Trinidad and Tobago Dollar\n" + "141: Tuvaluan Dollar\n" + "142: New Taiwan Dollar\n"
						+ "143: Tanzanian Shilling\n" + "144: Ukrainian Hryvnia\n" + "145: Ugandan Shilling\n"
						+ "146: United States Dollar\n" + "147: Uruguayan Peso\n" + "148: Uzbekistani So'm\n"
						+ "149: Venezuelan Bolívar Soberano\n" + "150: Vietnamese Đồng\n" + "151: Vanuatu Vatu\n"
						+ "152: Samoan Tālā\n" + "153: Central African CFA Franc\n" + "154: East Caribbean Dollar\n"
						+ "155: Special Drawing Rights\n" + "156: West African CFA franc\n" + "157: CFP Franc\n"
						+ "158: Yemeni Rial\n" + "159: South African Rand\n" + "160: Zambian Kwacha\n"
						+ "161: Zimbabwean Dollar\n" + "\n");
			}

			toCurrency = currencyCodes.get(to);

			System.out.println("Amount you wish to convert?");
			amount = input.nextFloat();

			sendHttpGETRequest(fromCurrency, toCurrency, amount);

			System.out.println("Would you like to make another conversion?");
			System.out.println("1: Yes \t Any other NUMBER!: NO ");
			if (input.nextInt() != 1) {
				choice = false;
			}

		} while (choice);
		System.out.println("Thank you for using the currency converter!");
	}

	private static void sendHttpGETRequest(String fromCurrency, String toCurrency, double amount) {
		try {
			URL url = new URL("https://v6.exchangerate-api.com/v6/YOUR_API_KEY/pair/" + fromCurrency + "/"
					+ toCurrency + "/" + amount);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			// Check if connect is made
			int responseCode = conn.getResponseCode();

			// 200 OK
			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);
			} else {

				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());

				}

				System.out.println("\n JSON in string format " + informationString);// informationString.toString();

				// Close the scanner
				scanner.close();

				// JSON simple library Setup with Maven is used to convert strings to JSON

				JSONParser parse = new JSONParser();
				JSONObject jobj = (JSONObject) parse.parse(String.valueOf(informationString));
				String answer = String.valueOf(jobj.get("conversion_result"));
				String base_code = String.valueOf(jobj.get("base_code"));
				String target_code = String.valueOf(jobj.get("target_code"));
				String conversion_rate = String.valueOf(jobj.get("conversion_rate"));

				System.out.println("You have converted from " + " " + base_code + "to" + " " + target_code
						+ " with a rate of " + " " + conversion_rate);
				System.out.println("Your Conversion result is: " + answer);

			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
