package Commands;

import java.util.Stack;

public class Undo implements ICommand {

    private Stack<ICommand> redoStacks;

    private Stack<ICommand> undoStacks;

    public Undo(Stack<ICommand> redoStacks, Stack<ICommand> undoStacks) {
        this.redoStacks = redoStacks;
        this.undoStacks = undoStacks;
    }

    @Override
    public void execute() {
        if (!undoStacks.isEmpty()) {
            ICommand last = undoStacks.pop();
            last.undo();
            redoStacks.push(last);
        }
    }

    @Override
    public void undo() {

    }
}
