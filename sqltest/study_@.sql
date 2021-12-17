select truncate(7777.5678, -1);
select '5%3', mod(5,3) from dual;
select ceiling(3.14);
select floor(3.14);
select GREATEST(1,2,3);
select least(1,2,3);
select format(1234.123, 0);
select ascii('a');
select concat_ws('v', 'dfd', 'dfd');
select replace('asdf', 'a', 'b');
select mid('aaa', 1, 1);
select substring('aaa', 1, 1);
select ltrim('  a  aaa  aa');
select rtrim('  a  aaa  aa            d  ');
select trim('  a  aaa  aa');
select reverse('asdfasdf');
select char_length('sdfsdf');
select trim(both 'z' from 'zzdddzz');
SELECT ename, IFNULL(comm, 0) FROM emp;
SELECT ename, IFNULL(comm, '미정') FROM emp;
SELECT ename, IFNULL(comm, 0) + 100 FROM emp;
select if(sal>4000, 't1', if(sal>3000, 't2', if(sal > 2000, 't3', 't4'))) FROM EMP;
SELECT ename, sal, IF(sal> 4000, 'T1', IF(sal> 3000, 'T2', IF(sal> 2000, 'T3', IF(sal> 1000, 'T4','T5'))))
FROM emp;

select ename, weekday(hiredate) from emp;

SELECT ename, case WEEKDAY(hiredate)
when '0' then '월요일'
when '1' then '화요일'
when '2' then '수요일'
when '3' then '목요일'
when '4' then '금요일'
end as '입사 요일'
from emp;


SELECT ename, case WEEKDAY(hiredate)
when '0' then '월요일'
when '1' then '화요일'
when '2' then '수요일'
when '3' then '목요일'
when '4' then '금요일'
when '5' then '토요일'
when '6' then '일요일'
end as '입사 요일'
from emp;


SELECT DATE_FORMAT(NOW(), "%Y년 %y년");
SELECT DATE_FORMAT('2021-01-03', "%m월 %c월");
SELECT DATE_FORMAT(NOW(), "%H시 %h시 %l시");
SELECT DATE_FORMAT(NOW(), "%T %r");
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 DAY);

SELECT ename, sal, CASE
 WHEN sal> 4000 THEN 'T1'
 WHEN sal> 3000 THEN 'T2'
 WHEN sal> 2000 THEN 'T3'
 WHEN sal> 1000 THEN 'T4'
 ELSE 'T5' END grade
FROM emp;

SELECT ename, hiredate, NOW(), NOW()-hiredate, DATEDIFF(NOW(), hiredate)
, YEAR(hiredate), MONTH(hiredate), DAY(hiredate) FROM emp;

select timestampdiff(day, cast('2021-01-01' as date), now());