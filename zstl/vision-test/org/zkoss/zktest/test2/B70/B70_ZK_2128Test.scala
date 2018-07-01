package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2128.zul")
class B70_ZK_2128Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="Frozen Tree Cell columns" contentType="text/html;charset=UTF-8"?>
<zk>
<label>
	Click "do something" twice or more, the cells won't disappear.
</label>
<div height="350px" width="30%"  apply="org.zkoss.bind.BindComposer" 
    viewModel="@id('vm') @init('org.zkoss.zktest.test.B70_ZK_2128VM')">
  <vlayout vflex="1" hflex="1">
	  <tree model="@load(vm.treeModel)" id="treeNativeScrollbar" hflex="1" rows="8">
	    <custom-attributes org.zkoss.zul.nativebar="true"/>
	    <frozen columns="1"/>
	    <treecols sizable="false" children="@load(vm.cols)  @template(vm.colTemplate(forEachStatus.index))" >
	      <template name="col0" var="node">
	        <treecol label="Fixed Column" width="160px"/>
	      </template>
	      <template name="col" var="node">
	        <treecol width="60px" visible="@load(vm.isVisible(node))">
	          <label value="@load(node)"/>
	          <div>
	            multi-line
	          </div>
	        </treecol>
	      </template>
	      <template name="fill">
	        <treecol hflex="1"/>
	      </template>      
	    </treecols> 
	
	    <auxhead children="@load(vm.cols)  @template(vm.auxTemplate(forEachStatus.index))" visible="@load(vm.showAux)">
	      <template name="aux0">
	        <auxheader>Fixed Aux</auxheader>
	      </template>
	      <template name="aux" var="node">
	        <auxheader>
	          X
	        </auxheader>
	      </template>
	      <template name="fill">
	        <auxheader/>
	      </template>      
	    </auxhead> 
	    
	    <template name="model" var="row">
	      <treeitem>
	        <treerow children="@load(vm.items) @template(vm.cellTemplate(forEachStatus.index))">
	          <template name="cell0">
	            <treecell label="fixed cell"/>
	          </template>
	          <template name="cell" var="node">
	            <treecell>
	              <label value="@load(node)"/>
	            </treecell>
	          </template>
	          <template name="fill">
	            <treecell/>
	          </template>
	        </treerow>
	      </treeitem>
	    </template>
	  </tree>
	  <hlayout>
		  <checkbox label="toggle aux header" checked="@bind(vm.showAux)"/>
		  <button label="do something" onClick="@command('doSomething')"/>          
	  </hlayout>
  </vlayout>
</div>

<div height="350px" width="30%"  apply="org.zkoss.bind.BindComposer" 
    viewModel="@id('vm') @init('org.zkoss.zktest.test.B70_ZK_2128VM')">
  <vlayout vflex="1" hflex="1">
	  <tree model="@load(vm.treeModel)" id="treeFakeScrollbar" hflex="1" rows="8">
	    <frozen columns="1"/>
	    <treecols sizable="false" children="@load(vm.cols)  @template(vm.colTemplate(forEachStatus.index))" >
	      <template name="col0" var="node">
	        <treecol label="Fixed Column" width="160px"/>
	      </template>
	      <template name="col" var="node">
	        <treecol width="60px" visible="@load(vm.isVisible(node))">
	          <label value="@load(node)"/>
	          <div>
	            multi-line
	          </div>
	        </treecol>
	      </template>
	      <template name="fill">
	        <treecol hflex="1"/>
	      </template>      
	    </treecols> 
	
	    <auxhead children="@load(vm.cols)  @template(vm.auxTemplate(forEachStatus.index))" visible="@load(vm.showAux)">
	      <template name="aux0">
	        <auxheader>Fixed Aux</auxheader>
	      </template>
	      <template name="aux" var="node">
	        <auxheader>
	          X
	        </auxheader>
	      </template>
	      <template name="fill">
	        <auxheader/>
	      </template>      
	    </auxhead> 
	    
	    <template name="model" var="row">
	      <treeitem>
	        <treerow children="@load(vm.items) @template(vm.cellTemplate(forEachStatus.index))">
	          <template name="cell0">
	            <treecell label="fixed cell"/>
	          </template>
	          <template name="cell" var="node">
	            <treecell>
	              <label value="@load(node)"/>
	            </treecell>
	          </template>
	          <template name="fill">
	            <treecell/>
	          </template>
	        </treerow>
	      </treeitem>
	    </template>
	  </tree>
  
	  <hlayout>
		  <checkbox label="toggle aux header" checked="@bind(vm.showAux)"/>
		  <button label="do something" onClick="@command('doSomething')"/>          
	  </hlayout>
  </vlayout>
</div>
</zk>"""  
  runZTL(zscript,
    () => {
      
      0 to 1 foreach { index =>
        val btn = jq(".z-button").eq(index)
      	0 to 1 foreach { innerIndex => 
      	  click(btn)
      	  waitResponse()
      	  verifyImage()
      	}
      }
    })
    
  }
}