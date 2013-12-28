<%@ include file="init.jsp" %>
<%
	Object carousel = request.getAttribute("carousel");
	int i =0;
	String item=" active";
	int itemCount = Integer.parseInt(request.getAttribute("itemSize").toString() );
	
%>

<div id="km-carousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
   <ol class="carousel-indicators">
   	<%
   		String a="active";
   		for (int z = 0; z< itemCount;z++)
   		{
   			if (z>0)
   				a="";
   	%>
   		<li data-target="#km-carousel" data-slide-to="<%=z %>" class="<%=a%>"></li>
   	<%
   		}
   	%>

  </ol>
  
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
   
   
   
   <c:if test="${carousel.carouselType eq 'WEBCONTENT' }">
		<c:forEach items="${carousel.webContentList}" var="webContent">
			 
			<div class="item<%=item%>">
				<%i++;
				if (i>0)
					item="";
				%>
					<liferay-ui:journal-article articleId="${webContent.id }" groupId="${carousel.groupId}" />
			</div>
			
		</c:forEach>
	</c:if>
   
   
    
     
   
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#km-carousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#km-carousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>








<style type="text/css">
	${carousel.cssStyle}
</style>