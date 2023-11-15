package Test_Lab1;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestWorkspace {
    @Test
    public void testWorkspace(){
        new File("test4.md").delete();
        String[] inputList = getInputList();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        assertEquals(
                "└── 书籍推荐\n" +
                        "    └── 编程\n" +
                        "        ├── ·《设计模式的艺术》\n" +
                        "        ├── ·《云原⽣：运⽤容器、函数计算和数据构建下⼀代应⽤》\n" +
                        "        └── ·《深入理解Java虚拟机》\n" +
                        "└── 旅⾏清单\n" +
                        "    └── 亚洲\n", output);
    }

    private static String[] getInputList() {
        String input = "load test4.md\n" +
                "append-head # 旅⾏清单\n" +
                "append-tail ## 亚洲\n" +
                "save\n" +
                "append-tail 1. 中国\n" +
                "append-tail 2. ⽇本\n" +
                "append-tail ## 欧洲\n" +
                "load test3.md\n" +
                "list-tree\n" +
                "load test4.md\n" +
                "list-tree";
        return input.split("\n");
    }
}
