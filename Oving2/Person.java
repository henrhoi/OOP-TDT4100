package oving2;
import java.util.Date;

public class Person {
	
	/*
	 Navn: Fornavn, etternavn, ingen mellomrom, minst 2 bokstaver hver, kun inneholde bokstaver, vÊre skilt av mellomrom
	 Email: hvis den ikke er 0, mÂ den vÊre pÂ formen fornavn.etternavn @ domene.landskode
	 F¯dselsdato: ikke frem i tid
	 Kj¯nn: enten M, F eller null
	 
	 */
	
	public String name;
	public String email;
	public Date birthday;
	public char gender;
//	public String SSN;
	
	String[] Landskoder = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd",
	                "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc",
	                "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk",
	                "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge",
	                "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht",
	                "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km",
	                "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md",
	                "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz",
	                "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl",
	                "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh",
	                "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj",
	                "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg",
	                "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
//	public void setSSN(String SSN){
//		this.SSN = SSN;
//	}
//	public String getSSN(){
//		return SSN;
//	}
	
	public void setName(String name) {
		checkName(name);
		this.name = name;
	}
	public void setEmail(String email) {
		checkMail(email);
		this.email = email;
	}
	public void setBirthday(Date birthday) {
		Date today = new Date();
		if (birthday.after(today)) {
			throw new IllegalArgumentException("Must be born before today!");
		}
		this.birthday = birthday;
	}
	public void setGender(char gender) {
		if (gender != 'M' && gender != 'F' && gender != '\0'){
			throw new IllegalArgumentException("Must be F, M or null");
		}
		this.gender = gender;
	}
	public void checkName (String name){
		if (name.length()<5){
			throw new IllegalArgumentException("name must be at least 4 letters + whitespace");
		}
		String name2 = name.replace(" ", "");
		int spaces = name.length() - name2.length();
		if (spaces != 1){
			throw new IllegalArgumentException("Must have 1 whitespace");
		}
		String[] names = name.split(" ");
		String firstName = names[0]; //fornavn
		String lastName = names[1];  // etternavn
		
		
		String name1_large = firstName.toUpperCase();
		String name2_large = lastName.toUpperCase();
		
		if (!name1_large.chars().allMatch(Character::isLetter)){
			throw new IllegalArgumentException("Must be letters");
		}
		else if (!name2_large.chars().allMatch(Character::isLetter)){
			throw new IllegalArgumentException("Must be letters");
		}
		else if (firstName.length()<2){
			throw new IllegalArgumentException("Firstname must be at least 2 letters");
		}
		else if (lastName.length()<2){
			throw new IllegalArgumentException("Lastname must be at least 2 letters");
		}
		
	}
	
	public void checkMail(String email){
		if ((!email.contains("@") || !email.contains(".")) && email != null) {
			throw new IllegalArgumentException("Email must have @ and .");
		}
//		String small_email = email.toLowerCase(); //Locale.ROOT
//		if (small_email != email){
//			throw new IllegalArgumentException("email must be in small letters");
//		}
		
		int b = 0;
		for (int i = 0; i < email.length(); i++){
			char c = email.charAt(i);
			if (Character.isUpperCase(c)){
				b+=1;}			
		}if (b > 0){
			throw new IllegalArgumentException("Du har store bokstaver!");
		}
		
		String email1 = email.replace(".", "");
		int dots = email.length() - email1.length();
		if (dots!=2){
			throw new IllegalArgumentException("MÂ ha to punktum i hele emailen");
		}
		
		String[] names = name.split(" ");
		String firstName = names[0]; //fornavn John
		String lastName = names[1];  // etternavn Doe
		String[] parts_email = email.split("@");
		String parts1_email = parts_email[0];  //fornavn.etternavn
		if (!parts1_email.contains(".")){
			throw new IllegalArgumentException("Must be . in email part 1");
		}
		String[] parts1_email1 = parts1_email.split("\\.");
		String firstName_mail = parts1_email1[0]; //fornavn email
		String lastName_mail = parts1_email1[1]; //etternavn email
		String parts2_email = parts_email[1];
		if (!parts2_email.contains(".")){
			throw new IllegalArgumentException("Must be . in email part 2");
		}
		else if (parts2_email.endsWith(".") || parts2_email.startsWith(".")){
			throw new IllegalArgumentException("MÂ ha 2 punktum!");
		}
		String[] parts2_email2 = parts2_email.split("\\."); //domene.landskode
//		if (parts2_email2[0] == null || parts2_email2[1] == null){
//			throw new IllegalArgumentException("Cannot be null in the twicest part ofc");
//		}
		String landskode = parts2_email2[1]; //landskode
		
		

		if (!firstName.toLowerCase().equals(firstName_mail)){
			throw new IllegalArgumentException("firsname must be the same as in email");
		}
		else if (!lastName.toLowerCase().equals(lastName_mail)){
			throw new IllegalArgumentException("lastname must be the same as in email");
		}
		int in = 0;
		for (int i = 0; i<Landskoder.length; i++){
			if (Landskoder[i].equals(landskode)){
				in += 1;
			}
		}
		if (in!=1){
			throw new IllegalArgumentException("Must be a cool countrycode");
			
		}
		
		
	}
		
	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public char getGender() {
		return gender;
	}
	public static void main(String[] args){
		Person henrik = new Person();
		henrik.setName("Henrik Hoiness");
		henrik.setEmail("henrik.hoiness@online.no");
	}

}