<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@include file="../../common/taglib.jsp" %>
	<%@include file="../../common/common-css.jsp" %>
	<%@include file="../../common/common-js.jsp" %>
<!-- 写需要的 js 文件 -->
<script type="text/javascript">
	
</script>
	
</head>
<body>
<form id="fenye" name="fenye" action="<%=request.getContextPath()%>/background/nonoUser/find.html" method="post">
<div style="overflow-y:scroll;overflow-x:scroll; height:75%;">
<table width="100%" cellpadding="0" cellspacing="0" >
  <!-- 搜索页面展示 -->
  <tr>
     <td align="left" >
       <div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
          	<!-- 表头显示 -->
            <div class="box_top">
                <b>&nbsp;&nbsp;系统管理——>诺诺用户管理列表 </b>
            </div>
            <div class="box_center pt10 pb10">
              <!-- 查询条件添加 -->
              <table cellpadding="0" cellspacing="0">
                <tr>
                  <td>&nbsp;&nbsp;查询条件1</td>
                  <td><input type="text" name="propsName1" value="${propsName1}" class="input-text lh25"/></td>
                  <td>&nbsp;&nbsp;查询条件2</td>
                  <td><input type="text" name="propsName2" value="${propsName2}" class="input-text lh25"/></td>
                    <td>
	                    <div class="box_bottom pb5 pt5 pr10" style="border-top:0px solid #dadada;">
			              <div class="search_bar_btn" style="text-align:right;">
			                 <input type="submit" name="button" class="btn btn82 btn_search" value="查询">   
	                         <sec:authorize ifAnyGranted="ROLE_nono_user_addUI">
	                            <input type="button" name="button" class="btn btn82 btn_add" value="新增" onclick="GOTO('<%=request.getContextPath()%>/background/nonoUser/addUI.html')">
	                         </sec:authorize>
	                         <sec:authorize ifAnyGranted="ROLE_nono_user_delete">
	                            <input type="button" name="button" class="btn btn82 btn_del" value="删除" onclick="return deleteAll()">
	                         </sec:authorize>
	                         <input type="button" name="button" class="btn btn82 btn_res" value="重置" onclick="clearText()">
			              </div>
			            </div>
                    </td>
                </tr>
              </table>
            </div>
          </div>
        </div>
        </div>
     </td>
  </tr>
  <!-- 主页面展示 -->
  <tr>
    <td>
        <div id="table" class="mt10">
            <div class="box span10 oh">
              <table class="list_table" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
			          <tr>
			            <th >
			              <input id="chose" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" />
			            </th>
			            <!-- 显示的列 -->
              									<th>用户编码</th>
							<th>用户真实姓名</th>
							<th>用户手机号</th>
							<th>诺诺用户在自己系统中的唯一标志</th>
							<th>身份证号码</th>
							<th>用户类型：NNBK：诺诺绑卡,MXD:名校贷,但是很多情况下是都存在的</th>
							<th>是否使用状态,1:弃用,0:使用</th>
							<th>创建时间</th>
							<th>更新时间</th>
	
              			<th >基本操作</th>
			          </tr>
			          <c:forEach var="key" items="${pageView.records}">
			              <tr class="tr">
							<!-- 显示的内容 -->
           										<td align="center" >
						<input type="checkbox" name="check" value="${key.userCode}" />
						</td>
						<td align="center" ><a href="<%=request.getContextPath()%>/background/nonoUser/findById.html?objId=${key.userCode}&type=0">${key.userCode}</a></td>
						<td align="center" >${key.userName}</td>
						<td align="center" >${key.mobileNumber}</td>
						<td align="center" >${key.nonoCode}</td>
						<td align="center" >${key.certificateNumber}</td>
						<td align="center" >${key.userType}</td>
						<td align="center" >${key.isDelete}</td>
						<td align="center" >${fn:substring(key.createDate,0,19)}</td>
						<td align="center" >${fn:substring(key.updateDate,0,19)}</td>
						<td align="center" >
						
						<sec:authorize ifAnyGranted="ROLE_nono_user_info">
							<img src="<%=request.getContextPath()%>/images/admin.gif" width="10" height="10" />
							<a href="<%=request.getContextPath()%>/background/nonoUser/findById.html?objId=${key.userCode}&type=0">
							详细信息</a>
						</sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_nono_user_edit">
							<img src="<%=request.getContextPath()%>/images/edt.gif" width="12" height="12" />
							<a href="<%=request.getContextPath()%>/background/nonoUser/findById.html?objId=${key.userCode}&type=1">编辑</a>
						</sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_nono_user_delete">
							<img src="<%=request.getContextPath()%>/images/del.gif" width="16" height="16" />
							<a href="javascript:void(0);" onclick="deleteId('<%=request.getContextPath()%>/background/nonoUser/deleteById.html','${key.userCode}')">删除</a>
						</sec:authorize>
						
						</td>	
			              </tr>
			          </c:forEach>
              </table>
        </div>
      </div>
    </td>
  </tr>
   <!-- 分页 -->
   <tr>
    <td>
        <div id="table" class="mt10">
            <div class="box span10 oh">
              <%@include file="../../common/webfenye.jsp" %>
            </div>
      </div>
    </td>
  </tr>
  
</table>
</div>
</form>
</body>
</html>
