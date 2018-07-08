package com.gh003.user.controller;

import com.gh003.insurance.dao.InsuranceMapper;
import com.gh003.insurance.entity.Insurance;
import com.gh003.user.dao.UserMapper;
import com.gh003.user.entity.User;
import com.gh003.user.service.UserService;
import com.gh003.user.service.impl.UserServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo控制器
 *
 * @author BAIYEQIYA
 * @date 2018/5/20 12:01
 * @since JDK 1.8
 */
@Controller
@CrossOrigin
public class UserController {
	@Autowired
    private UserServiceImpl userServiceImpl;
	
	@Autowired
    private InsuranceMapper insranceMapper;
	@Autowired
	UserMapper usermapper;
	
	//登录后跳转的接口
	 @RequestMapping("/home")
	    public String goHome(Model model,HttpSession session) {
	    	System.out.println("session.getname:"+session.getAttribute("username"));
	    	String name=(String) session.getAttribute("username");
	    	if(name!=null) {
		    	
		    	 User u = userServiceImpl.getUserByName(name);
		    	 Integer salerid = u.getId();
		    	 System.out.println("salerid="+salerid);
		    	 if(u!=null) {
		    		 User verifyUser = userServiceImpl.verifyUser(u);
			    	 if(verifyUser.getGrade().equals("admin")) {
			    		 //System.out.println(user.getName());
				    	 System.out.println(verifyUser.getId()+verifyUser.getGrade());
				    	 model.addAttribute("name",verifyUser.getName());
				    	 model.addAttribute("salerid",verifyUser.getId());
			    		 return "policy";
			    	 }
			    	 else if(verifyUser.getGrade().equals("salesman")) {
			    		 System.out.println(verifyUser.getId()+verifyUser.getGrade());
			    		 model.addAttribute("name",verifyUser.getName());
			    		 model.addAttribute("salerid",verifyUser.getId());
			    		 return "policysaler";
			    	 }
			    	 else {
			    		 model.addAttribute("loginmsg","非法访问！");
			    		 return "loginerror";
			    	 }
		    	 }else {
		  
		    		 return "404";//去掉又报错
		    	 }
		    	 
	    	}
	    	else {
	    		System.out.println(session);
	    		model.addAttribute("loginmsg","需要登录");
	    		return "loginerror";
	    	}
	    	 //if(verifyUser.)
	    	
	        
	       
	    }
	    //查看保单功能(前端URL访问)
	    @RequestMapping("/toPolicyRoot")
	    public String toPolicyAdmin(HttpSession session,ModelMap map) {
	    	System.out.println("/toPolicyRoot ->session.getname:"+session.getAttribute("username"));
	    	String name=(String) session.getAttribute("username");
	    	if(name!=null) {
		    	
		    	 	User u = userServiceImpl.getUserByName(name);
			    	 if(u!=null) {
			    		 User verifyUser = userServiceImpl.verifyUser(u);
				    	 if(verifyUser.getGrade().endsWith("admin")) {
				    		
					    	 System.out.println("id="+verifyUser.getId()+"等级："+verifyUser.getGrade());
					    	 map.addAttribute("name",verifyUser.getName());
					    	 map.addAttribute("salerid",verifyUser.getId());
				    		 return "policyroot";
				    	 }
				    	 else if(verifyUser.getGrade().endsWith("salesman")) {
				    		 System.out.println(verifyUser.getId()+verifyUser.getGrade());
				    		 map.addAttribute("name",verifyUser.getName());
				    		 map.addAttribute("salerid",verifyUser.getId());
				    		 return "policysaler";//返回销售员的保单系统
				    	 }
				    	 else {
				    		 return "404";
				    	 }
			    	 }else {
			    		 return "404";//没有这个用户
			    	 }
	    	 
		   	}
		   	else {
		   		return "404";
		   	}
	    
	    } 
	 
	 
	
	
	//___________________作 业 3 给定户名返回密码_____________________________________________
	 @RequestMapping(value="/findbyname",method = RequestMethod.GET)
	 @ResponseBody
	 public String findbyname(String name) {
		 User user = new User();
		 user=userServiceImpl.getUserByName(name); 
		 if (user!=null) {
			 return "用户："+name+"  密码："+user.getPassword();	
		 }else {
			 return "用户找不到";	
		 }
	 }
    
    
   
   //____________________作 业 4 给定密码返回用户名______________________________________________
    @RequestMapping(value="/finduser",method = RequestMethod.GET)
    @ResponseBody
    public String loginVerify(String password) throws Exception {

    	System.out.println("密码："+password); 	
    	List<User> user;
    	
    	System.out.println("finduser被调用");
    	user=userServiceImpl.getUserListByPasswordFillter(password);
    	if (!user.isEmpty()) {		
    			String us[] = new String[user.size()]; 
    			StringBuffer sB = new StringBuffer();
    			for (int i = 0; i < us.length; i++) { 				
					us[i]="找到用户："+user.get(i).getName()+"  密码："+user.get(i).getPassword()+"<br/>";
					sB.append(us[i]);
    			}		  			 
    		    return sB.toString();
		}
    	else {
    		return "找不到用户："+"因为密码 "+password+"找不到";
    		//return null;
    	}	
     }
    
    @RequestMapping(value="/biaodan/findbypassword",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByPassword(String name,String password) throws Exception {
    	List<User> u;
    	u = userServiceImpl.getUserListByPassword(password);
    	
        return u;
    }  
    //_____________________作业7() 返回所有用户_____2018/6/8______________
    @RequestMapping(value="/findAllUsers")//提供给前端的ajax方法
    @ResponseBody
    public Object findallusers() throws Exception {
    	
    	List<User> user;
    	user = usermapper.selectAllUser();
    	System.out.println("返回所有用户信息");
    	return user;

    	
    }
    
    @RequestMapping("/register")
    @ResponseBody
    public Integer userregister(String name,String password,String sex,Integer age,Model model) throws Exception {
    	
    	//String name,password,email,wechat;
    	System.out.println(name);
    	System.out.println(password);
    	if(userServiceImpl.getUserByName(name)!=null) {
    		return 0;//代表用户已存在(给前端)
    	}			
    	User user = new User();
    	
    	if(name!=null&&password!=null) {
    		user.setName(name);
        	user.setPassword(password);
        	user.setSex("sex");
        	user.setStatus("normal");
        	user.setGrade("salesman");//默认为销售员
        	if(sex==null) {
        		user.setSex("男");
        	}else {
        		user.setSex(sex);
        	}
        	if(age==null)
        		user.setAge(18);
        	else {
        		user.setAge(age);
        	}
        	Date date = new Date();
        	user.setTime(date);

        	userServiceImpl.save(user);
            return 1;	//成功
    	}else {
    		return 2;//提示需要填完整的信息
    	}
    	
    }
    
    
    @RequestMapping("/deleteuser")//提供给前端的ajax方法
    @ResponseBody
    public Integer delUser(Integer id) throws Exception {
    	if(id!=null) {
    		User u = userServiceImpl.getById(id);
    		if(u!=null&&u.getGrade().equals("admin")) {
    			return 2;//管理员不能删除
    		}
    		//int result= userServiceImpl.deleteUserById(id);
    		u.setStatus("deleted");//标记为已删除(注销)
    		int result= userServiceImpl.updateByPrimary(u);
    		System.out.println("删除了"+1+"个用户！");
    		if(result>0) {
    			return 1;
    		}
    		
    	}
        return 0;
    	
    }
    
   
    @RequestMapping("/addU")
    public String adduser(ModelMap map) {   
        return "adduser";
    }
    
    @RequestMapping("/about")
    public String aboutme(HttpSession session,ModelMap map) { 
    	System.out.println("session.getname:"+session.getAttribute("username"));
    	String name=(String) session.getAttribute("username");
    	DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	List<Insurance> ins;
    	if(name!=null) {
    		User u = userServiceImpl.getUserByName(name);
    		ins = insranceMapper.selectBySalerId(u.getId());//根据账户id获取保单(获得保单数量)
    		if(u!=null) {
    			String date = null;
    			date = format1.format( u.getTime());//格式化时间
    			map.addAttribute("name", u.getName() );
    			map.addAttribute("age", u.getAge() );
    			map.addAttribute("sex", u.getSex() );
    			map.addAttribute("password", u.getPassword() );
    			map.addAttribute("grade", u.getGrade().equals("admin")?"管理员":"业务员" );
    			map.addAttribute("time", date );
    			if(!ins.isEmpty()) {
    				map.addAttribute("policynum", ins.size() );//传递保单数量
    			}			
    			
    		}
    	}
        return "aboutme";//返回aboutme.html
    }

}
