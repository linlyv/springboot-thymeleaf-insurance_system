package com.gh003.insurance.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Insurance {
    /**
     * 
     */
    private Integer orderid;

    /**
     * 
     */
   

    /**
     * 
     */
    private String policyholder; //被保险人（姓名）
    private String policyholderid;//被保险人id
    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String policyname;//保险类名

    /**
     * 
     */
    private BigDecimal cost;

    /**
     * 
     */
    private Date effecttime;

    /**
     * 
     */
    private Date failuretime;

    /**
     * 
     */
    private Integer saler;

    /**
     * 
     * @return orderid 
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 
     * @param orderid 
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 
     * @return policyholderid 
     */
    public String getPolicyholderid() {
        return policyholderid;
    }

    /**
     * 
     * @param policyholderid 
     */
    public void setPolicyholderid(String policyholderid) {
        this.policyholderid = policyholderid;
    }

    /**
     * 
     * @return policyholder 
     */
    public String getPolicyholder() {
        return policyholder;
    }

    /**
     * 
     * @param policyholder 
     */
    public void setPolicyholder(String policyholder) {
        this.policyholder = policyholder == null ? null : policyholder.trim();
    }

    /**
     * 
     * @return phone 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 
     * @return policyname 
     */
    public String getPolicyname() {
        return policyname;
    }

    /**
     * 
     * @param policyname 
     */
    public void setPolicyname(String policyname) {
        this.policyname = policyname == null ? null : policyname.trim();
    }

    /**
     * 
     * @return cost 
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * 
     * @param cost 
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * 
     * @return effecttime 
     */
    public Date getEffecttime() {
        return effecttime;
    }

    /**
     * 
     * @param effecttime 
     */
    public void setEffecttime(Date effecttime) {
        this.effecttime = effecttime;
    }

    /**
     * 
     * @return failuretime 
     */
    public Date getFailuretime() {
        return failuretime;
    }

    /**
     * 
     * @param failuretime 
     */
    public void setFailuretime(Date failuretime) {
        this.failuretime = failuretime;
    }

    /**
     * 
     * @return saler 
     */
    public Integer getSaler() {
        return saler;
    }

    /**
     * 
     * @param saler 
     */
    public void setSaler(Integer saler) {
        this.saler = saler;
    }
    

    
    
}