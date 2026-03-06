public class App2 {
    public static void main(String[] args) throws Exception {
        
        ElectricCar myCar = new ElectricCar("Tesla", "Brio", "Merah", 0);

        System.out.println(myCar.getSpeed());
        myCar.startEngine();
}
}

abstract class Car{
    protected String brand;
    protected String type;
    protected String color;
    private int speed;

    // constructor
    public Car (String brand, String type, String color, int speed){
            this.brand = brand;
            this.type = type;
            this.color = color;
            this.speed = speed;
    }

    // method abstrak gak perlu kurawal
    abstract void startEngine();

    // encapsulation, melindungi stribut agar tdk bs diakses dr luar
    //setter getter
    public int getSpeed(){ //public supaya bisa digunakan diluar kelas
        return speed;
    }

    public void setSpeed(String speedNew){
        this.brand = speedNew;
    }

}
//protected bs diakses kls turunan, pvt tdk


class ElectricCar extends Car{ //ini itu buat mewarisi, kalo extends itu buat mewarisi, kalo implements itu buat interface
    // constructur
    public ElectricCar (String brand, String type, String color, int speed){
        super (brand, type, color, speed);
    }

    @Override //mbl listrik disel kan beda implementasi, maka ada abstrak method kan mobil pasti bisal jalan
    //melakukan hal yg sama dg cara beda
    void startEngine(){
        System.out.println("Ini Electic Car");

    }
}

//buat extends, asda intansiansi beda, class sama polimorphism