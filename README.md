# 📚 STRUKDAT-2026

| Nama  | Keisya Halimah Mulia |
|-------|----------------------|
| Kelas | A                    |
| NRP   | 5027251068           |
| Mata Kuliah | Struktur Data dan Pemrograman Berorientasi Objek |

Repositori ini berisi **seluruh materi, hands-on kelas, dan latihan mandiri** sepanjang perkuliahan Struktur Data dan Pemrograman Berorientasi Objek serta akan ditulis dalam bahasa Java. Setiap folder diorganisir per topik dan akan terus diperbarui mengikuti perkembangan materi.

---

## Daftar Isi

1. [Struktur Repositori](#struktur-repositori)
2. [Daftar Materi](#daftar-materi)
   - [OOP (Object-Oriented Programming)](#oop--object-oriented-programming)
   - [Materi Selanjutnya](#materi-selanjutnya)
3. [Catatan Java](#catatan-java)
4. [Cara Clone & Setup](#cara-clone--setup)

---

## Struktur Repositori

```
STRUKDAT-2026/
│
├── OOP/
│   ├── Hands on kelas 0203/        # Hands-on kelas, 2 Maret
│   └── Mandiri Practice Modul 1/   # Latihan mandiri modul 1
│
└── (materi selanjutnya akan ditambahkan...)
```

> Struktur folder akan terus berkembang sesuai materi yang dipelajari.

---

## Daftar Materi

### OOP (Object-Oriented Programming)

Fondasi pemrograman berorientasi objek di Java, mencakup konsep class & object, konstruktor, dan 4 pilar utama OOP.

<details>
<summary>Lihat detail materi OOP</summary>

#### 4 Pilar OOP

| Pilar | Penjelasan Singkat |
|-------|--------------------|
| **Encapsulation** | Atribut `private` diakses lewat getter & setter dengan validasi |
| **Abstraction** | `abstract class` dan `abstract method` untuk menyembunyikan detail implementasi |
| **Inheritance** | Subclass mewarisi atribut & method induk via keyword `extends` |
| **Polymorphism** | Satu method, banyak perilaku — diimplementasikan via `@Override` |

#### Folder

| Folder | Isi |
|--------|-----|
| `Hands on kelas 0203/` | Class `Car` dengan encapsulation & constructor; Abstract class `Car` → `ElectricCar` |
| `Mandiri Practice Modul 1/` | Simulasi Music Player: `AudioTrack` (abstract) → `StudioSong`, `LiveStreamAudio` |

#### Cara Menjalankan (Mandiri Practice)

```bash
javac AppMusic.java
java AppMusic
```

</details>

---

### Materi Selanjutnya

Bagian ini akan diisi seiring perkuliahan berlanjut.

| Topik | Status |
|-------|--------|
| OOP | Done |
| ... | Coming soon |

---

## Catatan Java

Beberapa konsep Java penting yang sering dipakai di repo ini:

- `private` → hanya bisa diakses dalam class sendiri
- `protected` → bisa diakses oleh class turunan
- `public` → bisa diakses dari mana saja
- `super()` → memanggil constructor atau method milik parent class
- `@Override` → menandai bahwa method menimpa implementasi dari parent class
- Java bersifat **hybrid** (compiler + interpreter via JVM) → cross-platform, file `.class` bisa jalan di mana saja
- Memory management otomatis lewat **Garbage Collector** — tidak ada destruktor manual seperti di C++

---

## Cara Clone & Setup

```bash
# Clone repositori
git clone https://github.com/username/STRUKDAT-2026.git

# Masuk ke folder project
cd STRUKDAT-2026

# Compile salah satu file (contoh)
javac NamaFile.java

# Jalankan
java NamaFile
```


---

> 📌 README ini akan terus diperbarui seiring bertambahnya materi sepanjang semester.