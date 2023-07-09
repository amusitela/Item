package com.ruoyi.common.utils.poi;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public interface CSVHandlerAdapter
{
    /**
     * 格式化
     *
     * @param value 单元格数据值
     * @param args csv注解args参数组
     *
     * @return 处理后的值
     */
    Object format(Object value, String[] args);
}
