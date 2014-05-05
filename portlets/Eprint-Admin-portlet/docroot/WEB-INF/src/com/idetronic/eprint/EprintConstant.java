package com.idetronic.eprint;

public interface EprintConstant {
	public static final String EPRINT_URL = "http://192.168.0.120";
	
	
	public static final String PAGE_NAVIGATION = "/html/eprintview/navigation.jsp";
	public static final String VIEW_EPRINT_DETAIL = "/html/eprintview/detail.jsp";
	public static final String EDIT_EPRINT_PAGE = "/html/eprint/asset/edit_entry.jsp";
	//our pages
	public final static String PAGE_LIST = "/html/eprintview/list.jsp";
	public final static String PAGE_BY_SUBJECT = "/html/eprintview/bysubject.jsp";
	public final static String PAGE_FILTER_BY_TYPE = "/html/eprintview/bytype.jsp";
	//public final static String PAGE_BY_SUBJECT2 = "/html/eprintview/bysubject2.jsp";
	public final static String PAGE_ENTRY_SUBJECT_ID = "/html/eprintview/bysubject_id.jsp";
	public final static String PAGE_ENTRY_SUBJECT_ID_DATATABLE = "/html/eprintview/bysubject_id_json.jsp";
	public final static String PAGE_ENTRY_SUBJECT_ID_DATATABLE_JSON = "/html/eprintview/bysubject_id_json_ajax.jsp";
	
	public final static String FILE_BY_SUBJECT = "/html/eprintview/bysubject.jsp";
	public final static String FILE_BY_SUBJECT_TREE = "/html/eprintview/subject_tree.jsp";
	
	
	//xslt
	public final static String XSL_BY_SUBJECT="/com/idetronic/eprint/transform/xhtmlbysubject.xslt";
	public final static String XSL_BY_TYPE="/com/idetronic/eprint/transform/xhtmlbytype.xslt";
	//SQL
	public final static String KEY_BROWSE_BY_SUBJECT_SQL ="browse.by.subject";
	public final static String SQL_FINDBY_SUBJECTID="com.idetronic.eprint.service.persistence.EprintFinder.findBySubjectId";
	
	public static final int KEY_BY_SUBJECT_TREE=1;
	public static final int KEY_BY_EPRINT_TYPE=2;
	public static final int KEY_BY_DIVISION_TREE=3;
	
	public static final String EPRINT_STATUS_ARCHIVE="archive";
	public static final String EPRINT_METADATA_VISIBILITY_SHOW="show";
	
	public static final int NAVIGATION_BY_SUBJECT = 1;

}
