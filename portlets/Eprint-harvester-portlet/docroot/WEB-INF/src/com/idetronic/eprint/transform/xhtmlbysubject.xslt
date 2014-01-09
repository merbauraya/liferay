<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <ul>
       <xsl:apply-templates select="item" />
  </ul>
</xsl:template>
  <xsl:template match="item">

      <li>
         <h4>
             <a class="trigger" href="#">
             <xsl:value-of select="@name"/>
             </a>
         </h4>
         <div>
             <xsl:attribute name="class">
                <xsl:text>outer </xsl:text>
                <xsl:if test="@level=2">shown </xsl:if>
                <xsl:value-of select="@level" />
                
             </xsl:attribute>
             <div class="inner">
                  <ul>
                     <xsl:apply-templates select="*"/>
                  </ul>
             </div>
         </div>
    </li>

</xsl:template>

</xsl:stylesheet>
