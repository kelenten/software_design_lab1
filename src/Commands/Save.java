package Commands;

public class Save implements Command{
    @Override
    public void execute() {
        System.out.print("保存成功");
    }

    @Override
    public void undo() {

    }
}
