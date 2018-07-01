
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-096.zul,Flex")
class Z65_Flex_096Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Intbox, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <intbox hflex="1" value="1" vflex="1"/>
            <intbox hflex="1" value="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Intbox, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <intbox hflex="1" value="1" vflex="1"/>
            <intbox hflex="1" value="1" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Intbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <intbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <intbox hflex="1" mold="rounded" value="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Intbox, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <intbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <intbox hflex="1" mold="rounded" value="1" vflex="2"/>
        </vbox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}