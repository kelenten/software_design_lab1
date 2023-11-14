import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEdit {
    @Test
    public void testEdit(){
        new File("test1.md").delete();
        String[] inputList = getInputList();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        assertEquals(
                "└── 我的资源\n" +
                        "    └── 程序设计\n" +
                        "        └── 软件设计\n" +
                        "            └── 设计模式\n" +
                        "                ├── 1. 观察者模式\n" +
                        "                ├── 2. 策略模式\n" +
                        "                └── 3. 组合模式\n" +
                        "└── 我的资源\n" +
                        "    ├── 程序设计\n" +
                        "    |   └── 软件设计\n" +
                        "    |       └── 设计模式\n" +
                        "    |           ├── 1. 观察者模式\n" +
                        "    |           ├── 2. 策略模式\n" +
                        "    |           └── 3. 组合模式\n" +
                        "    └── ⼯具箱\n" +
                        "        └── Adobe\n", output);
    }

    private static String[] getInputList() {
        String input = "load test1.md\n" +
                "insert ## 程序设计\n" +
                "append-head # 我的资源\n" +
                "append-tail ### 软件设计\n" +
                "append-tail #### 设计模式\n" +
                "append-tail 1. 观察者模式\n" +
                "append-tail 3. 单例模式\n" +
                "insert 6 2. 策略模式\n" +
                "delete 单例模式\n" +
                "append-tail 3. 组合模式\n" +
                "list-tree\n" +
                "append-tail ## ⼯具箱\n" +
                "append-tail ### Adobe\n" +
                "list-tree\n" +
                "save";
        return input.split("\n");
    }
}
