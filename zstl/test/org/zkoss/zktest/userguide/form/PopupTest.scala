/* PopupTest.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.userguide.form

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class PopupTest extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    var zscript =
      """
<window id="demo"
	apply="org.zkoss.zktest.test.DemoWindowComposer">
	<html><![CDATA[
		<h4>Form with Popup</h4>
		<p>Demonstrate a series of popup components in a form. <a href="javascript:;" onclick="if (jq('#infos').is(':hidden')) {jq('#infos').slideDown();} else {jq('#infos').slideUp();}">More..</a></p>		
		<ul style="display:none;" id="infos">
			<li>A tooltip is shown when mouse over, disappear in 0.5 second if mouse leave.</li>
            <li>A popup is shown when mouse click, disappear when losing focus.</li>
			<li>A context is shown when right click, disappear when option clicking.</li>
		</ul>
	]]></html>
	<tabbox width="100%" tabscroll="false">
		<tabs>
			<tab id="demoView" label="Demo" />
			<tab id="srcView" label="View Source" />
		</tabs>
		<tabpanels>
			<tabpanel>
				<window id="view"></window>
			</tabpanel>

			<tabpanel>
				<panel>
					<panelchildren>
						<textbox id="codeView" class="code" rows="20"
							width="95%">
							<attribute name="value"><![CDATA[
<zk>
	ZK Mail Composer
	<grid fixedLayout="true" width="450px">
		<columns>
			<column label="Option" width="100px" />
			<column label="Input" />
		</columns>
		<rows>
			<row>
				To :
				<hbox>
					<textbox width="150px" value="info@zkoss.org"
						constraint="/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*([,;]\s*\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*/: Please enter real e-mail address" />
					<hbox>
						<image src="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png" tooltip="mail"
							style="cursor: help" />
						<label value="Move mouse Over Me!"
							tooltip="mail" />
					</hbox>
				</hbox>
			</row>
			<row>
				Subject :
				<hbox>
					<textbox value="I love ZK" width="150px" />
					<hbox>
						<image src="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png" popup="title"
							style="cursor:pointer" />
						<label value="Click Me!" popup="title" />
					</hbox>
				</hbox>
			</row>

			<row>
				Introduction:
				<hbox>
					<textbox id="intro" rows="3" width="250px"
						context="editPopup">
						<attribute name="value">Right Click On Me ! </attribute>
					</textbox>
				</hbox>
			</row>
		</rows>
	</grid>
	<menupopup id="editPopup">
		<menuitem label="ClearAll" onClick="intro.value=null" />
		<menu label="QuickText">
			<menupopup>
				<menuitem label="Everything is OK!"
					onClick="intro.value=intro.value + self.label" />
				<menuitem label="Thank you very much!"
					onClick="intro.value=intro.value + self.label" />
				<menuitem label="I'm on a business trip!"
					onClick="intro.value=intro.value + self.label" />
				<menuitem label="I'm busy now!"
					onClick="intro.value=intro.value + self.label" />
			</menupopup>
		</menu>
	</menupopup>
	<popup id="title" width="400px">
		<html>Input the subject of this letter. Problem report :</html>
		<toolbarbutton label="ZK Forum" target="zkdemo"
			href="http://www.zkoss.org/forum" />
	</popup>
	<popup id="mail" width="300px">
		<html>
			Please enter real email address. &lt;br /&gt; The validator
			allow multiple email addresses separated by semi-colons
			(&lt;font color="red"&gt;;&lt;/font&gt;).&lt;br /&gt; For
			Example:&lt;u&gt;zk@zkoss.org&lt;/u&gt;;&lt;u&gt;info@zkoss.org&lt;/u&gt;
		</html>
	</popup>
</zk>		]]></attribute>
						</textbox>
					</panelchildren>
					<toolbar mold="panel">
						<button id="tryBtn" label="Try me!" />
						<button id="reloadBtn" label="Reload" />
					</toolbar>
				</panel>
			</tabpanel>
		</tabpanels>
	</tabbox>
</window>
		
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val demo = ztl$engine.$f("demo")
    val infos = ztl$engine.$f("infos")
    val demoView = ztl$engine.$f("demoView")
    val srcView = ztl$engine.$f("srcView")
    val view = ztl$engine.$f("view")
    val codeView = ztl$engine.$f("codeView")
    val intro = ztl$engine.$f("intro")
    val editPopup = ztl$engine.$f("editPopup")
    val title = ztl$engine.$f("title")
    val mail = ztl$engine.$f("mail")
    val tryBtn = ztl$engine.$f("tryBtn")
    val reloadBtn = ztl$engine.$f("reloadBtn")
    runZTL(zscript, () => {
      mouseOver(jq("$view").find("@label:eq(2)"))
      sleep(1000)
      verifyTrue(jq("$mail").isVisible())
      click(jq("$view").find("@textbox:eq(0)"))
      waitResponse()
      verifyFalse(jq("@popup").isVisible())
      click(jq("$view").find("@label:eq(4)"))
      waitResponse()
      verifyTrue(jq("$view").find("@html").exists())
    })
  }
}



