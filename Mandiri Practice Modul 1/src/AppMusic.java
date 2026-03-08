//main abstract class
public class AppMusic{
  public static void main(String[] args){
    //inisiasi object myIndieSong dg constructor dari class StudiSong
    StudioSong myIndieSong = new StudioSong("Bertaut", "Nadin Amizah", 50);

    //object myLiveRecord dg constructor dari class LiveStreamAudio
    LiveStreamAudio myLiveRecord = new LiveStreamAudio("theater ", "JKT48", 80);

    System.out.println("\n||Tes Music Player||");
    System.out.println("Putar lagu: " + myIndieSong.getTitle());

    //polymorfisme
    myIndieSong.playAudio();
    System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    myLiveRecord.playAudio();

    //test ubah volume (encapsulation)
    System.out.println("\n||Tes Ubah Volume||");
    myIndieSong.setVolume(150); //peringatan
    myIndieSong.setVolume(60);  //bisa
  }
}


//1. abstract, abstract class
abstract class AudioTrack {
  protected String title;
  protected String artist;
  private int volume; //encapsulation

  //superclass
  public AudioTrack(String title, String artist, int volume) {
    this.title = title;
    this.artist = artist;
    this.volume= volume;
  }
//abstract method
abstract void playAudio();

//getter setter
public int getVolume(){
  return volume;
}

public void setVolume(int volumeNew){
  if(volumeNew <= 100 && volumeNew >= 0){
    this.volume = volumeNew;
    System.out.println("\nPSN: Saat Ini Volume berhasil diubah ke " + this.volume + "\n");
  }else{
    System.out.println("Jika volume diubah ke: " + volumeNew);
    System.out.print("Volume dapat merusak kuping\n");
  }
}

//getter ambil property protected
public String getTitle(){
  return title;
}}

//2. inheritane, subclass
class StudioSong extends AudioTrack{

  //subclass
  public StudioSong(String title, String artist, int volume){
    super(title, artist, volume); //
  }

  //polymorphism
  @Override
  void playAudio(){
    System.out.println("Memutar " + title + " by " + artist + " (Kualitas Audio Max).");
    System.out.println("Tingkat volume: " + getVolume());
  }}

  //inheritance 2
  class LiveStreamAudio extends AudioTrack{

    public LiveStreamAudio(String title, String artist, int volume){
      super(title, artist, volume);
    }

  //polymorphism 2
  @Override
  void playAudio(){
    System.out.println("Menyambungkan ke stream...");
    System.out.println("Memutar rekaman live " + title + "by " + artist + ".");
    System.out.println("(Terdengan suara sorakan penonton di background!)");
  }
}