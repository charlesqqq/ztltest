package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Livegrouping_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
	<![CDATA[
	import org.zkoss.zul.*;
	import org.zkoss.zkdemo.userguide.*;
	
	LiveGroupRenderer renderer = new LiveGroupRenderer();

	String[][][] datas = {
		{
			// Today
			{ "1", "[zk1 - Help] RE: Bandbox Autocomplete Problem", 
				"2008/11/18 10:16:27", "16KB" },
			{ "2", "[zk1 - Help] RE: Bandbox Autocomplete Problem", 
				"2008/11/18 10:14:27", "18KB" },
			{ "3", "[zk1 - Help] RE: Databinding with radiogroups",
				"2008/11/18 09:47:27", "12KB" },
			{ "4", "[zk1 - Help] RE: It's not possible to navigate a listbox' ite",
				"2008/11/18 09:35:27", "12KB" },
			{ "5", "[zk1 - Help] RE: ZK problem in dynamic menu",
				"2008/11/18 08:37:27", "12KB" },				
			{ "6", "[zk1 - Help] RE: FileUpload",
				"2008/11/18 08:27:57", "14KB" },
			{ "7", "[zk1 - Help] RE: Datebox format",
				"2008/11/18 06:27:31", "11KB" },
			{ "8", "[zk1 - Help] RE: Datebox format",
				"2008/11/18 06:17:22", "12KB" },
			{ "9", "[zk1 - Help] FileUpload",
				"2008/11/18 05:07:25", "11KB" },
			{"10", "[zk1 - Help] FileUpload",
				"2008/11/18 05:07:25", "11KB" },
			{"11", "[zk1 - Help] FileUpload",
				"2008/11/18 05:07:25", "11KB" },
			{"12", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/18 04:44:17", "12KB" },
			{"13", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/18 04:44:17", "12KB" },
			{"14", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/18 04:44:17", "12KB" },
			{"15", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/18 04:44:17", "12KB" },
			{"16", "[zk1 - Help] RE: SelectedItemConverter Question", 
				"2008/11/18 04:31:12", "14KB" },
		},
		{
			// Yesterday
			{ "1", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/17 19:44:17", "39KB" },
			{ "2", "[zk1 - General] RE: Openi ng more than one new browser window",
				"2008/11/17 19:42:17", "35KB" },
			{ "3", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/17 19:40:17", "26KB" },
			{ "4", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/17 18:14:17", "27KB" },
			{ "5", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/17 17:05:17", "18KB" },
			{ "6", "[zk1 - General] RE: Opening more than one new browser window",
				"2008/11/17 16:44:17", "19KB" },
			{ "7", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/17 13:31:12", "14KB" },
			{ "8", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/17 13:31:12", "14KB" },
			{ "9", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/17 13:31:12", "14KB" },
			{"10", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/17 13:31:12", "14KB" },
			{"11", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/17 13:26:37", "14KB" },
			{"12", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/17 13:26:37", "14KB" },
			{"13", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/17 13:26:37", "14KB" },
			{"14", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/17 10:41:33", "14KB" },	
			{"15", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/17 10:14:27", "14KB" },
		},
		{
			// Last Week
			{ "1", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/15 04:31:12", "14KB" },
			{ "2", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/15 04:31:12", "14KB" },
			{ "3", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/15 04:31:12", "14KB" },
			{ "4", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/15 03:26:37", "14KB" },
			{ "5", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/15 03:26:37", "14KB" },
			{ "6", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/15 03:26:37", "14KB" },
			{ "7", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/14 12:41:33", "14KB" },
			{ "8", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/14 02:41:33", "14KB" },
			{ "9", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/14 02:41:33", "14KB" },
			{"10", "[zk1 - Help] RE: Times_Series Chart help",
				"2008/11/14 02:41:33", "14KB" },
			{"11", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/13 02:14:27", "14KB" },
			{"12", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/13 02:14:27", "14KB" },
			{"13", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/13 02:14:27", "14KB" },
			{"14", "[zk1 - Help] RE: SelectedItemConverter Question",
				"2008/11/13 02:14:27", "14KB" },
		}			
	};
	GroupsModel model = 
		new SimpleGroupsModel(datas, new String[] {"Date: Today", "Date: Yesterday", "Date: Last Week"});
	model.setOpenGroup0(0, false);
	model.setOpenGroup0(1, false);
	]]>
	</zscript>
	<grid id="lb1" height="400px" fixedLayout="true" model="${model}" rowRenderer="${renderer}">
	 	<columns sizable="true">
	       <column width="80px" label="From"/>
	       <column label="Subject"/>
	       <column width="150px" label="Received"/>
	       <column width="50px" label="Size"/>
	     </columns>
	</grid>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
