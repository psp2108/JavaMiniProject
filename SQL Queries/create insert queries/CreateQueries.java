class CreateQueries{
	public static void main(String[] args){
		
		String fn[] = {"Prem","Ankit","Harshil","Madhura","Harsh","Shanay","Pratik","Fenil","Atharva","Dharmik","Divya","Kirti","Ananya","Arnav","Heet","Amogh","Ayush","Harshil","Jashan Singh","Jay","Kaustubh","Jash","Rucha" ,"Hrishikesh","Arnesh","Jai","Dhyey","Ayushi","Dhairya","Pranjal","Jainam","Danish","Hrithika","Harsh","Heeket","Arish","Adit","Kalpesh","Jay","Aniruddha","Himanshu","Abhi","Aniket","Drashti","Devansh","Jigar","Shreya","Dev","Devansh","Dhruv","Tanmai"
};
		String ln[] = {"Bhajaj","Gupta","Vakharia","Shanbhag","Mistry","Panchal","Shah","Gholani","Tawate","Parikh","Shah","Gupta","Malik","Parekhji","Kanani","Parab","Shah","Jhaveri","Banga","Shah","Shinde","Kekre","Amin","Shenai","Vaidya","Mehta","Thumar","Lodaria","Shah","Chitale","Shah","Jain","Dodia","Mehta","Mehta","Damania","Kalyani","Patil","Gala","Das","Tandel","Thummar","Shahane","Shah","Shah","Mav","Pathak","Savla","Agarwal","Patil","Prabhune"
};

		String ht[] = {"Govandi","Mankhurd","Vashi","Sanpada","Juinagar","Nerul","Seawoods-Darave","CBD Belapur","Kharghar","Mansarovar","Khandeshwar","Panvel","Churchgate","Marine Lines","Charni Road","Grant Road","Mumbai Central","Mahalaxmi","Lower Parel","Elphinstone Road","Dadar","Matunga Road","Mahim","Bandra","Khar Road","Santacruz","Andheri","Andheri","Jogeshwari","Goregaon","Malad","Kandivali","Borivali","Dahisar","Mira Road","Bhayandar","Naigaon","Vasai Road","Nala Sopara","Virar","valtarna","Saphale","Kelve Road","Palghar","Umroli","Boisar","Vangaon","Dahanu Road", "Badlapur","Thane","Malad"
};
		
		for(int i=0; i<ht.length; i++){
			String str = "insert into student_profile values ('6000418"+((8*1000) + i + 1)+"','"+fn[i]+" "+ln[i]+"','1234','"+fn[i]+"@gmail.com','"+ht[i]+"','Comps');";
			System.out.println(str);
		}
		
	}
}

