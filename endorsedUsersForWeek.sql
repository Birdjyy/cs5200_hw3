CREATE DEFINER=`jinyaoyu`@`%` PROCEDURE `endorsedUsersForWeek`()
BEGIN
	select * from person where person_id in (select user_fk from (select user_fk from (select * from answer where correct_answer=true) as a group by user_fk order by count(*)limit 5) as t) order by firstname;
END