package com.ruoyi.Logistics.clean.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.WorkMapper;
import com.ruoyi.Logistics.clean.domain.Work;
import com.ruoyi.Logistics.clean.service.IWorkService;
import com.ruoyi.common.core.text.Convert;

/**
 * workService业务层处理
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Service
public class WorkServiceImpl implements IWorkService 
{
    @Autowired
    private WorkMapper workMapper;

    /**
     * 查询work
     * 
     * @param no work主键
     * @return work
     */
    @Override
    public Work selectWorkByNum(Integer no)
    {
        return workMapper.selectWorkByNo(no);
    }

    /**
     * 查询work列表
     * 
     * @param work work
     * @return work
     */
    @Override
    public List<Work> selectWorkList(Work work)
    {
        return workMapper.selectWorkList(work);
    }

    /**
     * 查询work列表
     *
     * @return work
     */
    @Override
    public List<Work> selectAll()
    {
        return workMapper.selectAll();
    }

    /**
     * 新增work
     * 
     * @param work work
     * @return 结果
     */
    @Override
    public int insertWork(Work work)
    {
        return workMapper.insertWork(work);
    }

    /**
     * 修改work
     * 
     * @param work work
     * @return 结果
     */
    @Override
    public int updateWork(Work work)
    {
        return workMapper.updateWork(work);
    }

    /**
     * 批量删除work
     * 
     * @param nos 需要删除的work主键
     * @return 结果
     */
    @Override
    public int deleteWorkByNums(String nos)
    {
        return workMapper.deleteWorkByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除work信息
     * 
     * @param no work主键
     * @return 结果
     */
    @Override
    public int deleteWorkByNum(Long no)
    {
        return workMapper.deleteWorkByNo(no);
    }

    /**
     * 清理重复数据
     *
     * */
    @Override
    public List<Work> workClean()
    {
        List<Work> works = workMapper.selectWorkList(new Work());
        Map<String, Integer> workmap = new HashMap<>();
        Work work = null;

        for (int i = 0; i < works.size(); i ++ ) System.out.println(works.get(i));

        for (int i = 0; i < works.size(); i ++ ) {
            work = works.get(i);
            //System.out.println(work);
            String wKey = work.getTnum()+work.getStatus().toString();
            if (workmap.get(wKey) == null) {
                workmap.put((wKey), 1);
            }
            else {
                work.setError(1);
            }
            // System.out.println(work.getError());
            if (work.getError() == 1) workMapper.updateWork(work);
        }
        return works;
    }
}
