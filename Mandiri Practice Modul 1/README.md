# TUGAS 2 STRUKDAT
Matkul: **STRUKDAT 4 Pillars OOP**

| Nama  | Keisya Halimah Mulia |
| ----- | -------------------- |
| Kelas | A                    |
| NRP   | 5027251068           |


---


Contoh sederhana **Music Player** yang digunakan untuk memahami konsep dasar OOP (Object-Oriented Programming) di Java. Mulai dari apa itu class dan object, sampai ke 4 pilar utama OOP.

**CASE CERITA** developer bikin music player yang bisa handle dua jenis audio, lagu studio dan rekaman live. Daripada bikin dua class terpisah yang isinya hampir sama, dia bikin satu super class `AudioTrack` buat nampung semua kesamaan seperti title, artist, dan volume.

`AudioTrack` dijadikan abstract karena tidak ada yang namanya "memutar audio" tanpa tahu audio apa, yang bisa diputar itu `StudioSong` sama `LiveStreamAudio`. Method `playAudio()` dikosongkan di super class supaya setiap turunan wajib isi caranya sendiri, karena muterin lagu studio dan live concert jelas beda prosesnya.

Volume dibuat `private` dan dikasih validasi di setter, biar tidak ada yang bisa set volume sembarangan sampai angka yang bisa rusak kuping. Akses harus lewat `setVolume()`, kalau inputnya di luar range 0-100 langsung ditolak.

---

## Daftar Isi
1. [Class & Object](#1-class--object)
2. [Konstruktor & Destruktor](#2-konstruktor--destruktor)
3. [4 Pilar OOP](#3-4-pilar-oop)
   - [Encapsulation](#-encapsulation-enkapsulasi)
   - [Abstraction](#-abstraction-abstraksi)
   - [Inheritance](#-inheritance-pewarisan)
   - [Polymorphism](#-polymorphism-polimorfisme)
4. [Struktur Kode](#4-struktur-kode)
5. [Cara Menjalankan](#5-cara-menjalankan)

---

## 1. Class & Object

### Apa itu Class?
Class itu ibarat **cetakan kue**. Cetakannya sendiri bukan kuenya, terdiri lebih dapi dari satu cetakan, jadi bisa bikin banyak kue dengan isian yang berbeda-beda.

Dalam kode ini, `AudioTrack` adalah class. Di dalamnya ada:
- **Atribut**= data yang dimiliki (title, artist, volume)
- **Method**= aksi yang bisa dilakukan (playAudio, setVolume)

```java
abstract class AudioTrack {
    protected String title;
    protected String artist;
    private int volume;
    // ...
}
```

### Apa itu Object?
Object adalah **hasil cetakannya** , kue yang sudah jadi. Setiap object punya nilai atribut masing-masing.

```java
// Membuat object dari class StudioSong
StudioSong myIndieSong = new StudioSong("Bertaut", "Nadin Amizah", 50);

// Membuat object lain dari class LiveStreamAudio
LiveStreamAudio myLiveRecord = new LiveStreamAudio("Theater", "JKT48", 80);
```

`myIndieSong` dan `myLiveRecord` adalah dua object berbeda , sama-sama "audio", tapi isinya beda.

---

## 2. Konstruktor & Destruktor

### Konstruktor
Konstruktor itu seperti **formulir pendaftaran** saat kamu bikin akun baru. Setiap kali object dibuat (`new`), konstruktor langsung dijalankan untuk mengisi data awal.

Ciri-ciri konstruktor:
- Namanya **sama persis** dengan nama class
- **Tidak punya return type** (beda dengan method biasa)
- Langsung jalan saat object dibuat

```java
// Konstruktor di AudioTrack (Super Class)
public AudioTrack(String title, String artist, int volume) {
    this.title = title;
    this.artist = artist;
    this.volume = volume;
}

// Konstruktor di StudioSong (Sub Class)
public StudioSong(String title, String artist, int volume) {
    super(title, artist, volume); // Memanggil konstruktor induk
}
```

> `super()` dipakai untuk memanggil konstruktor milik class induk. Jadi kita tidak perlu nulis ulang pengisian atribut yang sama.

Ada 3 jenis konstruktor:
| Jenis | Keterangan |
|---|---|
| No-Argument | Konstruktor tanpa parameter, isi nilai default |
| Parameterized | Konstruktor dengan parameter, isi nilai saat object dibuat |
| Implicit | Dibuat otomatis Java jika kita tidak bikin konstruktor sama sekali |

### Destruktor
Di Java, **destruktor tidak ada secara eksplisit**. Java punya **Garbage Collector (GC)** yang secara otomatis menghapus object yang sudah tidak dipakai dari memori. Jadi kita tidak perlu khawatir soal memory leak seperti di C++.

---

## 3. 4 Pilar OOP

### Encapsulation (Enkapsulasi)

**Analogi:** Bayangkan mesin ATM. Kamu bisa tarik uang dan cek saldo lewat tombol yang tersedia , tapi kamu tidak bisa langsung otak-atik mesin di dalamnya. Itulah enkapsulasi: **data disembunyikan, akses diatur lewat jalur resmi**.

Dalam kode ini, atribut `volume` dibuat `private` supaya tidak bisa diubah sembarangan dari luar. Untuk mengaksesnya, harus lewat getter dan setter.

```java
private int volume; // Tidak bisa diakses langsung dari luar class

// Getter , untuk MEMBACA nilai
public int getVolume() {
    return volume;
}

// Setter , untuk MENGUBAH nilai, dengan validasi
public void setVolume(int volumeNew) {
    if (volumeNew <= 100 && volumeNew >= 0) {
        this.volume = volumeNew;
        System.out.println("PSN: Volume berhasil diubah ke " + this.volume);
    } else {
        System.out.println("Volume dapat merusak kuping!");
    }
}
```

Kalau tanpa setter dan validasi ini, siapa saja bisa nulis `myIndieSong.volume = 9999` dan langsung meledakkan telinga pendengar.

---

### Abstraction (Abstraksi)

**Analogi:** Kamu tahu cara pakai remote TV , tekan tombol, saluran ganti. Tapi kamu tidak perlu tahu cara kerja sirkuit di dalamnya. Abstraksi adalah **menyembunyikan detail teknis, cukup tampilkan yang perlu saja**.

Di Java, abstraksi diimplementasikan dengan `abstract class` dan `abstract method`.

```java
abstract class AudioTrack {
    // Abstract method , tidak ada isinya, hanya "janji" bahwa
    // setiap class turunan WAJIB mengisi implementasinya sendiri
    abstract void playAudio();
}
```

- `abstract class AudioTrack` → tidak bisa di-`new` langsung. Ini cuma "konsep" audio, bukan audio yang spesifik.
- `abstract void playAudio()` → method tanpa isi. Setiap turunannya wajib override.

Kenapa berguna? Karena kita tahu semua jenis audio **pasti bisa diputar**, tapi cara memutarnya berbeda-beda. Abstraksi memastikan semua turunan punya method itu, tanpa memaksa satu cara.

---

### Inheritance (Pewarisan)

**Analogi:** Anak mewarisi sifat orang tua , warna mata, tinggi badan. Tapi si anak juga punya kepribadiannya sendiri yang berbeda. Itulah inheritance: **class anak mewarisi atribut dan method class induk, tapi bisa punya tambahan sendiri**.

```java
// StudioSong mewarisi semua yang ada di AudioTrack
class StudioSong extends AudioTrack {
    public StudioSong(String title, String artist, int volume) {
        super(title, artist, volume); // Pakai konstruktor induk
    }
}

// LiveStreamAudio juga mewarisi AudioTrack
class LiveStreamAudio extends AudioTrack {
    public LiveStreamAudio(String title, String artist, int volume) {
        super(title, artist, volume);
    }
}
```

Dengan inheritance, kita tidak perlu nulis ulang atribut `title`, `artist`, `volume` dan method `getVolume()`, `setVolume()`, `getTitle()` di setiap class. Cukup tulis sekali di induk, semua anak otomatis dapat.

**Jenis-jenis Inheritance:**
| Jenis | Keterangan |
|---|---|
| Single | Satu anak, satu induk |
| Hierarchical | Banyak anak, satu induk (seperti kode ini) |
| MultiLevel | A → B → C (turunan bertingkat) |
| Hybrid | Kombinasi dari beberapa jenis |
| Multiple | Satu anak, banyak induk (di Java hanya lewat Interface) |

---

### Polymorphism (Polimorfisme)

**Analogi:** Kata "main" punya arti berbeda tergantung konteks , main bola, main piano, main game. Perintahnya sama ("main"), tapi caranya beda. Itulah polymorphism: **satu nama method, banyak perilaku berbeda** (sama tapi beda). 

Di kode ini, `playAudio()` dipanggil pada dua object berbeda, tapi hasilnya berbeda:

```java
// Polymorphism di StudioSong
@Override
void playAudio() {
    System.out.println("Memutar " + title + " by " + artist + " (Kualitas Audio Max).");
    System.out.println("Tingkat volume: " + getVolume());
}

// Polymorphism di LiveStreamAudio , perilaku berbeda!
@Override
void playAudio() {
    System.out.println("Menyambungkan ke stream...");
    System.out.println("Memutar rekaman live " + title + " by " + artist + ".");
    System.out.println("(Terdengar suara sorakan penonton di background!)");
}
```

`@Override` adalah tanda bahwa method ini **menimpa** method induk dengan implementasi baru. Saat `myIndieSong.playAudio()` dipanggil, Java tahu harus jalankan versi StudioSong. Saat `myLiveRecord.playAudio()` dipanggil, Java jalankan versi LiveStreamAudio.

---

## 4. Struktur Kode

```
AudioTrack (abstract class) ← Induk semua audio
│   ├── title, artist (protected)
│   ├── volume (private)
│   ├── playAudio() ← abstract, wajib di-override
│   ├── getVolume() / setVolume() ← encapsulation
│   └── getTitle()
│
├── StudioSong (extends AudioTrack)
│   └── playAudio() ← versi studio, kualitas max
│
└── LiveStreamAudio (extends AudioTrack)
    └── playAudio() ← versi live, ada efek sorakan
```

### Access Modifiers yang Dipakai

| Modifier | Dipakai Pada | Artinya |
|---|---|---|
| `private` | `volume` | Hanya bisa diakses di dalam `AudioTrack` sendiri |
| `protected` | `title`, `artist` | Bisa diakses oleh class turunan (`StudioSong`, `LiveStreamAudio`) |
| `public` | Method getter/setter, konstruktor | Bisa diakses dari mana saja |

---

## 5. Cara Menjalankan

```bash
# Compile
javac AppMusic.java

# Jalankan
java AppMusic
```

**Output yang diharapkan:**
```
||Tes Music Player||
Putar lagu: Bertaut
Memutar Bertaut by Nadin Amizah (Kualitas Audio Max).
Tingkat volume: 50

|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

Menyambungkan ke stream...
Memutar rekaman live Theater by JKT48.
(Terdengar suara sorakan penonton di background!)

||Tes Ubah Volume||
Jika volume diubah ke: 150
Volume dapat merusak kuping

PSN: Saat Ini Volume berhasil diubah ke 60
```

---

> Dibuat sebagai materi pembelajaran OOP Java , Modul 1 & 2