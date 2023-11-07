package Commands;

public class Load implements Command{
    String fileName;

    public Load(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        System.out.println("创建文件： " + this.fileName);
    }
}
