import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestMixedOperation {

    @Test
    public void testMixedOperations(){
        new File("test5.md").delete();

        String[] inputList = getInputList();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        assertEquals(
                "└── 旅⾏清单\n" +
                        "    ├── 亚洲\n" +
                        "    |   ├── 1. 中国\n" +
                        "    |   └── 2. ⽇本\n" +
                        "    └── 欧洲\n" +
                        "└── 旅⾏清单\n" +
                        "    ├── 1. 中国\n" +
                        "    ├── 2. ⽇本\n" +
                        "    └── 欧洲\n" +
                        "20231112 15:05:11  list-tree\n" +
                        "20231112 15:05:11  delete 亚洲\n" +
                        "\n" +
                        "└── 旅⾏清单\n" +
                        "    ├── 亚洲\n" +
                        "    |   ├── 1. 中国\n" +
                        "    |   └── 2. ⽇本\n" +
                        "    └── 欧洲\n" +
                        "└── 旅⾏清单\n" +
                        "    ├── 1. 中国\n" +
                        "    ├── 2. ⽇本\n" +
                        "    └── 欧洲\n" +
                        "└── 旅⾏清单\n" +
                        "    ├── 1. 中国\n" +
                        "    ├── 2. ⽇本\n" +
                        "    └── 欧洲\n", output);
    }

    private static String[] getInputList() {
        String input = "load test5.md\n" +
                "append-head # 旅⾏清单\n" +
                "append-tail ## 欧洲\n" +
                "insert 2 ## 亚洲\n" +
                "insert 3 1. 中国\n" +
                "insert 4 2. ⽇本\n" +
                "save\n" +
                "undo\n" +
                "list-tree\n" +
                "delete 亚洲\n" +
                "list-tree\n" +
                "history 2\n" +
                "undo\n" +
                "list-tree\n" +
                "redo\n" +
                "list-tree\n" +
                "redo\n" +
                "list-tree\n" +
                "save";
        return input.split("\n");
    }
}
