/* B50_3094118Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3094118Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<zk>
	<window>
		<zscript>
		<![CDATA[
	class TestTreeModel extends org.zkoss.zul.AbstractTreeModel implements
		 org.zkoss.zul.ext.TreeSelectableModel {
		public TestTreeModel(Object root) {
			super(root);
		}
		public int getChildCount(Object parent) {
			if (isLeaf(parent))
				return -1;
			else {
				ArrayList al = (ArrayList) parent;
				return al.size();
			}
		}
		public boolean isLeaf(Object node) {
			boolean isLeaf = !(node instanceof ArrayList);
			if (!isLeaf) {
				return (((ArrayList) node).size() == 0);
			}
			return isLeaf;
		}
		public Object getChild(Object parent, int index) {
			ArrayList al = (ArrayList) parent;
			return al.get(index);
		}
		public Object getRoot() {
			return super.getRoot();
		}
		public void insert(Object parent, int indexFrom, int indexTo, Object[] newNodes)
				throws IndexOutOfBoundsException {
			ArrayList al = (ArrayList) parent;
			for (int i = indexFrom; i <= indexTo; i++) {
				try {
					al.add(i, newNodes[i - indexFrom]);
				} catch (Exception exp) {
					throw new IndexOutOfBoundsException("Out of bound: " + i + " while size=" + al.size());
				}
			}
			fireEvent(parent, indexFrom, indexTo, org.zkoss.zul.event.TreeDataEvent.INTERVAL_ADDED);

		}
		
	public void setMultiple(boolean multiple) {
		// TODO Auto-generated method stub

	}

	public boolean isMultiple() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addSelectionPath(int[] path) {
		// TODO Auto-generated method stub

	}

	public void addSelectionPaths(int[][] paths) {
		// TODO Auto-generated method stub

	}

	public boolean removeSelectionPath(int[] path) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeSelectionPaths(int[][] paths) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPathSelected(int[] path) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSelectionEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clearSelection() {
		// TODO Auto-generated method stub

	}

	public int[] getSelectionPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[][] getSelectionPaths() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSelectionCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	}
	import java.util.ArrayList;
	ArrayList mother = new ArrayList();
	ArrayList child1 = new ArrayList();

	//Assign children to root "mother"
	mother.add("Davis");
	mother.add(child1);

	ArrayList child2 = new ArrayList();
	child2.add("test");
	mother.add(child2);

	TestTreeModel tma = new TestTreeModel(mother);
	public void insert() {
		Object[] datas = { _v.getValue() };
		tma.insert(child1, 0, 0, datas);
	}
]]>
</zscript>
		<div>1.click insert</div>
		<div>2."[]" tree item should appear the open icon.</div>
		<div>3.click "[]" tree item</div>
		<div>4."aaa" should be first tree node.</div>
		<vbox>
			<tree model="${tma}" id="tree" pageSize="5" ></tree>
			<hbox></hbox>
			<hbox>
				Insert Node:
				<textbox id="_v" value="aaa" />
				<button label="insert" onClick="insert();" />
				<button label="tree invalidate" onClick="tree.invalidate();" />
			</hbox>
		</vbox>
		<zscript>
	</zscript>
	</window>

</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val _v = ztl$engine.$f("_v")
    runZTL(zscript, () => {
      verifyEquals(3, jq("@treerow").length())
      verifyEquals(1, jq("@treerow").find(".z-tree-close").length())
      verifyFalse(jq("@treerow:eq(1)").find(".z-tree-close").exists())
      click(jq("@button:contains(insert)"))
      waitResponse()
      verifyEquals(2, jq("@treerow").find(".z-tree-close").length())
      verifyEquals("[]", jq("@treerow:eq(1) .z-treecell-text").text().replaceAll(" ", ""))
      verifyTrue(jq("@treerow:eq(1)").find(".z-tree-close").exists())
      click(jq("@treerow:eq(1)").find(".z-tree-close"))
      waitResponse()
      verifyEquals(4, jq("@treerow").length())
      verifyEquals("[]", jq("@treerow:eq(1) .z-treecell-text").text().replaceAll(" ", ""))
      verifyEquals("aaa", jq("@treerow:eq(2) .z-treecell-text").text().replaceAll(" ", ""))
    })
  }
}



