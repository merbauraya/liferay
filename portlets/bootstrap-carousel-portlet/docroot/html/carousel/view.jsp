<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />


<div id="km-carousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#km-carousel" data-slide-to="0" class="active"></li>
    <li data-target="#km-carousel" data-slide-to="1"></li>
    <li data-target="#km-carousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
   
    
     <div class="item active">
    	<div class="carousel-item">
    		<div class="c-item-left">
	    		<h6> Welcome to knowldege management @ptar</h6>
	    		<ul>
	    			<li>Document Management</li>
	    			<li>Calendar &amp; Event management</li>
	    			<li>Feeds from multiple sources</li>
	    			<li>More coming...</li>
	    		</ul>
	    	</div>
	    	<img src="http://fedora19:8080/documents/10179/162513/ptar_km.png/b25efa25-89e4-4cff-b709-eb4dd5b9d6db?t=1386403842259">
    	</div>
    </div>
    <div class="item">
    	<div class="carousel-item">
    		<div class="c-item-left">
    			<h6>Document Management</h6>
    			<ul>
    				<li>Safely store your documents</li>
    				<li>Keep track of new upload</li>
    				<li>Access permission control</li>
    				<li>Document versioning support</li>
    			</ul>
    		</div>
    		<img src="http://fedora19:8080/documents/10179/11710/doc_mgmt.jpg/d742f9df-c3d1-45fa-b268-f749ce9e2061?t=1386411220607"/>
    		
    	</div>
    </div>
    
    <div class="item">
    	<div class="carousel-item">
    		<div class="c-item-left">
    			<h6>Calendar & Event Management</h6>
    			<ul>
    				<li>Keep track of PTAR event</li>
    				<li>Subscribe to event feed</li>
    				<li>Import/export calendar event</li>
    				<li>Event notification</li>
    			</ul>
    		</div>
    		<img src="http://fedora19:8080/documents/10179/162513/calendar.jpg/6bf55887-be58-437b-81d7-4904e1813c1f?t=1386446571869"/>
    	</div>
    </div>
   
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#km-carousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#km-carousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>