<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <body>
        <h1>
          Zbiór wierszy
        </h1>
        <xsl:for-each select="//Poem">
          <strong>
            <h5>
              <xsl:value-of select="Author/FirstName"/>
              <xsl:text disable-output-escaping="yes"><![CDATA[&nbsp;]]></xsl:text>

              <xsl:value-of select="Author/LastName"/>
            </h5>
            <h2>
              <xsl:value-of select="Title"/>
            </h2>
          </strong>
          <xsl:for-each select="Strophe">
            <xsl:for-each select="Verse">
              <xsl:apply-templates/>
              <br/>
            </xsl:for-each>
            <br/>
          </xsl:for-each>
          <br/>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="Bold">
    <strong>
      <xsl:apply-templates/>
    </strong>
  </xsl:template>
  <xsl:template match="*">
    <xsl:value-of select="."/>
  </xsl:template>

</xsl:stylesheet>
