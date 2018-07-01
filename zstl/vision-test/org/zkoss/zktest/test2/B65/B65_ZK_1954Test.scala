package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1954.zul")
class B65_ZK_1954Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="Scroll ListBox" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Scroll ListBox" border="normal">
		<div>
			<vbox>
				<label>1.Select the last item in listbox.</label>
				<label>2.Click "delete",then the vertical scroll bar won't display.</label>
			</vbox>
		    <zscript>Object[] o = new Object[10];</zscript>
		    <listbox id="list" width="300px" checkmark="true" multiple="true">
		        <listhead>
		            <listheader>
		                <label value="Column"/>
		            </listheader>
		        </listhead>
		        <listitem forEach="${o}">
		            <listcell label="value"/>
		        </listitem>
		    </listbox>
		    <zscript>
		        <![CDATA[
		            public void deleteSelection() {
		                for(Iterator it = list.getChildren().iterator(); it.hasNext();) {
							if(list.getSelectedItems().contains(it.next()))
								it.remove();
		                }
		            }
		        ]]>
		    </zscript>
		</div>
		<button id="deleteBtn" label="delete" onClick="deleteSelection();"/>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-listitem:eq(9)"))
      waitResponse()
      verifyImage()
    })
    
  }
}