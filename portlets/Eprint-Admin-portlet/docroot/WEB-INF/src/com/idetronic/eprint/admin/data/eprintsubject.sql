select a.eprintid,b.subjectid,b.name_name 
from eprint_subjects a,subject_name_name b
where a.subjects = b.subjectid