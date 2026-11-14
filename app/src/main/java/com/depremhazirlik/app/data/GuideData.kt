package com.depremhazirlik.app.data

data class GuideSection(
    val id: String,
    val title: String,
    val bullets: List<String>
)

object GuideData {

    val sections: List<GuideSection> = listOf(
        GuideSection(
            id = "before",
            title = "Deprem Öncesi",
            bullets = listOf(
                "Evi ve iş yerini gözden geçir; ağır dolapları, kitaplıkları ve televizyonu duvara sabitle.",
                "Acil durum çantasını kapının yanında, 3 günlük su ve gıda ile hazır tut.",
                "Ailenle toplanma alanını ve en az iki tahliye rotasını belirle.",
                "Su, ilaç ve kimlik belgelerinin kopyasını su geçirmez poşette bulundur.",
                "En yakın hastane, toplanma alanı ve açık alanları önceden öğren.",
                "İlk yardım ve \"Çök – Kapan – Tutun\" tekniğini herkesle tekrar et.",
                "Bina hakkında bilgi al: yaş, yapı tipi ve tahliye merdiveni kullanılamıyorsa alternatif çıkış."
            )
        ),
        GuideSection(
            id = "during",
            title = "Deprem Anında",
            bullets = listOf(
                "\"Çök – Kapan – Tutun\": sağlam bir masanın altına çök, başını ve boynunu koru, sarsıntı bitene kadar tutun.",
                "Dışarı koşma; merdiven ve asansör kesinlikle kullanma.",
                "Pencere, cam dolap ve devrilecek eşyalardan uzaklaş.",
                "Mutfaktaysan ocakta yemeği al, ateşten uzaklaş.",
                "Sarsıntı durana kadar bekle; artçı sarsıntılar çok güçlü olabilir.",
                "Dışarıdaysan açık alana geç; binalardan, duvarlardan, direklerden ve köprülerden uzak dur.",
                "Araçtaysan yavaşla ve kenara çek; sarsıntı bitene kadar araçta kal."
            )
        ),
        GuideSection(
            id = "after",
            title = "Deprem Sonrası",
            bullets = listOf(
                "Önce çevrendeki yaralıları kontrol et ve ilk yardım uygula.",
                "Hasarlı binadan tahliye ol; artçı sarsıntılara dikkat et.",
                "Asansörü asla kullanma, merdivenleri tercih et.",
                "Gaz kokusu varsa elektrik anahtarlarını çevirme, kapı ve pencereleri aç.",
                "Telefonu kısa SMS için kullan, hatları meşgul etme.",
                "Resmî kaynaklardan (AFAD, Kızılay, valilik) bilgi al; söylentiye inanma.",
                "Toplanma alanına git, yetkililerin yönlendirmesini bekle.",
                "Hasarlı binalara, kolon ve duvarlara dokunma; çevreyi izlemeye devam et."
            )
        ),
        GuideSection(
            id = "under",
            title = "Enkaz Altında",
            bullets = listOf(
                "Panik yapma; enerjini koru ve sakin kal.",
                "Ağzını ve burnunu elinle veya kumaşla kapat, tozu soluma.",
                "Düdük veya sert bir cisimle ritmik ses ver; sürekli bağırma.",
                "Telefonun ışığını kısa kısa kullan, pilini koru.",
                "Kurtarma ekibi sesini duyduğunda net ve kısa yanıt ver.",
                "Çatı, moloz ve kablolarına dokunma; ikinci bir sarsıntıda yer değişebilir.",
                "Kanaman varsa yarayı baskı uygulayarak durdur."
            )
        ),
        GuideSection(
            id = "tips",
            title = "Dikkat Edilmesi Gerekenler",
            bullets = listOf(
                "İnternet ve telefon hatları yoğun olacak; kısa SMS tercih et.",
                "Doğrulanmamış görüntü ve haberleri sosyal medyada paylaşma.",
                "Asansör, merdiven boşluğu ve hasarlı yapılarla temas kurma.",
                "Yolda çöken asfalt, kopan elektrik hattı ve gaz kokusundan uzak dur.",
                "Artçı sarsıntılar ilk depremden küçük olsa da yıkıcı olabilir.",
                "Yakınlarını bilgilendirmek için kısa ve net mesaj yaz: nerede olduğunu söyle.",
                "Arama yapmak yerine, hat açıldığında ilk aramanı 112 yerine yakınlarına yap."
            )
        )
    )
}
