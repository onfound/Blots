package sample;

public class Player implements Participant {
    private int stepCount;

    @Override
    public boolean makeMove() {
        if (stepCount >= COUNT_STEP){
            stepCount = 0;
            return false;
        }else stepCount++;
        return true;
    }

}
