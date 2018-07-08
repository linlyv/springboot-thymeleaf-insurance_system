function editTd(id){

	var b = $("input[type='button'][id='"+id+"']").parent(); //td
	var a = b.siblings(); //td的兄弟节点
	if(a[1].children.length===0){
	   a[1].innerHTML="<input type='text' value='"+a[1].innerText+"'/>";
	}
	if(a[2].children.length===0){
	   a[2].innerHTML="<input type='text' value='"+a[2].innerText+"'/>";
	}
	if(a[3].children.length===0){
	   a[3].innerHTML="<input type='text' value='"+a[3].innerText+"'/>";
	}
	//将编辑改成 保存和取消两个按钮
	b[0].innerHTML="<input id='"+id+"' type='button' onclick='saveEditTd(this.id);' value='保存'/><input type='button' onclick='resertEditTd();' value='取消'/>
	






}

//取消editTd编辑
function resertEditTd() {
   ready(); //此方法是自己写的，局部刷新页面，重新加载数据
}

function saveEditTd(id) {
	   var a = $("input[type='button'][id='"+id+"']").parent().siblings(); //td的兄弟节点
	   var td_name = a[1].children[0].value; //服务名称
	   var td_alias = a[2].children[0].value; //服务别名
	   var td_type = a[3].children[0].value; //服务类型

	   var url = base_path+"console/cfg/saveEditTd";
	   $.ajax({
	      url:url,
	      type:"post",
	      data:{
	         "td_name":td_name,
	         "td_alias":td_alias,
	         "td_type":td_type,
	         "id":id,
	         "tpl":configId
	      },
	      datatype:"json",
	      success:function (result) {
	         ready(); //此方法是自己写的，局部刷新页面，重新加载数据
	      }
	   });
	}