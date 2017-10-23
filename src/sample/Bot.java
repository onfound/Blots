package sample;


public class Bot implements Participant {
    private Field field;

    Bot(Field field){
        this.field = field;
    }

    @Override
    public boolean makeMove() {
        System.out.println("JUST DO IT, BOT!!!!");
        return true;
    }
}
