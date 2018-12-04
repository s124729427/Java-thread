
public class RacingNG {
    public static void main(String[] args) {
    	long time_1;    	
        long time_2;
        int h1 = 0;
        int h2 = 0;
        time_1 = System.currentTimeMillis();
        for (int i=0; i<5000; i++){
            h1++;
            h2++;
            System.out.println("H1:"+h1);
            System.out.println("H2:"+h2);
        }
        time_2 = System.currentTimeMillis();
        System.out.println((time_2-time_1));
        System.out.println(time_1);
        System.out.println(time_2);
    }
}