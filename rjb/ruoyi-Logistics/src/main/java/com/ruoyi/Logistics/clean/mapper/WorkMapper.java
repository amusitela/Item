package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Work;

/**
 * workMapper接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface WorkMapper 
{
    /**
     * 查询work
     * 
     * @param no work主键
     * @return work
     */
    public Work selectWorkByNo(Long no);

    /**
     * 查询work列表
     * 
     * @param work work
     * @return work集合
     */
    public List<Work> selectWorkList(Work work);

    /**
     * 查询work列表
     *
     * @return work
     */
    public List<Work> selectAll();

    /**
     * 新增work
     * 
     * @param work work
     * @return 结果
     */
    public int insertWork(Work work);

    /**
     * 修改work
     * 
     * @param work work
     * @return 结果
     */
    public int updateWork(Work work);

    /**
     * 删除work
     * 
     * @param no work主键
     * @return 结果
     */
    public int deleteWorkByNo(Long no);

    /**
     * 批量删除work
     * 
     * @param nos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWorkByNos(String[] nos);
}
