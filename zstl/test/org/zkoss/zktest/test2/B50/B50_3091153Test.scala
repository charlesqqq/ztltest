/* B50_3091153Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3091153Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
<html><![CDATA[
<ol>
 <li>Click the open icon to open the tree item</li>
 <li>Click the deSelectAll button to deselect all. All of them shall be de-selected</li>
 <li>Click the selectAll button and all shall be selected</li>
</ol>
]]></html>

<zscript><![CDATA[
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.event.TreeDataListener;
import org.zkoss.zul.ext.TreeSelectableModel;
import org.zkoss.zul.ext.TreeOpenableModel;


public class Test14105Window extends Window implements AfterCompose {
	private Tree tree;

	public void afterCompose() {
		tree = this.getFellow("tree");
		tree.setTreeitemRenderer(new MyTreeitemRenderer());
		tree.setModel(new MyTreeModel());
	}
}
public class MyTreeitemRenderer implements TreeitemRenderer {
	public void render(Treeitem treeitem, Object arg1, int index) throws Exception {
		treeitem.setLabel(arg1.toString());
		treeitem.setSelected(true);
	}
}
public class MyTreeModel implements TreeModel, TreeOpenableModel, TreeSelectableModel {
	public void setMultiple(boolean multiple) {

	}

	public boolean isMultiple() {
		return true;
	}

	public boolean addSelectionPath(int[] path) {
		return false;
	}

	public boolean addSelectionPaths(int[][] paths) {
		return false;
	}

	public boolean removeSelectionPath(int[] path) {
		return false;
	}

	public boolean removeSelectionPaths(int[][] paths) {
		return false;
	}

	public boolean isPathSelected(int[] path) {
		return false;
	}

	public boolean isSelectionEmpty() {
		return false;
	}

	public void clearSelection() {

	}

	public int[] getSelectionPath() {
		return new int[0];
	}

	public int[][] getSelectionPaths() {
		return new int[0][];
	}

	public int getSelectionCount() {
		return 0;
	}
	public void addTreeDataListener(TreeDataListener arg0) {
		// TODO Auto-generated method stub
	}

	public Object getChild(Object arg0, int arg1) {
		if (arg0.getClass().isArray())
			return "tttt";
		return "dd";
	}

	public int getChildCount(Object arg0) {
		if (arg0.getClass().isArray())
			return ((String[]) arg0).length;
			// TODO Auto-generated method stub
		return "tttt".equals(arg0) ? 5 : 0;
	}
	public int[] getPath(Object child) {
		List path = new ArrayList();
		dfSearch(path, getRoot(), child);

		final int[] ipath = new int[path.size()];
		for (int j = 0; j < ipath.length; j++)
			ipath[j] = path.get(j);
		return ipath;
	}
	private boolean dfSearch(List path, Object node, Object target){
		if (node.equals(target))
			return true;
		if (isLeaf(node))
			return false;

		for (int i = 0, size = getChildCount(node); i< size; i++)
			if (dfSearch(path, getChild(node, i), target)){
				path.add(0, new Integer(i));
				return true;
			}
		return false;
	}
	public Object getChild(int[] path) {
		Object parent = getRoot();
		Object node = null;
		int childCount = getChildCount(parent);
		for (int i = 0; i < path.length; i++) {
			if (path[i] < 0 || path[i] > childCount)
				return null;
			node = getChild(parent, path[i]);

			if (node != null && (childCount = getChildCount(node)) > 0) {
				parent = node;
			} else if (i != path.length - 1) {
				return null;
			}
		}
		return node;
	}
	public Object getRoot() {
		// TODO Auto-generated method stub
		return new String[] { "tttt" };
	}

	public boolean isLeaf(Object arg0) {
		if (arg0.getClass().isArray())
			return false;
		// TODO Auto-generated method stub
		return !"tttt".equals(arg0);
	}

	public void removeTreeDataListener(TreeDataListener arg0) {
		// TODO Auto-generated method stub
	}


	public boolean addOpenPath(int[] path) {
		return false;
	}

	public boolean addOpenPaths(int[][] paths) {
		return false;
	}

	public boolean removeOpenPath(int[] path) {
		return false;
	}

	public boolean removeOpenPaths(int[][] paths) {
		return false;
	}

	public boolean isPathOpened(int[] path) {
		return false;
	}

	public boolean isOpenEmpty() {
		return false;
	}

	public void clearOpen() {

	}

	public int getOpenCount() {
		return 0;
	}

	public int[] getOpenPath() {
		return new int[0];
	}

	public int[][] getOpenPaths() {
		return new int[0][];
	}
}
]]></zscript>
<window use="Test14105Window" title="new page title"
border="normal">
<tree id="tree" height="300px" checkmark="true" multiple="true" />
<button label="selectAll" onClick="tree.selectAll()"/>
<button label="deSelectAll" onClick="tree.clearSelection()"/>
</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      verifyEquals(1, jq(".z-treerow").length())
      verifyEquals(1, jq(".z-treerow-selected").length())
      click(jq(".z-treerow").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(6, jq(".z-treerow-selected").length())
      verifyEquals(6, jq(".z-treerow").length())
      click(jq("@button[label=\"deSelectAll\"]"))
      waitResponse()
      verifyEquals(0, jq(".z-treerow-selected").length())
      verifyEquals(6, jq(".z-treerow").length())
      click(jq("@button[label=\"selectAll\"]"))
      waitResponse()
      verifyEquals(6, jq(".z-treerow-selected").length())
      verifyEquals(6, jq(".z-treerow").length())
    })
  }
}



