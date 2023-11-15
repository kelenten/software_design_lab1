package Test_Lab1;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestMixedRedo {
    @Test
    public void testMixedRedo(){
        new File("test3.md").delete();
        String[] inputList = getInputList();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        assertEquals(
                "└── 书籍推荐\n" +
                        "    └── 编程\n" +
                        "        └── ·《设计模式的艺术》\n" +
                        "└── 书籍推荐\n" +
                        "    └── 编程\n" +
                        "        ├── ·《设计模式的艺术》\n" +
                        "        ├── ·《云原⽣：运⽤容器、函数计算和数据构建下⼀代应⽤》\n" +
                        "        └── ·《深入理解Java虚拟机》\n", output);
    }

    private static String[] getInputList() {
        String input = "load test3.md\n" +
                "append-head # 书籍推荐\n" +
                "append-tail * 《深入理解计算机系统》\n" +
                "undo\n" +
                "append-tail ## 编程\n" +
                "append-tail * 《设计模式的艺术》\n" +
                "redo\n" +
                "list-tree\n" +
                "append-tail * 《云原⽣：运⽤容器、函数计算和数据构建下⼀代应⽤》\n" +
                "append-tail * 《深入理解Java虚拟机》\n" +
                "undo\n" +
                "redo\n" +
                "list-tree\n" +
                "save";
        return input.split("\n");
    }
}
