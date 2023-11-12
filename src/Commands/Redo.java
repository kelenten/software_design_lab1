package Commands;

import java.util.Stack;

public class Redo implements ICommand {

    private Stack<ICommand> redoStacks;

    private Stack<ICommand> undoStacks;

    public Redo(Stack<ICommand> redoStacks, Stack<ICommand> undoStacks) {
        this.redoStacks = redoStacks;
        this.undoStacks = undoStacks;
    }

    @Override
    public void execute() {
        if (!redoStacks.isEmpty()) {
            ICommand last = redoStacks.pop();
            last.execute();
            undoStacks.push(last);
        }
    }

    @Override
    public void undo() {

    }
}
