package com.gh003.user.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gh003.user.entity.User;
import com.gh003.user.service.impl.UserServiceImpl;
@Controller
public class LoginController {
	@Autowired
    private UserServiceImpl userServiceImpl;
	//________________作 业 5 用户登录验证实验______________________________________________
	    @RequestMapping(value="/login")//前端页面提交数据
	    @ResponseBody
	    public Integer login1(String name,String password,Model model,HttpSession session) throws Exception {
	    	Integer msg=new Integer(0);
	    	System.out.println(name);
	    	System.out.println(password);
	    	User user = new User();
	    	user=userServiceImpl.getUserByName(name);
	    	System.out.println("login被调用");
	    	if (user!=null) {
				if(user.getPassword().equals(password) ) {
					System.out.println("ok");
					model.addAttribute("name", name);//退出按钮需要这个参数值
					session.setAttribute("username",name);
					if(user.getStatus().equals("deleted")) {
						msg=4;//已删除(注销)用户不能登录
						return msg;
					}
					msg=1;//登录成功
					return msg;			
				}
				
				else {
					System.out.println("error");
					model.addAttribute("msg", "passwdError");
					msg=2;//密码错误
					return msg;
				}
			}
	    	else {
	    		System.out.println("用户名不存在");
	    		model.addAttribute("msg", "nameError");
	    		msg=3;
				return msg;
	    	}
	    	
	    }
	    
	    
	    

	    @RequestMapping("/loginVerify")//直接url访问
	    public String loginVerify(String name,String password,HttpSession session,Model model){
	        User user = new User();
	        user.setName(name);
	        user.setPassword(password);
	        System.out.println("登录验证…………");
	        boolean verify = userServiceImpl.verifyLogin(user);
	        if (verify) {
	            session.setAttribute("username",name);
	            return "loginsuccess";
	            //return "redirect:/home";//重定向->UserController.goHome()方法
	        } else {
	        	model.addAttribute("loginmsg","登录失败，账号或者密码错误");
	    		return "loginerror";
	            //return "redirect:/index.html";//重定向到登录的HTML静态页面
	        }
	    }
	    
	    
	    @RequestMapping("/loginout")
	    public String loginOut(String name,HttpSession session){
	        User user = new User();
	        user.setName(name);
	       
	        System.out.println("退出登录…………");
	        User u = userServiceImpl.getUserByName(name);
	        if (u!=null) {
	            session.removeAttribute("username");
	            return "redirect:/home";//重定向->UserController.gohome()方法
	        } else {
	            return "redirect:/index.html";//重定向到登录的HTML静态页面
	        }
	    }
	    
	    
	    //________________作业6:修改密码
	    @RequestMapping("/newpassword")
        @ResponseBody
        public String newpassword(String name,String oldpassword,String newpassword) throws Exception {
                
                System.out.println(name);
                System.out.println(oldpassword);
                
                User user = new User();
                
                System.out.println("newpassword被调用");
                user=userServiceImpl.getUserByName(name);
                if (user!=null&&oldpassword!=null) {
                            if(user.getPassword().equals(oldpassword)&&newpassword!=null) {
                                       user.setPassword(newpassword);
                                            if (userServiceImpl.updateByPrimary(user)>0) {
                                                    System.out.println("ok");
                                                    return "密码修改成功";
                                            }
                                            else {
                                                    return "更新失败";
                                            }                                                                                                                                
                            }
                            else if(newpassword==null) {
                            	return "新密码不能为空";
                            }
                            else {
                                    System.out.println("error");
                                    return "旧密码错误";
                            }
                    }
                else if(user==null) {
                	return "用户名不能为空";
                }
                else if(oldpassword==null) {
                	return "旧密码不能为空";
                }
                else {
                        System.out.println("none");
                        return "用户名不存在";
                }
                
        }
	    
	    
}
