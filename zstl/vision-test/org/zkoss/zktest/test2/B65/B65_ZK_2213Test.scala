package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2213.zul")
class B65_ZK_2213Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>
<zk xmlns:h="native">
	<window id="window" width="100%" height="100%">
		<button onClick="loadGrid();" label="load grid" />
		<tabbox vflex="true" hflex="true">
			<tabpanels>
				<tabpanel>
					<listbox mold="paging" id="gridPrincipal" rows="0"
						pagingPosition="bottom" sizedByContent="true" pageSize="10"
						activePage="0" vflex="true" hflex="true">
						<listhead menupopup="none" sizable="true">
							<listheader width="80px" label="Banana" />
							<listheader width="400px" label="Car" />
						</listhead>
					</listbox>
				</tabpanel>
				<tabpanel>
					<groupbox contentStyle="overflow:auto;"
						title="title" vflex="1" hflex="1">
						<tablelayout columns="2" style="padding:0px;"
							width="716px" height="63px" left="2px" top="15px" hflex="true"
							id="FGridPanel2">
							<tablechildren rowspan="1">
								<textbox></textbox>
							</tablechildren>
							<tablechildren rowspan="1">
								<textbox></textbox>
							</tablechildren>
							<tablechildren rowspan="1">
								<textbox></textbox>
							</tablechildren>
						</tablelayout>
						<groupbox title="title" hflex="true"></groupbox>
					</groupbox>
				</tabpanel>
			</tabpanels>
			<tabs>
				<tab selected="true" label="Listagem" />
				<tab label="Cadastro" />
			</tabs>
		</tabbox>
	</window>
	<zscript>
        <![CDATA[
	void loadGrid() {
		List items = new ArrayList();
		for (int y = 0; y < 50; y++) {
			Listitem item = new Listitem();
			Listcell cell = new Listcell();
			cell.setLabel("descricao " + y);
			item.getChildren().add(cell);

			items.add(item);
		}

		Window w = (Window) ((Page) Executions.getCurrent().getDesktop()
				.getPages().iterator().next()).getFellow("window", true);

		Listbox gridPrincipal = w.getFellow("gridPrincipal", true);
		gridPrincipal.getChildren().addAll(items);
	}
]]>        
    </zscript>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      click(jq(".z-tab:contains(Cadastro)"))
      waitResponse()
      verifyImage()
    })
    
  }
}