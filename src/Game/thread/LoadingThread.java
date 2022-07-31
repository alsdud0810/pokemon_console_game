package Game.thread;

public class LoadingThread extends Thread {
    public String type;

    public LoadingThread(String type){
        this.type = type;
    }
    public void Loading(){
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("로딩중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }
    public void Starting(){
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("시작중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }

    public void NextStage() {
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("다음 장소로 이동 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }

    public void PreviousStage() {
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("이전 장소로 이동 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }

    public void BackToStage() {
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("장소로 돌아가는 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }
    public void GotoCenter() {
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("포켓몬 센터 입장 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }
    public void GotoShop() {
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("상점 입장 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
    }
    public void GotoGym(){
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("체육관 입장 중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }

    }

    public void run() {
        switch (type) {
            case "loading":  // 로딩중 실행
                Loading();
                break;
            case "starting":  // 시작중 실행
                Starting();
                break;
            case "nextstage":
                NextStage();
                break;
            case "previousstage":
                PreviousStage();
                break;
            case "backtostage":
                BackToStage();
                break;
            case "gotocenter":
                GotoCenter();
                break;
            case "gotoshop":
                GotoShop();
                break;
            case "gotogym":
                GotoGym();
                break;
        }
    }
}
