package com.cotroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.TbJob;
import com.mapper.TbJobMapper;
import com.service.TbJobService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.util.QueryObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private TbJobService jobService;

    @Autowired
    private TbJobMapper tbJobMapper;
    /**
     * 分页查询所有的职位
     * @param m
     * @param page
     * @param limit
     * @param queryObj
     * @return
     */
    @GetMapping("/job")
    public String getAllJob(Model m, @RequestParam(defaultValue = "1") long page, @RequestParam(defaultValue = "10") long limit, QueryObj queryObj){
        QueryWrapper<QueryObj> wrapper = new QueryWrapper<>();
        wrapper.setEntity(queryObj);
        IPage<TbJob> jobPage = jobService.getAllJob(page,limit,wrapper);
        jobPage.setTotal(jobPage.getRecords().size());
        m.addAttribute("jobPage",jobPage);
        m.addAttribute("page",page);
        m.addAttribute("queryObj",queryObj);
        System.out.println(jobPage.getRecords());
        return "job/job";
    }

    /**
     * 根据id获得岗位
     * @param m
     * @param jobId
     * @return
     */
    @RequestMapping("/job/jobDetail")
    public String getJobById(Model m,Integer jobId){
        TbJob job=jobService.getJobById(jobId);
        m.addAttribute("job",job);
        return "job/job-detail";
    }
    @ResponseBody
    @RequestMapping("/job/addNewJob")
    public String addNewJob(Model m,Integer jobId){
        return "暂未开放";
    }

    @RequestMapping("/admin/jobList")
    public String jobList(int limit, int page, Model model){
        List<TbJob> jobList = tbJobMapper.queryJobListByLimit((page-1)*limit,limit);
        model.addAttribute("jobList",jobList);
        return "admin/job/job";
    }
}
