package Test_Lab1;

import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLab1 {

    @Test
    public void testEdit(){
        new File("test1.md").delete();
        String[] inputList = getInputList1();
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

    @Test
    public void testRedo(){
        new File("test2.md").delete();
        String[] inputList = getInputList2();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        assertEquals("└── 旅⾏清单\n" +
                "    ├── 1. 中国\n" +
                "    └── 2. ⽇本\n", output);
    }

    @Test
    public void testMixedRedo(){
        new File("test3.md").delete();
        String[] inputList = getInputList3();
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

    /*@Test
    public void testWorkspace(){
        new File("test4.md").delete();
        String[] inputList = getInputList4();
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
    }*/

    @Test
    public void testMixedOperations(){
        new File("test5.md").delete();

        String[] inputList = getInputList5();
        // 唯一的文件管理器
        String output = TestUtils.getOutput(inputList);

        Pattern pattern = Pattern.compile("└── 旅⾏清单\n" +
                "    ├── 亚洲\n" +
                "    |   ├── 1. 中国\n" +
                "    |   └── 2. ⽇本\n" +
                "    └── 欧洲\n" +
                "└── 旅⾏清单\n" +
                "    ├── 1. 中国\n" +
                "    ├── 2. ⽇本\n" +
                "    └── 欧洲\n" +
                "(\\d{8} \\d{2}:\\d{2}:\\d{2})  list-tree\n" +
                "(\\d{8} \\d{2}:\\d{2}:\\d{2})  delete 亚洲\n" +
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
                "    └── 欧洲\n");;
        Matcher matcher = pattern.matcher(output);

        assertTrue(matcher.find());

//        assertEquals(
//                "└── 旅⾏清单\n" +
//                        "    ├── 亚洲\n" +
//                        "    |   ├── 1. 中国\n" +
//                        "    |   └── 2. ⽇本\n" +
//                        "    └── 欧洲\n" +
//                        "└── 旅⾏清单\n" +
//                        "    ├── 1. 中国\n" +
//                        "    ├── 2. ⽇本\n" +
//                        "    └── 欧洲\n" +
//                        "20231114 14:07:08  list-tree\n" +
//                        "20231114 14:07:08  delete 亚洲\n" +
//                        "\n" +
//                        "└── 旅⾏清单\n" +
//                        "    ├── 亚洲\n" +
//                        "    |   ├── 1. 中国\n" +
//                        "    |   └── 2. ⽇本\n" +
//                        "    └── 欧洲\n" +
//                        "└── 旅⾏清单\n" +
//                        "    ├── 1. 中国\n" +
//                        "    ├── 2. ⽇本\n" +
//                        "    └── 欧洲\n" +
//                        "└── 旅⾏清单\n" +
//                        "    ├── 1. 中国\n" +
//                        "    ├── 2. ⽇本\n" +
//                        "    └── 欧洲\n", output);
    }

    private static String[] getInputList1() {
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

    private static String[] getInputList2() {
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

    private static String[] getInputList3() {
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

    private static String[] getInputList4() {
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

    private static String[] getInputList5() {
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
