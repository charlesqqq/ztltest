package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-2028.zul")
class B65_ZK_2028Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window title="Chosenbox Deletion with ListSubModel" border="normal" width="500px" height="200px">
	<zscript><![CDATA[
		import java.util.ArrayList;
		import org.zkoss.zul.*;
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add("book");
		list.add("cake");
		list.add("ding");
		ListSubModel model = ListModels.toListSubModel(new ListModelList(list));
	]]></zscript>
	<label multiline="true">
		1. Choose "book", "apple", "cake".
		2. Delete "cake"
		3. "book" and "apple" should still be selected.
	</label>
	<separator/>
	<chosenbox id="cb" width="300px" model="${model}"/>
</window>"""
    runZTL(zscript,
      () => {
        var inp = jq(".z-chosenbox").toWidget().$n("inp")
        var list = List("book", "apple", "cake")
        for (item <- list) {
          sendKeys(inp, item)
          waitResponse(true)
          sleep(200)
          sendKeys(inp, Keys.ENTER)
          waitResponse(true)
          sleep(200)
        }
        click(jq(".z-chosenbox-item:contains(cake) .z-chosenbox-delete"))
        waitResponse(true)
        verifyTrue("'book' and 'apple' should still be selected.",
          jq(".z-chosenbox-item:contains(apple)").exists
            && jq(".z-chosenbox-item:contains(book)").exists())
      })

  }
}