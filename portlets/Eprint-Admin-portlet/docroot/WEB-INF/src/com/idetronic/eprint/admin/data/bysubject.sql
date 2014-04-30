SELECT a.subjectid AS l1_subjectid, 
       b.name_name AS l1_subjectname, 
       NULL        AS l2_subjectid, 
       NULL        AS l2_subjectname, 
       NULL        AS l3_subjectid, 
       NULL        AS l3_subjectname, 
       NULL        AS l4_subjectid, 
       NULL        AS l4_subjectname, 
       NULL        AS l5_subjectid, 
       NULL        AS l5_subjectname, 
       NULL        AS l6_subjectid, 
       NULL        AS l6_subjectname, 
       Count(*)    AS l1_total, 
       0           AS l2_total, 
       0           AS l3_total, 
       0           AS l4_total, 
       0           AS l5_total, 
       0           AS l6_total 
FROM   eprint_subjects ep, 
       eprint, 
       subject_parents a, 
       subject_name_name b 
WHERE  ep.eprintid = eprint.eprintid 
       AND a.subjectid = 'subjects' 
       AND ep.subjects = a.subjectid 
       AND a.subjectid = b.subjectid 
       AND eprint.eprint_status = 'archive' 
       AND eprint.metadata_visibility = 'show' 
GROUP  BY a.subjectid, 
          b.name_name, 
          l2_subjectid, 
          l2_subjectname, 
          l3_subjectid, 
          l3_subjectname, 
          l4_subjectid, 
          l4_subjectname, 
          l5_subjectid, 
          l5_subjectname 
UNION 
SELECT l1.subjectid, 
       n1.name_name, 
       l2.subjectid AS l2_subjectid, 
       n2.name_name AS n2_name, 
       NULL, 
       NULL, 
       NULL         AS l4_subjectid, 
       NULL         AS n4_subjectname, 
       NULL         AS l5_subjectid, 
       NULL         AS n5_subjectname, 
       NULL         AS l6_subjectid, 
       NULL         AS n6_subjectname, 
       0            AS l1_total, 
       Count(*)     AS l2_total, 
       0            AS l3_total, 
       0            AS l4_total, 
       0            AS l5_total, 
       0            AS l6_total 
FROM   eprint_subjects ep, 
       eprint, 
       subject_parents l1, 
       subject_parents l2, 
       subject_name_name n1, 
       subject_name_name n2 
WHERE  ep.eprintid = eprint.eprintid 
       AND l1.subjectid = 'subjects' 
       AND ep.subjects = l2.subjectid 
       AND l2.parents = l1.subjectid 
       AND l1.subjectid = n1.subjectid 
       AND l2.subjectid = n2.subjectid 
       AND eprint.eprint_status = 'archive' 
       AND eprint.metadata_visibility = 'show' 
GROUP  BY l1.subjectid, 
          n1.name_name, 
          l2.subjectid, 
          n2_name 
UNION 
SELECT l1.subjectid, 
       n1.name_name, 
       l2.subjectid, 
       n2.name_name, 
       l3.subjectid AS l3_subjectid, 
       n3.name_name AS n3_name, 
       NULL         AS l4_subjectid, 
       NULL         AS n4_subjectname, 
       NULL         AS l5_subjectid, 
       NULL         AS n5_subjectname, 
       NULL         AS l6_subjectid, 
       NULL         AS n6_subjectname, 
       0            AS l1_total, 
       0            AS l2_total, 
       Count(*)     AS l3_total, 
       0            AS l4_total, 
       0            AS l5_total, 
       0            AS l6_total 
FROM   eprint_subjects ep, 
       eprint, 
       subject_parents l1, 
       subject_parents l2, 
       subject_parents l3, 
       subject_name_name n1, 
       subject_name_name n2, 
       subject_name_name n3 
WHERE  ep.eprintid = eprint.eprintid 
       AND l1.subjectid = 'subjects' 
       AND l2.parents = l1.subjectid 
       AND ep.subjects = l3.subjectid 
       AND l3.parents = l2.subjectid 
       AND l1.subjectid = n1.subjectid 
       AND l2.subjectid = n2.subjectid 
       AND l3.subjectid = n3.subjectid 
       AND eprint.eprint_status = 'archive' 
       AND eprint.metadata_visibility = 'show' 
GROUP  BY l1.subjectid, 
          n1.name_name, 
          l2.subjectid, 
          n2.name_name, 
          l3.subjectid, 
          n3.name_name 
UNION 
SELECT l1.subjectid, 
       n1.name_name, 
       l2.subjectid, 
       n2.name_name, 
       l3.subjectid, 
       n3.name_name, 
       l4.subjectid, 
       n4.name_name, 
       NULL     AS l5_subjectid, 
       NULL     AS n5_subjectname, 
       NULL     AS l6_subjectid, 
       NULL     AS n6_subjectname, 
       0        AS l1_total, 
       0        AS l2_total, 
       0        AS l3_total, 
       Count(*) AS l4_total, 
       0        AS l5_total, 
       0        AS l6_total 
FROM   eprint_subjects ep, 
       eprint, 
       subject_parents l1, 
       subject_parents l2, 
       subject_parents l3, 
       subject_parents l4, 
       subject_name_name n1, 
       subject_name_name n2, 
       subject_name_name n3, 
       subject_name_name n4 
WHERE  ep.eprintid = eprint.eprintid 
       AND l1.subjectid = 'subjects' 
       AND ep.subjects = l4.subjectid 
       AND l2.parents = l1.subjectid 
       AND l3.parents = l2.subjectid 
       AND l4.parents = l3.subjectid 
       AND l1.subjectid = n1.subjectid 
       AND l2.subjectid = n2.subjectid 
       AND l3.subjectid = n3.subjectid 
       AND l4.subjectid = n4.subjectid 
       AND eprint.eprint_status = 'archive' 
       AND eprint.metadata_visibility = 'show' 
GROUP  BY l1.subjectid, 
          n1.name_name, 
          l2.subjectid, 
          n2.name_name, 
          l3.subjectid, 
          n3.name_name, 
          l4.subjectid, 
          n4.name_name 
UNION 
SELECT l1.subjectid, 
       n1.name_name, 
       l2.subjectid, 
       n2.name_name, 
       l3.subjectid, 
       n3.name_name, 
       l4.subjectid, 
       n4.name_name, 
       l5.subjectid, 
       n5.name_name, 
       NULL     AS l6_subjectid, 
       NULL     AS n6_subjectname, 
       0        AS l1_total, 
       0        AS l2_total, 
       0        AS l3_total, 
       0        AS l4_total, 
       Count(*) AS l5_total, 
       0        AS l6_total 
FROM   eprint_subjects ep, 
       eprint, 
       subject_parents l1, 
       subject_parents l2, 
       subject_parents l3, 
       subject_parents l4, 
       subject_parents l5, 
       subject_name_name n1, 
       subject_name_name n2, 
       subject_name_name n3, 
       subject_name_name n4, 
       subject_name_name n5 
WHERE  ep.eprintid = eprint.eprintid 
       AND l1.subjectid = 'subjects' 
       AND ep.subjects = l5.subjectid 
       AND l2.parents = l1.subjectid 
       AND l3.parents = l2.subjectid 
       AND l4.parents = l3.subjectid 
       AND l5.parents = l4.subjectid 
       AND l1.subjectid = n1.subjectid 
       AND l2.subjectid = n2.subjectid 
       AND l3.subjectid = n3.subjectid 
       AND l4.subjectid = n4.subjectid 
       AND l5.subjectid = n5.subjectid 
       AND eprint.eprint_status = 'archive' 
       AND eprint.metadata_visibility = 'show' 
GROUP  BY l1.subjectid, 
          n1.name_name, 
          l2.subjectid, 
          n2.name_name, 
          l3.subjectid, 
          n3.name_name, 
          l4.subjectid, 
          n4.name_name, 
          l5.subjectid, 
          n5.name_name 
UNION 
SELECT l1.subjectid, 
       n1.name_name, 
       l2.subjectid, 
       n2.name_name, 
       l3.subjectid, 
       n3.name_name, 
       l4.subjectid, 
       n4.name_name, 
       l5.subjectid, 
       n5.name_name, 
       l6.subjectid, 
       n6.name_name, 
       0        AS l1_total, 
       0        AS l2_total, 
       0        AS l3_total, 
       0        AS l4_total, 
       0        AS l5_total, 
       Count(*) AS l6_total 
FROM   eprint_subjects ep, 
       eprint, 
       subject_parents l1, 
       subject_parents l2, 
       subject_parents l3, 
       subject_parents l4, 
       subject_parents l5, 
       subject_parents l6, 
       subject_name_name n1, 
       subject_name_name n2, 
       subject_name_name n3, 
       subject_name_name n4, 
       subject_name_name n5, 
       subject_name_name n6 
WHERE  ep.eprintid = eprint.eprintid 
       AND l1.subjectid = 'subjects' 
       AND ep.subjects = l6.subjectid 
       AND l2.parents = l1.subjectid 
       AND l3.parents = l2.subjectid 
       AND l4.parents = l3.subjectid 
       AND l5.parents = l4.subjectid 
       AND l1.subjectid = n1.subjectid 
       AND l2.subjectid = n2.subjectid 
       AND l3.subjectid = n3.subjectid 
       AND l4.subjectid = n4.subjectid 
       AND l5.subjectid = n5.subjectid 
       AND l6.parents = l5.subjectid 
       AND l6.subjectid = n6.subjectid 
       AND eprint.eprint_status = 'archive' 
       AND eprint.metadata_visibility = 'show' 
GROUP  BY l1.subjectid, 
          n1.name_name, 
          l2.subjectid, 
          n2.name_name, 
          l3.subjectid, 
          n3.name_name, 
          l4.subjectid, 
          n4.name_name, 
          l5.subjectid, 
          n5.name_name, 
          l6.subjectid, 
          n6.name_name 
ORDER  BY l1_subjectid, 
          l2_subjectid, 
          l3_subjectid, 
          l4_subjectid, 
          l5_subjectid,
          l6_subjectid