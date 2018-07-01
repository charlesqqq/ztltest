package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-1856.zul")
class F70_ZK_1856Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk xmlns:ca="client/attribute">
	<hlayout width="900px">
		<vlayout hflex="1">
			<window title="fake scrollbar" border="normal">
				<div>should see frozen work</div>
				<tree rows="5" width="400px">
					<frozen columns="2" start="1" />
					<treecols sizable="true">
						<treecol width="100px">ID</treecol>
						<treecol width="50px">Priority</treecol>
						<treecol width="50px">Status</treecol>
						<treecol width="150px">Summary</treecol>
						<treecol width="250px">Detail</treecol>
					</treecols>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell>0001</treecell>
								<treecell>1</treecell>
								<treecell>closed</treecell>
								<treecell>Fix login issue</treecell>
								<treecell>
									Login does not work at all
								</treecell>
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell>0002</treecell>
								<treecell>3</treecell>
								<treecell>open</treecell>
								<treecell>Button style broken</treecell>
								<treecell>Check main.css</treecell>
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell>00021</treecell>
										<treecell>1</treecell>
										<treecell>closed</treecell>
										<treecell>
											Fix logout issue
										</treecell>
										<treecell>
											Logout does not work at all
										</treecell>
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell>0003</treecell>
								<treecell>2</treecell>
								<treecell>open</treecell>
								<treecell>
									Client search result
								</treecell>
								<treecell>
									Search service returns incomplete
									result
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
				<div>There are only one scroll bar in tree</div>
				<tree width="400px">
					<treecols>
						<treecol label="column ${each}"
							forEach="1,2,3,4,5,6,7,8,9" width="200px" />
					</treecols>
					<frozen columns="1" />
					<treechildren>
						<treeitem forEach="1,2,3,4,5">
							<treerow>
								<treecell forEach="1,2,3,4,5,6,7,8,9">
									item ${each}
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
				<div>
					Please click the button of 'Change pageSize', and
					then you should see the horizontal scrollbar inside
					the tree should be avalible as well.
				</div>
				<div>
					<button label="Change pageSize"
						onClick='d.height="100px"; tree.pageSize = 3;' />
					<div id="d" style="overflow:auto;">
						<tree id="tree" mold="paging" pageSize="1">
							<frozen columns="1" />
							<treecols>
								<treecol label="Index" />
								<treecol label="Head 1" />
								<treecol label="Head 2" />
								<treecol label="Head 3" />
							</treecols>
							<treechildren>
								<treeitem forEach="1,1,1">
									<treerow>
										<treecell forEach="1,2,3,4">
											item ${each}
										</treecell>
									</treerow>
								</treeitem>
							</treechildren>
						</tree>
					</div>
				</div>
				<div>the footer can be scroll too</div>
				<tree width="400px">
					<treecols>
						<treecol label="column ${each}"
							forEach="1,2,3,4,5,6,7,8,9" width="200px" />
					</treecols>
					<frozen columns="1" />
					<treechildren>
						<treeitem forEach="1,2,3,4,5">
							<treerow>
								<treecell forEach="1,2,3,4,5,6,7,8,9">
									item ${each}
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
					<treefoot>
						<treefooter forEach="1,2,3,4,5,6,7,8,9"
							label="item ${each}" />
					</treefoot>
				</tree>
			</window>
		</vlayout>
		<vlayout hflex="1">
			<window title="native scrollbar" border="normal">
				<div>should see frozen work</div>
				<tree rows="5" width="400px">
					<custom-attributes org.zkoss.zul.nativebar="true" />
					<frozen columns="2" start="1" />
					<treecols sizable="true">
						<treecol width="100px">ID</treecol>
						<treecol width="50px">Priority</treecol>
						<treecol width="50px">Status</treecol>
						<treecol width="150px">Summary</treecol>
						<treecol width="250px">Detail</treecol>
					</treecols>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell>0001</treecell>
								<treecell>1</treecell>
								<treecell>closed</treecell>
								<treecell>Fix login issue</treecell>
								<treecell>
									Login does not work at all
								</treecell>
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell>0002</treecell>
								<treecell>3</treecell>
								<treecell>open</treecell>
								<treecell>Button style broken</treecell>
								<treecell>Check main.css</treecell>
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell>00021</treecell>
										<treecell>1</treecell>
										<treecell>closed</treecell>
										<treecell>
											Fix logout issue
										</treecell>
										<treecell>
											Logout does not work at all
										</treecell>
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell>0003</treecell>
								<treecell>2</treecell>
								<treecell>open</treecell>
								<treecell>
									Client search result
								</treecell>
								<treecell>
									Search service returns incomplete
									result
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
				<div>There are only one scroll bar in tree</div>
				<tree width="400px">
					<custom-attributes org.zkoss.zul.nativebar="true" />
					<treecols>
						<treecol label="column ${each}"
							forEach="1,2,3,4,5,6,7,8,9" width="200px" />
					</treecols>
					<frozen columns="1" />
					<treechildren>
						<treeitem forEach="1,2,3,4,5">
							<treerow>
								<treecell forEach="1,2,3,4,5,6,7,8,9">
									item ${each}
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
				<div>
					Please click the button of 'Change pageSize', and
					then you should see the horizontal scrollbar inside
					the tree should be avalible as well.
				</div>
				<div>
					<button label="Change pageSize"
						onClick='d1.height="100px"; tree1.pageSize = 3;' />
					<div id="d1" style="overflow:auto;">
						<tree id="tree1" mold="paging" pageSize="1">
							<custom-attributes
								org.zkoss.zul.nativebar="true" />
							<frozen columns="1" />
							<treecols>
								<treecol label="Index" />
								<treecol label="Head 1" />
								<treecol label="Head 2" />
								<treecol label="Head 3" />
							</treecols>
							<treechildren>
								<treeitem forEach="1,1,1">
									<treerow>
										<treecell forEach="1,2,3,4">
											item ${each}
										</treecell>
									</treerow>
								</treeitem>
							</treechildren>
						</tree>
					</div>
				</div>
				<div>the footer can be scroll too</div>
				<tree width="400px">
					<custom-attributes org.zkoss.zul.nativebar="true" />
					<treecols>
						<treecol label="column ${each}"
							forEach="1,2,3,4,5,6,7,8,9" width="200px" />
					</treecols>
					<frozen columns="1" />
					<treechildren>
						<treeitem forEach="1,2,3,4,5">
							<treerow>
								<treecell forEach="1,2,3,4,5,6,7,8,9">
									item ${each}
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
					<treefoot>
						<treefooter forEach="1,2,3,4,5,6,7,8,9"
							label="item ${each}" />
					</treefoot>
				</tree>
			</window>
		</vlayout>
	</hlayout>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button").eq(0))
      waitResponse()
      verifyImage()
      
      click(jq(".z-button").eq(1))
      waitResponse()
      verifyImage()
    })
    
  }
}