package com.vo;
/**
 * @Author ldd
 * @Description 用来与前端进行信息传输
 * @Date 19:27 2021/3/18
 */
public class ResultVo {
    private boolean flag;   //是否成功
    private Integer status; //状态码
    private String message; //返回信息
    private Object data;    //返回数据

    public ResultVo(){
        super();
    }

    public ResultVo(boolean flag, Integer status, String message, Object data) {
        this.flag = flag;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResultVo(boolean flag, Integer status, String message) {
        this.flag = flag;
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
