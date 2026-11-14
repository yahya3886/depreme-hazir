package com.depremhazirlik.app.data

data class EmergencyNumber(
    val name: String,
    val number: String,
    val desc: String
)

data class EmergencyTip(
    val title: String,
    val line: String
)

object EmergencyData {

    val call112 = EmergencyNumber(
        name = "Acil Çağrı Merkezi",
        number = "112",
        desc = "Ambulans, itfaiye, polis ve tüm acil durumlar için tek numara."
    )

    val institutions: List<EmergencyNumber> = listOf(
        EmergencyNumber("AFAD", "122", "Afet ve Acil Durum Yönetimi Başkanlığı çağrı hattı"),
        EmergencyNumber("İtfaiye", "110", "Yangın, kurtarma ve tehlikeli madde olayları"),
        EmergencyNumber("Polis", "155", "Asayiş ve güvenlik ihbarları"),
        EmergencyNumber("Jandarma", "156", "Köy ve kırsal alandaki ihbarlar"),
        EmergencyNumber("Kızılay", "168", "Kan bağışı ve yardım hattı"),
        EmergencyNumber("Sosyal Destek (ALO Sıfır)", "184", "Aile ve Sosyal Hizmetler destek hattı")
    )

    val tips: List<EmergencyTip> = listOf(
        EmergencyTip(
            "112'yi ararken",
            "Olay yerini ve yakın işaretleri net söyle: cadde, kat, bina numarası."
        ),
        EmergencyTip(
            "Durumu özetle",
            "Kaç kişi yaralı, bina çöktü mü, yangın veya gaz kokusu var mı — kısa ve net."
        ),
        EmergencyTip(
            "Hattı meşgul etme",
            "Ciddi durum yoksa arama yerine kısa SMS tercih et; hatlar kitlenebilir."
        ),
        EmergencyTip(
            "Doğalgaz kaçağı",
            "Elektrik anahtarlarına dokunma, bölge gaz dağıtım şirketinin acil hattını ara."
        )
    )
}
