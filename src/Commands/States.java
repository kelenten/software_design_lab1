package Commands;

import Observers.SessionObserver;

public class States implements ICommand {

    boolean isAll = true;

    SessionObserver observer;

    public States(boolean isAll, SessionObserver observer) {
        this.isAll = isAll;
        this.observer = observer;
    }

    @Override
    public void execute() {
        if(isAll){
            observer.showAll();
        } else {
            observer.showCurrent();
        }
    }

    @Override
    public void undo() {

    }
}
