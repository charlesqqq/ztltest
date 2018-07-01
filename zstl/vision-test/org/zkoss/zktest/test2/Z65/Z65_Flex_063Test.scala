
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-063.zul,Flex")
class Z65_Flex_063Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Chosenbox]" width="480px">
        <chosenbox hflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Chosenbox, rounded]" width="480px">
        <chosenbox hflex="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}