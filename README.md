# Depreme Hazır 🇹🇷

Türkiye'deki **deprem gerçeği** üzerine hazırlanmış, Android için Kotlin ile geliştirilmiş
deprem hazırlık uygulaması.

Depreme karşı en etkili korunma, sarsıntı anında yapılacak doğru davranış ve **önceden
hazırlıklı olmaktır**. Bu uygulama; aileni, evini ve kendini depreme hazırlamak için
kontrol listeleri, davranış rehberi, acil numaralar ve bir bilgi testi sunar.

---

## Özellikler

| Sekme | İçerik |
|---|---|
| **Hazırlık** | Hazırlık seviyesi göstergesi, *Çök – Kapan – Tutun* adımları, Türkiye deprem gerçekleri, bilgi testi ve toplanma alanı kartı |
| **Kontrol** | 31 maddelik uygulamalı kontrol listesi: acil durum çantası, ev güvenliği ve aile planı. İşaretlemeler `SharedPreferences` üzerinde kalıcı olarak saklanır |
| **Rehber** | 5 katlanabilir bölüm: deprem öncesi, anında, sonrası, enkaz altında ve dikkat edilmesi gerekenler |
| **Acil** | 112 başta olmak üzere AFAD (122), itfaiye (110), polis (155), jandarma (156), Kızılay (168) ve ALO Sıfır (184) hatları. Tek dokunuşla arama |
| **Test** | 6 soruluk bilgi testi, doğru/yanlış geri bildirimi ve açıklayıcı cevaplar |

Ek olarak:

- Açık/koyu tema desteği (Material 3)
- Tamamen çevrimdışı çalışır — internet izni bile istemez
- Türkçe arayüz
- Tek ekran + alt menü navigasyonu

## Teknoloji

- Kotlin 2.0
- Android SDK 34 (minSdk 24 → Android 7.0+)
- AndroidX, Material Components 1.12
- View Binding
- Gradle 8.13 / AGP 8.11.1

## Derleme

```bash
# Android SDK yolunu belirleyin (veya local.properties dosyasını düzenleyin)
export ANDROID_HOME=/path/to/android-sdk

./gradlew assembleDebug
```

APK çıktısı:

```
app/build/outputs/apk/debug/app-debug.apk
```

Yayın sürümü için:

```bash
./gradlew assembleRelease
```

> Not: `local.properties` dosyası SDK yolunu içerir ve git'e dahil edilmez.

## Projeyi IDE'de açma

Android Studio'dan **Open** ile `deprem-hazirlik` klasörünü seçmeniz yeterli.
Gradle wrapper projeye dahildir.

## Uygulama yapısı

```
app/src/main/java/com/depremhazirlik/app/
├── MainActivity.kt              # Alt menü + fragment yönetimi
├── ui/
│   ├── HomeFragment.kt          # Hazırlık sekmesi
│   ├── ChecklistFragment.kt     # Kontrol listesi sekmesi
│   ├── GuideFragment.kt         # Davranış rehberi sekmesi
│   ├── EmergencyFragment.kt     # Acil numaralar sekmesi
│   └── QuizActivity.kt          # Bilgi testi
├── adapters/
│   ├── ChecklistAdapter.kt
│   ├── GuideAdapter.kt
│   └── EmergencyAdapter.kt
└── data/
    ├── ChecklistData.kt         # 31 hazırlık maddesi
    ├── ChecklistStore.kt        # Kalıcı kayıt (SharedPreferences)
    ├── GuideData.kt             # Rehber metinleri
    ├── EmergencyData.kt         # Acil numaralar
    └── QuizData.kt              # Test soruları
```

## Kaynaklar ve uyarı

İçerik AFAD'ın yayımladığı genel deprem hazırlık önerileri temel alınarak hazırlanmıştır.
Uygulama resmî bir AFAD/Kızılay ürünü değildir; acil durumlarda **112** ve resmî
duyurular esas alınmalıdır.

## Lisans

Örnek proje olarak serbestçe kullanılabilir.
