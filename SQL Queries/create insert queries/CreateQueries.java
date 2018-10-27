class CreateQueries{
	public static void main(String[] args){
		String fn[], ln[], ht[];
		fn = {"Ankit","Harshil","Madhura","Harsh","Shanay","Fenil","Atharva","Dharmik","Divya","Kirti","Ananya","Arnav","Heet","Amogh","Ayush","Harshil","Jashan Singh","Jay","Kaustubh","Jash","Hrishikesh","Arnesh","Jai","Dhyey","Ayushi","Dhairya","Pranjal","Jainam","Danish","Hrithika","Harsh","Heeket","Arish","Adit","Kalpesh","Jay","Aniruddha","Himanshu","Abhi","Aniket","Drashti","Devansh","Jigar","Shreya","Dev","Devansh","Dhruv","Tanmai"
};
		ln = {"Gupta","Vakharia","Shanbhag","Mistry","Shah","Gholani","Tawate","Parikh","Shah","Gupta","Malik","Parekhji","Kanani","Parab","Shah","Jhaveri","Banga","Shah","Kekre","Amin","Shenai","Vaidya","Mehta","Thumar","Lodaria","Shah","Chitale","Shah","Jain","Dodia","Mehta","Mehta","Damania","Kalyani","Patil","Gala","Das","Tandel","Thummar","Shahane","Shah","Shah","Mav","Pathak","Savla","Agarwal","Patil","Prabhune"
};

		ht = {"Govandi","Mankhurd","Vashi","Sanpada","Juinagar","Nerul","Seawoods-Darave","CBD Belapur","Kharghar","Mansarovar","Khandeshwar","Panvel","Churchgate","Marine Lines","Charni Road","Grant Road","Mumbai Central","Mahalaxmi","Lower Parel","Elphinstone Road","Dadar","Matunga Road","Mahim","Bandra","Khar Road","Santacruz","Vile Parle","Andheri","Jogeshwari","Goregaon","Malad","Kandivali","Borivali","Dahisar","Mira Road","Bhayandar","Naigaon","Vasai Road","Nala Sopara","Virar","valtarna","Saphale","Kelve Road","Palghar","Umroli","Boisar","Vangaon","Dahanu Road"
};
		
		for(int i=0; i<ht.length; i++){
			System.out.println(fn[i] + " " + ln[i] + ", " + ht[i]);
		}
		
	}
}