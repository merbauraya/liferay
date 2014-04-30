<%@include file="/html/eprint/init.jsp"%>
<%
	Eprint eprint = (Eprint)request.getAttribute("ASSET_ENTRY");
	String info = eprint.getEprintAbstract();
	out.print(info);
%>
