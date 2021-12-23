package com.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页实体类
 */
@Data
public class PageDTO {

    private List<Question> questions;
    private boolean showLast;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page = 0;  //默认为0
    private List<Integer> pages;

    /**
     * 计算分页
     */
    public void count (){

        if (this.questions.size() % 10 != 0){
            this.page = this.questions.size() / 10+1;
        }else{
            this.page = this.questions.size() /10;
        }

    }

    /**
     * 给list 循环赋值  （有多少页循环多少次）
     */
    public void quesListSize(){
        this.pages = new ArrayList<>();
        for (int i=0;i<this.page ; i++){
            this.pages.add(1);
        }
    }

    /**
     * 快捷 页 赋值
     */
    public void showOrhide(){

        if (this.page == 0){
            this.showLast = false;
            this.showFirstPage = false;
            this.showEndPage = true;
            this.showNext = true;
        }else if(this.page == this.pages.size()){
            this.showLast = true;
            this.showFirstPage = true;
            this.showEndPage = false;
            this.showNext = false;
        }

    }
}
