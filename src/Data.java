public class Data {
    public static boolean enemyRight=true,toSwitch=false,pLeft =false,pRight=false,spacePressed=false;
    public static boolean menu=true,play=false,pause=false,end=false;

    public static int lives,enemyLowY;

    public static void setLives(int num){lives = num;}
    public static void decreaseLives(){lives--;}
    public static int getLives(){return lives;}

    public static boolean isEnemyRight(){return enemyRight;}

    public static boolean isToSwitch(){return toSwitch;}
    public static void setToSwitch(boolean bool){toSwitch = bool;}

    public static void switchDirection(){
        if(enemyRight)
            enemyRight = false;
        else
            enemyRight = true;
    }

    public static void setEnemyLowY(int num){enemyLowY=num;}
    public static int getEnemyLowY(){return enemyLowY;}

    public static void setSpacePressed(boolean bool){spacePressed=bool;}
    public static void setPRight(boolean bool){pRight=bool;}
    public static void setPLeft(boolean bool){pLeft = bool;}

    public static boolean ispLeft(){return pLeft;}
    public static boolean ispRight(){return pRight;}
    public static boolean isSpacePressed(){return spacePressed;}

    public static boolean isMenu(){return menu;}
    public static boolean isPause(){return pause;}
    public static boolean isPlay(){return play;}
    public static boolean isEnd(){return end;}

    public static void togglePause(){
        if(play){
            play=false;
            pause=true;
        }else{
            play=true;
            pause=false;
        }
    }
    public static void toggleEnd(){
        if(play){
            play=false;
            end=true;
        }
    }
    public static void toggleMenu(){
        if(menu){
            play=true;
            menu=false;
        }else if(end){
            end=false;
            menu=true;
        }
    }
}
