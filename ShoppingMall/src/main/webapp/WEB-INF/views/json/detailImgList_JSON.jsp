<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
	<c:forEach var="i" items="${imgs }" varStatus="status">
		<c:if test="${not status.first }">
			,
		</c:if>
		{
			"num": ${i.num },
			"p_num": ${i.p_num },
			"img": "${i.img }"
		}
	</c:forEach>
]