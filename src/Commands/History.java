package Commands;

import Observers.LogObserver;

public class History implements ICommand {

    int num;

    LogObserver logObserver;

    public History(int num, LogObserver observer) {
        this.num = num;
        this.logObserver = observer;
    }

    @Override
    public void execute() {
        if(num > 0){
            logObserver.getLog(num);
        }
    }

    @Override
    public void undo() {

    }
}
