# Java OOP - Hands On 2 Maret

Hasil hands on di kelas pada tanggal 2 Maret, materi Object-Oriented Programming (OOP) di Java.

## Materi yang Dipelajari

- **Encapsulation** – Atribut `private` diakses lewat getter & setter
- **Polymorphism** – Constructor overloading dan method `@Override`
- **Inheritance** – Keyword `extends` untuk mewarisi class induk
- **Abstract Class** – Class yang tidak bisa diinstansiasi langsung

## File

| File | Keterangan |
|------|-----------|
| `App.java` | Contoh dasar class `Car` dengan encapsulation & constructor |
| `App2.java` | Abstract class `Car` diturunkan ke `ElectricCar` |

## Catatan

- `private` → hanya bisa diakses dalam class sendiri
- `protected` → bisa diakses class turunan
- `super()` → memanggil constructor parent class
- Java bersifat **hybrid** (compiler + interpreter via JVM), sehingga cross-platform (`.class` bytecode)
- Memory management otomatis lewat **Garbage Collector**, tidak ada destruktor manual