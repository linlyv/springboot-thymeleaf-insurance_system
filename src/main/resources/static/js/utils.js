
var baseUrl="http://6.6.6.218:8080/";

var tdiduserid = "<td id='userid'>";
var caozuohead="<td><div role='presentation' class='dropdown'><button class='btn btn-default dropdown-toggle' data-toggle='dropdown' href='#' role='button' aria-haspopup='true' aria-expanded='false'>操作<span class='caret'> </span></button>";
var shanchuhead="<ul class='dropdown-menu'><li><a href='/deleteuser?id=";
var shanchu="'>删除</a></li>";
var updetepasswdhead="<li><a href='newpassword?id=";//后面+data[i].id
var updatepasswd="'>修改密码</a></li></ul></div></td>";
//下面这两个不用
var shanchuhead_b = "<ul class='dropdown-menu'><li><button class='btn btn-danger' onclick='deletetr(this)'>删除</button></li>";//直接删除，没有提示就用这个
var shanchu_btn = "<ul class='dropdown-menu'><li><a id='modal-927525' href='#modal-container-927525' role='button' class='btn btn-danger' data-toggle='modal' onclick='deletetr(this)'>删除</a></li>"    //删除时有提示确认
	
	

var updatepasswd_btn = "<li><button class='btn btn-inverse btn-block btn-warning' onclick='editTd(this)' >修改密码</button></li></ul></div></td>";
var updatephone_btn = "<ul class='dropdown-menu'><li><button class='btn btn-inverse btn-block btn-warning' onclick='editPhoneTd(this)' >修改手机号</button></li></ul></div></td>";

var delmsg = "<div class='col-md-4 column'><div class='alert alert-success alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><h4>成功删除一个账户！</h4></div></div>";




var prepasswd="";
var prephonenum="";

var isdelete=0;
var trtodel = null;


Date.prototype.format =function(format)
{
var o = {
"M+" : this.getMonth()+1, //month
"d+" : this.getDate(), //day
"h+" : this.getHours(), //hour
"m+" : this.getMinutes(), //minute
"s+" : this.getSeconds(), //second
"q+" : Math.floor((this.getMonth()+3)/3), //quarter
"S" : this.getMilliseconds() //millisecond
}
if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
(this.getFullYear()+"").substr(4- RegExp.$1.length));
for(var k in o)if(new RegExp("("+ k +")").test(format))
format = format.replace(RegExp.$1,
RegExp.$1.length==1? o[k] :
("00"+ o[k]).substr((""+ o[k]).length));
return format;
}



function goPage(pno){
			    var itable = document.getElementById("idData");
			    var num = itable.rows.length;//表格所有行数(所有记录数)
			    console.log("查询到"+num+"张保单");
			    var totalPage = 0;//总页数
			    var pageSize = 11;//每页显示行数
			    //总共分几页
			    if(num/pageSize > parseInt(num/pageSize)){
			        totalPage=parseInt(num/pageSize)+1;
			    }else{
			        totalPage=parseInt(num/pageSize);
			    }
			    var currentPage = pno;//当前页数
			    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31
			    var endRow = currentPage * pageSize;//结束显示的行   40
			    endRow = (endRow > num)? num : endRow;    //40
			    
			    //遍历显示数据实现分页
			    for(var i=1;i<(num+1);i++){
			        var irow = itable.rows[i-1];
			        if(i>=startRow && i<=endRow){
			            irow.style.display = "table-row";
			        }else{
			            irow.style.display = "none";
			        }
			    }
			    var pageEnd = document.getElementById("pageEnd");
			    var tempStr = "<span>共"+totalPage+"页</span>";
			 
			 
			//.bind("click",{"newPage":pageIndex},function(event){
			//        goPage((pageIndex-1)*pageSize+1,(pageIndex-1)*pageSize+pageSize);
			//    }).appendTo('#pages');
			    if(currentPage>1){
			        tempStr += "<span class='btn btn-default btn-success' href=\"#\" onClick=\"goPage("+(1)+")\">首页</span>";
			        tempStr += "<span class='btn btn-default btn-success' href=\"#\" onClick=\"goPage("+(currentPage-1)+")\">上一页</span>"
			    }else{
			        tempStr += "<span class='btn btn-default btn-success disabled'>首页</span>";
			        tempStr += "<span class='btn btn-default btn-success disabled'>上一页</span>";
			    }
			 
			    for(var pageIndex= 1;pageIndex<totalPage+1;pageIndex++){
			        tempStr += "<a  onclick=\"goPage("+pageIndex+")\"><span>"+ pageIndex +"</span></a>";
			    }
			 
			    if(currentPage<totalPage){
			        tempStr += "<span class='btn btn-default btn-success'  href=\"#\" onClick=\"goPage("+(currentPage+1)+")\">下一页</span>";
			        tempStr += "<span class='btn btn-default btn-success' href=\"#\" onClick=\"goPage("+(totalPage)+")\">尾页</span>";
			    }else{
			        tempStr += "<span class='btn btn-default btn-success disabled'>下一页</span>";
			        tempStr += "<span class='btn btn-default btn-success disabled'>尾页</span>";
			    }
			 
			    document.getElementById("barcon").innerHTML = tempStr;

			    
		 
}
//不同的表格用不同的方法，这是用户管理模块的方法 id后面带1
function goPage1(pno){
    var itable = document.getElementById("idData1");
    var num = itable.rows.length;//表格所有行数(所有记录数)
    console.log("一共有"+num+"个账户");
    var totalPage = 0;//总页数
    var pageSize = 11;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31
    var endRow = currentPage * pageSize;//结束显示的行   40
    endRow = (endRow > num)? num : endRow;    //40
    console.log(endRow);
    //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){
        var irow = itable.rows[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "table-row";
        }else{
            irow.style.display = "none";
        }
    }
    var pageEnd1 = document.getElementById("pageEnd1");
    var tempStr = "<span>共"+totalPage+"页</span>";
 
 
//.bind("click",{"newPage":pageIndex},function(event){
//        goPage((pageIndex-1)*pageSize+1,(pageIndex-1)*pageSize+pageSize);
//    }).appendTo('#pages');
    if(currentPage>1){
        tempStr += "<span class='btn btn-default btn-success' href=\"#\" onClick=\"goPage1("+(1)+")\">首页</span>";
        tempStr += "<span class='btn btn-default btn-success' href=\"#\" onClick=\"goPage1("+(currentPage-1)+")\">上一页</span>"
    }else{
        tempStr += "<span class='btn btn-default btn-success disabled'>首页</span>";
        tempStr += "<span class='btn btn-default btn-success disabled'>上一页</span>";
    }
 
    for(var pageIndex= 1;pageIndex<totalPage+1;pageIndex++){
        tempStr += "<a  onclick=\"goPage1("+pageIndex+")\"><span>"+ pageIndex +"</span></a>";
    }
 
    if(currentPage<totalPage){
        tempStr += "<span class='btn btn-default btn-success'  href=\"#\" onClick=\"goPage1("+(currentPage+1)+")\">下一页</span>";
        tempStr += "<span class='btn btn-default btn-success' href=\"#\" onClick=\"goPage1("+(totalPage)+")\">尾页</span>";
    }else{
        tempStr += "<span class='btn btn-default btn-success disabled'>下一页</span>";
        tempStr += "<span class='btn btn-default btn-success disabled'>尾页</span>";
    }
 
    document.getElementById("barcon1").innerHTML = tempStr;

}

var ascending=true;
function sort(){
	 var tbody = $("#idData");//保单表格
	 var tr = tbody.children();
	 var tds =tr.find("td:eq(7)");//失效时间的列（数组）
	 tr.detach();//移除排序前的每一行
	 
	 //升序和降序的切换
	 if (ascending){
		 ascendingSort(tds,tr);
	 }
	 else{
		 descendingSort(tds,tr);
	 }
	goPage(1);//分页并跳到表格首页
	
}
//升序排列
function ascendingSort(tds,tr) {
    var len = tr.length;
    var reg = /[\u4e00-\u9fa5]/g;//去掉中文
    var time=new Array(len); 
    var time2=new Array(len); 
    var tbody2 =$("#idData");

    for (var i = 0; i < len - 1; i++) {
    	
        for (var j = 0; j < len - 1 - i; j++) {
        	//console.log(tr[j].children[7]);
        	var str1=tr[j].children[7].innerText.replace(reg,"/");      	
        	var str2=tr[j+1].children[7].innerText;
        	str1=str1.substring(0,str1.length-1);
        	str2=str2.substring(0,str2.length-1);
        	time = str1.split("/");
        	time2 = str2.split("/");

        	if(time[0]>time2[0]){
        		 var temp = tr[j];        // 元素交换             
                 tr[j] = tr[j+1];
                 tr[j+1] = temp;
        	}else if(time[1]>time2[1]){
        		 var temp = tr[j];        // 元素交换             
                 tr[j] = tr[j+1];
                 tr[j+1] = temp;               
        	}
        	else if(time[2] > time2[2]){
        		 var temp = tr[j];        // 元素交换             
                 tr[j] = tr[j+1];
                 tr[j+1] = temp;
        	}
//            if (time[j].getTime() > time[j+1].getTime() ) {        // 相邻元素两两对比        	
//                var temp = tr[j];        // 元素交换             
//                tr[j] = tr[j+1];
//                tr[j+1] = temp;
//                
//            }
        }
    }
    console.log("升序排列");
    for(var i=0;i< tr.length;i++){
		tbody2.append( "<tr>"+tr[i].innerHTML+"</tr>");
		
	}
    ascending=false;
} 



//降序排列
function descendingSort(tds,tr) {
	    var len = tr.length;
	    var reg = /[\u4e00-\u9fa5]/g;
	    var time=new Array(len); 
	    var time2=new Array(len); 
	    var tbody2 =$("#idData");

	    for (var i = 0; i < len - 1; i++) {    	
	        for (var j = 0; j < len - 1 - i; j++) {
	        	//console.log(tr[j].children[7]);
	        	var str1=tr[j].children[7].innerText.replace(reg,"/");
	        	var str2=tr[j+1].children[7].innerText.replace(reg,"/");
	        	str1=str1.substring(0,str1.length-1);
	        	str2=str2.substring(0,str2.length-1);
	        	time = str1.split("/");
	        	time2 = str2.split("/");
	        	
	        	
	        	if(time[0] < time2[0]){
	        		 var temp = tr[j];        // 元素交换             
	                 tr[j] = tr[j+1];
	                 tr[j+1] = temp;
	        	}else if(time[1] < time2[1]){
	        		 var temp = tr[j];        // 元素交换             
	                 tr[j] = tr[j+1];
	                 tr[j+1] = temp;               
	        	}
	        	else if(time[2] < time2[2]){
	        		 var temp = tr[j];        // 元素交换             
	                 tr[j] = tr[j+1];
	                 tr[j+1] = temp;
	        	}
	        	

	            
	        }
	    }
	    console.log("降序排列");
	    for(var i=0;i< tr.length;i++){
			tbody2.append( "<tr>"+tr[i].innerHTML+"</tr>");
		}
	    ascending=true;
}    



function reflash(){
	$.ajax({
		url: baseUrl+"findAllUsers"
	}).then(function(data) {
		console.log("success");
		console.log(typeof(data));
		var mydata = data;
		console.log(data.length);
		var i=0;
		$("#idData1").children().remove();
		for(var i in mydata)
			$("#idData1").append("<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].sex+"</td><td>"+data[i].age+"</td><td>"+data[i].password+"</td><td>"+
					parseDate(data[i].time)+"</td>"+caozuohead+shanchu_btn+updatepasswd_btn+"</tr>");
			console.log(typeof(parseDate(data[i].time)));
	});
	setTimeout("goPage1(1)","1000"); 
}

function findpolicy() {
	  // 声明变量
	  var input, filter, table, tr, td, td2,i;
	  input = document.getElementById("input-filter");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("idData");
	  tr = table.getElementsByTagName("tr");
	 console.log(filter);
	  if(filter){
	  	
	  
	  
	  // 循环表格每一行，查找匹配项
		  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[3];//第四列是用户名
			    td2= tr[i].getElementsByTagName("td")[8];//第9列是销售员id
			    if (td||td2) {												//td2.innerHTML.toUpperCase()==filter  ->精确搜索
				      if (td.innerHTML.toUpperCase().indexOf(filter) > -1 || td2.innerHTML.toUpperCase()==filter) {
				        tr[i].style.display = "";
				      } else {
				        tr[i].style.display = "none";
				      }
			    }
			    
		  }
		  //goPage(1);
	 }else{
	 	goPage(1);
	 }
}



function find() {
			  // 声明变量
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("input-filter1");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("idData1");
			  tr = table.getElementsByTagName("tr");
			 console.log(filter);
			  if(filter){
			  	
			  
			  
			  // 循环表格每一行，查找匹配项
				  for (i = 0; i < tr.length; i++) {
					    td = tr[i].getElementsByTagName("td")[1];

					    if (td) {
						      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						        tr[i].style.display = "";
						      } else {
						        tr[i].style.display = "none";
						      }
					    }
					    
				  }
				  //goPage(1);
			 }else{
			 	goPage1(1);
			 }
		}
function parseDate(item)
   {
    		
    		var d = new Date(item).format("yyyy/MM/dd");
    		return d;
 }

function registerPOST()
{	  
 console.log($("#form").serialize()); 
 $.ajax({  
      type : "POST",
		xhrFields: {
         withCredentials: true
     },
     crossDomain: true,
      url : baseUrl+"register",
		data: $("#form").serialize(),
//		data:JSON.stringify({  
//         name:$("#name").val(),  
//         password:$("#password").val(),  
//         //$(document).getElementById("p1").innerHTML="注册成功，点击登录";
// 		}),
		dataType: "json",
      success : function(data){ 
			//location.href="index.html";
			console.log("success"); 
			//console.log(data); 
			if(data==1){
				location.href="/";
			}else if(data==0){
				document.getElementById("p1").innerHTML="注册失败,用户名已存在";
			}
      },  
      error:function(){  
			console.log("error");
          //location.href="erro.html"; 
      }  
 });   
}  

//提交保单数据
function addpost2()
{	  
 console.log($("#form").serialize()); 
 $.ajax({  
      type : "post",
		xhrFields: {
         withCredentials: true
     },
      crossDomain: true,
      url : baseUrl+"addpolicy",
	  data: $("#form").serialize(),
	  dataType: "json",
      success : function(data){ 
			//location.href="index.html";
			console.log("success"); 
			//console.log(data); 
			if(data==1){
				location.href="home";
			}else if(data==0){
				document.getElementById("p1").innerHTML="提交失败";
			}
      },  
      error:function(){  
			console.log("error");
          //location.href="erro.html"; 
      }  
 });   
}  

function todelete(isdel){
	if(isdel==1){
		var pretr=trtodel.html();//保存要删除的行
		var delid = trtodel.children()[0];
		
		console.log(delid);
		
		$.ajax({
    		url: baseUrl+"deleteuser?id="+delid.innerText,
    	}).then(function(data) {
    		console.log(data);
    		if(data==2){
    			window.alert("管理员账号，无法删除");    			
    			//trtodel.append(trtodel.html());
    		}else{
    			trtodel.detach(); //执行tr的移除
    			//console.log("成功删除一个用户");
    			window.alert("成功删除一个账户");
    			
    		}

    	});
    	isdelete=0;
	}else if(isdel==0){
		console.log($("#delMsg").html());
		
		trtodel=null;
		isdelete=0;
	}else isdelete=0;
}

function deletetr(tdobject){  
    var td=$(tdobject);  
    var pretr=td.parents("tr").html();//保存要删除的行
    trtodel=td.parents("tr");//先保存要删除的对象，交给todelete方法确认  
    var delid = td.parents("tr").children()[0];
    console.log("点击了删除按钮");
   
} 

function editTd(btnobject){
	var btn=$(btnobject);  
	var li1=btn.parents("ul").children()[0];
	var li2=btn.parents("ul").children()[1];
	console.log(li1.innerText);
    var edit_td = btn.parents("tr").children()[4];//对应密码的td
    console.log(edit_td);
    prepasswd=edit_td.innerText;//保存密码在全局变量
    edit_td.innerHTML="<input type='text' name='password' maxlength='11' value='"+edit_td.innerText+"'/>";

	//将编辑改成 保存和取消两个按钮
	li1.innerHTML="<input id='"+edit_td.innerText+"' type='button' class='btn btn-success' onclick='saveEditTd(this);' value='保存'/>";
	li2.innerHTML="<input type='button' class='btn btn-info' onclick='resertEditTd(this);' value='取消'/>";
}
//手机号修改入口
function editPhoneTd(btnobject){
	var btn=$(btnobject);  
	var li1=btn.parents("ul").children()[0];
	
	console.log(li1.innerText);
    var edit_td = btn.parents("tr").children()[5];//5对应手机号的td
    console.log(edit_td);
    prephonenum=edit_td.innerText;//保存原来手机号在全局变量
    edit_td.innerHTML="<input type='text' name='phone' maxlength='11' value='"+edit_td.innerText+"'/>";

	//将修改手机号改成 保存和取消两个按钮
	li1.innerHTML="<input id='"+edit_td.innerText+"' type='button' class='btn btn-success' onclick='savePhoneEdit(this);' value='保存'/><li><input type='button' class='btn btn-info' onclick='cancelPhoneEdit(this);' value='取消'/></li>";
	

}
//取消手机号的修改
function cancelPhoneEdit(li2Object) {
	var btn=$(li2Object);  
	var li1=btn.parents("ul").children()[0];
	var li2=btn.parents("ul").children()[1];
	 
	console.log(li1.innerText);
    var edit_td = btn.parents("tr").children()[5];//对应手机号的td
    var thisinput = $(edit_td).find("input");
    console.log(thisinput);
    console.log(thisinput.val());
    edit_td.innerHTML=prephonenum;//从全局变量恢复原来的手机号

	
	li1.innerHTML="<button class='btn btn-inverse btn-block btn-warning' onclick='editPhoneTd(this)' >修改手机号</button>";
	li2.innerHTML="";
}



//
//取消editTd编辑
function resertEditTd(li2Object) {
	var btn=$(li2Object);  
	var li1=btn.parents("ul").children()[0];
	var li2=btn.parents("ul").children()[1];
	 
	console.log(li1.innerText);
    var edit_td = btn.parents("tr").children()[4];//对应密码的td
    var thisinput = $(edit_td).find("input");
    console.log(thisinput);
    console.log(thisinput.val());
    edit_td.innerHTML=prepasswd;//从全局变量恢复原来的密码

	li1.innerHTML="<a id='modal-927525' href='#modal-container-927525' role='button' class='btn btn-danger' data-toggle='modal' onclick='deletetr(this)'>删除</a>";
	li2.innerHTML="<button class='btn btn-inverse btn-block btn-warning' onclick='editTd(this)' >修改密码</button>";
}

//
function savePhoneEdit(li1Object) {
	var btn=$(li1Object);  
	var li1=btn.parents("ul").children()[0];
	var li2=btn.parents("ul").children()[1];
	 var edit_td = btn.parents("tr").children()[5];//5对应手机号的td
	 var thisinput = $(edit_td).find("input");
	 var phonenum = thisinput.val();
	 console.log(phonenum);
	 var td = btn.parents("tr").children()[0];//保单号对应的td单元格
	 var orderid= td.innerText;
	 console.log("orderid"+orderid);
	 var url = baseUrl+"newphonenum";
	   $.ajax({
	      url:url,
	      type:"post",
	      data:{
	         "orderid":orderid,
	         "phone":phonenum,	         
	         "oldphone":prephonenum,	      
	      },
	      datatype:"json",
	      success:function (result) {
	    	  console.log("success");
	    	  if(result==2){
	    		  window.alert("成功修改手机号");
	    	  }else if(result==0){
	    		  window.alert("缺少必要的参数，失败");
	    	  }
	    	  else {
	    		  window.alert("手机号修改失败");
	    	  }
	    	 
	        
	      }
	   });
	   edit_td.innerHTML=prephonenum;
	
	li1.innerHTML="<button class='btn btn-inverse btn-block btn-warning' onclick='editPhoneTd(this)' >修改密码</button>";
	li2.innerHTML="";
}



//
function saveEditTd(li1Object) {
	var btn=$(li1Object);  
	var li1=btn.parents("ul").children()[0];
	var li2=btn.parents("ul").children()[1];
	
	 var edit_td = btn.parents("tr").children()[4];//对应密码的td
	 var thisinput = $(edit_td).find("input");
	 var password = thisinput.val();
	 console.log(password);
	 var td = btn.parents("tr").children()[1];
	 var name= td.innerText;
	 console.log(name);
	 var url = baseUrl+"newpassword";
	   $.ajax({
	      url:url,
	      type:"post",
	      data:{
	         "name":name,
	         "newpassword":password,	         
	         "oldpassword":prepasswd,	      
	      },
	      datatype:"json",
	      success:function (result) {
	    	  console.log("success");
	    	  window.alert("成功修改密码");
	        
	      }
	   });
	   edit_td.innerHTML=password;
	li1.innerHTML="<a id='modal-927525' href='#modal-container-927525' role='button' class='btn btn-danger' data-toggle='modal' onclick='deletetr(this)'>删除账号</a>";
	li2.innerHTML="<button class='btn btn-inverse btn-block btn-warning' onclick='editTd(this)' >修改密码</button>";
}


function closemodal(){
	
	$('#closemodal').click();
	document.getElementById("p3").innerHTML="";
	
}



//aboutme.html里的方法
function newpasswd(){
	console.log($("#form3").serialize()); 
	var username = document.getElementById("username").value;
	var oldpasswd = document.getElementById("oldpassword").value;
	var newpasswd = document.getElementById("newpassword").value;
	console.log(username);
	 var url = baseUrl+"newpassword";
	   $.ajax({
	      url:url,
	      type:"post",
	      data:{
	         "name":username,
	         "newpassword":newpasswd,	         
	         "oldpassword":oldpasswd,	      
	      },
	      datatype:"json",
	      success:function (data1) {
	    	  console.log("success");
	    	  //window.alert("成功修改密码");
	    	  setTimeout("closemodal()","1000");
	    	  document.getElementById("p3").innerHTML=data1;
	      }
	   });
	 
	 
}


//设置年龄下拉选项
function setage(){

	for (var i=18;i<80;i++){
		$("#select1").append("<option >"+i+"</option>");
	}

}

