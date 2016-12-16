<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="../../common/taglib.jsp"%>
<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/common-js.jsp"%>
</head>

<body>

<div style="height: 100%;overflow-y: auto;">
<div id="forms" class="mt10">
   <div class="box">
     <div class="box_border">
       <div class="box_top" ><b class="pl15" >系统管理——>信息展示</b></div>
       <div class="box_center" style="overflow-y:scroll;align:center; height:75%;">
		<form action="" method="post" name="userForm" id="userForm">
			<input type="hidden" name="userCode" value="${objId}"><!-- 修改时候自动添加 -->
			<table class="form_table pt15 pb15 list_table" width="100%" border="1" cellpadding="0" cellspacing="0">
                 <!-- 展示信息 -->
                			<tr>
					<td class="td_right">
						用户编码:
					</td>
					<td class="td_left" >
					${object.userCode}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						用户真实姓名:
					</td>
					<td class="td_left" >
					${object.userName}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						用户手机号:
					</td>
					<td class="td_left" >
					${object.mobileNumber}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						诺诺用户在自己系统中的唯一标志:
					</td>
					<td class="td_left" >
					${object.nonoCode}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						身份证号码:
					</td>
					<td class="td_left" >
					${object.certificateNumber}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						用户类型：NNBK：诺诺绑卡,MXD:名校贷,但是很多情况下是都存在的:
					</td>
					<td class="td_left" >
					${object.userType}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						是否使用状态,1:弃用,0:使用:
					</td>
					<td class="td_left" >
					${object.isDelete}
					</td>
				</tr>
				<tr>
					<td class="td_right">
						创建时间:
					</td>
					<td class="td_left" >
					${fn:substring(object.createDate,0,19)}"
					</td>
				</tr>
				<tr>
					<td class="td_right">
						更新时间:
					</td>
					<td class="td_left" >
					${fn:substring(object.updateDate,0,19)}"
					</td>
				</tr>
	     
                                   
				<tr>
					<td class="td_right">
                    </td>
                    <td class="td_left">
                      <input type="button"  class="btn btn82 btn_nochecked" value="返回" onclick="location.href='javascript:history.go(-1)'">
                    </td>
				</tr>
			</table>
		  </form>
		  </div>
          </div>
        </div>
     </div>
	</div>
</body>
</html>
