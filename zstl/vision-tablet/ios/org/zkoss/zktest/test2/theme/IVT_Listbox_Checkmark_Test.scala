package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Checkmark_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox id="box" fixedLayout="true" multiple="true" checkmark="true">
	<listhead menupopup="auto">
		<listheader label="Name"/>
		<listheader label="Gender" sort="client"/>
		<listheader label="Age" sort="auto"/>
		<listheader label="Description"/>
	</listhead>
	<listitem selected="true">
		<listcell label="Mary"/>
		<listcell label="FEMALE"/>
		<listcell label="18"/>
		<listcell label="A young lady."/>
	</listitem>
	<listitem selected="true">
		<listcell label="John"/>
		<listcell label="MALE"/>
		<listcell label="20"/>
		<listcell label="A college student."/>
	</listitem>
	<listitem disabled="true">
		<listcell label="Jane"/>
		<listcell label="FEMALE"/>
		<listcell label="32"/>
		<listcell label="A remarkable artist."/>
	</listitem>
	<listitem disabled="true">
		<listcell>
			<a href="http://www.zkoss.org">ZK</a>
		</listcell>
		<listcell label="MALE"/>
		<listcell label="29"/>
		<listcell label="A graduate."/>
	</listitem>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
