package com.cotroller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.TbDon;
import com.entity.UserInfo;
import com.mapper.TbDonMapper;
import com.service.TbDonService;
import com.util.QueryObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@Controller
public class DonateController {

    @Autowired
    TbDonService tbDonService;

    @Autowired
    TbDonMapper tbDonMapper;

    /**
     * 分页获取所有的捐赠记录
     * @param m
     * @param page
     * @param limit
     * @param queryObj
     * @return
     */
    @RequestMapping("/donate")
    public String getAllDon(Model m, @RequestParam(defaultValue = "1") long page, @RequestParam(defaultValue = "10") long limit, QueryObj queryObj){
        QueryWrapper<QueryObj> wrapper = new QueryWrapper<>();
        wrapper.setEntity(queryObj);
        IPage<TbDon> donPage = tbDonService.getAllDon(page,limit,wrapper);
        donPage.setTotal(donPage.getRecords().size());
        m.addAttribute("donPage",donPage);
        m.addAttribute("page",page);
        m.addAttribute("queryObj",queryObj);

        return "donate/donate";
    }

    /**
     * 跳转到捐赠页面
     * @return
     */
    @RequestMapping("/don/createNewDon")
    public String createNewDon(){
        return "donate/addDonate";
    }

    @RequestMapping("/don/addDon")
    @ResponseBody
    public Integer addDon(TbDon tbDon, HttpSession session){
        UserInfo tbStu= (UserInfo) session.getAttribute("USER");
        if(tbDon.getDonName()!=null&& !"".equals(tbDon.getDonName().trim())&&tbDon.getDonDesc()!=null&&!"".equals(tbDon.getDonDesc())){
            tbDon.setUserid(tbStu.getUserid());
            tbDon.setDonStatus(0);
            tbDon.setDonTime(LocalDateTime.now());
            boolean b = tbDonService.save(tbDon);
            if (b) {
                return 1;
            } else {
                return 0;
            }
        }else {
            return 0;
        }
    }


    /**
     * 根据id查看捐赠的详细信息
     * @param donId
     * @param m
     * @return
     */
    @RequestMapping("/don/getDonById")
    public String getDonById(Integer donId,Model m){
        TbDon tbDon = tbDonService.getDonById(donId);
        m.addAttribute("tbDon",tbDon);
        return "donate/donateDetail";
    }

//    @RequestMapping("/updateDonById")
//    public String updateDonById(TbDon tbDon){
//        //tbDonService.updateById(tbDon);
//        return "redirect:/don/getAllDon";
//    }
//
//    @RequestMapping("/delDonById")
//    public String delDonById(@RequestParam("donId") List<Integer> donIds){
//        //tbDonService.removeByIds(donIds);
//        return "redirect:/don/getAllDon";
//    }

    @GetMapping("/admin/donateList")
    public String donateList(int page,int limit,Model model){
        List<TbDon> donList = tbDonMapper.queryDonateListByLimit((page-1)*limit,limit);
        model.addAttribute("donList",donList);
        return "admin/donate/donate";
    }

}
