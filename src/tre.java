public class tre extends Thread{
	
    private long A[][];  
    private long B[][];  
    private long C[][];  
    private int start ;  
    private int end ;  
    private long sum = 0 ; 
    
   public tre(long a[][],long b[][],int st,int en){  
      this.A = a;  
      this.B = b;  
      this.start = st;  
      this.end = en;  
      this.C = new long[en][en];  
    } 
   public void run(){
	   int i,j,k;
       for( i=start; i< end; i += 3)    
       {    
           for( j=0;j<end;j++)    
           {    
               C [i][j] = 0;    
               for( k=0; k< end;k++)    
               {    
                   C[i][j]+=A[i][k]*B[k][j];    
               }    
           }  
           System.out.println(i);
       }
       
       for( i=start; i<end; i+=3)    
           for( j=0; j<end; j++)     
               sum += C[i][j]; 
   }							
   
   public void serial() {  //串行计算一个矩阵的乘法然后在求和  
       int i,j,k;  
       for( i=0; i< end; i ++)    
       {    
           for( j=0;j<end;j++)    
           {    
               C[i][j]=0;    
               for( k=0; k< end;k++)    
               {    
                   C[i][j]+=A[i][k]*B[k][j];    
               }    
           }    
       }    
       for( i=0; i<end; i++) {    
           for( j=0; j<end; j++) {     
               sum += C[i][j];
              
           }
       }
   }
   public long getSum() {  
       return this.sum;  
   }  
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        int i,j,t = 0;  
        int leng = 1000;  
        long startTime,endTime;  
        long a[][] = new long[leng][leng];  
        long b[][] = new long[leng][leng];  
        //--------------对矩阵A和矩阵B进行初始化-------------    
        for(i=0;i<leng;i++)       
        {    
            t=i+1;    
            for(j=0;j<leng;j++)    
            {    
                a[i][j]=t++;    
                b[i][j]=1;    
            }    
        }
        tre thread1 = new tre(a, b, 0, leng);  
        tre thread2 = new tre(a, b, 1, leng); 
        tre thread3 = new tre(a, b, 2, leng);
       
        //-------------------使用執行緒计算--------------------
        startTime = System.currentTimeMillis();  
        thread1.start();  
        thread2.start();
        thread3.start();
        
        thread1.join();
        thread2.join();
        thread3.join();
        
       
         
        endTime = System.currentTimeMillis();  
        System.out.println("使用執行緒结果 = " + (thread1.getSum() + thread2.getSum()+ thread3.getSum() ));  
        System.out.println("使用執行緒时间 = " + (endTime - startTime));  
      //-------------------迴圈無執行緒计算-------------------- 
        startTime = System.currentTimeMillis();  
        tre Serial = new tre(a, b, 0, leng);  
        Serial.serial();  
        endTime = System.currentTimeMillis();  
        System.out.println("迴圈無執行緒结果 = " + Serial.getSum());  
        System.out.println("迴圈無執行緒时间 = " + (endTime - startTime)); 
	}

}