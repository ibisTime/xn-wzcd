/**
 * @Title XNlh5014Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午8:07:53 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:32:35 
 * @history:
 */
public class XN632317Req extends APageReq {

    private static final long serialVersionUID = 2796572107342038372L;

    private String teamCode;

    private String status;

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
