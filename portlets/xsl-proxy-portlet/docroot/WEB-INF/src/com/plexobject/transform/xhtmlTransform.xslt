<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0"
  xmlns:xhtml="http://www.w3.org/1999/xhtml"
  xmlns="http://www.w3.org/1999/xhtml"
  exclude-result-prefixes="xhtml">

  <xsl:param name="callbackHandler"/>
  <xsl:param name="callbackUser"/>
  <xsl:param name="callbackState"/>
  <xsl:param name="portletURL" />
<!-- 
  <xsl:template match="html/body/div/div[@class = 'ep_tm_page_content']">
  		<xsl:copy> 
      <xsl:apply-templates select="@* | node()"/>
    </xsl:copy>
  </xsl:template>	-->
 
  <xsl:template match="@* | node()">
     <xsl:copy> 
      <xsl:apply-templates select="@* | node()"/>
    </xsl:copy>
  </xsl:template> 
<xsl:template match="xhtml:a">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:attribute name="href">
			<xsl:value-of select="$portletURL"/>
			<xsl:text>&amp;origUrl=</xsl:text>
			<xsl:value-of select="./@href"></xsl:value-of>
		</xsl:attribute>
		<xsl:apply-templates select="node()"/>
	</xsl:copy>	
</xsl:template>
  <xsl:template match="xhtml:form">
  	
    <xsl:copy>
      <xsl:apply-templates select="@*"/>
      <xsl:attribute name="action" xmlns:java="http://xml.apache.org/xslt/java">
            <xsl:param name="callbackOriginalActionUrl" select="@action"/>
            <xsl:value-of select="$portletURL" />
            
            <xsl:value-of select="java:com.plexobject.transform.XslContentTransformer.setAction($callbackHandler, string(@action))" />
      </xsl:attribute>
      <xsl:attribute name="method" xmlns:java="http://xml.apache.org/xslt/java">
            <xsl:param name="callbackOriginalMethodType" select="@method"/>
            <xsl:text disable-output-escaping="yes">POST</xsl:text>
            <xsl:value-of select="java:com.plexobject.transform.XslContentTransformer.setMethod($callbackHandler, string(@method))" />
      </xsl:attribute>
      <xsl:attribute name="id">_Form</xsl:attribute>
      <xsl:attribute name="name">_Form</xsl:attribute>
        <input type="hidden" name="_user" value="{$callbackUser}"/>
        <input type="hidden" name="_originalActionUrl" value="{@action}"/>
        <input type="hidden" name="_orginalMethodType" value="{@method}"/>
        <input type="hidden" name="_userState" value="{$callbackState}"/>
      <xsl:apply-templates select="node()"/>
    </xsl:copy>
  </xsl:template>


  


</xsl:stylesheet>

