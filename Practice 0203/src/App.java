public class App {
    public static void main(String[] args) throws Exception {
        //inisiasi
        Car myCar = new Car();

        Car myHonda = new Car("Honda", "Brio", "Kuning", 1500);

    
        System.out.println(myCar.getBrand()); //ini buat manggil default
        System.out.println(myHonda.getBrand());

        myCar.setBrand("Toyota");
        System.out.println(myCar.getBrand());

        //kalo gak pakai getter setter pakai di public tapi buruk, soalnya nanti tbtb ngubah sistem termodifikasi secara tdk sengaja
    }
}

class Car {
    //atribut
    //pivate tdk bisa di akses di luar kelass, kalo bisa pakai setter getter. tiap atribut bikin set dan get
    private String brand; //string itu sebenarnya kelas, kalo kecil nanti error
    private String type;
    private String color;
    private int speed;

    // constructor gak perlu return type,  gak bisa ditumpuk/diwariskan, ada 3 jenis
    public Car(){ //tipe 1 no argumen
        this.brand = "Default";
    }

        public Car(String brand, String type, String color, int speed){
            this.brand = brand;
            this.type = type;
            this.color = color;
            this.speed = speed;

        } //type 2 ada paratemeternya
        //type 3 itu impilisit 

    // kalo method hrs ada return type
    // method biasa
    public String getBrand(){ //public supaya bisa digunakan diluar kelas
        return brand;
    }

    public void setBrand(String  brandNew){
        this.brand = "Xenia";
    }
}

//destructur, hps kelas yg udah gak diperlukan itu ga ada. soalnya udah ada gc garbage collection otomatis

/*jenis bahasa pemrograman
copiler = jadi file biner dulu, lbh cpt langsung dieksekusi os, mendekati bahasa mesin
interpreter = punya vm, mendekati bahasa manusia, exp phyton, satuu persatu baris
 hybrid= java seshrap perpaduan keduanya
 .class itu byte codenya
 java punya filosofi bisa di win bisa mac, gak pengaruh sama osnya*/
