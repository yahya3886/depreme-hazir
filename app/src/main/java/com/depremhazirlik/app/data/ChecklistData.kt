package com.depremhazirlik.app.data

/** Hazırlık kontrol listesinin veri modeli. */
data class ChecklistSection(
    val id: String,
    val title: String,
    val subtitle: String
)

data class ChecklistItem(
    val id: String,
    val sectionId: String,
    val title: String,
    val subtitle: String
)

object ChecklistData {

    val sections: List<ChecklistSection> = listOf(
        ChecklistSection("bag", "1. Acil durum çantası", "Çantanı bir gecede hazırlayamazsın, şimdi topla."),
        ChecklistSection("home", "2. Ev güvenliği", "Devrilme ve düşme risklerini ortadan kaldır."),
        ChecklistSection("plan", "3. Aile planı", "Kim nerede, nereye gidecek — önceden konuşun.")
    )

    val items: List<ChecklistItem> = listOf(
        // --- Acil durum çantası ---
        ChecklistItem("water", "bag", "Su", "Kişi başı günde 3 litre, en az 3 günlük"),
        ChecklistItem("food", "bag", "Kuru gıda ve konserve", "Açılabilir, uzun ömürlü; 3 günlük"),
        ChecklistItem("flashlight", "bag", "El feneri ve yedek pil", "Telefon fenerine güvenme"),
        ChecklistItem("radio", "bag", "El çevirmeli radyo", "Elektrik kesilse de haber al"),
        ChecklistItem("whistle", "bag", "Düdük", "Enkazdan ses duyurmak için"),
        ChecklistItem("firstaid", "bag", "İlk yardım çantası", "Yara bandı, antiseptik, sargı bezi"),
        ChecklistItem("docs", "bag", "Kimlik ve önemli evraklar", "Su geçirmez poşette kopya bulundur"),
        ChecklistItem("cash", "bag", "Nakit para", "ATM'ler ve POS cihazları çalışmayabilir"),
        ChecklistItem("powerbank", "bag", "Powerbank ve şarj kablosu", "Yedek batarya dolu olsun"),
        ChecklistItem("blanket", "bag", "Battaniye ve giysi", "Mevsime uygun, sıcak tutacak"),
        ChecklistItem("hygiene", "bag", "Hijyen malzemeleri", "Islak mendil, havlu, maske"),
        ChecklistItem("medicine", "bag", "Kişisel ilaçlar", "Kronik hastalıkta 30 günlük doz"),
        ChecklistItem("tool", "bag", "Çakı, konserve açacı, çakmak", "Sağlam bir çakı ve kibrit"),
        ChecklistItem("mask", "bag", "Toz maskesi ve eldiven", "Enkaz ve toz ortamı için"),

        // --- Ev güvenliği ---
        ChecklistItem("anchor_tv", "home", "Televizyonu ve sehpayı sabitle", "Devrilme en sık yaralanma nedeni"),
        ChecklistItem("anchor_shelf", "home", "Dolap ve rafları duvara sabitle", "Ağır eşyalar savrulmasın"),
        ChecklistItem("heavy_low", "home", "Ağır eşyaları alt raflara koy", "Üst raflar hafif kalsın"),
        ChecklistItem("bed_side", "home", "Yatağın yanına ayakkabı ve fener koy", "Gece çıplak ayak kalma"),
        ChecklistItem("glass", "home", "Cam dolap ve pencerelerden uzak dur", "Sarsıntıda kırılabilir"),
        ChecklistItem("gas_panel", "home", "Gaz ve elektrik panosunu öğren", "Kaçakta nasıl kapatacaksın?"),
        ChecklistItem("exit", "home", "Tahliye yolunu açık tut", "Merdiven ve koridorları doldurma"),
        ChecklistItem("water_heater", "home", "Sıcak su deposunu sabitle", "Yüksekten düşerse ağır yaralanma"),

        // --- Aile planı ---
        ChecklistItem("assembly", "plan", "Toplanma alanını belirle", "AFAD üzerinden en yakın alanı sorgula"),
        ChecklistItem("route", "plan", "İki farklı tahliye rotası seç", "Ana yol kullanılamaz olabilir"),
        ChecklistItem("meeting", "plan", "Aile buluşma noktası belirle", "Herkes oraya gidecek"),
        ChecklistItem("contact", "plan", "Şehir dışı irtibat kişisi belirle", "Yurt içi hatlar kilitlenince o kişiyi ara"),
        ChecklistItem("practice", "plan", "Aile tatbikatı yap", "Yılda en az bir kez"),
        ChecklistItem("kids", "plan", "Çocuklarla konuş", "Okul ve kreşin tahliye planını öğren"),
        ChecklistItem("pets", "plan", "Evcil hayvan için plan yap", "Mama, tasma ve taşıma çantası"),
        ChecklistItem("neighbors", "plan", "Komşularla tanış", "Yaşlı ve engelli komşulara yardım planı")
    )

    fun total(): Int = items.size
}
