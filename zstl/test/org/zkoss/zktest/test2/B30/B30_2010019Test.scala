/* B30_2010019Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2010019Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
			
			<div width="100%" xmlns="http://www.zkoss.org/2005/zul" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd ">
			<html><![CDATA[
			<p>
			1. You shall see two listboxes.<br/> 
			2. The first one is Name-0 ~ Name-4, and Name-0 is selected<br/>
			3. The second one is A ~ C, and A is selected.<br/>
			4. Press "New" button by the 1st listbox.<br/>
			5. The 1st Listbox shall select namexxxxxxxx where xxxxxxxxx is a long number, and each time can be different.<br/>
			6. The 2nd Listbox shall select C.<br/>
			7. Press "New" button again.<br/>
			8. The 1st Listbox shall select namexxxxxxxx where xxxxxxxxx is a long number.<br/>
			9. The 2nd Listbox shall select A.<br/>
			10. You shall see the 2nd Listbox cycle thru A, B, C for each "New" button clicking.<br/>
			11. Done.<br/>
			</p>
			]]></html>
			
				<zscript>
					<![CDATA[
						import org.zkoss.zktest.test2.BizService;
						
						BizService businessService = new BizService();
						void addNewRepository(){
							businessService.addNewRepository(parentsListBox.getModel());
						}
						
						void refreshFields(){
							System.out.println("refresh selected driver");
							binder.loadAll();
						}
						
						void refreshURL() {
							System.out.println("selecting driver");
						}
						
						void disable(boolean arg0) {
							System.out.println(arg0);
						}
						
					]]>
				</zscript>
				<vbox width="100%">
					<div>Repositories</div>
					<hbox >
						Select Repository:
						<listbox id="parentsListBox" mold="select" model="@{businessService.repositories}"
							selectedItem="@{businessService.repository}" onSelect="disable(businessService.getRepository()==null)">
							<listitem self="@{each=repository}">
								<listcell label="@{repository.name}" />
							</listitem>
						</listbox>
						<div>
							Cause Error:
							<button id="myBtn" label="New" onClick="addNewRepository();refreshFields();" />
						</div>
					</hbox>
					<div>Driver</div>
			
					<hbox>
						Select Driver:
						<listbox id="driversListbox" model="@{businessService.drivers}" mold="select"
							selectedItem="@{businessService.repository.driver}" onSelect="refreshURL()">
							<listitem self="@{each=driver}" label="@{driver}" />
						</listbox>
					</hbox>
				</vbox>
			</div>
						
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val parentsListBox = ztl$engine.$f("parentsListBox")
    val myBtn = ztl$engine.$f("myBtn")
    val driversListbox = ztl$engine.$f("driversListbox")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      click(myBtn)
      waitResponse()
      // First validation.
      var pattern = "name\\d*"
      var nameValue = jq(parentsListBox).`val`()
      verifyTrue(nameValue.matches(pattern))
      verifyEquals("C", jq(driversListbox).`val`())
      click(myBtn)
      waitResponse()
      // Second validation.
      nameValue = jq(parentsListBox).`val`()
      verifyTrue(nameValue.matches(pattern))
      verifyEquals("A", jq(driversListbox).`val`())
      click(myBtn)
      waitResponse()
      // Third validation.
      nameValue = jq(parentsListBox).`val`()
      verifyTrue(nameValue.matches(pattern))
      verifyEquals("B", jq(driversListbox).`val`())
    })
  }
}



