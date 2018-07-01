package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Header_Column_Embedded_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<grid fixedLayout="true" width="900px">
	<columns sizable="true">
		<column label="Type">
			<menubar>
				<menu label="File">
					<menupopup>
						<menuitem label="New"
							onClick="alert(self.label)" />
						<menuitem label="Open"
							onClick="alert(self.label)" />
						<menuitem label="Save"
							onClick="alert(self.label)" />
						<menuseparator />
						<menuitem label="Exit"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
				<menu label="Help">
					<menupopup>
						<menuitem label="Index"
							onClick="alert(self.label)" />
						<menu label="About">
							<menupopup>
								<menuitem label="About ZK"
									onClick="alert(self.label)" />
								<menuitem
									label="About Potix" onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
			</menubar>
			<button label="lable" onClick='alert("button")' />
			<datebox />
		</column>
		<column label="Content">
			<listbox rows="1" mold="select">
				<listitem label="option1" />
				<listitem label="option2" />
				<listitem label="option3" />
			</listbox>
		</column>
	</columns>
	<rows>
		<row>
			<label value="File:" />
			<textbox width="99%" />
		</row>
		<row>
			<label value="Type:" />
			<hbox>
				<listbox rows="1" mold="select">
					<listitem label="Java Files,(*.java)" />
					<listitem label="All Files,(*.*)" />
				</listbox>
				<button label="Browse..." />
			</hbox>
		</row>
		<row>
			<label value="Options:" />
			<textbox rows="3" width="99%" />
		</row>
	</rows>
</grid>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
