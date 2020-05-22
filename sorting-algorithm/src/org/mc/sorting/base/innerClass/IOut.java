package org.mc.sorting.base.innerClass;

/**
 * @author machao
 * @date 2020-05-21
 */
public interface IOut {

    /**
     * 获取值
     *
     * @param str
     * @return
     */
    String getValue(String str);

    /**
     * 接口内部类
     */
    class PrintOut implements IOut {
        @Override
        public String getValue(String str) {
            System.out.println("print out");
            return "print out";
        }
    }
}
