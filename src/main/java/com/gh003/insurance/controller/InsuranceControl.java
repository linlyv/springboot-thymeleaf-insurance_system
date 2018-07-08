package com.gh003.insurance.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gh003.insurance.dao.InsuranceMapper;
import com.gh003.insurance.entity.Insurance;
import com.gh003.user.entity.User;
import com.gh003.user.service.impl.UserServiceImpl;



@Controller
public class InsuranceControl {

	@Autowired
	InsuranceMapper insuranceMapper;
	
	@Autowired
	UserServiceImpl uServiceImpl;
	
	//添加保单功能模块
	@RequestMapping(value="/addpolicy")//前端通过Ajax访问
	@ResponseBody
	public Integer add(Insurance ins, Integer year) throws ParseException {
		System.err.println(ins.getPhone()+"保险类型："+ins.getPolicyname());
		
		//BigDecimal cost=new BigDecimal(1000);//保险费
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();//把现在的时间作为购买时间
		
		
//		try{
//		String str=date.toString();       
//		        Date dt = new Date(format1.format(date));  
//		        System.out.println("转换后的值：" + date);
//		}catch (Exception e) {
//		e.printStackTrace();
//		}
//		
		
//        Date dt=format1.parse(date.toString());
//        System.out.println(dt);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR,year);//日期加1年
	       
        Date FailureTimeSet=rightNow.getTime();
		System.out.println("FailureTimeSet:"+FailureTimeSet);
		
		
		//date = format1.parse(purchaseTime);
		ins.setFailuretime(FailureTimeSet);
		ins.setEffecttime(date);
		//ins.setCost(cost);
		System.err.println(ins.toString());
		System.err.println(ins.getPolicyname());
		insuranceMapper.insertSelective(ins);
		return 1;
	}
	
	
	@RequestMapping("/toPolicy")//前端直接点击访问
	
	public String getPolicy_Saler(ModelMap map,HttpSession session) throws Exception {
		List<Insurance> listIns;
		System.out.println("/toPolicyRoot ->session.getname:"+session.getAttribute("username"));
		
    	String name=(String) session.getAttribute("username");
		if(name!=null) {
			
			
			 User user = uServiceImpl.getUserByName(name);
			 
			 Integer salerid= user.getId();
			 listIns = insuranceMapper.selectBySalerId(salerid);
			 if (user!=null&&listIns!=null&&salerid!=null) {
				
					 try {
						 if(user.getGrade().equals("admin")&&user.getName().equals(name)) {
							 map.addAttribute("id",salerid.toString());
							 map.addAttribute("name",user.getName());
							 System.out.println("管理员"+user.getName()+"查询了保单");
							 return "policyroot";
						 }
						 else if(user.getGrade().equals("salesman")) {
							 map.addAttribute("salerid",salerid.toString());
								map.addAttribute("name",user.getName());
								System.out.println("业务员查询："+salerid.toString());
								return "policysaler";
						 }
					} catch (Exception e) {
						// TODO: handle exception
					}	
				 
			 }
			
			
		}else if(name==null) {
			map.addAttribute("loginmsg","需要登录");
			return "loginerror";
		}
		
		
		return "404";
	}
	
	//修改手机号
	  @RequestMapping("/newphonenum")
      @ResponseBody
      public Integer newPhone(Integer orderid,String oldphone,String phone) throws Exception {
		  	  System.out.println("修改手机号接口被调用");
              System.out.println("orderid="+orderid);
              System.out.println("oldphone="+oldphone);
              
              Insurance insurance = new Insurance();
              if(orderid!=null && oldphone!=null && phone!=null) {
            	  insurance = insuranceMapper.selectByPrimaryKey(orderid);
            	  if(insurance!=null ) {
            		  insurance.setPhone(phone);
            		 if(insuranceMapper.updateByPrimaryKeySelective(insurance)>0) {
            			 return 2;//修改成功
            		 }
            		 else {
            			 return 3;//修改失败
            		 }
            	  }
            	  else {
            		  return 1;//没有这个保单
            	  }
              }
              else {
            	  return 0;//缺少必要的参数
              }
              
              
      }
	
	
	
	
	
}
