<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:bridge="java:org.portletbridge.portlet.BridgeFunctions"
xmlns:xhtml="http://www.w3.org/1999/xhtml"
xmlns="http://www.w3.org/1999/xhtml"
extension-element-prefixes="bridge"
exclude-result-prefixes="xhtml xsl">

<!-- @author rickard -->
<!-- @author jamie -->
 <xsl:param name="callbackHandler"/>
  <xsl:param name="callbackUser"/>
  <xsl:param name="callbackState"/>


<xsl:output method="html"
encoding="UTF-8"
indent="yes"
standalone="no"
omit-xml-declaration="yes"/>

<xsl:param name="bridge"/>
<xsl:variable name="base" select="/xhtml:HTML/xhtml:HEAD/xhtml:BASE/@href"/>

<!-- Fetch some info from head, and all of body -->
<xsl:template match="/xhtml:HTML">
<xsl:apply-templates select="xhtml:HEAD"/>
<xsl:apply-templates select="xhtml:BODY"/>
</xsl:template>

<xsl:template match="/xhtml:HTML/xhtml:HEAD">
<!--
<xsl:apply-templates select="xhtml:STYLE"/>
<xsl:apply-templates select="xhtml:LINK[bridge:equalsIgnoreCase($bridge, @rel, 'stylesheet') and (not(@media) or (@media != 'print' and @media != 'handheld'))]"/>
-->
<xsl:apply-templates select="xhtml:SCRIPT"/>
<xsl:apply-templates select="xhtml:TITLE"/>
</xsl:template>

<xsl:template match="/xhtml:HTML/xhtml:HEAD/xhtml:TITLE">
<xsl:value-of select="bridge:setTitle($bridge, text())"/>
</xsl:template>

<xsl:template match="/xhtml:HTML/xhtml:BODY">
<DIV>
<xsl:attribute name="class">
<xsl:value-of select="@class"/>
</xsl:attribute>
<SCRIPT>
<xsl:value-of select="@onload"/>
</SCRIPT>
<xsl:apply-templates select="node()"/>
</DIV>
</xsl:template>

<!-- Rewrite links -->
<xsl:template match="xhtml:A/@href">
<xsl:attribute name="href">
<xsl:value-of select="bridge:link($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>

<xsl:template match="xhtml:A/@onclick">
<xsl:attribute name="onclick">
<xsl:value-of select="bridge:script($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>

<!-- Rewrite script links -->
<xsl:template match="xhtml:SCRIPT/@src | SCRIPT/@src">
<SCRIPT>
<xsl:attribute name="type">
<xsl:text>text/javascript</xsl:text>
</xsl:attribute>
<xsl:attribute name="src">
<xsl:value-of select="bridge:link($bridge, $base, .)"/>
</xsl:attribute>
</SCRIPT>
</xsl:template>

<!-- Rewrite image references -->
<xsl:template match="xhtml:IMG/@src">
<xsl:attribute name="src">
<xsl:value-of select="bridge:link($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>

<xsl:template match="xhtml:INPUT/@src">
<xsl:attribute name="src">
<xsl:value-of select="bridge:link($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>

<!-- Rewrite imagemap references -->
<xsl:template match="xhtml:MAP/xhtml:AREA/@href">
<xsl:attribute name="href">
<xsl:value-of select="bridge:link($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>


<!-- Copy style tags from head 
<xsl:template match="/xhtml:HTML/xhtml:HEAD/xhtml:STYLE">
<xsl:copy>
<xsl:apply-templates select="@*"/>
<xsl:value-of select="bridge:style($bridge, $base, .)"/>
</xsl:copy>
</xsl:template> -->

<xsl:template match="@style">
<xsl:attribute name="style">
<xsl:value-of select="bridge:style($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>

<!-- Copy script tags from head -->
<xsl:template match="/xhtml:HTML/xhtml:HEAD/xhtml:SCRIPT[@src] | /HTML/HEAD/SCRIPT[@src]">
<xsl:element name="SCRIPT">
<xsl:attribute name="src">
<xsl:value-of select="bridge:link($bridge, $base, @src)"/>
</xsl:attribute>
</xsl:element>
</xsl:template>

<xsl:template match="/xhtml:HTML/xhtml:HEAD/xhtml:SCRIPT/text()">
<xsl:value-of select="bridge:script($bridge, $base, .)"/>
</xsl:template>

<!-- Convert link tags in head to style tags -->
<xsl:template match="/xhtml:HTML/xhtml:HEAD/xhtml:LINK">
<STYLE type="text/css">@import "<xsl:value-of select="bridge:link($bridge, $base, @href)"/>";</STYLE>
</xsl:template>

<xsl:template match="xhtml:FORM/@action">
<xsl:attribute name="action">
<xsl:value-of select="bridge:link($bridge, $base, .)"/>
</xsl:attribute>
</xsl:template>

<!-- Identity template -->
<xsl:template match="@*|*">
<xsl:copy>
<xsl:apply-templates select="@*|node()"/>
</xsl:copy>
</xsl:template>
</xsl:stylesheet>