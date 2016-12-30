package com.bakerbeach.market.address.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class RegionHelper {
	

	private static String nl = "DR:Drenthe;FL:Flevoland;FR:Friesland;GE:Gelderland;GR:Groningen;LI:Limburg;NB:Noord-Brabant;NH:Noord-Holland;OV:Overijssel;UT:Utrecht;ZE:Zeeland;ZH:Zuid-Holland";
	private static String it = "AG:Agrigento;AL:Alessandria;AN:Ancona;AO:Aosta;AR:Arezzo;AP:Ascoli Piceno;AT:Asti;AV:Avellino;BA:Bari;BL:Belluno;BN:Benevento;BG:Bergamo;BI:Biella;BO:Bologna;BZ:Bolzano;BS:Brescia;BR:Brindisi;CA:Cagliari;CL:Caltanissetta;CB:Campobasso;CE:Caserta;CT:Catania;CZ:Catanzaro;CH:Chieti;CO:Como;CS:Cosenza;CR:Cremona;KR:Crotone;CN:Cuneo;EN:Enna;FE:Ferrara;FI:Firenze;FG:Foggia;FO:Forli-Cesena;FR:Frosinone;GE:Genova;GO:Gorizia;GR:Grosseto;IM:Imperia;IS:Isernia;SP:La Spezia;AQ:L’Aquila;LT:Latina;LE:Lecce;LC:Lecco;LI:Livorno;LO:Lodi;LU:Lucca;MC:Macerata;MN:Mantova;MS:Massa-Carrara;MT:Matera;ME:Messina;MI:Milano;MO:Modena;MB:Monza e Brianza;NA:Napoli;NO:Novara;NU:Nuoro;OR:Oristano;PD:Padova;PA:Palermo;PR:Parma;PV:Pavia;PG:Perugia;PS:Pesaro;PE:Pescara;PC:Piacenza;PI:Pisa;PT:Pistoia;PN:Pordenone;PZ:Potenza;PO:Prato;RG:Ragusa;RA:Ravenna;RC:Reggio Calabria;RE:Reggio Emilia;RI:Rieti;RN:Rimini;RM:Roma;RO:Rovigo;SA:Salerno;SS:Sassari;SV:Savona;SI:Siena;SR:Siracusa;SO:Sondrio;TA:Taranto;TE:Teramo;TR:Terni;TO:Torino;TP:Trapani;TN:Trento;TV:Treviso;TS:Trieste;UD:Udine;VA:Varese;VE:Venezia;VB:Verbania-Cusio-Ossola;VC:Vercelli;VR:Verona;VV:Vibo Valentia;VI:Vicenza;VT:Viterbo";
	private static String ca = "AB:Alberta;BC:British Columbia;MB:Manitoba;NB:New Brunswick;NL:Newfoundland;NT:Northwest Territories;NS:Nova Scotia;NU:Nunavut;ON:Ontario;PE:Prince Edward Island;QC:Quebec;SK:Saskatchewan;YT:Yukon";
	private static String us = "AL:Alabama;AK:Alaska;AZ:Arizona;AR:Arkansas;CA:California;CO:Colorado;CT:Connecticut;DE:Delaware;DC:District Of Columbia (Washington, D.C.);FL:Florida;GA:Georgia;HI:Hawaii;ID:Idaho;IL:Illinois;IN:Indiana;IA:Iowa;KS:Kansas;KY:Kentucky;LA:Louisiana;ME:Maine;MD:Maryland;MA:Massachusetts;MI:Michigan;MN:Minnesota;MS:Mississippi;MO:Missouri;MT:Montana;NE:Nebraska;NV:Nevada;NH:New Hampshire;NJ:New Jersey;NM:New Mexico;NY:New York;NC:North Carolina;ND:North Dakota;OH:Ohio;OK:Oklahoma;OR:Oregon;PA:Pennsylvania;PR:Puerto Rico;RI:Rhode Island;SC:South Carolina;SD:South Dakota;TN:Tennessee;TX:Texas;UT:Utah;VT:Vermont;VA:Virginia;WA:Washington;WV:West Virginia;WI:Wisconsin;WY:Wyoming<;AA:Armed Forces Americas;AE:Armed Forces;AP:Armed Forces Pacific;AS:American Samoa;GU:Guam;MP:Northern Mariana Islands;VI:Virgin Islands";
	
	private static final Map<String, Map<String, String>> regions = new HashMap<String, Map<String,String>>();
	
	private static final Map<String, String> nlRegions = new LinkedHashMap<String, String>();
	private static final Map<String, String> itRegions = new LinkedHashMap<String, String>();
	private static final Map<String, String> caRegions = new LinkedHashMap<String, String>();
	private static final Map<String, String> usRegions = new LinkedHashMap<String, String>();
	static {
		for (String kv : nl.split(";")) {
			String k = StringUtils.substringBefore(kv, ":");
			String v = StringUtils.substringAfter(kv, ":");
			nlRegions.put(k, v);
		}
		
		for (String kv : it.split(";")) {
			String k = StringUtils.substringBefore(kv, ":");
			String v = StringUtils.substringAfter(kv, ":");
			itRegions.put(k, v);
		}
		
		for (String kv : ca.split(";")) {
			String k = StringUtils.substringBefore(kv, ":");
			String v = StringUtils.substringAfter(kv, ":");
			caRegions.put(k, v);
		}
		
		for (String kv : us.split(";")) {
			String k = StringUtils.substringBefore(kv, ":");
			String v = StringUtils.substringAfter(kv, ":");
			usRegions.put(k, v);
		}
		
		regions.put("NL", nlRegions);
		regions.put("IT", itRegions);
		regions.put("CA", caRegions);
		regions.put("US", usRegions);
	}
	

}
