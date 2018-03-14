public class Data {
    public static boolean enemyRight=true,toSwitch=false,pLeft =false,pRight=false;

    public static boolean isEnemyRight(){return enemyRight;}

    public static boolean isToSwitch(){return toSwitch;}

    public static void setToSwitch(boolean bool){toSwitch = bool;}

    public static void switchDirection(){
        if(enemyRight)
            enemyRight = false;
        else
            enemyRight = true;
    }

    public static void setPRight(boolean bool){pRight=bool;}
    public static void setPLeft(boolean bool){pLeft = bool;}

    public static boolean ispLeft(){return pLeft;}
    public static boolean ispRight(){return pRight;}

}
