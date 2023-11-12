import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestRedo {
    @Test
    public void testRedo(){
        new File("test2.md").delete();
        String[] inputList = getInputList();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        assertEquals("└── 旅⾏清单\n" +
                "    ├── 1. 中国\n" +
                "    └── 2. ⽇本\n", output);
    }


    private static String[] getInputList() {
        String input = "load test2.md\n" +
                "append-head # 旅⾏清单\n" +
                "append-tail ## 亚洲\n" +
                "append-tail 1. 中国\n" +
                "append-tail 2. ⽇本\n" +
                "delete 亚洲\n" +
                "undo\n" +
                "redo\n" +
                "list-tree\n" +
                "save";
        return input.split("\n");
    }
}
