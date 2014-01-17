<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output omit-xml-declaration="yes"/>
 
<xsl:template match="/">
  <ul>
  	 <xsl:apply-templates select="item" />
  </ul>
</xsl:template>
  <xsl:template match="item">

      <li>
      	<xsl:if test="*">
	   		   <img>
	   		   		<xsl:attribute name="class">
	   		   			<xsl:text>ep-entry-expander</xsl:text>
	   		   		</xsl:attribute>
	   		   		
	   		   		<xsl:attribute name="src">
	   		   			<xsl:text>/Eprint-Admin-portlet/</xsl:text>
	   		   			<xsl:choose>
	   		   				<xsl:when test="@level &lt; 2">
	   		   					<xsl:text>img/01_minus.png</xsl:text>
	   		   				</xsl:when>
	   		   				<xsl:otherwise>
	   		   					<xsl:text>img/01_plus.png</xsl:text>
	   		   				</xsl:otherwise>
	   		   			</xsl:choose>
	   		   			
	   		   			
	   		   		</xsl:attribute>
	   		   		<xsl:attribute name="alt">
	   		   			<xsl:text>expande</xsl:text>
	   		   		</xsl:attribute>
	   		   </img>
	   	 </xsl:if>
        
             <a>
             	<xsl:attribute name="href">
             		<xsl:text>#</xsl:text>
             	</xsl:attribute>
             		<xsl:attribute name="class">
             		<xsl:text>ep-head-link</xsl:text>
             	</xsl:attribute>
             	<xsl:attribute name="id">
             		<xsl:text>epsubject-</xsl:text>
             		<xsl:value-of select="@key"/>
             	</xsl:attribute>
             	<xsl:value-of select="@name"/>
             	<span>
             		<xsl:attribute name="class">
             			<xsl:text>badge</xsl:text>
             		</xsl:attribute>
             		<xsl:value-of select='sum(.//@total)'/>
             	</span>
             	
             </a>
         
         <div>
             <xsl:attribute name="class">
                <xsl:text>ep-child-cont </xsl:text>
                <xsl:if test="@level &gt; 1">aui-helper-hidden</xsl:if>
                
                
             </xsl:attribute>
              
             <div class="ep-inner">
                  <ul>
                     <xsl:apply-templates select="*"/>
                  </ul>
             </div>
         </div>
    </li>

</xsl:template>

</xsl:stylesheet>
