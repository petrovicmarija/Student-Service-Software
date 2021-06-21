package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BazaGlavna {
	private static BazaGlavna instanca = null;
	
	private Profesor profesor = new Profesor("","");
	
	public static BazaGlavna getInstance() {
		if(instanca == null) {
			instanca = new BazaGlavna();
		}
		return instanca;
	}
	
	private ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	private ArrayList<Student> studenti = new ArrayList<Student>();
	private ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	
	private BazaGlavna() {
		initBaza();
	}
	
	private void initBaza() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		profesori.add(new Profesor("Nikolić", "Miloš", LocalDate.parse("12.12.1965.", formatter), "Temerinska 15, Novi Sad", "021/356-785", "milos.nikolic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 600", "123123123", Titula.profDr, Zvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Mirković", "Nikola", LocalDate.parse("01.01.1978.", formatter), "Jovana Cvijića 25, Subotica", "021/368-456", "nikola.mirkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 601", "321321321", Titula.profDr, Zvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Petković", "Ilija",LocalDate.parse("03.09.1988.", formatter), "Gogoljeva 1, Novi Sad", "021/215-314", "ilija.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 602", "456456456", Titula.dr, Zvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Petrović", "Mitar", LocalDate.parse("25.07.1976.", formatter), "Marka Kraljevića 102, Beograd", "021/884-640", "mitar.petrovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 603", "789789789", Titula.dr, Zvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Micic", "Vasa", LocalDate.parse("14.02.1970.", formatter), "Tolstojeva 55, Novi Sad", "021/212-114", "vasa.micic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 604", "001001001", Titula.dr, Zvanje.DOCENT));
		profesori.add(new Profesor("Miletic", "Srđan", LocalDate.parse("20.04.1966.", formatter), "Šekspirova 12, Novi Sad", "021/978-225", "srdjan.miletic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 605", "002002002", Titula.dr, Zvanje.DOCENT));
		profesori.add(new Profesor("Mihajlovic", "Branislav", LocalDate.parse("28.06.1980.", formatter), "Jovana Subotića 99, Novi Sad", "021/778-323", "branislav.mihajlovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 606", "559585632", Titula.profDr, Zvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Marković", "Marko", LocalDate.parse("31.01.1985.", formatter), "Mirka Markovića 101, Kraljevo", "021/899-659", "marko.markovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 607", "334968855", Titula.profDr, Zvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Milaković", "Miloš", LocalDate.parse("21.09.1975.", formatter), "Braće Jugović 1, Kragujevac", "021/122-326", "milos.milakovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 608", "073070365", Titula.dr, Zvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Bratić", "Lazar", LocalDate.parse("13.11.1973.", formatter), "Jovanke Orleanke 3, Niš", "021/156-326", "lazar.bratic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 609", "006003786", Titula.dr, Zvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Dražić", "Ljeposava", LocalDate.parse("11.08.1964.", formatter), "Vojvode Stepe 1100, Beograd", "021/888-156", "ljeposava.drazic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 610", "158496152", Titula.dr, Zvanje.DOCENT));
		profesori.add(new Profesor("Dragić", "Miroljub", LocalDate.parse("02.03.1959.", formatter), "Miše Ljubibratiće 123, Aleksandrovac", "021/456-125", "miroljub.dragic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 611", "777348595", Titula.dr, Zvanje.DOCENT));
		profesori.add(new Profesor("Rekavić", "Bogdan", LocalDate.parse("23.06.1977.", formatter), "Resavska 12, Beograd", "021/886-455", "bogdan.rekavic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 612", "721254363", Titula.dr, Zvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Milić", "Stanka", LocalDate.parse("03.03.1990.", formatter), "Vidakovićeva 90, Novi Sad", "021/945-255", "stanka.milic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 613", "225533448", Titula.dr, Zvanje.DOCENT));
		profesori.add(new Profesor("Vuković", "Milica", LocalDate.parse("18.10.1967.", formatter), "Nikolićeva 12, Novi Sad", "021/746-659", "milica.vukovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 614", "111555888", Titula.profDr, Zvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Mišić", "Miša", LocalDate.parse("20.10.1969.", formatter), "Šojićeva 10, Subotica", "021/489-326", "misa.misic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 615", "003003003", Titula.dr, Zvanje.DOCENT));
		profesori.add(new Profesor("Maricic", "Branko", LocalDate.parse("18.01.1973.", formatter), "Nikole Tesle 25, Sombor", "021/487-265", "branko.maricic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 616", "004004004", Titula.profDr, Zvanje.DOCENT));
		profesori.add(new Profesor("Lukovic", "Branislav", LocalDate.parse("08.04.1982.", formatter), "Živojina Mišića 7, Apatin", "021/159-478", "branislav.lukovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 617", "005005005", Titula.dr, Zvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Obradovic", "Branimir", LocalDate.parse("07.01.1979.", formatter), "Stari šor 18, Sremska Mitrovica", "021/922-333", "branimir.obradovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 618", "006006006", Titula.profDr, Zvanje.DOCENT));
		
		
		predmeti.add(new Predmet("P1", "osnove programiranja", Semestar.zimski, 1, nadjiProfesoraPoBrLicne("321321321"), 7));
		predmeti.add(new Predmet("P2", "statistika", Semestar.letnji, 3, nadjiProfesoraPoBrLicne("321321321"), 8));
		predmeti.add(new Predmet("P3", "algoritmi i strukture podataka", Semestar.letnji, 2, nadjiProfesoraPoBrLicne("321321321"), 9));
		predmeti.add(new Predmet("P4", "LPRS", Semestar.zimski, 3, nadjiProfesoraPoBrLicne("321321321"), 7));
		predmeti.add(new Predmet("P5", "matematika", Semestar.letnji, 1, nadjiProfesoraPoBrLicne(""), 11));
		predmeti.add(new Predmet("P6", "xml i web servisi", Semestar.letnji, 4, nadjiProfesoraPoBrLicne(""), 6));
		predmeti.add(new Predmet("P7", "Metode optimizacije", Semestar.zimski, 3, nadjiProfesoraPoBrLicne(""), 6));
		predmeti.add(new Predmet("P8", "osnove elektortehnike", Semestar.letnji, 1, nadjiProfesoraPoBrLicne("001001001"), 11));
		predmeti.add(new Predmet("P9", "Sociologija", Semestar.zimski, 1, nadjiProfesoraPoBrLicne("001001001"), 10));
		predmeti.add(new Predmet("P10", "Filozofija", Semestar.zimski, 1, nadjiProfesoraPoBrLicne("001001001"), 4));
		predmeti.add(new Predmet("P11", "ORT", Semestar.letnji, 2, nadjiProfesoraPoBrLicne(""), 7));
		predmeti.add(new Predmet("P12", "NANS", Semestar.letnji, 2, nadjiProfesoraPoBrLicne("002002002"), 5));
		predmeti.add(new Predmet("P13", "Organizacija podataka", Semestar.zimski, 2, nadjiProfesoraPoBrLicne("002002002"), 7));
		predmeti.add(new Predmet("P14", "Baze podataka", Semestar.zimski, 2, nadjiProfesoraPoBrLicne("002002002"), 6));
		predmeti.add(new Predmet("P15", "paralelno programiranje", Semestar.zimski, 2, nadjiProfesoraPoBrLicne("559585632"), 8));
		predmeti.add(new Predmet("P16", "konkurentno programiranje", Semestar.letnji, 2, nadjiProfesoraPoBrLicne("559585632"), 9));
		predmeti.add(new Predmet("P17", "Operativni sistemi", Semestar.letnji, 2, nadjiProfesoraPoBrLicne(""), 8));
		predmeti.add(new Predmet("P18", "Algebra", Semestar.zimski, 1, nadjiProfesoraPoBrLicne(""), 15));
		predmeti.add(new Predmet("P19", "Verovatnoca", Semestar.letnji, 3, nadjiProfesoraPoBrLicne(""), 14));
		predmeti.add(new Predmet("PS20", "Upravljacki sistemi", Semestar.letnji, 3, nadjiProfesoraPoBrLicne(""), 8));
		predmeti.add(new Predmet("PS21", "Osnovi elektrotehnike", Semestar.zimski, 2, nadjiProfesoraPoBrLicne(""), 7));
		predmeti.add(new Predmet("PS22", "Slucajni procesi", Semestar.letnji, 4, nadjiProfesoraPoBrLicne(""), 9));
		predmeti.add(new Predmet("PS23", "Racunarstvo visokih performansi", Semestar.letnji, 4, nadjiProfesoraPoBrLicne(""), 10));
		predmeti.add(new Predmet("P24", "Analiza 1", Semestar.zimski, 1, nadjiProfesoraPoBrLicne(""), 20));
		predmeti.add(new Predmet("IT25", "Informaciona bezbednost", Semestar.letnji, 4, nadjiProfesoraPoBrLicne("004004004"), 9));
		predmeti.add(new Predmet("IT26", "Elektronsko placanje", Semestar.zimski, 3, nadjiProfesoraPoBrLicne("005005005"), 8));
		predmeti.add(new Predmet("IT27", "Distribuirani sistemi", Semestar.zimski, 4, nadjiProfesoraPoBrLicne("006006006"), 6));
		predmeti.add(new Predmet("P28", "Projektovanje softvera", Semestar.zimski, 3, nadjiProfesoraPoBrLicne("005005005"), 5));
		predmeti.add(new Predmet("P29", "Informacioni sistemi", Semestar.zimski, 4, nadjiProfesoraPoBrLicne("004004004"), 6));
		predmeti.add(new Predmet("P30", "Masinsko ucenje", Semestar.letnji, 4, nadjiProfesoraPoBrLicne(null), 7));
		
		studenti.add(new Student("RA 2/2020", "Marko", "Milosevic", 1, Student.parseDate("12.03.2001."), "Karađorđeva 83, Novi Sad", "021/333-555", "marko.milosevic@mailinator.com", Status.B, 2020, 0.00));
		studenti.add(new Student("RA 3/2019", "Marija", "Milic", 2, Student.parseDate("12.01.2000."), "Stražilovska 12, Novi Sad", "021/555-2222", "marija.milic@mailinator.com", Status.S, 2019, 0.00));
		studenti.add(new Student("RA 3/2017", "Nikola", "Nikolic", 1, Student.parseDate("30.08.2001."), "Knez Mihajlova 16, Beograd", "021/135-463", "nikola.nikolic@mailinator.com", Status.B, 2017, 0.00));
		studenti.add(new Student("RA 134/2015", "Pera", "Peric", 3, Student.parseDate("07.06.1995."), "Gogoljeva 3, Novi Sad", "021/903-463", "pera.peric@mailinator.com", Status.S, 2015, 0.00));
		studenti.add(new Student("RA 5/2019", "Sofija", "Ilic", 3, Student.parseDate("06.05.1999."), "Miše Dimitrijevića 44, Novi Sad", "021/731-067", "sofija.ilic@mailinator.com", Status.B, 2019, 0.00));
		studenti.add(new Student("RA 8/2018", "Martina", "Lukic", 3, Student.parseDate("16.05.1999."), "Vojvode Stepe 180, Beograd", "011/4333-800", "martina.lukic@mailinator.com", Status.S, 2018, 0.00));
		studenti.add(new Student("RA 10/2017", "Stojan", "Stojakovic", 1, Student.parseDate("19.10.2001."), "1300 Kaplara, Šabac", "011/3130-007", "stojan.stojakovic@mailinator.com", Status.B, 2017,0.00));
		studenti.add(new Student("RA 12/2017", "Milan", "Milanovic", 2, Student.parseDate("02.11.2000."), "Surepova 12, Šabac", "015/313-061", "milan.milanovic@mailinator.com", Status.S, 2017, 0.00));
		studenti.add(new Student("RA 16/2019", "Miroslav", "Milic", 2, Student.parseDate("11.10.2000."), "Milovana Glišića, Valjevo", "021/351-091", "miroslav.milic@mailinator.com", Status.B, 2019, 0.00));
		studenti.add(new Student("RA 21/2015", "Stefan", "Gojic", 3, Student.parseDate("01.05.1999."), "Bulevar Mihajla Pupina, Novi Sad", "015/324-500", "stefan.gojic@mailinator.com", Status.S, 2015, 0.00));
		studenti.add(new Student("RA 9/2020", "Anastasija", "Jokic", 3, Student.parseDate("11.07.1999."), "Braće Ribnikar 12, Novi Sad", "011/2333-900", "anastasija.jokic@mailinator.com", Status.B, 2020, 0.00));
		studenti.add(new Student("RA 4/2017", "Bogdan", "Bogdanovic", 3, Student.parseDate("23.07.1999."), "Cara Dušana 42, Subotica", "021/231-114", "bogdan.bogdanovic@mailinator.com", Status.S, 2017, 0.00));
		studenti.add(new Student("RA 30/2019", "Ana", "Dabovic", 1, Student.parseDate("12.12.2001."), "Marka Kraljevića 1, Kikinda", "014/303-007", "ana.dabovic@mailinator.com", Status.B, 2019, 0.00));
		studenti.add(new Student("RA 1/2020", "Mika", "Mikic", 1, Student.parseDate("05.11.2001."), "Nikole Stojanovića 2, Kraljevo", "015/101-909", "mika.mikic@mailinator.com", Status.S, 2020, 0.00));
		studenti.add(new Student("RA 11/2018", "Jovan", "Deretic", 4, Student.parseDate("10.09.1998."), "Marka Bratića 99, Niš", "002/200-300", "jovan.deretic@mailinator.com", Status.B, 2018, 0.00));
		studenti.add(new Student("RA 12/2018", "Nikola", "Miskovic", 4, Student.parseDate("03.08.1998."), "Cara Dušana 12, Banja Luka", "022/123-456", "nikola.miskovic@mailinator.com", Status.S, 2018,0.00));
		studenti.add(new Student("RA 13/2018", "Martin", "Stojanovic", 4, Student.parseDate("01.05.1998."), "Borisa Bačkog 1, Bijeljina", "024/321-775", "martin.stojanovic@mailinator.com", Status.S, 2018, 0.00));
		studenti.add(new Student("RA 14/2018", "Tomislav", "Novakovic", 4, Student.parseDate("25.02.1996."), "Mirka Maksića 10, Kruševac", "011/1188-379", "tomislav.novakovic@mailinator.com", Status.B, 2018, 0.00));
		studenti.add(new Student("RA 154/2016", "Lena", "Ivic", 4, Student.parseDate("11.05.1998."), "Stari Most 6, Sremska Mitrovica", "024/333-555", "lena.ivic@mailinator.com", Status.B, 2016, 0.00));
		studenti.add(new Student("RA 23/2020", "Jovan", "Lazic", 1, Student.parseDate("22.01.2001."), "Nevesinjskih ustanika 10, Nevesinje", "025/1189-479", "jovan.lazic@mailinator.com", Status.B, 2020, 0.00));
		studenti.add(new Student("RA 1/2019", "Isidora", "Mikic", 2, Student.parseDate("31.12.2000."), "Radničка 11, Novi Sad", "011/1122-366", "isidora.mikic@mailinator.com", Status.B, 2019, 0.00));
		studenti.add(new Student("SW 4/2014", "Vladimir", "Ilic", 4, Student.parseDate("31.08.1998."), "Miloša Obilića 1, Beograd", "0211122-367", "vladimir.ilic@mailinator.com", Status.B, 2014, 0.00));
		studenti.add(new Student("SW 17/2015", "Mirko", "Alicic", 3, Student.parseDate("21.07.1999."), "Heroja Pinkija 112, Novi Sad", "012/1122-368", "mirko.alicic@mailinator.com", Status.S, 2015,0.00));
		studenti.add(new Student("SW 17/2016", "Milisav", "Perkovic", 4, Student.parseDate("28.09.1998."), "Pavla Bakića 26, Novi Sad", "012/1122-369", "milisav.pejkovic@mailinator.com", Status.S, 2016, 0.00));
		studenti.add(new Student("SW 27/2018", "Purisa", "Djordjevic", 2, Student.parseDate("29.02.2000."), "Pavla Papa 1, Novi Sad", "011/1543-370", "purisa.djordjevic@mailinator.com", Status.B, 2018, 0.00));
		studenti.add(new Student("RA 226/2017", "Mikica", "Kovacevic", 3, Student.parseDate("23.03.1999."), "Valentina Vodnika 112, Novi Sad", "011/1992-371", "mikica.kovacevic@mailinator.com", Status.S, 2017, 0.00));
		studenti.add(new Student("SW 12/2020", "Milos", "Milic", 1, Student.parseDate("21.10.2001."), "Neznanog junaka 12, Beograd", "011/8172-372", "milos.milic@mailinator.com", Status.S, 2020, 0.00));


	}
	
	private Profesor nadjiProfesoraPoBrLicne(String brLicneKarte) {
		Profesor profesorNadjen = profesor;
		for(Profesor profesorr : profesori) {
			if(profesorr.getBrLicneKarte().equals(brLicneKarte)) {
				profesorNadjen = profesorr;
				break;
			}
		}
		
		return profesorNadjen;
	}
	
	//private Predmet nadjiPredmetProfesoru() {}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	
}
