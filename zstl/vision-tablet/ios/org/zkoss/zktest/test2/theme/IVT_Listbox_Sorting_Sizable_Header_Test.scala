package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Sorting_Sizable_Header_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox fixedLayout="true" width="900px">
	<auxhead>
		<auxheader label="A+B (Align Center)" colspan="2" align="center"/>
		<auxheader label="C" />
	</auxhead>
	<listhead sizable="true">
		<listheader align="center" width="40px"
			image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
		<listheader label="Subject" sort="auto" />
		<listheader label="Received" sort="auto" />
	</listhead>
	<listitem height="28px">
		<listcell
			image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
		<listcell label="ZK Jet 0.8.0 is released" />
		<listcell label="2008/11/17 17:41:29" />
	</listitem>
	<listitem height="28px">
		<listcell
			image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
		<listcell
			label="URLs for iPhone-Optimized Google Sites" />
		<listcell label="2008/11/17 15:56:37" />
	</listitem>
	<listitem height="28px">
		<listcell label="&#160;" />
		<listcell label="Style Guide for ZK 3.5 released" />
		<listcell label="2008/11/14 13:23:07" />
	</listitem>
	<listitem height="28px">
		<listcell
			image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
		<listcell label="ZK Studio 0.9.0 released." />
		<listcell label="2008/11/16 10:26:37" />
	</listitem>
	<listfoot>
		<listfooter label="footer" span="3" align="left" />
	</listfoot>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
