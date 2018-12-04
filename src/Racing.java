
public class Racing {
  public static void main(String[] args) throws InterruptedException {
    int h1 = 0;
    
    //產生Horse物件並啟動執行緒
    Horse h2 = new Horse();
    long a = System.currentTimeMillis();
    h2.start();
    h2.join();
    
   // try {
       // h2.join();       
   // }catch (InterruptedException e) {
       // System.out.println("執行緒被中斷");
    //}
    
    for (int i=0; i<5000; i++){
      h1++;
      System.out.println("H1:"+h1);
    }
    long b = System.currentTimeMillis();
    System.out.println(a);
    System.out.println(b);
  }
}