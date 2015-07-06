<%@ include file="/html/init.jsp" %>
<%@page import="javax.portlet.ResourceResponse"%>


<portlet:resourceURL var="subjectListURL">
	<portlet:param name="resource" value="depositableSubject" />
</portlet:resourceURL>
<%
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	//List<ItemSubject> itemSubjects = ItemSubjectLocalServiceUtil.getByItemId(item.getItemId());
	//List<ItemDivision> itemDivisions = ItemDivisionLocalServiceUtil.getByItemId(item.getItemId());
	
	//List<Division> divisions = DivisionLocalServiceUtil.getDepositable();
	//long divisionId = 0;
	//for (ItemDivision itemDivision: itemDivisions)
	//	divisionId = itemDivision.getDivisionId();

	List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
	List<AssetCategory> categories = new ArrayList<AssetCategory>();
	List<AssetCategory> subCategories;
	long catId = 0L;
	String subCatIdsList ="";
	
	DynamicQuery queryVocabularies = DynamicQueryFactoryUtil.forClass(
			AssetVocabulary.class).add(
					PropertyFactoryUtil.forName("name").eq("Subject"));
	
	try {
        vocabularies = AssetVocabularyLocalServiceUtil.dynamicQuery(
                queryVocabularies, 0, 1);
        DynamicQuery queryCategories = DynamicQueryFactoryUtil
                .forClass(AssetCategory.class).add(
                        PropertyFactoryUtil.forName("vocabularyId").eq(
                                vocabularies.get(0).getVocabularyId())); // then get all categories matching the vocabulary
        categories = AssetVocabularyLocalServiceUtil.dynamicQuery(
                queryCategories, 0, 100); // let's get some to show
       
     //Iterate over all Categories            
      for(AssetCategory cat:categories){
          String categoryName = cat.getName(); //get category Name
          //if(categoryName.equalsIgnoreCase("Subject")  ){   //Get Opthomologist CatId
           //     catId = cat.getCategoryId();   
          //}
          subCatIdsList=subCatIdsList.concat(String.valueOf(cat.getCategoryId()));
          subCatIdsList = subCatIdsList.concat(",");
          //subCatIdsList = subCatIdsList.concat(String.valueOf(cat.getCategoryId())).concat(",");
      
      if (subCatIdsList.length() > 0) {
          subCatIdsList = subCatIdsList.substring(0, subCatIdsList.length()-1);
         }
      }
               
    //Get subCategories:
    	/*
        if(catId!=0){   
             subCategories = AssetCategoryLocalServiceUtil.getChildCategories(catId);
             for(AssetCategory subCatId : subCategories){
                 subCatIdsList = subCatIdsList.concat(String.valueOf(subCatId.getCategoryId())).concat(",");
             }
             if (subCatIdsList.length() > 0) {
                 subCatIdsList = subCatIdsList.substring(0, subCatIdsList.length()-1);
                }
            }   */
               
    } catch (SystemException e) {
        // handle exception...
    }
%>

<liferay-ui:asset-categories-error />
<liferay-ui:asset-tags-error />
<aui:fieldset>
	
	<aui:input 
		classPK="<%=item.getItemId() %>" 
		model="<%= SuburItem.class %>" 
		name="categories" 
		type="assetCategories" />	
	
	
	<aui:input classPK="<%=item.getItemId() %>" 
		model="<%= SuburItem.class %>" 
		name="tags" 
		type="assetTags" />
	
</aui:fieldset>				
<input type="hidden" name="categoryIds" id="<portlet:namespace/>categoryIds" value=""/>			
<input type="hidden" name="tagNames" id="<portlet:namespace/>tagNames" value=""/>		




