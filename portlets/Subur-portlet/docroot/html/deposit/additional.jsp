<%@ include file="/html/item.jsp" %>
<%
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	int[] additionalMetadatas = null;
	List<MetadataPropertyValue> additionalMetadataEntries = null;
	if (Validator.isNotNull(item))
	{
		additionalMetadataEntries = MetadataPropertyValueLocalServiceUtil.getAdditionalMetadata(item.getItemId());
		additionalMetadatas = new int[additionalMetadataEntries.size()];
		
	}
	if (Validator.isNull(item) || additionalMetadataEntries.isEmpty())
	{
		additionalMetadataEntries = new ArrayList<MetadataPropertyValue>();
		additionalMetadataEntries.add(new MetadataPropertyValueImpl());
		additionalMetadatas =  new int[] {0};
	}
	
%>

<div id="additionalMetadataList">
	<%
	
	for (int i = 0; i < additionalMetadatas.length; i++) {
		int additionalMetadataIndex = additionalMetadatas[i];
		
		MetadataPropertyValue propValue = additionalMetadataEntries.get(i);
		//ProjectsEntry projectsEntry = projectsEntries.get(i);

		
		
	%>

		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input type="hidden" name='<%= "additionalMetaEntry" + additionalMetadataIndex %>' value="<%= propValue.getPrimaryKey() %>" />

				

				<div style="clear: both;"><!-- --></div>

				<aui:layout cssClass="lfr-form-row-inline">
					
					<aui:column>
						<aui:input label="First Name" fieldParam='<%= "firstName" + additionalMetadataIndex %>' name='<%="firstName"+ additionalMetadataIndex %>' value="<%=SuburUtil.getFirstName(propValue.getTextValue()) %>" />
					</aui:column>
					<aui:column>
						<aui:input label="Last Name" fieldParam='<%= "lastName" + additionalMetadataIndex %>' name='<%="lastName"+ additionalMetadataIndex %>' value="<%=SuburUtil.getLastName(propValue.getTextValue()) %>" />
					</aui:column>
					
					
				</aui:layout>

				
			</div>
		</div>

	<%
	}
	%>

	<aui:input name="authorIndexes" type="hidden" value="<%= StringUtil.merge(authors) %>" />
</div>



<aui:script position="inline" use="liferay-auto-fields">
	Liferay.once(
		'formNavigator:reveal<portlet:namespace />author',
		function() {
			new Liferay.AutoFields(
				{
					contentBox: '#authorList',
					fieldIndexes: '<portlet:namespace />authorIndexes',
					namespace: '<portlet:namespace/>'
				}
			).render();
		}
	);
</aui:script>
