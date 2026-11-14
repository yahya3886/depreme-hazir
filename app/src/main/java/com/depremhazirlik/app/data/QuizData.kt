package com.depremhazirlik.app.data

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

object QuizData {

    val questions: List<QuizQuestion> = listOf(
        QuizQuestion(
            question = "Deprem sarsıntısı başladığında ilk ne yapmalısın?",
            options = listOf(
                "Pencereye koşup dışarı bakmak",
                "Çök – Kapan – Tutun: sağlam masa altına gir",
                "Asansöre binip binadan çıkmak",
                "Cam kapıları açıp havalandırmak"
            ),
            correctIndex = 1,
            explanation = "Sarsıntı anında doğru teknik Çök – Kapan – Tutun'dur. Dışarı koşmak ve asansör kullanmak yaralanma riskini artırır."
        ),
        QuizQuestion(
            question = "Deprem sonrası binadan çıkarken hangisi doğru?",
            options = listOf(
                "Asansörle inmek",
                "Elektrik düğmesini açıp kontrol etmek",
                "Merdivenle tahliye olmak ve artçıya hazırlanmak",
                "Binada kalıp beklemek"
            ),
            correctIndex = 2,
            explanation = "Artçı sarsıntılar olabilir. Asansör kesinlikle kullanılmaz; merdivenle tahliye edilir."
        ),
        QuizQuestion(
            question = "Acil durum çantasında ne kadar su bulundurulmalı?",
            options = listOf(
                "Sadece bir günlük",
                "Kişi başı günde 3 litre, en az 3 günlük",
                "Sadece bir hafta sonu için",
                "Su gerekmez, kuru gıda yeter"
            ),
            correctIndex = 1,
            explanation = "Afet sonrası altyapı çökebilir. Kişi başı günde 3 litre olmak üzere en az 3 günlük su stoklanmalıdır."
        ),
        QuizQuestion(
            question = "Enkaz altında sesini duyurmak için ne yapmalısın?",
            options = listOf(
                "Sürekli yüksek sesle bağırmak",
                "Düdük veya cisimle ritmik kısa sesler vermek",
                "Ses çıkarmamak, uyumak",
                "Telefonu sürekli açık tutup konuşmak"
            ),
            correctIndex = 1,
            explanation = "Sürekli bağırmak enerjini bitirir. Düdük veya cisimle ritmik ses vermek hem enerji tasarrufu sağlar hem daha iyi duyulur."
        ),
        QuizQuestion(
            question = "Telefon hatları meşgulken hangisini tercih etmelisin?",
            options = listOf(
                "Uzun uzun aramaya devam etmek",
                "Kısa ve net bir SMS göndermek",
                "Video arama açmak",
                "Sosyal medyada canlı yayın yapmak"
            ),
            correctIndex = 1,
            explanation = "Sesli aramalar hattı daha hızlı kilitler. Kısa SMS, hat açıldığında ulaşma şansını artırır."
        ),
        QuizQuestion(
            question = "Türkiye'nin deprem gerçeği hakkında hangisi doğrudur?",
            options = listOf(
                "Deprem yalnızca doğu illerinde görülür",
                "Ülke topraklarının yaklaşık %90'ı yüksek tehlike altındadır",
                "Deprem birkaç gün önceden kesin anlaşılır",
                "Yüksek binalar depremden etkilenmez"
            ),
            correctIndex = 1,
            explanation = "Türkiye topraklarının yaklaşık %90'ı yüksek deprem tehlikesi altındadır ve nüfusun büyük kısmı bu bölgelerde yaşar."
        )
    )

    fun total(): Int = questions.size
}
