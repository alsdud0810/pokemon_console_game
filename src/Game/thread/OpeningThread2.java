package Game.thread;

public class OpeningThread2 implements Runnable{
    public void run(){
        System.out.println("\n\n오박사: 함께할 포켓몬이 생겼구나. 축하한다!\n");
        System.out.println("\n오박사: 그럼 이만 나가보거라.\n\n");
        System.out.println("철컥-");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        for (int i = 0; i < 60; i++) {
            System.out.println();
        }
    }
}
