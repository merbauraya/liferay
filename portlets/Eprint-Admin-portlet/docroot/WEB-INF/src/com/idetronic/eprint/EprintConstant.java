package com.idetronic.eprint;

public interface EprintConstant {
	public static final String EPRINT_URL = "http://192.168.0.120";
	
	
	public static final String VIEW_EPRINT_DETAIL = "/html/eprintview/detail.jsp";
	//our pages
	public final static String PAGE_BY_SUBJECT = "/html/eprintview/bysubject.jsp";
	//public final static String PAGE_BY_SUBJECT2 = "/html/eprintview/bysubject2.jsp";
	public final static String PAGE_ENTRY_SUBJECT_ID = "/html/eprintview/bysubject_id.jsp";
	public final static String PAGE_ENTRY_SUBJECT_ID_DATATABLE = "/html/eprintview/bysubject_id_json.jsp";
	public final static String PAGE_ENTRY_SUBJECT_ID_DATATABLE_JSON = "/html/eprintview/bysubject_id_json_ajax.jsp";
	
	public final static String FILE_BY_SUBJECT = "/html/eprintview/bysubject.jsp";
	public final static String FILE_BY_SUBJECT_TREE = "/html/eprintview/subject_tree.jsp";
	
	
	//xslt
	public final static String XSL_BY_SUBJECT="/com/idetronic/eprint/transform/xhtmlbysubject.xslt";
	//SQL
	public final static String KEY_BROWSE_BY_SUBJECT_SQL ="browse.by.subject";
	public final static String SQL_FINDBY_SUBJECTID="com.idetronic.eprint.service.persistence.EprintFinder.findBySubjectId";
	

}
