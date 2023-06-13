package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Work;

/**
 * workService接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface IWorkService 
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
     * @return work集合
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
     * 批量删除work
     * 
     * @param nos 需要删除的work主键集合
     * @return 结果
     */
    public int deleteWorkByNos(String nos);

    /**
     * 删除work信息
     * 
     * @param no work主键
     * @return 结果
     */
    public int deleteWorkByNo(Long no);
}
