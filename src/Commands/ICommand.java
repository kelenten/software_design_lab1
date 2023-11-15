package Commands;

// TODO：具体的操作应该放在命令对象下面
public interface ICommand {
    void execute();

    void undo();
}
