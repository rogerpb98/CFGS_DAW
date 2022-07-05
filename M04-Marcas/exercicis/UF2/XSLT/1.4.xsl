<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>My CD Collection</h2>
  <table border="1">
    <ul>
      <li style="text-align:left">Title</li>
      <li style="text-align:left">Autor</li>
    </ul>
    <xsl:for-each select="cataleg/llibre">
    <ul>
      <li><xsl:value-of select="autor"/></li>
      <li><xsl:value-of select="titol"/></li>
    </ul>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

