CREATE PROCEDURE `getUnansweredQuestions` (in m_id int)
BEGIN
	select q.text, count(*) from (select * from answer a join question q on question_id = question_fk) c group by module having module not in (select module from answer a, question q where correct=true);
END