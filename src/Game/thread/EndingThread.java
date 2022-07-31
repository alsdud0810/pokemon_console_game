package Game.thread;


public class EndingThread implements Runnable{
    public void run(){
        String[] script = {"단","델",":"," 훌","륭","하","구","나","."," 나","와 ","리","자","몽","을 ","이","기","다","니",".",".","\n",
                            "단","델",":"," 깔","끔","한 ","경","기","였","어."," 인","정","하","지",".","\n",
                            "단","델",":"," 자",","," 이","제 ","네","가 ","챔","피","언","이","다",". ","축","하","한","다","!"};

        for (int i=0; i<script.length;i++){
            System.out.print(script[i]);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        String[] script2 = {"\n\n\n\n챔","피","언 ","단","델","과 ","리","자","몽","을 ","쓰","러","뜨","리","고 ","지","우","가 ","챔","피","언","이 ","되","었","습","니","다","!","!","\n"};
        for (int i=0; i<script2.length;i++){
            System.out.print(script2[i]);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("게임 종료 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);


    }
}

